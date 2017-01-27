package una.cr.design.service;

import java.util.List;
import una.cr.design.dao.ConsultorioDAO;
import una.cr.design.model.Consultorio;

/**
 *
 * @author John
 */
public class ConsultorioService {

    private ConsultorioDAO consultorioDAO;

    /**
     * Constructor sin parámetros
     */
    public ConsultorioService() {
    }

    public ConsultorioService(ConsultorioDAO consultorioDao) {
        this.consultorioDAO = consultorioDao;
    }

    public Consultorio findById(int id) {
        return consultorioDAO.findById(id);
    }

    public Consultorio saveConsultorio(Consultorio consultorio) {
        return consultorioDAO.saveConsultorio(consultorio);
    }

    public List<Consultorio> findAll() {
        return consultorioDAO.findAll();
    }

    public boolean deleteConsultorio(int id) {
        return consultorioDAO.deleteConsultorio(id);
    }

    public Consultorio updateConsultorio(Consultorio consultorio) {
        return consultorioDAO.updateConsultorio(consultorio);
    }

    public ConsultorioDAO getConsultorioDAO() {
        return consultorioDAO;
    }

    public void setConsultorioDAO(ConsultorioDAO pacienteDAO) {
        this.consultorioDAO = pacienteDAO;
    }
}
