package ua.lviv.iot.controller;

import ua.lviv.iot.dao.AirportDAO;
import ua.lviv.iot.model.Airport;

import java.sql.SQLException;
import java.util.List;

public class AirportController implements GeneralController<Airport> {

    AirportDAO airportDAO = new AirportDAO();

    @Override
    public List<Airport> findAll() throws SQLException {
        return airportDAO.findAll();
    }

    @Override
    public Airport findById(Integer id) throws SQLException {
        return airportDAO.findById(id);
    }

    @Override
    public void create(Airport airport) throws SQLException {
        airportDAO.create(airport);
    }

    @Override
    public void update(Integer id, Airport airport) throws SQLException {
        airportDAO.update(id, airport);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        airportDAO.delete(id);
    }
}
