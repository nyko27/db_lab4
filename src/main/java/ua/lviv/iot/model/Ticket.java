package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
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

    public Ticket() {

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
    @Column(name = "flight_id")
    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @Basic
    @Column(name = "price_in_uah")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;
        if (flightId != null ? !flightId.equals(ticket.flightId) : ticket.flightId != null) return false;
        if (priceInUah != null ? !priceInUah.equals(ticket.priceInUah) : ticket.priceInUah != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (flightId != null ? flightId.hashCode() : 0);
        result = 31 * result + (priceInUah != null ? priceInUah.hashCode() : 0);
        return result;
    }


}
