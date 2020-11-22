package ua.lviv.iot.model;

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

    public Airport( Integer airLineId, String airportName, String city, String country) {
        this(null, airLineId, airportName, city, country);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAirLineId() {
        return airLineId;
    }

    public void setAirLineId(Integer airLineId) {
        this.airLineId = airLineId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "\nAirport: " +
                "id:" + id + ", airLineId:" + airLineId + ", city:" + city + ", country:" + country +
                ", airportName: " + airportName;
    }
}
