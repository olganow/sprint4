import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.MainPage;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)

public class QuestionTest {

    private String actualText;
    private final String questionText;
    private final int questionIndex;
    private final String expectedText;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    public QuestionTest(int questionIndex, String questionText, String expectedText) {
        this.questionIndex = questionIndex;
        this.questionText = questionText;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getText() {
        return new Object[][]{
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},

        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void teardown() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }

    @Test
    public void questionTest() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        MainPage objMainPage = new MainPage(driver);
        objMainPage.closeCookieBar();
        objMainPage.clickQuestionButton(questionIndex);
        objMainPage.getTextButtonQuestion(questionIndex);

        actualText = objMainPage.getTextQuestion(questionIndex);
        MatcherAssert.assertThat(actualText, containsString(expectedText));

    }
}
