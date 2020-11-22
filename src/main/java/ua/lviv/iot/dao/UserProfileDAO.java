package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Ticket;
import ua.lviv.iot.model.UserProfile;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserProfileDAO implements GeneralDAO<UserProfile> {

    private static final String SELECT_ALL = "SELECT * FROM sky_scanner.user_profile";
    private static final String SELECT_ONE = "SELECT * FROM sky_scanner.user_profile WHERE id=?";
    private static final String CREATE = "INSERT sky_scanner.user_profile (user_name, surname) VALUES (?,?)";
    private static final String UPDATE = "UPDATE sky_scanner.user_profile SET user_name=?, surname=? WHERE id=?";
    private static final String DELETE = "DELETE FROM sky_scanner.user_profile WHERE id=?";

    @Override
    public List<UserProfile> findAll() throws SQLException {
        List<UserProfile> profiles = new ArrayList<UserProfile>();
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
            System.out.println(ps);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                UserProfile profile = new UserProfile(
                        resultSet.getInt("id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("surname"));
                profiles.add(profile);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return profiles;
    }

    @Override
    public UserProfile findById(Integer id) throws SQLException {
        UserProfile profile = null;
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                profile = new UserProfile(resultSet.getInt("id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("surname"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return profile;
    }

    @Override
    public void create(UserProfile profile) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
            ps.setString(1, profile.getUserName());
            ps.setString(2, profile.getSurName());
            ps.executeUpdate();
            System.out.println(ps);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void update(Integer id, UserProfile profile) throws SQLException {
        try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
            ps.setInt(3, id);
            ps.setString(1, profile.getUserName());
            ps.setString(2, profile.getSurName());

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
