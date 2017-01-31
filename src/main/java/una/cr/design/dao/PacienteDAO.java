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
package una.cr.design.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import una.cr.design.model.Paciente;

/**
 *
 * @author Grupo Tango
 */
public class PacienteDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * 
     * @param id
     * @return
     */
    public Paciente findById(int id) {
        Paciente paciente = null;
        org.hibernate.Query query = session.createQuery("from Paciente where id_paciente = :id_paciente ");
        query.setParameter("id_paciente", id);

        if (query.list().size() > 0) {
            paciente = (Paciente) query.list().get(0);
        }

        return paciente;
    }
    
    /**
     *
     * @param paciente
     * @return
     */
    public Paciente savePaciente(Paciente paciente) {
        session.beginTransaction();
        session.save(paciente);
        session.getTransaction().commit();

        return paciente;
    }
    
    /**
     *
     * @return
     */
    public List<Paciente> findAll() {
        List<Paciente> pacienteList = new ArrayList<>();

        pacienteList = session.createCriteria(Paciente.class).list();

        return pacienteList;
    }

    /**
     *
     * @param id
     * @return
     */
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

    /**
     *
     * @param paciente
     * @return
     */
    public Paciente updatePaciente(Paciente paciente) {
        session.beginTransaction();
        session.update(paciente);
        session.getTransaction().commit();

        return paciente;
    }

}
