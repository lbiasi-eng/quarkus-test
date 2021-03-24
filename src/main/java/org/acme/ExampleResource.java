package org.acme;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.entity.Account;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	List<Account> accounts = Account.listAll();
    	String names = accounts.stream().map(a -> a.getName()).collect(Collectors.joining(" "));
    	
        return "Hello to " + names;
    }
}