package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Airline;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AirlineDAO implements GeneralDAO<Airline> {

    private static final String SELECT_ALL = "SELECT * FROM sky_scanner.airline";
    private static final String SELECT_ONE = "SELECT * FROM sky_scanner.airline WHERE id=?";
    private static final String CREATE = "INSERT sky_scanner.airline "
            + "(airline_name) VALUES (?)";
    private static final String UPDATE = "UPDATE sky_scanner.airline"
            + " SET airline_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM sky_scanner.airline WHERE id=?";


    @Override
    public List<Airline> findAll() throws SQLException {
        List<Airline> airlines = new ArrayList<Airline>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Airline airline = new Airline(
                        resultSet.getInt("id"),
                        resultSet.getString("airline_name")
                );
                airlines.add(airline);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return airlines;
    }

    @Override
    public Airline findById(Integer id) throws SQLException {
        Airline airline = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                airline = new Airline(
                        result.getInt("id"),
                         result.getString("airline_name")
                );

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return airline;
    }

    @Override
    public void create(Airline newAirline) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setString(1, newAirline.getAirlineName());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, Airline updatedAirline) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setString(1, updatedAirline.getAirlineName());
            ps.setInt(2, id);
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

