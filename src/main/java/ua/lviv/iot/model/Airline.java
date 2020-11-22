package ua.lviv.iot.model;

public class Airline {


    private Integer id;
    private String airlineName;

    public Airline(Integer id, String airlineName) {
        this.id = id;
        this.airlineName = airlineName;
    }

    public Airline(String airlineName) {
        this(null, airlineName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }


    @Override
    public String toString() {
        return "\nAirline: " +
                "id:" + id + ", airlineName:" + airlineName;
    }

}
