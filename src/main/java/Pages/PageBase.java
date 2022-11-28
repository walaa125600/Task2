package Pages;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {

	WebDriver driver;


	public PageBase(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public JavascriptExecutor jSExecutor;

	public PageBase() {
	}

	protected static void ClickBtn(WebElement Button)
	{

		Button.click();
	}

	protected static void SetTextElementTxt(WebElement TextElement, String Value)
	{
		TextElement.sendKeys(Value);
	}

	public void ScrollToBottom()
	{

		jSExecutor.executeScript("scrollBy(0,600)");
	}
	
}






