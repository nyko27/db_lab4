package ua.lviv.iot.controller;

import ua.lviv.iot.dao.AirlineDAO;
import ua.lviv.iot.model.Airline;

import java.sql.SQLException;
import java.util.List;

public class AirlineController implements GeneralController<Airline> {

    AirlineDAO airlineDAO = new AirlineDAO();

    @Override
    public List<Airline> findAll() throws SQLException {
        return airlineDAO.findAll();
    }

    @Override
    public Airline findById(Integer id) throws SQLException {
        return airlineDAO.findById(id);
    }

    @Override
    public void create(Airline airline) throws SQLException {
        airlineDAO.create(airline);
    }

    @Override
    public void update(Airline airline) throws SQLException {
        airlineDAO.update(airline);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        airlineDAO.delete(id);
    }
}
