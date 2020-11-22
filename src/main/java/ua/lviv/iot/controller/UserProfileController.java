package ua.lviv.iot.controller;

import ua.lviv.iot.dao.UserProfileDAO;
import ua.lviv.iot.model.UserProfile;

import java.sql.SQLException;
import java.util.List;

public class UserProfileController implements GeneralController<UserProfile> {

    UserProfileDAO userProfileDAO = new UserProfileDAO();

    @Override
    public List<UserProfile> findAll() throws SQLException {
        return userProfileDAO.findAll();
    }

    @Override
    public UserProfile findById(Integer id) throws SQLException {
        return userProfileDAO.findById(id);
    }

    @Override
    public void create(UserProfile profile) throws SQLException {
        userProfileDAO.create(profile);
    }

    @Override
    public void update(Integer id, UserProfile profile) throws SQLException {
        userProfileDAO.update(id, profile);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        userProfileDAO.delete(id);
    }
}
