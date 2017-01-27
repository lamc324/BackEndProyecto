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
 * @author venegas97k
 */
public class PacientesService {


    private PacienteDAO pacienteDAO;

    /**
     * Constructor sin parámetros
     */
    public PacientesService() {
    }

    public PacientesService(PacienteDAO pacienteDao) {
        this.pacienteDAO = pacienteDao;
    }
    
    public Paciente findById(int id){
        return pacienteDAO.findById(id);
    }

    public Paciente savePaciente(Paciente paciente) {
        return pacienteDAO.savePaciente(paciente);
    }
    
    public List<Paciente> findAll() {
        return pacienteDAO.findAll();
    }

    public boolean deletePaciente(int id) {
        return pacienteDAO.deletePaciente(id);
    }

    public Paciente updatePaciente(Paciente paciente) {
        return pacienteDAO.updatePaciente(paciente);
    }

    public PacienteDAO getStudentDAO() {
        return pacienteDAO;
    }

    public void setStudentDAO(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }
    
}