package una.cr.design.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import una.cr.design.model.Paciente;

/**
 *
 * @author John
 */
public class PacienteDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    
    public Paciente findById(int id) {
        Paciente paciente = null;
        org.hibernate.Query query = session.createQuery("from Paciente where id_paciente = :id_paciente ");
        query.setParameter("id_paciente", id);

        if (query.list().size() > 0) {
            paciente = (Paciente) query.list().get(0);
        }

        return paciente;
    }
    
    public Paciente savePaciente(Paciente paciente) {
        session.beginTransaction();
        session.save(paciente);
        session.getTransaction().commit();

        return paciente;
    }
    
    public List<Paciente> findAll() {
        List<Paciente> pacienteList = new ArrayList<>();

        pacienteList = session.createCriteria(Paciente.class).list();

        return pacienteList;
    }

    public boolean deletePaciente(int id) {
        boolean isDeleted = false;
        Paciente paciente = null;

        session.beginTransaction();
        paciente = (Paciente) session.get(Paciente.class, id);
        session.delete(paciente);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }

    public Paciente updatePaciente(Paciente paciente) {
        session.beginTransaction();
        session.update(paciente);
        session.getTransaction().commit();

        return paciente;
    }

}
