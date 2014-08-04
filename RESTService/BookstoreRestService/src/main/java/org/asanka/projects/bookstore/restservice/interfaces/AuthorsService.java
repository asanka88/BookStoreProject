package org.asanka.projects.bookstore.restservice.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by asanka on 8/4/14.
 */
@Path("/author")
public interface AuthorsService {
    @GET
    @Path("/{name}")
    @Produces("application/json")
    public Response getAuthor(@PathParam("name") String name);

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Response getAuthors();

    @POST
    @Path("/add")
    @Produces("text/plain")
    public Response addAuthor(@FormParam("name") String name);

    @DELETE
    @Path("/{name}")
    @Produces("text/plain")
    public Response deleteAuthor(@PathParam("name") String name);
}
