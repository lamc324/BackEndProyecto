/*
 * Copyright (C) 2016 Grupo Tango
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Estudiantes: Luis Alonso Morgan Campos,
 * John Herrera Jimenez, Kevin Venegas Loria, Caleb Villalta Quesada, Josue David Matamorros.
 */
package una.cr.design.service;

import java.util.List;
import una.cr.design.dao.ConsultorioDAO;
import una.cr.design.model.Consultorio;

/**
 *
 * @author Grupo Tango
 */
public class ConsultorioService {

    private ConsultorioDAO consultorioDAO;

    /**
     * Constructor sin parámetros
     */
    public ConsultorioService() {
    }

    /**
     *
     * @param consultorioDao
     */
    public ConsultorioService(ConsultorioDAO consultorioDao) {
        this.consultorioDAO = consultorioDao;
    }

    /**
     *
     * @param id
     * @return
     */
    public Consultorio findById(int id) {
        return consultorioDAO.findById(id);
    }

    /**
     *
     * @param consultorio
     * @return
     */
    public Consultorio saveConsultorio(Consultorio consultorio) {
        return consultorioDAO.saveConsultorio(consultorio);
    }

    /**
     *
     * @return
     */
    public List<Consultorio> findAll() {
        return consultorioDAO.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteConsultorio(int id) {
        return consultorioDAO.deleteConsultorio(id);
    }

    /**
     *
     * @param consultorio
     * @return
     */
    public Consultorio updateConsultorio(Consultorio consultorio) {
        return consultorioDAO.updateConsultorio(consultorio);
    }

    /**
     *
     * @return
     */
    public ConsultorioDAO getConsultorioDAO() {
        return consultorioDAO;
    }

    /**
     *
     * @param pacienteDAO
     */
    public void setConsultorioDAO(ConsultorioDAO pacienteDAO) {
        this.consultorioDAO = pacienteDAO;
    }
}
