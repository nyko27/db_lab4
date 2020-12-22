package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
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

    public Flight() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "airline_id")
    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    @Basic
    @Column(name = "departure_airport_id")
    public Integer getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(Integer departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    @Basic
    @Column(name = "arrival_airport_id")
    public Integer getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(Integer arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    @Basic
    @Column(name = "airplane_name")
    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    @Basic
    @Column(name = "allowed_baggage_in_kilogrms")
    public Integer getAllowedBaggageInKilograms() {
        return allowedBaggageInKilograms;
    }

    public void setAllowedBaggageInKilograms(Integer allowedBaggageInKilograms) {
        this.allowedBaggageInKilograms = allowedBaggageInKilograms;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (id != null ? !id.equals(flight.id) : flight.id != null) return false;
        if (airlineId != null ? !airlineId.equals(flight.airlineId) : flight.airlineId != null) return false;
        if (departureAirportId != null ? !departureAirportId.equals(flight.departureAirportId) : flight.departureAirportId != null)
            return false;
        if (arrivalAirportId != null ? !arrivalAirportId.equals(flight.arrivalAirportId) : flight.arrivalAirportId != null)
            return false;
        if (airplaneName != null ? !airplaneName.equals(flight.airplaneName) : flight.airplaneName != null)
            return false;
        if (allowedBaggageInKilograms != null ? !allowedBaggageInKilograms.equals(flight.allowedBaggageInKilograms) : flight.allowedBaggageInKilograms != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (airplaneName != null ? airplaneName.hashCode() : 0);
        result = 31 * result + (allowedBaggageInKilograms != null ? allowedBaggageInKilograms.hashCode() : 0);
        result = 31 * result + (departureAirportId != null ? departureAirportId.hashCode() : 0);
        result = 31 * result + (arrivalAirportId != null ? arrivalAirportId.hashCode() : 0);
        result = 31 * result + (airlineId != null ? airlineId.hashCode() : 0);
        return result;
    }
}
