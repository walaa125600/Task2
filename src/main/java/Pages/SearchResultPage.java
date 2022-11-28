package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchResultPage extends PageBase{
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        jSExecutor =(JavascriptExecutor)driver;

    }
    Extractor ext;
    WebDriverWait wait;
    public void SelectRandomItem() throws Exception {
        ext = new Extractor();
        wait = new WebDriverWait(driver, 100);
        String RandomListLocator = ext.Locaters(0, 8);
        List<WebElement> allSeats = driver.findElements(By.xpath(RandomListLocator));
        wait = new WebDriverWait(driver, 100);
        Random rand = new Random();
        int randomProduct = rand.nextInt(allSeats.size());
        System.out.println(randomProduct);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allSeats.get(randomProduct));
        allSeats.get(randomProduct).click();
    }



}
