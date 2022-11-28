package tests;

import Pages.BorderPage;
import Pages.CardInformation;
import Pages.HomePage;
import Pages.SearchResultPage;
import org.testng.annotations.Test;

public class Runner extends TestBase{
    @Test(priority = 0)
    public void NavigateToRoomSet() throws Exception {
        HomePage HomePageObject =new HomePage(driver);
        HomePageObject.SelectDestination();
        HomePageObject.SelectDate();
        HomePageObject.ClickingOnSearchBtn();
        SearchResultPage SearchPageObject=new SearchResultPage(driver);
        SearchPageObject.SelectRandomItem();
        BorderPage BorderObject=new BorderPage(driver);
        BorderObject.SelectRandomBoardingPointSeat();
        BorderObject.SelectRandomDroppingPointSeat();
        BorderObject.FullFillCustomerDetails();
        BorderObject.FullFillFirstPassengerDetails();
        BorderObject.FullFillSecondPassengerDetails();
        CardInformation CardObject=new CardInformation(driver);
        CardObject.CreditCardInformation();

    }
}
