package ua.lviv.iot.dao;


import ua.lviv.iot.model.Airport;
import ua.lviv.iot.connection.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AirportDAO implements GeneralDAO<Airport> {

    private static final String SELECT_ALL = "SELECT * FROM sky_scanner.airport";
    private static final String SELECT_ONE = "SELECT * FROM sky_scanner.airport WHERE id=?";
    private static final String CREATE = "INSERT sky_scanner.airport(airport_name, city, country, airline_id) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE sky_scanner.airport"
            + " SET airport_name=?, city=?, country=?, airline_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM sky_scanner.airport WHERE id=?";


    @Override
    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new ArrayList<Airport>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Airport airport = new Airport(
                        resultSet.getInt("id"),
                        resultSet.getInt("airline_id"),
                        resultSet.getString("airport_name"),
                        resultSet.getString("city"),
                        resultSet.getString("country")

                );
                airports.add(airport);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return airports;
    }

    @Override
    public Airport findById(Integer id) throws SQLException {
        Airport airport = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                airport = new Airport(result.getInt("id"), result.getInt("airline_id"),
                        result.getString("airport_name"), result.getString("city"),
                        result.getString("country"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return airport;
    }


    @Override
    public void create(Airport newAirport) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setString(1, newAirport.getAirportName());
            ps.setString(2, String.valueOf(newAirport.getCity()));
            ps.setString(3, String.valueOf(newAirport.getCountry()));
            ps.setInt(4,newAirport.getAirLineId());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Airport updatedAirport) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setString(1, updatedAirport.getAirportName());
            ps.setString(2, updatedAirport.getCity());
            ps.setString(3, updatedAirport.getCountry());
            ps.setInt(4, updatedAirport.getAirLineId());
            ps.setInt(5, id);
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