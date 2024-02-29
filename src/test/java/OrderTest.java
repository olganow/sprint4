import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;
import pageObject.OrderFirstPage;
import pageObject.OrderSecondPage;

import static constants.Constant.URL;
import static org.junit.Assert.assertTrue;

public class OrderTest {

    private WebDriver driver;
    private MainPage objMainPage;
    private OrderFirstPage objOrderFirstPage;
    private OrderSecondPage objOrderSecondPage;
    private final String firstName = "Аманда";
    private final String secondName = "Фирс";
    private final String address = "Улица Вязов";
    private final String phone = "89110000000";
    private final String dayData = "28";


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        objMainPage = new MainPage(driver);
        objOrderFirstPage = new OrderFirstPage(driver);
        objOrderSecondPage = new OrderSecondPage(driver);
        driver.get(URL);
        objMainPage.closeCookieBar();
    }

    @After
    public void teardown() {
        driver = new ChromeDriver();
        driver.quit();
    }


    private void fillOrderDetails() {
        objOrderFirstPage.setFirstName(firstName);
        objOrderFirstPage.setSecondName(secondName);
        objOrderFirstPage.setAddress(address);
        objOrderFirstPage.selectStation("Лубянка");
        objOrderFirstPage.setNumber(phone);
        objOrderFirstPage.clickNextButton();

        objOrderSecondPage.setData(dayData);
        objOrderSecondPage.setPeriod("двое суток");
        objOrderSecondPage.clickOrderButton();
        objOrderSecondPage.confirmOrderButton();
    }

    @Test
    public void orderWithTopButtonTest() {
        objMainPage.clickOnTopOrderButton();
        fillOrderDetails();
        assertTrue(objOrderSecondPage.isFinalStatusOrderDisplayed());
    }

    @Test
    public void orderWithDownButtonTest() {
        objMainPage.clickOnDownOrderButton();
        fillOrderDetails();
        assertTrue(objOrderSecondPage.isFinalStatusOrderDisplayed());
    }
}
