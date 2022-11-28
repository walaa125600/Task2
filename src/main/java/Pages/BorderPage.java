package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BorderPage extends PageBase{
    public BorderPage (WebDriver driver) {
        this.driver = driver;
        jSExecutor =(JavascriptExecutor)driver;

    }
    Extractor ext;
    WebDriverWait wait;

    public void SelectRandomBoardingPointSeat() throws Exception {
        ext = new Extractor();
        wait = new WebDriverWait(driver, 100);
        // Find and click on a random product
        String AvailableSeatLocator = ext.Locaters(0, 10);
        List<WebElement> AvailableSeatList = driver.findElements(By.xpath(AvailableSeatLocator ));
        wait = new WebDriverWait(driver, 100);
        Random rand = new Random();
        int randomProduct = rand.nextInt(AvailableSeatList.size());
        System.out.println(randomProduct);
        System.out.println("5");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",AvailableSeatList.get(randomProduct));
         AvailableSeatList.get(randomProduct).click();

    }

    public void SelectRandomDroppingPointSeat() throws Exception {
        ext = new Extractor();

        wait = new WebDriverWait(driver, 100);
        String DroppingPointTab = ext.Locaters(0, 12);
        WebElement DroppingPointElement= driver.findElement(By.xpath(DroppingPointTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",DroppingPointElement);
        ClickBtn(DroppingPointElement);

        // Find and click on a random product
        String AvailableSeatLocator = ext.Locaters(0, 10);
        List<WebElement> AvailableSeatList = driver.findElements(By.xpath(AvailableSeatLocator ));
        wait = new WebDriverWait(driver, 100);
        Random rand = new Random();
        int randomProduct = rand.nextInt(AvailableSeatList.size());
        System.out.println(randomProduct);
        System.out.println("5");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",AvailableSeatList.get(randomProduct));
        AvailableSeatList.get(randomProduct).click();


    }
public void FullFillCustomerDetails() throws Exception {
        ext=new Extractor();
    String CustomerDetailsTab = ext.Locaters(0, 13);
    WebElement CustomerDetailTabElement = driver.findElement(By.xpath(CustomerDetailsTab));
    ClickBtn(CustomerDetailTabElement);

    String EmailTxtLocator= ext.Locaters(1,1);
    String EmailLocator = ext.Locaters(0, 15);
    WebElement EmailTabElement = driver.findElement(By.id(EmailLocator));
    SetTextElementTxt(EmailTabElement,EmailTxtLocator);


    String MobileTxtBoxValue= ext.Locaters(1,2);
    String MobileTxtLocator = ext.Locaters(0, 14);
    WebElement MobileTxtElement = driver.findElement(By.id(MobileTxtLocator));
    SetTextElementTxt(MobileTxtElement,MobileTxtBoxValue);

    String PassengerDetailsTab = ext.Locaters(0, 16);
    WebElement PassengerDetailTabElement = driver.findElement(By.id(PassengerDetailsTab));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PassengerDetailTabElement);


}

public void FullFillFirstPassengerDetails() throws Exception {
    ext = new Extractor();
    String PassengerNameValue = ext.Locaters(1, 3);
    String PassengerNameLocator = ext.Locaters(0, 17);
    WebElement PassengerNameElement = driver.findElement(By.id(PassengerNameLocator));
    SetTextElementTxt(PassengerNameElement, PassengerNameValue);


    String DropDownLocator = ext.Locaters(0, 18);
    driver.findElement(By.id(DropDownLocator));
    Select select = new Select(driver.findElement(By.id(DropDownLocator)));
    select.selectByIndex(1);
    try{
        driver.switchTo().alert().accept();
    }
    catch(Exception e){

    }


    String PassengerAgeValue = ext.Locaters(1, 4);
    String PassengerAgeLocator = ext.Locaters(0, 19);
    WebElement PassengerAgeElement = driver.findElement(By.id(PassengerAgeLocator));
    ClickBtn(PassengerAgeElement);
    SetTextElementTxt(PassengerAgeElement, PassengerAgeValue);


    String ConcessionDropDownLocator = ext.Locaters(0, 20);

    select = new Select(driver.findElement(By.id(ConcessionDropDownLocator)));
    select.selectByIndex(1);

    String CountryValue = ext.Locaters(1, 5);
    String CountryDropDownLocator = ext.Locaters(0, 21);
    select = new Select(driver.findElement(By.id(CountryDropDownLocator)));
    select.selectByValue(CountryValue);





    String PassportNoValue = ext.Locaters(1, 10);
    String PassportNoLocator = ext.Locaters(0, 22);
    WebElement PassportNoElement = driver.findElement(By.id(PassportNoLocator));
    ClickBtn(PassportNoElement);
    SetTextElementTxt(PassportNoElement, PassportNoValue);


    String AddressValue = ext.Locaters(1, 6);
    String AddressLocator = ext.Locaters(0, 23);
    WebElement AddressElement = driver.findElement(By.id(AddressLocator));
    ClickBtn(PassportNoElement);
    SetTextElementTxt(AddressElement, AddressValue);



    String DateOfBirthTab = ext.Locaters(0, 25);
    WebElement DateOfBirthElement = driver.findElement(By.id(DateOfBirthTab));
    ClickBtn(DateOfBirthElement);


    String MonthValue = ext.Locaters(1, 7);
    String MonthLocator = ext.Locaters(0, 26);
    select = new Select(driver.findElement(By.className(MonthLocator)));
    select.selectByVisibleText(MonthValue);

    String YearLocator = ext.Locaters(0, 27);
    select = new Select(driver.findElement(By.className(YearLocator)));
    select.selectByIndex(72);

    String Day = ext.Locaters(0, 28);
    WebElement DayElement = driver.findElement(By.xpath(Day));
    ClickBtn(DayElement);



}

    public void FullFillSecondPassengerDetails() throws Exception {
        ext=new Extractor();
        String PassengerNameValue= ext.Locaters(1,11);
        String PassengerNameLocator = ext.Locaters(0, 24);
        WebElement PassengerNameElement = driver.findElement(By.id(PassengerNameLocator));
        SetTextElementTxt(PassengerNameElement,PassengerNameValue);


        String DropDownLocator = ext.Locaters(0, 29);
        Select select = new Select(driver.findElement(By.id(DropDownLocator)));
        select.selectByIndex(2);
        try{
            driver.switchTo().alert().accept();
        }
        catch(Exception e){

        }

        String PassengerAgeValue= ext.Locaters(1,12);
        String PassengerAgeLocator = ext.Locaters(0, 30);
        WebElement PassengerAgeElement = driver.findElement(By.id(PassengerAgeLocator));
        ClickBtn(PassengerAgeElement);
        SetTextElementTxt(PassengerAgeElement,PassengerAgeValue);


        String ConcessionDropDownLocator = ext.Locaters(0, 31);
        select = new Select(driver.findElement(By.id(ConcessionDropDownLocator)));
        select.selectByIndex(1);

        String CountryValue= ext.Locaters(1,13);
        String CountryDropDownLocator = ext.Locaters(0, 32);
        select = new Select(driver.findElement(By.id(CountryDropDownLocator)));
        select.selectByValue(CountryValue);

        String PassportNoValue= ext.Locaters(1,17);
        String PassportNoLocator = ext.Locaters(0, 33);
        WebElement PassportNoElement = driver.findElement(By.id(PassportNoLocator));
        SetTextElementTxt(PassportNoElement,PassportNoValue);


        String AddressValue= ext.Locaters(1,14);
        String AddressLocator = ext.Locaters(0, 34);
        WebElement AddressElement = driver.findElement(By.id(AddressLocator));
        SetTextElementTxt(AddressElement,AddressValue);


        String DateOfBirthTab = ext.Locaters(0, 35);
        WebElement DateOfBirthElement = driver.findElement(By.id(DateOfBirthTab));
        ClickBtn(DateOfBirthElement);


        String MonthValue= ext.Locaters(1,15);
        String MonthLocator = ext.Locaters(0, 36);
        select = new Select(driver.findElement(By.className(MonthLocator)));
        select.selectByVisibleText(MonthValue);

        String YearLocator = ext.Locaters(0, 37);
        select = new Select(driver.findElement(By.className(YearLocator)));
        select.selectByIndex(74);

        String Day = ext.Locaters(0, 38);
        WebElement DayElement = driver.findElement(By.xpath(Day));
        ClickBtn(DayElement);

        try{
            driver.switchTo().alert().accept();
        }
        catch(Exception e){

        }


        String MakePaymentValue = ext.Locaters(0, 39);
        WebElement MakePaymentElement = driver.findElement(By.xpath(MakePaymentValue));
        ClickBtn(MakePaymentElement);

    }




}
