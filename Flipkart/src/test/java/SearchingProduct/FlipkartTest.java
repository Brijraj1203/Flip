package SearchingProduct;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import objectRepo.HomePage;
import objectRepo.LaunchPage;

public class FlipkartTest extends BaseClass{
	@Test
	public void phoneTest() throws MalformedURLException
	{		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		LaunchPage launchPage=new LaunchPage(driver);
		launchPage.clickOnSkipButton();
		
		HomePage hmPage=new HomePage(driver);
		hmPage.searchForAProduct();

		
	}

}
