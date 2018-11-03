/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.EstadoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Estado;

/**
 * REST Web Service
 *
 * @author SAULOD
 */
@Path("xptows")
public class XPTOWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of XPTOWS
     */
    public XPTOWS() {
    }

    /**
     * Método que lista todos os estados cadastrados
     *
     * @return um objeto JSON
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("estado/listar")
    public String getEstado() {
        List<Estado> listaEstado;
        EstadoDAO estadoDAO = new EstadoDAO();
        Gson gson = new Gson();

        listaEstado = estadoDAO.listar();

        return gson.toJson(listaEstado);
    }

    /**
     * Método que busca um estado por sua sigla
     *
     * @param uf
     * @return um objeto JSON
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("estado/bucarUF/{uf}")
    public String getEstadoUF(@PathParam("uf") String uf) {
        
        Estado estado = new Estado();
        EstadoDAO estadoDAO = new EstadoDAO();
        Gson gson = new Gson();
        estado.setVarUf(uf);
        estado = estadoDAO.buscarUF(estado);

        return gson.toJson(estado);
    }

    /**
     * Método que busca um estado por seu id
     *
     * @param id
     * @return um objeto JSON
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("estado/buscaDesc/{id}")
    public String getEstadoId(@PathParam("id") int id) {
        
        Estado estado = new Estado();
        EstadoDAO estadoDAO = new EstadoDAO();
        Gson gson = new Gson();
        estado.setIdTbEstado(id);
        estado = estadoDAO.buscarUF(estado);

        return gson.toJson(estado);
    }
    /**
     * Método que um estado por sua descricao
     *
     * @param desc
     * @return um objeto JSON
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("estado/buscaDesc/{desc}")
    public String getEstadoDesc(@PathParam("desc") String desc) {
        
        Estado estado = new Estado();
        EstadoDAO estadoDAO = new EstadoDAO();
        Gson gson = new Gson();
        estado.setVarDesc(desc);
        estado = estadoDAO.buscarUF(estado);

        return gson.toJson(estado);
    }
}
