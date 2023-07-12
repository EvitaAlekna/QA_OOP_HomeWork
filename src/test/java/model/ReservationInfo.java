package model;

public class ReservationInfo {
    private String firstName;
    private String lastName;
    private String discount;
    private int passengerCount;
    private int childCount;
    private int bagsCount;
    private String flightDate;

    public ReservationInfo(String firstName, String lastName, String discount, int passengerCount, int childCount,
                           int bagsCount, String flightDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.discount = discount;
        this.passengerCount = passengerCount;
        this.childCount = childCount;
        this.bagsCount = bagsCount;
        this.flightDate = flightDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public int getBagsCount() {
        return bagsCount;
    }

    public void setBagsCount(int bagsCount) {
        this.bagsCount = bagsCount;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }
}
