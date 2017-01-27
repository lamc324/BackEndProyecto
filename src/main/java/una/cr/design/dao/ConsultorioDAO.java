/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.cr.design.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import una.cr.design.model.Consultorio;
import una.cr.design.model.Paciente;

/**
 *
 * @author John
 */
public class ConsultorioDAO {
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    
    public Consultorio findById(int id) {
        Consultorio consultorio = null;
        org.hibernate.Query query = session.createQuery("from Consultorio where id_consultorio = :id_consultorio ");
        query.setParameter("id_consultorio", id);

        if (query.list().size() > 0) {
            consultorio = (Consultorio) query.list().get(0);
        }

        return consultorio;
    }
    
    public Consultorio saveConsultorio(Consultorio consultorio) {
        session.beginTransaction();
        session.save(consultorio);
        session.getTransaction().commit();

        return consultorio;
    }
    
    public List<Consultorio> findAll() {
        List<Consultorio> consultorioList = new ArrayList<>();

        consultorioList = session.createCriteria(Paciente.class).list();

        return consultorioList;
    }

    public boolean deleteConsultorio(int id) {
        boolean isDeleted = false;
        Consultorio consultorio = null;

        session.beginTransaction();
        consultorio = (Consultorio) session.get(Consultorio.class, id);
        session.delete(consultorio);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }

    public Consultorio updateConsultorio(Consultorio consultorio) {
        session.beginTransaction();
        session.update(consultorio);
        session.getTransaction().commit();

        return consultorio;
    }
}
