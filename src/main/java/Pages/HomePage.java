package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        this.driver = driver;
        jSExecutor =(JavascriptExecutor)driver;

    }
    Extractor ext;
    public void SelectDestination() throws Exception {
        ext = new Extractor();
        ScrollToBottom();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        String Destination= ext.Locaters(0,2);
        WebElement DestinationElement= driver.findElement(By.xpath(Destination));
        ClickBtn(DestinationElement);


    }

public void SelectDate() throws Exception {
    ext = new Extractor();


    WebDriverWait wait = new WebDriverWait(driver, 50);
    String CalenderLocator = ext.Locaters(0, 4);
    new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(CalenderLocator)));


    DateFormat("26","December","2022");


}
public void ClickingOnSearchBtn() throws Exception {
    ext = new Extractor();
    String SearchBtn= ext.Locaters(0,5);
    WebElement SearchBtnElement= driver.findElement(By.xpath(SearchBtn));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SearchBtnElement);
     ClickBtn(SearchBtnElement);
}
public static String[] getMonthYearValue(String  MonthYearValue){
    return MonthYearValue.split(" ");
    }

    public  void DateFormat(String exDay, String exMonth, String ExYear)throws Exception
    {


        if(exMonth.equals("February") && Integer.parseInt(exDay)>29 ){
            System.out.println("Wrong Day Selection: " +exMonth+ " : " +exDay);
            return;

        }
        if(Integer.parseInt(exDay)>31){
            System.out.println("Wrong Day Selection: " +exMonth+ " : " +exDay);
            return;
        }


        String MonthLocator=ext.Locaters(0,6);
        String MonthYearValue=driver.findElement(By.className(MonthLocator)).getText();

        while (!(getMonthYearValue(MonthYearValue)[0].equals(exMonth)
                && getMonthYearValue(MonthYearValue)[1].equals(ExYear))){
            String NextArrow= ext.Locaters(0,7);
            WebElement NextArrowElement= driver.findElement(By.xpath(NextArrow));
            ClickBtn(NextArrowElement);
            MonthLocator=ext.Locaters(0,6);
            MonthYearValue=driver.findElement(By.className(MonthLocator)).getText();
            System.out.println(MonthYearValue);


        }
        try{
            WebElement DayElement=this.driver.findElement(By.xpath("//a[text()='"+exDay+"']"));
            jSExecutor.executeScript("arguments[0].click();", DayElement);
        }
        catch(Exception e){
        System.out.println("Wrong Day Selection: " +exMonth+ " : " +exDay);

        }

    }





}

