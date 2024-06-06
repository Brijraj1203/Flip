package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LaunchPage {
	AndroidDriver driver;
	public LaunchPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.flipkart.android:id/custom_back_icon")
	private WebElement skipButton;
	public AndroidDriver getDriver() {
		return driver;
	}
	public WebElement getSkipButton() {
		return skipButton;
	}
	
	public void clickOnSkipButton() {
		skipButton.click();
	}

}
