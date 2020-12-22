package ua.lviv.iot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import ua.lviv.iot.connection.HibernateJPA;
import ua.lviv.iot.model.Airline;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class AirlineDAO implements GeneralDAO<Airline> {

    @Override
    public List<Airline> findAll() throws SQLException {
        List<Airline> airlines = new LinkedList<>();
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            airlines = session.createQuery("from Airline ").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return airlines;
    }


    @Override
    public Airline findById(Integer id) throws SQLException {
        Airline airline = null;
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            airline = session.get(Airline.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return airline;
    }

    @Override
    public void create(Airline airline) throws SQLException {

        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            session.save(airline);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void update(Airline newAirline) throws SQLException {
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            session.update(newAirline);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            Airline airlineToDelete = session.get(Airline.class, id);
            if (airlineToDelete != null) {
                session.delete(airlineToDelete);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}

