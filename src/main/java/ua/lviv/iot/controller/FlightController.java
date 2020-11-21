package ua.lviv.iot.controller;

import ua.lviv.iot.dao.FlightDAO;
import ua.lviv.iot.model.Flight;

import java.sql.SQLException;
import java.util.List;

public class FlightController implements GeneralController<Flight> {

    FlightDAO flightDAO = new FlightDAO();

    @Override
    public List<Flight> findAll() throws SQLException {
        return flightDAO.findAll();
    }

    @Override
    public Flight findById(Integer id) throws SQLException {
        return flightDAO.findById(id);
    }

    @Override
    public void create(Flight flight) throws SQLException {
        flightDAO.create(flight);
    }

    @Override
    public void update(Integer id, Flight flight) throws SQLException {
        flightDAO.update(id, flight);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        flightDAO.delete(id);
    }
}
