package ua.lviv.iot.controller;

import ua.lviv.iot.dao.TicketDAO;
import ua.lviv.iot.model.Ticket;

import java.sql.SQLException;
import java.util.List;

public class TicketController implements GeneralController<Ticket> {

    TicketDAO ticketDAO = new TicketDAO();

    @Override
    public List<Ticket> findAll() throws SQLException {
        return ticketDAO.findAll();
    }

    @Override
    public Ticket findById(Integer id) throws SQLException {
        return ticketDAO.findById(id);
    }

    @Override
    public void create(Ticket ticket) throws SQLException {
        ticketDAO.create(ticket);
    }

    @Override
    public void update(Ticket ticket) throws SQLException {
        ticketDAO.update(ticket);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        ticketDAO.delete(id);
    }
}
