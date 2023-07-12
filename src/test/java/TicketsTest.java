import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

import java.time.Duration;
import java.util.List;

public class TicketsTest {
    //Testavije dannije kak i lokatori zhelateljno skladivatj sdesj
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick = 'setLang();']");
    private final By FLIGHT_INFO = By.xpath(".//span[@class = 'bTxt']");

    private final By NEXT_FLIGHT = By.id("flight");
    private final By BOOK_BTN = By.id("book2");
    private final By SELECTED_SEAT = By.xpath(".//div[@onclick = 'seat(13)']");
    private final By BOOK_BTN3 = By.id("book3");


    private final By SELECTED_AIRPORT =By.xpath(".//span[@class = 'bTxt']");
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULT_COUNT = By.id("adults");
    private final By CHILDREN_COUNT = By.id("children");
    private final By LUGGAGE_COUNT = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By TEXT = By.xpath(".//div[@class = 'finalTxt']");
    private final By FLIGHT_PRICE = By.xpath(".//div[@id = 'response']/child::node()");

    private final String URL = "http://www.qaguru.lv:8089/tickets";
    private final String DEPARTURE_AIRPORT = "RIX";
    private final String ARRIVAL_AIRPORT = "MEL";
    private int SEAT_NUMBER = 13;


    private final String NAME = "Evita";
    private final String SURNAME = "Alekna";
    private final String DISCOUNT = "QwEr137";
    private final int ADULTS = 1;
    private final int CHILDREN = 2;
    private final int BAGS = 3;
    private final String SELECTED_NEXT_FLIGHT = "11-05-2018";

    @Test
    public void successTicketsBookCheck() {
        // Open browser
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();

        // Open Home Page
        browser.get(URL);

        // Select Departure airport
        WebElement fromDropdown = browser.findElement(FROM);
        Select fromSelect = new Select(fromDropdown);
        fromSelect.selectByValue(DEPARTURE_AIRPORT);

        // Select Arrival airport
        WebElement toDropdown = browser.findElement(TO);
        Select toSelect = new Select(toDropdown);
        toSelect.selectByValue(ARRIVAL_AIRPORT);

        // Press GoGoGo btn
        browser.findElement(GO_BTN).click();

        //Check if selected airport appears
        List<WebElement> selectedAirports = browser.findElements(SELECTED_AIRPORT);
        System.out.println("First airport" + " " + selectedAirports.get(0).getText());
        System.out.println("Second airport" + " " + selectedAirports.get(1).getText());

        // Fill in passengers personal info
        WebElement nameInputField = browser.findElement(NAME_INPUT);
        nameInputField.clear();
        nameInputField.sendKeys(NAME);

        WebElement surnameInputField = browser.findElement(SURNAME_INPUT);
        surnameInputField.clear();
        surnameInputField.sendKeys(SURNAME);

        WebElement discountInputField = browser.findElement(DISCOUNT_INPUT);
        discountInputField.clear();
        discountInputField.sendKeys(DISCOUNT);

        WebElement adultInputField = browser.findElement(ADULT_COUNT);
        adultInputField.clear();
        adultInputField.sendKeys(String.valueOf(ADULTS));

        WebElement childrenInputField = browser.findElement(CHILDREN_COUNT);
        childrenInputField.clear();
        childrenInputField.sendKeys(String.valueOf(CHILDREN));

        WebElement luggageInputField = browser.findElement(LUGGAGE_COUNT);
        luggageInputField.clear();
        luggageInputField.sendKeys(String.valueOf(BAGS));

        // Select next flight
        WebElement nextFlightsDropdown = browser.findElement(NEXT_FLIGHT);
        Select nextFlightSelect = new Select(nextFlightsDropdown);
        nextFlightSelect.selectByValue(SELECTED_NEXT_FLIGHT);

        // Press Get Price link
        browser.findElement(GET_PRICE_BTN).click();

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(FLIGHT_INFO, 5));

        List<WebElement> flightInfo = browser.findElements(FLIGHT_INFO);
        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(0).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(1).getText(), "Wrong Arrival Airport!");

        String name = flightInfo.get(2).getText();
        Assertions.assertEquals(NAME, name.substring(0, name.length() - 1), "Wrong Name!");

        Assertions.assertEquals(DEPARTURE_AIRPORT, flightInfo.get(3).getText(), "Wrong Departure Airport!");
        Assertions.assertEquals(ARRIVAL_AIRPORT, flightInfo.get(4).getText(), "Wrong Arrival Airport!");

        WebElement responseElement = browser.findElement((By.id("response")));
        String responseText = responseElement.getText();
        String price = responseText;
        String cutOut = price.substring(responseText.indexOf("for") + 4, responseText.indexOf(" EUR"));
        System.out.println(cutOut);


        // Press Book btn
        browser.findElement(BOOK_BTN).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(SELECTED_SEAT, 1));

        // Select seat Nr
        browser.findElement(SELECTED_SEAT).click();

        // Press book btn
        browser.findElement(BOOK_BTN3).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(TEXT, 1));

        // Check if successful msg appears
        WebElement finalText = browser.findElement(TEXT);
        System.out.println(finalText.getText());


    }
}

