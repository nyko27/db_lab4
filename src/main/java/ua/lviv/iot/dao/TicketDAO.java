package ua.lviv.iot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import ua.lviv.iot.connection.HibernateJPA;
import ua.lviv.iot.model.Ticket;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TicketDAO implements GeneralDAO<Ticket> {

    @Override
    public List<Ticket> findAll() throws SQLException {
        List<Ticket> tickets = new LinkedList<>();
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            tickets = session.createQuery("from Ticket ").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return tickets;
    }


    @Override
    public Ticket findById(Integer id) throws SQLException {
        Ticket ticket = null;
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            ticket = session.get(Ticket.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public void create(Ticket ticket) throws SQLException {

        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            session.save(ticket);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void update(Ticket newTicket) throws SQLException {
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            session.update(newTicket);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = HibernateJPA.getSession()) {
            session.beginTransaction();
            Ticket ticketToDelete = session.get(Ticket.class, id);
            if (ticketToDelete != null) {
                session.delete(ticketToDelete);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}
