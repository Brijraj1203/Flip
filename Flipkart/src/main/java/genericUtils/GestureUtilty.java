package genericUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/**
 * this class contains methods to perform different gestures
 * @author Brijraj
 */
public class GestureUtilty {
	AndroidDriver driver;
	public GestureUtilty(AndroidDriver driver) 
	{
		this.driver=driver;
	}
	
	/**
	 * this method performs long click gesture on an element for 3 seconds
	 * 
	 */
	public void longClick(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"duration",3000));
	}
	
	/**
	 * this method performs long click gesture on a given x,y coordinate for 3 seconds
	 * @param x
	 * @param y
	 */
	public void longClickByCordinates(int x,int y)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("x",x,"y",y,"duration",3000));
	}
	
	/**
	 * This method performs click gesture on an WebElement
	 * @param element
	 */
	public void click(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
	}
	
	/**
	 * This method performs click gesture at a given x and y coordinate
	 * @param x
	 * @param y
	 */
	public void clickByCordinates(int x,int y)
	{
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture", ImmutableMap.of("x",x,"y",y));
	}
	
	/**
	 * this method double clicks on an element
	 * @param element
	 */
	public void doubleClick(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
	}
	
	/**
	 * this method double clicks at a given coordinate
	 * @param x
	 * @param y
	 */
	public void doubleClickByCordinates(int x,int y)
	{
		((JavascriptExecutor)driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of("x",x,"y",y));
	}
	
	/**
	 * this method drags an element and drops it at x,y coordinate
	 * @param element
	 * @param x
	 * @param y
	 */
	public void dragAnElement(WebElement element,int x, int y)
	{
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"endX",x,"endY",y));
	}
	
	/**
	 * performs drag action from startX,startY coordinate to x,y coordinate
	 * @param startX
	 * @param startY
	 * @param x
	 * @param y
	 */
	public void dragFromACoordinate(int startX,int startY,int x, int y)
	{
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of("startX",startX,"startY",startY,"endX",x,"endY",y));
	}
	
	/**
	 * this method performs swipe on an element
	 * direction can be left,right,up and down
	 * percent should be between 0 and 1
	 * @param element
	 * @param direction
	 * @param percent
	 */
	public void swipe(WebElement element,String direction,double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"direction",direction,"percent",percent));
	}
	
	/**
	 * this method performs swipe from a coordinate to a coordinate
	 * direction can be left,right,up and down
	 * percent should be between 0 and 1
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 * @param direction
	 * @param percent
	 */
	public void swipeByCoordinates(int left,int top,int width,int height,String direction,double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left",left,"top",top,"width",width,"height",height,"direction",direction,"percent",percent));
	}
	
	/**
	 * this method performs pinch open gesture on an element
	 * percent should be between 0 and 1
	 * @param element
	 * @param percent
	 */
	public void pinchOpenGesture(WebElement element,double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent",percent));
	}
	
	/**
	 * this method perform pinch open gesture by coordinates
	 * percent should be between 0 and 1
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 * @param percent
	 */
	public void pinchOpenGestureByCoordinate(int left,int top,int width,int height,double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("left",left,"top",top,"width",width,"height",height,"percent",percent));
	}
	
	/**
	 * this method performs pinch close gesture on an element
	 * percent should be between 0 and 1
	 * @param element
	 * @param percent
	 */
	public void pinchCloseGesture(WebElement element,double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent",percent));
	}
	
	/**
	 * this method perform pinch close gesture by coordinates
	 * percent should be between 0 and 1
	 * @param left
	 * @param top
	 * @param width
	 * @param height
	 * @param percent
	 */
	public void pinchCloseGestureByCoordinate(int left,int top,int width,int height,double percent)
	{
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of("left",left,"top",top,"width",width,"height",height,"percent",percent));
	}
	
	/**
	 * this method performs scrolling till a provided text
	 * @param text
	 */
	public void scrollTillText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector).scrollIntoView(text(\""+text+"\"));"));
	}
	
	/**
	 * this method performs scrolling till an element according to provided text and clicks on it
	 * @param text
	 */
	public void scrollTillElementAndClick(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector).scrollIntoView(text(\""+text+"\"));")).click();
	}

}
