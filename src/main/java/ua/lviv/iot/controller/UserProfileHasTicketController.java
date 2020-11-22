package ua.lviv.iot.controller;

import ua.lviv.iot.dao.UserProfileHasTicketDAO;
import ua.lviv.iot.model.UserProfileHasTicket;

import java.sql.SQLException;
import java.util.List;

public class UserProfileHasTicketController implements GeneralController<UserProfileHasTicket> {

    UserProfileHasTicketDAO dao = new UserProfileHasTicketDAO();

    @Override
    public List<UserProfileHasTicket> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public UserProfileHasTicket findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(UserProfileHasTicket userProfileHasTicket) throws SQLException {
        dao.create(userProfileHasTicket);
    }

    @Override
    public void update(Integer id, UserProfileHasTicket userProfileHasTicket) throws SQLException {
        dao.update(id , userProfileHasTicket);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
