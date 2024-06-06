package genericUtils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtility {
	
	AndroidDriver driver;
	
	public DriverUtility(AndroidDriver driver) 
	{
		this.driver=driver;
	}
	
	public void installApplication(String path)
	{
		driver.installApp(path);
	}
	
	public void uninstallApp(String packageName)
	{
		driver.removeApp(packageName);
	}
	
	public void verifyAppInstall(String packageName)
	{
		driver.isAppInstalled(packageName);
	}
	
	public void verifyDeviceLocked()
	{
		driver.isDeviceLocked();
	}
	
	public void appRunningState(String packageName) 
	{
		driver.queryAppState(packageName);
	}
	
	public void runInBackground(int time)
	{
		driver.runAppInBackground(Duration.ofSeconds(time));
	}
	
	public void fetchCurrentActivity()
	{
		driver.currentActivity();	
	}
	
	public void orientationPortrait()
	{
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.PORTRAIT);
	}
	
	public void orientationLandscape()
	{
		ScreenOrientation screen = driver.getOrientation();
		driver.rotate(screen.LANDSCAPE);
	}
	
	public void contextHandle(String packageName)
	{
		Set<String> contexts = driver.getContextHandles();
		System.out.println("No. of contexts: "+contexts.size());
		for (String ch : contexts)
		{
			System.out.println(ch);
			driver.context("WEBVIEW_"+packageName);
		}
	}

}
