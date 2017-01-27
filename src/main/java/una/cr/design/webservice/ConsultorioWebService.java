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
import una.cr.design.dao.ConsultorioDAO;
import una.cr.design.model.Consultorio;
import una.cr.design.service.ConsultorioService;
import una.cr.design.service.PacientesService;

/**
 *
 * @author John
 */
@Path("consultorios")
public class ConsultorioWebService {

    private ConsultorioDAO consultorioDAO;
    private ConsultorioService consultorioService;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public ConsultorioWebService() {
    }

    /**
     * Retrieves All the Students
     *
     * @return Student
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consultorio> getAllPacientes() {
        List<Consultorio> consultorioList = null;
        consultorioDAO = new ConsultorioDAO();
        consultorioService = new ConsultorioService(consultorioDAO);

        consultorioList = consultorioService.findAll();

        return consultorioList;
    }

    /**
     * Retrieves only one student
     *
     * @param id
     * @return Student
     */
    @GET
    @Path("/{id_consultorio}")
    @Produces(MediaType.APPLICATION_JSON)
    public Consultorio getPacientes(@PathParam("id_consultorio") int id) {
        Consultorio consultorio = null;
        consultorioDAO = new ConsultorioDAO();
        consultorioService = new ConsultorioService(consultorioDAO);

        consultorio = consultorioService.findById(id);

        return consultorio;
    }

    /**
     * Create a new Student
     *
     * @param paciente
     * @return student
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Consultorio createStudent(Consultorio consultorio) {

        consultorioDAO = new ConsultorioDAO();
        consultorioService = new ConsultorioService(consultorioDAO);

        consultorio = consultorioService.saveConsultorio(consultorio);

        return consultorio;
    }

    /**
     * Delete a new Student
     *
     * @param id
     * @return student
     */
    @DELETE
    @Path("/{id_consultorio}")
    public boolean deletePaciente(@PathParam("id_consultorio") int id) {
        boolean result;
        consultorioDAO = new ConsultorioDAO();
        consultorioService = new ConsultorioService(consultorioDAO);

        result = consultorioService.deleteConsultorio(id);

        return result;
    }

    /**
     * Update a Student
     *
     * @param paciente
     * @return student
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

