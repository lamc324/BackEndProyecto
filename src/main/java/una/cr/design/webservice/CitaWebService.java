/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author John
 */
@Path("citas")
public class CitaWebService {
    private CitaDAO citaDAO;
    private CitaService citaService;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public CitaWebService() {
    }

    /**
     * Retrieves All the Students
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
     * Retrieves only one student
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
     * Create a new Student
     *
     * @param consultorio
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
     * Delete a new Student
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
     * Update a Student
     *
     * @param consultorio
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
