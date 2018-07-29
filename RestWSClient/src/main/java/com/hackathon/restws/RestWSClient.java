package com.hackathon.restws;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import com.hackathon.restws.model.*;


public class RestWSClient {

	private static final String Jams_SERVER_URL = "http://localhost:9081/RestWSServer/services/Jamsservice";

	public static void main(String[] args) {
		//getSingle(123);
		getAll();
	}
	
	
	public static void getSingle(long idValue) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Jams_SERVER_URL).path("/Jamss").path("/{id}").resolveTemplate("id", idValue);
		Builder request = target.request();
		System.out.println( "Status:-" + request.get().getStatus() );
		Jams Jams = request.get(Jams.class);
		System.out.println( Jams );
	}
	
	public static void getAll() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Jams_SERVER_URL).path("/Jamss");
		Builder request = target.request();
		Response response = request.get();
		Jams[] readEntity = response.readEntity(Jams[].class);	
		System.out.println( "Status:-" + request.get().getStatus() );
		System.out.println( "List of Jams");
		for(int i = 0; i < readEntity.length; i++) {
			System.out.println( readEntity[i] );
		}	 
		
	}

}
