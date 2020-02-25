package com.tolgaze.hashcode2020;
import java.util.List;

public class Library {
	public int id;
	public List<Book> booksArrayList;
	public Double score;
	public Double numberOfBooksScanned;
	public int signupDay;
	public int scanPerDay;
	public int numberOfBooks;

	public Double getNumberOfBooksScanned() {
		return numberOfBooksScanned;
	}

	public void setNumberOfBooksScanned(Double numberOfBooksScanned) {
		this.numberOfBooksScanned = numberOfBooksScanned;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public int getSignupDay() {
		return signupDay;
	}

	public void setSignupDay(int signupDay) {
		this.signupDay = signupDay;
	}

	public int getScanPerDay() {
		return scanPerDay;
	}

	public void setScanPerDay(int scanPerDay) {
		this.scanPerDay = scanPerDay;
	}

	public List<Book> getBooksList() {
		return booksArrayList;
	}

	public void setBooksList(List<Book> booksArrayList) {
		this.booksArrayList = booksArrayList;
	}
}
