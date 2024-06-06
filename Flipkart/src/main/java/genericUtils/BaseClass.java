package genericUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	AppiumDriverLocalService service;
	public FileUtility fUtil=new FileUtility();
	public AndroidDriver driver;
	public GestureUtilty gUtil;
	public DriverUtility dUtil;
	
	@BeforeSuite
	public void startServer()
	{
		File f=new File(IPathConstant.MainJSPath);
		service = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress(IPathConstant.IPAddress).usingPort(IPathConstant.PortNo).withTimeout(Duration.ofSeconds(IPathConstant.ServerTime)).build();
		service.start();
		System.out.println("---server started---");
		
	}
	
	@BeforeClass
	public void bc() throws IOException
	{
		
		String platformName=fUtil.getDataFromPropertyFile("platformName");
		String automationName=fUtil.getDataFromPropertyFile("automationName");
		String deviceName=fUtil.getDataFromPropertyFile("deviceName");
		String UDID=fUtil.getDataFromPropertyFile("UDID");
		String url=fUtil.getDataFromPropertyFile("url");
		String packageName=fUtil.getDataFromPropertyFile("appPackage");
		String appActivity=fUtil.getDataFromPropertyFile("appActivity");
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName", platformName);
		dc.setCapability("automationName", automationName);
		dc.setCapability("deviceName", deviceName);
		dc.setCapability("UDID", UDID);
//		dc.setCapability("ignoreHiddenApiPolicyError", true);
//		dc.setCapability("noReset", true);
//		dc.setCapability("autoGrantPermission", true);
		dc.setCapability("appPackage", packageName);
		dc.setCapability("appActivity", appActivity);
		
		URL u=new URL(url);
		driver=new AndroidDriver(u,dc);
		//driver.activateApp(packageName);
		dUtil=new DriverUtility(driver);
		gUtil=new GestureUtilty(driver);
	}
	
	@AfterClass
	public void ac() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();;
		System.out.println("Application closed");
	}
	@AfterSuite
	public void closeServer()
	{
		service.close();
		System.out.println("---server closed---");
		
	}

}
