/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import una.cr.design.model.Cita;

/**
 *
 * @author John
 */
public class CitaDAO {
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    public Cita findById(int id) {
        Cita cita = null;
        org.hibernate.Query query = session.createQuery("from Cita where id_cita = :id_cita ");
        query.setParameter("id_cita", id);

        if (query.list().size() > 0) {
            cita = (Cita) query.list().get(0);
        }

        return cita;
    }

    public Cita saveCita(Cita cita) {
        session.beginTransaction();
        session.save(cita);
        session.getTransaction().commit();

        return cita;
    }

    public List<Cita> findAll() {
        List<Cita> citaList = new ArrayList<>();

        citaList = session.createCriteria(Cita.class).list();

        return citaList;
    }

    public boolean deleteCita(int id) {
        boolean isDeleted = false;
        Cita cita = null;

        session.beginTransaction();
        cita = (Cita) session.get(Cita.class, id);
        session.delete(cita);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }

    public Cita updateCita(Cita cita) {
        session.beginTransaction();
        session.update(cita);
        session.getTransaction().commit();

        return cita;
    }
}
