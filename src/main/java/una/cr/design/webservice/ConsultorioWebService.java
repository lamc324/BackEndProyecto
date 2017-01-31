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
import una.cr.design.dao.ConsultorioDAO;
import una.cr.design.model.Consultorio;
import una.cr.design.service.ConsultorioService;

/**
 *
 * @author Grupo Tango
 */
@Path("consultorios")
public class ConsultorioWebService {

    private ConsultorioDAO consultorioDAO;
    private ConsultorioService consultorioService;

    @Context
    private UriInfo context;

    /**
     * 
     */
    public ConsultorioWebService() {
    }

    /**
     * Obtiene todos los consultorios
     *
     * @return Consultorio
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consultorio> getAllConsultorios() {
        List<Consultorio> consultorioList = null;
        consultorioDAO = new ConsultorioDAO();
        consultorioService = new ConsultorioService(consultorioDAO);

        consultorioList = consultorioService.findAll();

        return consultorioList;
    }

    /**
     * Obtiene solo un consultorio
     *
     * @param id
     * @return Consultorio
     */
    @GET
    @Path("/{id_consultorio}")
    @Produces(MediaType.APPLICATION_JSON)
    public Consultorio getConsultorio(@PathParam("id_consultorio") int id) {
        Consultorio consultorio = null;
        consultorioDAO = new ConsultorioDAO();
        consultorioService = new ConsultorioService(consultorioDAO);

        consultorio = consultorioService.findById(id);

        return consultorio;
    }

    /**
     * Crea un consultorio
     *
     * @param consultorio
     * @return Consultorio
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Consultorio createConsultorio(Consultorio consultorio) {

        consultorioDAO = new ConsultorioDAO();
        consultorioService = new ConsultorioService(consultorioDAO);

        consultorio = consultorioService.saveConsultorio(consultorio);

        return consultorio;
    }

    /**
     * Borra un consultorio
     *
     * @param id
     * @return Consultorio
     */
    @DELETE
    @Path("/{id_consultorio}")
    public boolean deleteConsultorio(@PathParam("id_consultorio") int id) {
        boolean result;
        consultorioDAO = new ConsultorioDAO();
        consultorioService = new ConsultorioService(consultorioDAO);

        result = consultorioService.deleteConsultorio(id);

        return result;
    }

    /**
     * Actualiza un consultorio
     *
     * @param consultorio
     * @return Consultorio
     */
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Consultorio updateConsultorio(Consultorio consultorio) {

        consultorioDAO = new ConsultorioDAO();
        consultorioService = new ConsultorioService(consultorioDAO);

        consultorio = consultorioService.updateConsultorio(consultorio);

        return consultorio;
    }

}
