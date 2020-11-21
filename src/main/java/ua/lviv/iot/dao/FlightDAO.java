package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class FlightDAO implements GeneralDAO<Flight> {

    private static final String SELECT_ALL = "SELECT * FROM sky_scanner.flight";
    private static final String SELECT_ONE = "SELECT * FROM sky_scanner.flight WHERE id=?";
    private static final String CREATE = "INSERT sky_scanner.flight"
            + "(airline_id, departure_airport_id, arrival_airport_id, allowed_baggage_in_kilogrms, airplane_name)" +
            "VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE sky_scanner.flight"
            + " SET airplane_name=?, allowed_baggage_in_kilogrms=?, departure_airport_id=?, arrival_airport_id=?,  " +
            "airline_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM sky_scanner.flight WHERE id=?";


    @Override
    public List<Flight> findAll() throws SQLException {
        List<Flight> flights = new ArrayList<Flight>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Flight flight = new Flight(
                        resultSet.getInt("id"),
                        resultSet.getInt("airline_id"),
                        resultSet.getInt("departure_airport_id"),
                        resultSet.getInt("arrival_airport_id"),
                        resultSet.getInt("allowed_baggage_in_kilogrms"),
                        resultSet.getString("airplane_name"));
                flights.add(flight);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return flights;
    }


    @Override
    public Flight findById(Integer id) throws SQLException {
        Flight flight = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                flight = new Flight(resultSet.getInt("id"),
                        resultSet.getInt("airline_id"),
                        resultSet.getInt("departure_airport_id"),
                        resultSet.getInt("arrival_airport_id"),
                        resultSet.getInt("allowed_baggage_in_kilogrms"),
                        resultSet.getString("airplane_name"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return flight;
    }

    @Override
    public void create(Flight flight) throws SQLException {

        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setInt(1, flight.getAirlineId());
            ps.setInt(2, flight.getDepartureAirportId());
            ps.setInt(3, flight.getArrivalAirportId());
            ps.setInt(4, flight.getAllowedBaggageInKilograms());
            ps.setString(5, flight.getAirplaneName());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Flight newFlight) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setInt(1, id);
            ps.setString(2, newFlight.getAirplaneName());
            ps.setInt(3, newFlight.getAllowedBaggageInKilograms());
            ps.setInt(4, newFlight.getDepartureAirportId());
            ps.setInt(5, newFlight.getArrivalAirportId());
            ps.setInt(6, newFlight.getAirlineId());

            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(DELETE)) {
            ps.setInt(1, id);
            System.out.println(ps);
            ps.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
