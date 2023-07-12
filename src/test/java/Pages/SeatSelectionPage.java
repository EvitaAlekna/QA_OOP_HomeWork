package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeatSelectionPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By BOOK_BTN3 = By.id("book3");

    private BaseFunc baseFunc;

    public SeatSelectionPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSeat(int seatNr) {
        baseFunc.waitForElementsCountToBeAtLeast(SEAT, 15);
        List<WebElement> seats = baseFunc.findElements(SEAT);
        Assertions.assertFalse(seats.isEmpty(), "There is no seats at all!");
        boolean flag = false;
        for (WebElement seat : seats) {
            if (Integer.parseInt(seat.getText()) == seatNr) {
                seat.click();
                flag = true;
                break;
            }
        }

        Assertions.assertTrue(flag, "Seat is" + seatNr + "not found");
    }

    public void clickBook() {
        baseFunc.click(BOOK_BTN3);
    }
}
