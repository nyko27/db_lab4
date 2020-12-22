package ua.lviv.iot.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import ua.lviv.iot.connection.HibernateJPA;
import ua.lviv.iot.model.Airport;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class AirportDAO implements GeneralDAO<Airport> {

    @Override
    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new LinkedList<>();
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            airports = session.createQuery("from Airport ").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return airports;
    }

    @Override
    public Airport findById(Integer id) throws SQLException {
        Airport Airport = null;
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            Airport = session.get(Airport.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return Airport;
    }

    @Override
    public void create(Airport newAirport) throws SQLException {

        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            session.save(newAirport);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Airport newAirport) throws SQLException {
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            session.update(newAirport);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            Airport airportToDelete = session.get(Airport.class, id);
            if (airportToDelete != null) {
                session.delete(airportToDelete);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}