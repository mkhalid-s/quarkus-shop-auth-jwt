package org.ks.learn.shop.auth.resources;

import org.ks.learn.shop.auth.services.JwtService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/jwt")
@ApplicationScoped
public class ShoppingJwtResource {

    @Inject
    JwtService shoppingJwtService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getJwtToken() {
        return Response.ok(shoppingJwtService.generateJwtToken()).build();
    }
}
