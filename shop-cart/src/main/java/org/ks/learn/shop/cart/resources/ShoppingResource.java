package org.ks.learn.shop.cart.resources;

import org.ks.learn.shop.cart.entity.ShoppingItem;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Path("/api/shop")
@ApplicationScoped
public class ShoppingResource {

    List<ShoppingItem> shoppingItemList = new ArrayList<>();

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems() {
        return Response.ok(shoppingItemList).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "writer"})
    public Response addItem(ShoppingItem newItem) {
        shoppingItemList.add(newItem);
        return Response.ok(shoppingItemList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin", "writer"})
    public Response updateItem(ShoppingItem item) {
        shoppingItemList.stream().filter(shoppingItem -> shoppingItem.getUuid().equals(item.getUuid()))
                .findFirst().ifPresent(shoppingItem -> shoppingItemList.remove(shoppingItem));
        shoppingItemList.add(item);
        return Response.ok(shoppingItemList).build();
    }

    @Path("{id}")
    @DELETE
    @RolesAllowed({"admin"})
    public Response removeItem(@PathParam("id") UUID id) {
        shoppingItemList.stream().filter(shoppingItem -> shoppingItem.getUuid().equals(id))
                .findFirst().ifPresent(shoppingItem -> shoppingItemList.remove(shoppingItem));
        return Response.noContent().build();
    }
}
