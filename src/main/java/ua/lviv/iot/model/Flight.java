package ua.lviv.iot.model;

import java.util.Date;

public class Flight {

    private Integer id;
    private Integer airlineId;
    private Integer departureAirportId;
    private Integer arrivalAirportId;
    private Integer allowedBaggageInKilograms;
    private String airplaneName;


    public Flight(Integer id, Integer airlineId, Integer departureAirportId, Integer arrivalAirportId,
                  Integer allowedBaggageInKilograms, String airplaneName) {
        this.id = id;
        this.airlineId = airlineId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.allowedBaggageInKilograms = allowedBaggageInKilograms;
        this.airplaneName = airplaneName;
    }

    public Flight(Integer airlineId, Integer departureAirportId, Integer arrivalAirportId,
                  Integer allowedBaggageInKilograms, String airplaneName) {
        this(null, airlineId, departureAirportId, arrivalAirportId, allowedBaggageInKilograms, airplaneName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public Integer getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(Integer departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public Integer getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(Integer arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    public Integer getAllowedBaggageInKilograms() {
        return allowedBaggageInKilograms;
    }

    public void setAllowedBaggageInKilograms(Integer allowedBaggageInKilograms) {
        this.allowedBaggageInKilograms = allowedBaggageInKilograms;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }


    @Override
    public String toString() {
        return "\nFlight: " +
                "id:" + id +
                ", airlineId" + airlineId +
                ", departureAirportId:" + departureAirportId +
                ", arrivalAirportId:" + arrivalAirportId +
                ", allowedBaggageInKilograms:" + allowedBaggageInKilograms +
                ", airplaneName:" + airplaneName;
    }
}
