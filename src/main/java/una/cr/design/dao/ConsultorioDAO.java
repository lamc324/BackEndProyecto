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
import una.cr.design.model.Consultorio;

/**
 *
 * @author Grupo Tango
 */
public class ConsultorioDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @param id
     * @return
     */
    public Consultorio findById(int id) {
        Consultorio consultorio = null;
        org.hibernate.Query query = session.createQuery("from Consultorio where id_consultorio = :id_consultorio ");
        query.setParameter("id_consultorio", id);

        if (query.list().size() > 0) {
            consultorio = (Consultorio) query.list().get(0);
        }

        return consultorio;
    }

    /**
     *
     * @param consultorio
     * @return
     */
    public Consultorio saveConsultorio(Consultorio consultorio) {
        session.beginTransaction();
        session.save(consultorio);
        session.getTransaction().commit();

        return consultorio;
    }

    /**
     *
     * @return
     */
    public List<Consultorio> findAll() {
        List<Consultorio> consultorioList = new ArrayList<>();

        consultorioList = session.createCriteria(Consultorio.class).list();

        return consultorioList;
    }

    /**
     *
     * @param id
     * @return
     */
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

    /**
     *
     * @param consultorio
     * @return
     */
    public Consultorio updateConsultorio(Consultorio consultorio) {
        session.beginTransaction();
        session.update(consultorio);
        session.getTransaction().commit();

        return consultorio;
    }
}
