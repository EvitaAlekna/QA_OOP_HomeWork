package Pages;

import model.ReservationInfo;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PassengerInfoPage {
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULT_COUNT = By.id("adults");
    private final By CHILDREN_COUNT = By.id("children");
    private final By LUGGAGE_COUNT = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick = 'setLang();']");
    private final By BOOK_BTN = By.id("book2");

    private final By RESERVATION_INFO = By.xpath(".//span[@class = 'bTxt']");

    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInPassengerInfo(ReservationInfo reservationInfo) {
        baseFunc.type(NAME_INPUT, reservationInfo.getFirstName());
        baseFunc.type(SURNAME_INPUT, reservationInfo.getLastName());
        baseFunc.type(DISCOUNT_INPUT, reservationInfo.getDiscount());
        baseFunc.type(ADULT_COUNT, reservationInfo.getPassengerCount());
        baseFunc.type(CHILDREN_COUNT, reservationInfo.getChildCount());
        baseFunc.type(LUGGAGE_COUNT, reservationInfo.getBagsCount());
        baseFunc.selectByText(FLIGHT, reservationInfo.getFlightDate());
    }

    public void clickPrice() {
        baseFunc.click(GET_PRICE_BTN);
    }

    public String getFirstFromAirport() {
        return baseFunc.findElements(RESERVATION_INFO).get(0).getText();
    }

    public String getFirstToAirport() {
        return baseFunc.findElements(RESERVATION_INFO).get(1).getText();
    }

    public String getSecondFromAirport() {
        return baseFunc.findElements(RESERVATION_INFO).get(3).getText();
    }

    public String getSecondToAirport() {
        return baseFunc.findElements(RESERVATION_INFO).get(4).getText();
    }

    public String getPassengerName() {
        baseFunc.waitForElementsCountToBeAtLeast(RESERVATION_INFO, 3);
        String name = baseFunc.findElements(RESERVATION_INFO).get(2).getText();
        return name.substring(0, name.length() - 1);
    }

    public void clickBook() {
        baseFunc.click(BOOK_BTN);
    }
}




