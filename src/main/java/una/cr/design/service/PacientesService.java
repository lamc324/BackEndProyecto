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
import una.cr.design.dao.PacienteDAO;
import una.cr.design.model.Paciente;

/**
 *
 * @author Grupo Tango
 */
public class PacientesService {


    private PacienteDAO pacienteDAO;

    /**
     * Constructor sin parámetros
     */
    public PacientesService() {
    }

    /**
     *
     * @param pacienteDao
     */
    public PacientesService(PacienteDAO pacienteDao) {
        this.pacienteDAO = pacienteDao;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Paciente findById(int id){
        return pacienteDAO.findById(id);
    }

    /**
     *
     * @param paciente
     * @return
     */
    public Paciente savePaciente(Paciente paciente) {
        return pacienteDAO.savePaciente(paciente);
    }
    
    /**
     *
     * @return
     */
    public List<Paciente> findAll() {
        return pacienteDAO.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean deletePaciente(int id) {
        return pacienteDAO.deletePaciente(id);
    }

    /**
     *
     * @param paciente
     * @return
     */
    public Paciente updatePaciente(Paciente paciente) {
        return pacienteDAO.updatePaciente(paciente);
    }

    /**
     *
     * @return
     */
    public PacienteDAO getPacienteDAO() {
        return pacienteDAO;
    }

    /**
     *
     * @param pacienteDAO
     */
    public void setPacienteDAO(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }
    
}