package org.standrews.schedulingsurgeries.domain;

public class OperatingRoom {
    private Long operatingRoomId;
    private String operatingRoomName;
    private String openingTime;
    private String closingTime;

    public OperatingRoom(){
    }

    public OperatingRoom(String operatingRoomName, String openingTime, String closingTime) {
        this.operatingRoomName = operatingRoomName;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public Long getOperatingRoomId() {
        return operatingRoomId;
    }

    public String getOperatingRoomName() {
        return operatingRoomName;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }
}
