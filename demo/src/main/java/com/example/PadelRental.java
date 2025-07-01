package com.example;


public class PadelRental {
    private String name;
    private String phoneNumber;
    private String rentalDate;
    private String startTime;
    private String endTime;
    private String courtType;


    public PadelRental(String name, String phoneNumber, String rentalDate, String startTime, String endTime, String courtType) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rentalDate = rentalDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.courtType = courtType;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getRentalDate() {
        return rentalDate;
    }


    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }


    public String getStartTime() {
        return startTime;
    }


    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getEndTime() {
        return endTime;
    }


    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getCourtType() {
        return courtType;
    }


    public void setCourtType(String courtType) {
        this.courtType = courtType;
    }
}
