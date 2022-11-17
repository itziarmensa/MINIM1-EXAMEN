package edu.upc.dsa.Services;

import edu.upc.dsa.Domain.Covid19Manager;
import edu.upc.dsa.Domain.Entity.Exceptions.*;
import edu.upc.dsa.Domain.Entity.Info.PersonaInfo;
import edu.upc.dsa.Domain.Entity.Muestra;
import edu.upc.dsa.Infraestructure.Covid19ManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/sistema", description = "Endpoint to Sistema Service")
@Path("/sistema")
public class Services {

    private Covid19Manager manager;

    public Services() throws PersonaYaExiste, LabYaExiste, MuestraYaExiste {
        this.manager = Covid19ManagerImpl.getInstance();

        if(manager.size() == 0){
            this.manager.añadirPersona("432746","Itziar","Mensa",20,"A");
            this.manager.añadirPersona("3728865","Paula","Mensa",19,"B");
            this.manager.añadirPersona("378238346","Monica","Minguito",49,"C");
            this.manager.añadirPersona("3618235","Sara","Jimenez",36,"D");

            this.manager.crearLab("4327873","Vall d'Hebron");
            this.manager.crearLab("4327","Clínic");
            this.manager.crearLab("54738","Hospital Igualada");
            this.manager.crearLab("546326","Sant Joan de Déu");

            this.manager.añadirMuestra("4873934629","4327873","3728865", "17/11/2022","4327");
            this.manager.añadirMuestra("5214","4327","432746", "19/11/2022","546326");
        }
    }


    @POST
    @ApiOperation(value = "añadir una nueva persona", notes = "Añadir persona")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exitoso", response= PersonaInfo.class),
            @ApiResponse(code = 409, message = "La persona ya existe")
    })
    @Path("/persona")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response añadirPersona(PersonaInfo persona){
        try{
            this.manager.añadirPersona(persona.getIdPersona(),persona.getNombrePersona(),persona.getApellidosPersona(),persona.getEdadPersona(),persona.getSaludPersona());
        }catch(PersonaYaExiste e){
            return Response.status(409).entity(persona).build();
        }
        return Response.status(201).entity(persona).build();
    }

    @PUT
    @ApiOperation(value = "extraer muestra", notes = "Extraer Muestra")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exitoso"),
            @ApiResponse(code = 400, message = "La persona, el laboratorio o la muestra no existen"),
    })
    @Path("/muestra")
    @Produces(MediaType.APPLICATION_JSON)
    public Response extraerMuestra(Muestra muestra) {
        try {
            this.manager.extraerMuestra(muestra);
        } catch (PersonaNoExiste | LabNoExiste | MuestraYaExiste e) {
            return Response.status(403).build();
        }
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "procesar muestra", notes = "Procesar Muestra")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exitoso"),
            @ApiResponse(code = 400, message = "El laboratorio no existe"),
    })
    @Path("/muestra/{idLab}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response procesarMuestra(@PathParam("idLab") String idLab) {
        try {
            this.manager.procesarMuestra(idLab);
        } catch (LabNoExiste e) {
            return Response.status(403).build();
        }
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Lista muestras procesadas de una persona", notes = "Lista Muestras")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exitoso",response = Muestra.class, responseContainer="List")

    })
    @Path("/persona/{idPersona}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response nivelActual(@PathParam("idPersona") String idPersona){
        try {
            List<Muestra> lista = this.manager.listaMuestrasPersonaProcesadas(idPersona);
            GenericEntity<List<Muestra>> entity = new GenericEntity<List<Muestra>>(lista) {};
            return Response.status(200).entity(entity).build();
        }catch (PersonaNoExiste e){
            return Response.status(400).build();
        }

    }
}
