import Pages.*;
import model.ReservationInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketsTestOnPage {
    private final String URL = "http://www.qaguru.lv:8089/tickets";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";

    private final String NAME = "Evita";
    private final String SURNAME = "Alekna";
    private final String DISCOUNT = "QwEr137";
    private final int ADULTS = 1;
    private final int CHILDREN = 2;
    private final int BAGS = 3;
    private final String SELECTED_NEXT_FLIGHT = "11-05-2018";
    private ReservationInfo info = new ReservationInfo("Evita", "Alekna", "QwEr137",
            1, 2, 3, "11-05-2018");

    private int seatNr = 13;

    private final String FINAL_TEXT = "Thank You for flying with us!";

    @Test
    public void successTicketsBookCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.selectArrivalAirport(DEPARTURE_AIRPORT);
        homePage.selectDepartureAirport(ARRIVAL_AIRPORT);

        Assertions.assertEquals(DEPARTURE_AIRPORT, homePage.getDepartureAirport(), "Wrong Departure Airport");
        Assertions.assertEquals(ARRIVAL_AIRPORT, homePage.getArrivalAirport(), "Wrong Arrival Airport");

        homePage.clickGoGoGo();

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(info);

        infoPage.clickPrice();

        Assertions.assertEquals(info.getFirstName(), infoPage.getPassengerName(), "Wrong name!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, infoPage.getFirstFromAirport(), "Wrong first arrival Airport!");
        Assertions.assertEquals(DEPARTURE_AIRPORT, infoPage.getFirstToAirport(), "Wrong first departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, infoPage.getSecondFromAirport(), "Wrong second arrival Airport!");
        Assertions.assertEquals(DEPARTURE_AIRPORT, infoPage.getSecondToAirport(), "Wrong second departure Airport!");

        infoPage.clickBook();

        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.selectSeat(seatNr);

        seatSelectionPage.clickBook();

        ThanksPage thanksPage = new ThanksPage(baseFunc);
        Assertions.assertEquals(FINAL_TEXT, thanksPage.getFinalText(), "Wrong final Text!");
    }
}
