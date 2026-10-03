package com.project.movieticket;

public class Movie {

	private String movieName;
	private double rating;

	// Constructor
	public Movie(String movieName) {
		this.movieName = movieName;
		this.rating = 0;
	}

	// Getter
	public String getMovieName() {
		return movieName;
	}

	public double getRating() {
		return rating;
	}

	// Set rating
	public void setRating(double rating) {
		this.rating = rating;
	}

	// Display movie details
	public void displayMovie() {
		System.out.println("Movie : " + movieName);
		System.out.println("Rating : " + rating + " / 5");
	}
}