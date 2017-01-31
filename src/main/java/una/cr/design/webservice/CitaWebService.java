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
package una.cr.design.webservice;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import una.cr.design.dao.CitaDAO;
import una.cr.design.model.Cita;
import una.cr.design.service.CitaService;

/**
 *
 * @author Grupo Tango
 */
@Path("citas")
public class CitaWebService {
    private CitaDAO citaDAO;
    private CitaService citaService;

    @Context
    private UriInfo context;

    /**
     * 
     */
    public CitaWebService() {
    }

    /**
     * Obtiene todas las citas
     *
     * @return Student
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cita> getAllCitas() {
        List<Cita> citaList = null;
        citaDAO = new CitaDAO();
        citaService = new CitaService(citaDAO);

        citaList = citaService.findAll();

        return citaList;
    }

    /**
     * Obtiene una sola cita
     *
     * @param id
     * @return Student
     */
    @GET
    @Path("/{id_cita}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cita getCita(@PathParam("id_cita") int id) {
        Cita cita = null;
        citaDAO = new CitaDAO();
        citaService = new CitaService(citaDAO);

        cita = citaService.findById(id);

        return cita;
    }

    /**
     * Crea una cita
     *
     * @param cita
     * @return student
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cita createCita(Cita cita) {

        citaDAO = new CitaDAO();
        citaService = new CitaService(citaDAO);

        cita = citaService.saveCita(cita);

        return cita;
    }

    /**
     * Borra una cita
     *
     * @param id
     * @return student
     */
    @DELETE
    @Path("/{id_cita}")
    public boolean deleteCita(@PathParam("id_cita") int id) {
        boolean result;
        citaDAO = new CitaDAO();
        citaService = new CitaService(citaDAO);

        result = citaService.deleteCita(id);

        return result;
    }

    /**
     * Actualiza una cita
     *
     * @param cita
     * @return student
     */
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cita updateCita(Cita cita) {

        citaDAO = new CitaDAO();
        citaService = new CitaService(citaDAO);

        cita = citaService.updateCita(cita);

        return cita;
    }
}
