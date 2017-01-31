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

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import una.cr.design.model.Cita;

/**
 *
 * @author Grupo Tango
 */
public class CitaDAO {
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @param id
     * @return
     */
    public Cita findById(int id) {
        Cita cita = null;
        org.hibernate.Query query = session.createQuery("from Cita where id_cita = :id_cita ");
        query.setParameter("id_cita", id);

        if (query.list().size() > 0) {
            cita = (Cita) query.list().get(0);
        }

        return cita;
    }

    /**
     *
     * @param cita
     * @return
     */
    public Cita saveCita(Cita cita) {
        session.beginTransaction();
        session.save(cita);
        session.getTransaction().commit();

        return cita;
    }

    /**
     *
     * @return
     */
    public List<Cita> findAll() {
        List<Cita> citaList = new ArrayList<>();

        citaList = session.createCriteria(Cita.class).list();

        return citaList;
    }

    /**
     *
     * @param id
     * @return
     */
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

    /**
     *
     * @param cita
     * @return
     */
    public Cita updateCita(Cita cita) {
        session.beginTransaction();
        session.update(cita);
        session.getTransaction().commit();

        return cita;
    }
}
