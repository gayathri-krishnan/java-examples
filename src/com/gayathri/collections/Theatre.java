package com.gayathri.collections;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();
	// try this
	// private List<Seat> seats = new LinkedList()<>();
	// private Collection<Seat> seats = new ArrayList<>();
	// private Collection<Seat> seats = new HashSet<>();
	// private Collection<Seat> seats = new LinkedHashSet<>();
	// private Collection<Seat> seats = new TreeSet<>(); //This doesnt work.

	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;

		int lastRow = 'A' + (numRows - 1);
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return theatreName;
	}

	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = null;
		for (Seat seat : seats) {
			if (seat.getSeatNumber().equals(seatNumber)) {
				requestedSeat = seat;
				break;
			}
		}

		if (requestedSeat == null) {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}

		return requestedSeat.reserve();
	}

	// for testing
	public void getSeats() {
		for (Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}

	private class Seat {
		private final String seatNumber;
		private boolean reserved = false;

		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		// How can you enhance this to search for a seat in the collection?
		public boolean reserve() {
			// Collections.binarySearch(list, key)
			if (!this.reserved) {
				this.reserved = true;
				System.out.println("Seat " + seatNumber + " reserved");
				return true;
			} else {
				return false;
			}
		}

		public boolean cancel() {
			if (this.reserved) {
				this.reserved = false;
				System.out.println("Reservation of seat " + seatNumber + " cancelled");
				return true;
			} else {
				return false;
			}
		}

		public String getSeatNumber() {
			return seatNumber;
		}
	}

//Binary Search
//*******************************************************	
//	private class Seat implements Comparable<Seat>{
//		private final String seatNumber;
//		private boolean reserved = false;	
//
//		public Seat1(String seatNumber) {
//			this.seatNumber = seatNumber;
//		}
//		
//		
//
//		@Override
//		public int compareTo(Seat1 o) {
//			this.seatNumber.compareTo(o.seatNumber);
//		}
//
//
//
//		public boolean reserve() {
//			if (!this.reserved) {
//				this.reserved = true;
//				System.out.println("Seat " + seatNumber + " reserved");
//				return true;
//			} else {
//				return false;
//			}
//		}
//
//		public boolean cancel() {
//			if (this.reserved) {
//				this.reserved = false;
//				System.out.println("Reservation of seat " + seatNumber + " cancelled");
//				return true;
//			} else {
//				return false;
//			}
//		}
//
//		public String getSeatNumber() {
//			return seatNumber;
//		}
//	}
}