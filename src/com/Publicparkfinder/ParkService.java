package com.Publicparkfinder;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ParkService")
public class ParkService {

   ParkDao parkDao = new ParkDao();

   @GET
   @Path("/parks/{lat}/{lon}")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Park> getParks(@PathParam("lat") double lat,@PathParam("lon") double lon){
      List<Park> allList = parkDao.getParks(lat,lon);
      System.out.println("Parks for user location"+lat+","+lon+" :"+allList.size());
	  
      
      return allList;  
   }	
}