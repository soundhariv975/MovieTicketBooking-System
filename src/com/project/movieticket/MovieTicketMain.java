package com.project.movieticket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieTicketMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MovieTicketBooking system = new MovieTicketBooking();

		int choice = 0;

		do {

			System.out.println("\n----- MOVIE TICKET BOOKING SYSTEM -----");

			System.out.println("1. Show Available Seats");
			System.out.println("2. Book Ticket");
			System.out.println("3. Cancel Ticket");
			System.out.println("4. Rate Movie");
			System.out.println("5. View Movie Rating");
			System.out.println("6. Exit");

			System.out.print("Enter your choice: ");

			try {

				choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {

				case 1:

					// Show available seats
					system.showAvailableSeats();

					break;

				case 2:

					// Book ticket
					System.out.print("Enter Row Number (1-5): ");
					
					int row = sc.nextInt();

					System.out.print("Enter Seat Number (1-5): ");
					
					int seat = sc.nextInt();

					System.out.print("Is it weekend? (yes/no): ");
					
					String weekendInput = sc.next();

					boolean weekend;

					if (weekendInput.equalsIgnoreCase("yes")) {

						weekend = true;

					} else if (weekendInput.equalsIgnoreCase("no")) {

						weekend = false;

					} else {

						throw new IllegalArgumentException("Please enter yes or no.");
					}

					System.out.print("Enter Coupon Code (MOVIE10 / NONE): ");

					String couponCode = sc.next();

					system.bookTicket(row, seat, weekend, couponCode);

					break;

				case 3:

					// Cancel ticket
					System.out.print("Enter Row Number: ");

					int cancelRow = sc.nextInt();

					System.out.print("Enter Seat Number: ");

					int cancelSeat = sc.nextInt();

					system.cancelTicket(cancelRow, cancelSeat);

					break;

				case 4:

					// Rate movie
					System.out.print("Enter Movie Rating (1-5): ");

					double rating = sc.nextDouble();

					system.rateMovie(rating);

					break;

				case 5:

					// View rating
					system.displayRating();

					break;

				case 6:

					System.out.println("Thank you for using " + "Movie Ticket Booking System.");

					break;

				default:

					System.out.println("Invalid choice. Please try again.");
				}

			} catch (InputMismatchException e) {

				System.out.println("Invalid input. Please enter the correct value.");

				sc.nextLine();

			} catch (IllegalArgumentException e) {

				System.out.println("Error: " + e.getMessage());

			} catch (IllegalStateException e) {

				System.out.println("Error: " + e.getMessage());
			}

		} while (choice != 6);

		sc.close();
	}
}