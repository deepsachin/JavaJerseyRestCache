package com.contacts.restjersey;

/**
 * @author Sachin Deep
 */

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.contacts.inmemory.ContactInMemoryCache;


@Path("/")
public class ContactService{

	@GET
	@Path("/contacts/{id}")
	@Produces("application/json")
	public Response getContactByID(@PathParam("id") int f) throws JSONException {
		System.out.println("Data GET args: " +Integer.toString(f));
		ContactInMemoryCache<String, String> cache = new ContactInMemoryCache<String, String>(200, 500, 1000);  	
		System.out.println("Data GET: " + cache.get(Integer.toString(f)));
		String result = "" + cache.get(Integer.toString(f));
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/contacts")
	@Produces("application/json")
	public Response getAllContacts() {
		ContactInMemoryCache<String, String> cache = new ContactInMemoryCache<String, String>(200, 500, 1000);  	

		System.out.println("Data GET All count: " + cache.size());
		// To Do - Need to implement logic to get all the items from cache
		// To Do- Build json response with all items from cache
		String result = "";
		return Response.status(200).entity(result).build();
	}

	@POST
	@Path("/contacts")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(InputStream incomingData){
		String result = "";
		Random randomGenerator = new Random();
		int randomIntID = randomGenerator.nextInt(100);
		StringBuilder jsonData = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				jsonData.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}

		result = jsonData.toString();
		System.out.println("Data Received: " + result);

		ContactInMemoryCache<String, String> cache = new ContactInMemoryCache<String, String>(200, 500, 1000);
		cache.put(Integer.toString(randomIntID), result);

		JSONObject json_data_post = new JSONObject(result);
		json_data_post.put("id", Integer.toString(randomIntID));
		String post_result = "" + json_data_post;

		System.out.println("Created: " + Integer.toString(randomIntID));
		System.out.println("Data Posted: " + cache.get(Integer.toString(randomIntID)));
		// return HTTP response 200 in case of success
		return Response.status(200).entity(post_result).build();
	}

	@PUT
	@Path("/contacts/{id}")
	@Consumes("application/json")
	public Response update(InputStream incomingData){
		String result = "";
		StringBuilder jsonData = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				jsonData.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}

		result = jsonData.toString();
		System.out.println("Data Received: " + result);

		//To Do - Get Real ContactID from the existing Cache by given id in json 
		String ContactID = "";
		ContactInMemoryCache<String, String> cache = new ContactInMemoryCache<String, String>(200, 500, 1000);
		cache.put(ContactID, result);

		System.out.println("Updated: " + ContactID);
		System.out.println("Data Posted: " + cache.get(ContactID));
		// return HTTP response 200 in case of success
		return Response.status(200).build();
	}
}