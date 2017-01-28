package una.cr.design.service;

import java.util.List;
import una.cr.design.dao.CitaDAO;
import una.cr.design.model.Cita;

/**
 *
 * @author John
 */


public class CitaService {
     private CitaDAO citaDAO;

    /**
     * Constructor sin parámetros
     */
    public CitaService() {
    }

    public CitaService(CitaDAO citaDao) {
        this.citaDAO = citaDao;
    }

    public Cita findById(int id) {
        return citaDAO.findById(id);
    }

    public Cita saveCita(Cita cita) {
        return citaDAO.saveCita(cita);
    }

    public List<Cita> findAll() {
        return citaDAO.findAll();
    }

    public boolean deleteCita(int id) {
        return citaDAO.deleteCita(id);
    }

    public Cita updateCita(Cita cita) {
        return citaDAO.updateCita(cita);
    }

    public CitaDAO getCitaDAO() {
        return citaDAO;
    }

    public void setCitaDAO(CitaDAO citaDao) {
        this.citaDAO = citaDao;
    }
}
