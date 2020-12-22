package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
public class Airport {

    private Integer id;
    private Integer airLineId;
    private String airportName;
    private String city;
    private String country;

    public Airport(Integer id, Integer airLineId, String airportName, String city, String country) {
        this.id = id;
        this.airLineId = airLineId;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
    }

    public Airport(Integer airLineId, String airportName, String city, String country) {
        this(null, airLineId, airportName, city, country);
    }

    public Airport() {

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
    @Column(name = "airport_name")
    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "airline_id")
    public Integer getAirLineId() {
        return airLineId;
    }

    public void setAirLineId(Integer airlineId) {
        this.airLineId = airlineId;
    }

    @Override
    public String toString() {
        return "\nAirport: " +
                "id:" + id + ", airLineId:" + airLineId + ", city:" + city + ", country:" + country +
                ", airportName: " + airportName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (id != null ? !id.equals(airport.id) : airport.id != null) return false;
        if (airportName != null ? !airportName.equals(airport.airportName) : airport.airportName != null) return false;
        if (city != null ? !city.equals(airport.city) : airport.city != null) return false;
        if (country != null ? !country.equals(airport.country) : airport.country != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (airportName != null ? airportName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
