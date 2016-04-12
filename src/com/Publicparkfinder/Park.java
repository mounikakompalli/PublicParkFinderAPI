package com.Publicparkfinder;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "park")

/* Creating a PArk Object 
 * To represent Park details
 * */
public class Park implements Serializable,Comparable<Park> {

	private static final long serialVersionUID = 1L;
	private int id;
	private String parkName;
	private String parkAddress;
	private double lattitude;
	private double longitude;
	private double distance;

	public Park() {

	}

	public Park(int id, String parkName, String parkAddress, double lattitude, double longitude) {
		super();
		this.id = id;
		this.parkName = parkName;
		this.parkAddress = parkAddress;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkAddress() {
		return parkAddress;
	}

	public void setParkAddress(String parkAddress) {
		this.parkAddress = parkAddress;
	}

	public double getLattitude() {
		return lattitude;
	}

	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Park p) {
		// TODO Auto-generated method stub
		return Double.compare(this.distance,p.distance);
	}


}
