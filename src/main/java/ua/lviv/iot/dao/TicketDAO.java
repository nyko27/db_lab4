package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements GeneralDAO<Ticket> {

    private static final String SELECT_ALL = "SELECT * FROM sky_scanner.ticket";
    private static final String SELECT_ONE = "SELECT * FROM sky_scanner.ticket WHERE id=?";
    private static final String CREATE = "INSERT sky_scanner.ticket (flight_id, price_in_uah) VALUES (?,?)";
    private static final String UPDATE = "UPDATE sky_scanner.ticket SET flight_id=?, price_in_uah=? WHERE id=?";
    private static final String DELETE = "DELETE FROM sky_scanner.ticket WHERE id=?";

    @Override
    public List<Ticket> findAll() throws SQLException {
        List<Ticket> tickets = new ArrayList<Ticket>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("flight_id"),
                        resultSet.getInt("price_in_uah"));
                tickets.add(ticket);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket findById(Integer id) throws SQLException {
        Ticket ticket = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ticket = new Ticket(resultSet.getInt("id"),
                        resultSet.getInt("flight_id"),
                        resultSet.getInt("price_in_uah"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ticket;
    }

    @Override
    public void create(Ticket ticket) throws SQLException {

        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setInt(1, ticket.getFlightId());
            ps.setInt(2, ticket.getPriceInUah());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Ticket newTicket) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setInt(1, id);
            ps.setInt(2, newTicket.getFlightId());
            ps.setInt(3, newTicket.getPriceInUah());

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
