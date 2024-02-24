package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final By cookieConfirmButton = By.id("rcc-confirm-button");
    private final By accordionHeadQuestionList = By.className("accordion__button");
    private final By questionText = By.className("accordion__panel");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Закрытие панели и информацией о куках
    public void closeCookieBar() {
        driver.findElement(cookieConfirmButton).click();
    }

    //Нажать на вопрос
    public void clickQuestionButton(int questionIndex) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(accordionHeadQuestionList));
        driver.findElements(accordionHeadQuestionList).get(questionIndex).click();
    }

    //Получить текст вопроса
    public String getTextButtonQuestion(int questionIndex) {
        return driver.findElements(accordionHeadQuestionList).get(questionIndex).getText();
    }

    //Получить текст из вопроса
    public String getTextQuestion(int questionIndex) {
        return driver.findElements(questionText).get(questionIndex).getText();
    }
}

