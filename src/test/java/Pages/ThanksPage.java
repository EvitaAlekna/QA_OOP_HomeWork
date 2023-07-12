package Pages;

import model.ReservationInfo;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ThanksPage {
    private final By TEXT = By.xpath(".//div[@class = 'finalTxt']");

    private BaseFunc baseFunc;

    public ThanksPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getFinalText() {
        return baseFunc.findElement(TEXT).getText();
    }
}
