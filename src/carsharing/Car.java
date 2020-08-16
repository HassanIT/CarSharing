package carsharing;

import java.util.*;

public class Car {
	private int idNo, destination, location, milesDriven;
	private double faresCollected;
	private double FAREPERMILE = 1.0;
	private final int MAXPASSENGERS = 3;
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();

	public Car(int idNo, int location, int destination) {
		this.idNo = idNo;
		this.location = location;
		this.destination = destination;
	}

	public int getIdNo() {
		return this.idNo;
	}

	public int getLocation() {
		return this.location;
	}

	public int getDestination() {
		return this.destination;
	}

	public double getFares() {
		return this.faresCollected;
	}

	public int getMilesDriven() {
		return this.milesDriven;
	}

	public ArrayList<Passenger> getPassengers() {
		return this.passengers;
	}

	public boolean hasArrived() {
		boolean check = false;
		if (this.destination == this.getDestination()) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public boolean hasRoom() {
		boolean seatAvailible = false;
		if (passengers.size() != this.MAXPASSENGERS) {
			seatAvailible = true;
		} else {
			seatAvailible = false;
		}
		return seatAvailible;
	}

	public void drive() {
		if (this.destination != this.getLocation()) {
			this.destination++;
			this.FAREPERMILE++;
			this.milesDriven++;
			String s = "Car " + this.idNo + " drives to station " + this.destination;
			System.out.println(s);
		}
	}

	public boolean dropoff() {
		boolean dropped = false;
		if (hasArrived() == true) {

			String s = "Car " + this.getIdNo() + " drops off " + this.getPassengers() + " at station "
					+ this.getDestination();
			System.out.print(s);
			dropped = true;
		} else {
			dropped = false;
		}
		return dropped;
	}

	public boolean add(Passenger p) {
		boolean added = false;
		if (passengers.size() != this.MAXPASSENGERS) {
			passengers.add(p);
			added = true;
		} else {
			added = false;
		}
		return added;
	}

	public String toString() {
		String s = "Car[idNo=" + this.idNo + ", location=" + this.location + ", destination=" + this.getDestination() + ", passengers=" + this.getPassengers() + "]";
		return s;
	}
}