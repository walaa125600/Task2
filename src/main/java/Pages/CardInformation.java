package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class CardInformation extends PageBase{
    public CardInformation (WebDriver driver) {
        this.driver = driver;
        jSExecutor =(JavascriptExecutor)driver;

    }
    Extractor ext;
    WebDriverWait wait;

    public void CreditCardInformation() throws Exception {
        ext=new Extractor();

        String CardNumValue= ext.Locaters(1,18);
        String CardNumLocator=ext.Locaters(0,40);
        WebElement CardNumTxtBox=driver.findElement(By.id(CardNumLocator));
        SetTextElementTxt(CardNumTxtBox,CardNumValue);
       // driver.switchTo().alert().accept();
        try{
            driver.switchTo().alert().accept();
        }
        catch(Exception e){

        }

        String MonthValue = ext.Locaters(1, 19);
        String MonthLocator = ext.Locaters(0, 41);
       Select select = new Select(driver.findElement(By.id(MonthLocator)));
       select.selectByVisibleText(MonthValue);

        String YearLocator = ext.Locaters(0, 42);
        select = new Select(driver.findElement(By.id(YearLocator)));
        select.selectByIndex(5);

        String CVVNumValue= ext.Locaters(1,20);
        String CVVNumLocator=ext.Locaters(0,43);
        WebElement CVVNumTxtBox=driver.findElement(By.id(CVVNumLocator));
        SetTextElementTxt(CVVNumTxtBox,CVVNumValue);

        String CardHolderNameValue= ext.Locaters(1,21);
        String CardHolderNameLocator=ext.Locaters(0,44);
        WebElement CardHolderNameTxtBox=driver.findElement(By.id(CardHolderNameLocator));
        SetTextElementTxt(CardHolderNameTxtBox,CardHolderNameValue);

        String ProceedBtnLocator = ext.Locaters(0, 45);
        WebElement ProceedBtn = driver.findElement(By.id(ProceedBtnLocator));
        ClickBtn(ProceedBtn);


    }

}
