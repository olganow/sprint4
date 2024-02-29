package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;
    private final By cookieConfirmButton = By.id("rcc-confirm-button");
    private final By accordionHeadQuestionList = By.className("accordion__button");
    private final By questionText = By.className("accordion__panel");
    private final By topOrderButton = By.className("Button_Button__ra12g");
    private final By downOrderButton = By.xpath(".//*[text() = 'Как это работает']/parent::div//*[text() = 'Заказать']");

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


    //Cделать заказ через верхнюю кнопку
    public void clickOnTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    //Cделать заказ через нижнюю кнопку
    public void clickOnDownOrderButton() {
        driver.findElement(downOrderButton).click();
    }

}

