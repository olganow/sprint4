package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSecondPage {
    private final WebDriver driver;
    private final By dataField = By.xpath(".//*[@placeholder = '* Когда привезти самокат']");
    private final By periodField = By.className("Dropdown-placeholder");
    private final By orderButton = By.xpath(".//*[text() = 'Назад']/following-sibling::button");
    private final By confirmOrderButton = By.xpath(".//*[text() = 'Да']");
    private final By finalStatusOrder = By.xpath(".//*[text() = 'Заказ оформлен']");

    public OrderSecondPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setData(String data) {
        driver.findElement(dataField).click();
        driver.findElement(By.xpath(".//*[text() = '" + data + "']")).click();
    }

    public void setPeriod(String period) {
        driver.findElement(periodField).click();
        driver.findElement(By.xpath(".//*[text() = '" + period + "']")).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void confirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

    public boolean isFinalStatusOrderDisplayed() {
        return !driver.findElements(finalStatusOrder).isEmpty();
    }


}