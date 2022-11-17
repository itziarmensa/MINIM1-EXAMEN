package edu.upc.dsa.Services;

import edu.upc.dsa.Domain.Covid19Manager;
import edu.upc.dsa.Infraestructure.ManagerImpl;
import io.swagger.annotations.Api;

import javax.ws.rs.*;

@Api(value = "/*lo que sigui*", description = "Endpoint to *lo que sigui* Service")
@Path("/*lo que sigui*")
public class Services {

    private Covid19Manager manager;

    public Services(){
        this.manager = ManagerImpl.getInstance();

        if(manager.size() == 0){
            //this.manager.registerUser("Alba", "Roma Gómez", "23/11/2001", credentials1);
            // ...

            //this.manager.addObject("Pa Bimbo", "un pa molt bo", 2.3);
            // ...
        }
    }

    //EXEMPLE POST == AFEGIR UNA COSA NOVA
    /*@POST
    @ApiOperation(value = "añadir un nuevo usuario", notes = "Añadir usuarios")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exitoso", response= UsuarioInfo.class),
            @ApiResponse(code = 409, message = "El usuario ya existe")
    })
    @Path("/juego")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response añadirUsuario(UsuarioInfo usuario){
        try{
            this.manager.añadirUsuario(usuario.getId(),usuario.getNombre(),usuario.getApellidos());
        }catch(UsuarioYaExiste e){
            return Response.status(409).entity(usuario).build();
        }
        return Response.status(201).entity(usuario).build();
    }*/

    //EXEMPLE PUT == MODIFICAR UNA COSA EXISTENT
    /*@PUT
    @ApiOperation(value = "iniciar partida", notes = "Iniciar Partida")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exitoso"),
            @ApiResponse(code = 400, message = "El usuario o el juego no existen"),
            @ApiResponse(code = 403, message = "El usuario está en otra partida")
    })
    @Path("/usuario/{usuarioId}/{juegoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarPartida(@PathParam("usuarioId") String userId, @PathParam("juegoId") String juegoId) {
        try {
            this.manager.inicioPartida(userId, juegoId);
        } catch (PartidaActiva e) {
            return Response.status(403).build();
        } catch (UsuarioNoExiste | JuegoNoExiste e) {
            return Response.status(400).build();
        }
        return Response.status(201).build();
    }*/

    //EXEMPLE GET == OBTENIR ALGO DE ALGO JA CREAT
    /*@GET
    @ApiOperation(value = "Nivel actual de un usuario en una partida", notes = "Nivel Actual")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exitoso", responseContainer="List"),
            @ApiResponse(code = 400, message = "El usuario no existe"),
            @ApiResponse(code = 403, message = "El usuario no está en ninguna partida")

    })
    @Path("/usuario/nivel/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response nivelActual(@PathParam("usuarioId") String usuarioId){
        try {
            List<String> lista = this.manager.nivelActual(usuarioId);
            GenericEntity<List<String>> entity = new GenericEntity<List<String>>(lista) {};
            return Response.status(200).entity(entity).build();
        }catch (UsuarioNoExiste e){
            return Response.status(400).build();
        }catch (PartidaInactiva e){
            return Response.status(403).build();
        }

    }*/
}
