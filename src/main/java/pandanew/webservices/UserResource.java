package pandanew.webservices;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import pandanew.objects.User;

@Path("/gebruikers")
public class UserResource {

	private JsonObjectBuilder userToJson(User u){
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("firstname", u.getUserName())
	    .add("lasttime",u.getLasttime());
	    
        return job;
    }	
	@GET
	@Produces("application/json")
	public String getUser(){
		UserService service = UserServiceProvider.getUserService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for (User u : service.getAllUsers()){
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("name",u.getUserName());
			job.add("lasttime", u.getLasttime());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
    @PUT
	@Path("{naam}")
	@Produces("application/json")
	public Response updateUserLasttime(@PathParam("naam") String name)
				{
    	String lasttime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		UserService service = UserServiceProvider.getUserService();
		User u = service.getUserByName(name);
		
		if(u != null) {
			u.setLasttime(lasttime);
			String a = userToJson(service.updateLasttime(u)).build().toString();
			return Response.ok(a).build();
		}
		
		throw new WebApplicationException("User not found!");
		
	}

}
