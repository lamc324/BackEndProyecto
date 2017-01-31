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
import una.cr.design.dao.CitaDAO;
import una.cr.design.model.Cita;

/**
 *
 * @author Grupo Tango
 */


public class CitaService {
     private CitaDAO citaDAO;

    /**
     * Constructor sin parámetros
     */
    public CitaService() {
    }

    /**
     *
     * @param citaDao
     */
    public CitaService(CitaDAO citaDao) {
        this.citaDAO = citaDao;
    }

    /**
     *
     * @param id
     * @return
     */
    public Cita findById(int id) {
        return citaDAO.findById(id);
    }

    /**
     *
     * @param cita
     * @return
     */
    public Cita saveCita(Cita cita) {
        return citaDAO.saveCita(cita);
    }

    /**
     *
     * @return
     */
    public List<Cita> findAll() {
        return citaDAO.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteCita(int id) {
        return citaDAO.deleteCita(id);
    }

    /**
     *
     * @param cita
     * @return
     */
    public Cita updateCita(Cita cita) {
        return citaDAO.updateCita(cita);
    }

    /**
     *
     * @return
     */
    public CitaDAO getCitaDAO() {
        return citaDAO;
    }

    /**
     *
     * @param citaDao
     */
    public void setCitaDAO(CitaDAO citaDao) {
        this.citaDAO = citaDao;
    }
}
