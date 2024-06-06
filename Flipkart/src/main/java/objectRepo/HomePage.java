package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HomePage {
	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"mobiles\"]/android.view.ViewGroup/android.view.ViewGroup[1]")
	private WebElement searchBar;
	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}
	
	public void searchForAProduct()
	{
		searchBar.click();
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Iphone 15");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(AppiumBy.id("com.flipkart.android:id/not_now_button")).click();
		driver.findElement(AppiumBy.id("com.flipkart.android:id/not_now_button")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"View All Variants\"));")).click();
	}

}
