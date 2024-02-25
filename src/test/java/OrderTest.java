import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.MainPage;
import pageObject.OrderFirstPage;
import pageObject.OrderSecondPage;

import static constants.Constant.URL;
import static org.junit.Assert.assertTrue;

public class OrderTest {

    /*   Уважаемый ревьюер, добрый день!
    К сожалению, не смогла написать тест одновременно для двух браузеров Google Chrome
    и Mozilla Firefoх. Я сделала два pom.xml файла (их можно найти в двух коммитах).
    В первом коммите pom.xml зависимости работают Google Chrome, но не работают Mozilla Firefoх.
    Во втором коммите pom.xml зависимости работают Mozilla Firefoх,но не работают Google Chrome.
    Объединить зависимости в один файл для работы с двумя браузерами не получилось в консоли ошибки,
    которые не могу починить.
    */

    WebDriver driver;
    private final String firstName = "Аманда";
    private final String secondName = "Фирс";
    private final String address = "Улица Вязов";
    private final String phone = "89110000000";
    private final String dayData = "28";


    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @After
    public void teardown() {
        WebDriver driver = new FirefoxDriver();
        driver.quit();
    }

    @Test
    public void OrderWithTopButtonTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.closeCookieBar();
        objMainPage.clickOnTopOrderButton();

        OrderFirstPage objOrderFirstPage = new OrderFirstPage(driver);
        objOrderFirstPage.setFirstName(firstName);
        objOrderFirstPage.setSecondName(secondName);
        objOrderFirstPage.setAddress(address);
        objOrderFirstPage.selectStation("Лубянка");
        objOrderFirstPage.setNumber(phone);
        objOrderFirstPage.clickNextButton();


        OrderSecondPage objOrderSecondPage = new OrderSecondPage(driver);

        objOrderSecondPage.setData(dayData);
        objOrderSecondPage.setPeriod("двое суток");
        objOrderSecondPage.clickOrderButton();
        objOrderSecondPage.confirmOrderButton();

        assertTrue(objOrderSecondPage.isFinalStatusOrderDisplayed());
    }

    @Test
    public void OrderWithDownButtonTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.closeCookieBar();
        objMainPage.clickOnDownOrderButton();

        OrderFirstPage objOrderFirstPage = new OrderFirstPage(driver);
        objOrderFirstPage.setFirstName(firstName);
        objOrderFirstPage.setSecondName(secondName);
        objOrderFirstPage.setAddress(address);
        objOrderFirstPage.selectStation("Лубянка");
        objOrderFirstPage.setNumber(phone);
        objOrderFirstPage.clickNextButton();


        OrderSecondPage objOrderSecondPage = new OrderSecondPage(driver);

        objOrderSecondPage.setData(dayData);
        objOrderSecondPage.setPeriod("двое суток");
        objOrderSecondPage.clickOrderButton();
        objOrderSecondPage.confirmOrderButton();

        assertTrue(objOrderSecondPage.isFinalStatusOrderDisplayed());
    }
}
