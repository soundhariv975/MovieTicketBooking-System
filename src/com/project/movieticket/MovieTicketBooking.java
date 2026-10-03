package com.project.movieticket;

public class MovieTicketBooking {

	// 2D array for seats
	// false = Available
	// true = Booked
	private boolean[][] seats;

	private Movie movie;

	private double weekdayPrice = 200;
	private double weekendPrice = 250;

	// Constructor
	public MovieTicketBooking() {

		// 5 rows and 5 seats
		seats = new boolean[5][5];

		movie = new Movie("The Pursuit of Happyness");
	}

	// Show available seats
	public void showAvailableSeats() {

		System.out.println("\n----- SEAT STATUS -----");

		for (int i = 0; i < seats.length; i++) {

			for (int j = 0; j < seats[i].length; j++) {

				if (seats[i][j] == false) {

					System.out.print("A ");

				} else {

					System.out.print("B ");
				}
			}

			System.out.println();
		}

		System.out.println("A = Available");
		System.out.println("B = Booked");
	}

	// Book ticket
	public void bookTicket(int row, int seat, boolean weekend, String couponCode) {

		int rowIndex = row - 1;
		int seatIndex = seat - 1;

		// Check valid seat
		if (rowIndex < 0 || rowIndex >= seats.length || seatIndex < 0 || seatIndex >= seats[rowIndex].length) {

			throw new IllegalArgumentException("Invalid row or seat number.");
		}

		// Check whether seat is already booked
		if (seats[rowIndex][seatIndex]) {

			throw new IllegalStateException("Seat is already booked.");
		}

		// Weekend or weekday price
		double ticketPrice;

		if (weekend) {

			ticketPrice = weekendPrice;

		} else {

			ticketPrice = weekdayPrice;
		}

		// Coupon discount
		double discount = 0;

		if (couponCode.equalsIgnoreCase("MOVIE10")) {

			discount = ticketPrice * 0.10;

		} else if (!couponCode.equalsIgnoreCase("NONE")) {

			throw new IllegalArgumentException("Invalid coupon code.");
		}

		double finalPrice = ticketPrice - discount;

		// Book the seat
		seats[rowIndex][seatIndex] = true;

		System.out.println("\n----- BOOKING SUCCESSFUL -----");

		System.out.println("Movie : " + movie.getMovieName());
		System.out.println("Row : " + row);

		System.out.println("Seat : " + seat);

		System.out.println("Ticket Price : Rs." + ticketPrice);

		System.out.println("Discount : Rs." + discount);

		System.out.println("Final Price : Rs." + finalPrice);
	}

	// Cancel ticket
	public void cancelTicket(int row, int seat) {

		int rowIndex = row - 1;
		int seatIndex = seat - 1;

		// Check valid seat
		if (rowIndex < 0 || rowIndex >= seats.length || seatIndex < 0 || seatIndex >= seats[rowIndex].length) {

			throw new IllegalArgumentException("Invalid row or seat number.");
		}

		// Check whether seat is booked
		if (!seats[rowIndex][seatIndex]) {

			throw new IllegalStateException("Seat is not booked.");
		}

		// Cancel booking
		seats[rowIndex][seatIndex] = false;

		System.out.println("Ticket cancelled successfully.");
	}

	// Rate movie
	public void rateMovie(double rating) {

		if (rating < 1 || rating > 5) {
			
			throw new IllegalArgumentException("Rating must be between 1 and 5.");
		}

		movie.setRating(rating);

		System.out.println("Movie rating submitted successfully.");
	}

	// Display movie rating
	public void displayRating() {

		System.out.println("\n----- MOVIE RATING -----");
		
		movie.displayMovie();
	}
}