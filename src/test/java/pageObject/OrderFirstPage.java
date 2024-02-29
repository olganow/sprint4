package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFirstPage {
    private final WebDriver driver;
    private final By cookieConfirmButton = By.id("rcc-confirm-button");
    private final By firstNameField = By.xpath(".//*[@placeholder = '* Имя']");
    private final By secondNameField = By.xpath(".//*[@placeholder = '* Фамилия']");
    private final By addressField = By.xpath(".//*[@placeholder = '* Адрес: куда привезти заказ']");
    private final By subwayField = By.className("select-search__input");
    private final By nextButton = By.xpath(".//*[text() = 'Далее']");
    private final By numberField = By.xpath(".//*[@placeholder = '* Телефон: на него позвонит курьер']");//поле номера

    public OrderFirstPage(WebDriver driver) {
        this.driver = driver;
    }

    //Закрытие панели и информацией о куках
    public void closeCookieBar() {
        driver.findElement(cookieConfirmButton).click();
    }

    //Проверить что мы на странице ввода персональных данных
    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void selectStation(String station) {
        driver.findElement(subwayField).click();
        driver.findElement(By.xpath(".//*[text() = '" + station + "']")).click();
    }

    public void setNumber(String number) {
        driver.findElement(numberField).sendKeys(number);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}

