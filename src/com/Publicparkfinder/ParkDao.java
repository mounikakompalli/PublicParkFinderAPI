package com.Publicparkfinder;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
/*
 * To Load Parks information from predefined json file 
 * */
public class ParkDao {

	public List<Park> getParks(double lat, double lon) {
		List<Park> parkList = null;
		final List<Park> filteredParkList = new ArrayList<Park>();

		ObjectMapper mapper = new ObjectMapper();
		Parks parks = null;

		try {

			parks = mapper.readValue(new File("C:/Users/mouni/parksData.json"), Parks.class);

			parks.getParks().forEach((eachPark) -> {

				System.out.println("Each Object" + eachPark.getLattitude() + "," + eachPark.getLongitude());

				System.out.println("Distance" + distance(lat, lon, eachPark.getLattitude(), eachPark.getLongitude()));

				double distance = distance(lat, lon, eachPark.getLattitude(), eachPark.getLongitude());
				if (distance <= 10.00)
				{
					eachPark.setDistance(distance);
					filteredParkList.add(eachPark);
				}

			});
			
			Collections.sort(filteredParkList);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filteredParkList;
	}

	/* 
	 * to calculate distance between two geo coordinates
	 * */
	private static double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		return (dist);
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
