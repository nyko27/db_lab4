package ua.lviv.iot.model;

import java.util.Date;

public class Ticket {

    private Integer id;
    private Integer flightId;
    private Integer priceInUah;


    public Ticket(Integer id, Integer flightId, Integer priceInUah) {
        this.id = id;
        this.flightId = flightId;
        this.priceInUah = priceInUah;

    }

    public Ticket(Integer flightId, Integer priceInUah) {
        this(null, flightId, priceInUah);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getPriceInUah() {
        return priceInUah;
    }

    public void setPriceInUah(Integer priceInUah) {
        this.priceInUah = priceInUah;
    }


    @Override
    public String toString() {
        return "\nTicket: " +
                "id=" + id +
                ", flightId=" + flightId +
                ", priceInUah=" + priceInUah;
    }
}
