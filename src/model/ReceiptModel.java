package model;

public class ReceiptModel {
    private final int confirmationNumber;
    private final String date;
    private final String carType;
    private final String location;
    private final int lengthOfRental;

    ReceiptModel(int confirmationNumber, String date, String carType, String location, int lengthOfRental) {
        this.confirmationNumber = confirmationNumber;
        this.date = date;
        this.carType = carType;
        this.location = location;
        this.lengthOfRental = lengthOfRental;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public String getDate() {
        return date;
    }

    public String getCarType() {
        return carType;
    }

    public String getLocation() {
        return location;
    }

    public int getLengthOfRental() {
        return lengthOfRental;
    }
}