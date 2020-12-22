package ua.lviv.iot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import ua.lviv.iot.connection.HibernateJPA;
import ua.lviv.iot.model.Flight;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class FlightDAO implements GeneralDAO<Flight> {


    @Override
    public List<Flight> findAll() throws SQLException {
        List<Flight> flights = new LinkedList<>();
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            flights = session.createQuery("from Flight").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return flights;
    }


    @Override
    public Flight findById(Integer id) throws SQLException {
        Flight flight = null;
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            flight = session.get(Flight.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return flight;
    }

    @Override
    public void create(Flight flight) throws SQLException {

        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            session.save(flight);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void update( Flight newFlight) throws SQLException {
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            session.update(newFlight);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            Flight flightToDelete = session.get(Flight.class, id);
            if (flightToDelete != null){
                session.delete(flightToDelete);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}
