package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Ticket;
import ua.lviv.iot.model.UserProfileHasTicket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserProfileHasTicketDAO implements GeneralDAO<UserProfileHasTicket>{

    private static final String SELECT_ALL = "SELECT * FROM sky_scanner.user_profile_has_ticket";
    private static final String SELECT_ONE = "SELECT * FROM sky_scanner.user_profile_has_ticket WHERE id=?";
    private static final String CREATE = "INSERT sky_scanner.user_profile_has_ticket (user_profile_id, ticket_id)" +
            "VALUES (?,?)";
    private static final String UPDATE = "UPDATE sky_scanner.user_profile_has_ticket SET user_profile_id=?," +
            "ticket_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM sky_scanner.user_profile_has_ticket WHERE id=?";

    @Override
    public List<UserProfileHasTicket> findAll() throws SQLException {
        List<UserProfileHasTicket> usersTickets = new ArrayList<UserProfileHasTicket>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                UserProfileHasTicket usersTicket = new UserProfileHasTicket(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_profile_id"),
                        resultSet.getInt("ticket_id"));
                usersTickets.add(usersTicket);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return usersTickets;
    }

    @Override
    public UserProfileHasTicket findById(Integer id) throws SQLException {
        UserProfileHasTicket userTicket = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                userTicket = new UserProfileHasTicket(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_profile_id"),
                        resultSet.getInt("ticket_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return userTicket;
    }

    @Override
    public void create(UserProfileHasTicket newUserTicket) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setInt(1, newUserTicket.getUserProfileId());
            ps.setInt(2, newUserTicket.getTicketId());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, UserProfileHasTicket userProfileHasTicket) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setInt(3, id);
            ps.setInt(1, userProfileHasTicket.getUserProfileId());
            ps.setInt(2, userProfileHasTicket.getTicketId());

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
