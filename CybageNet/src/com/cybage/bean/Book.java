package com.cybage.bean;

public class Book {

private String bookname;
private String author;
private int price;

public Book() {
	super();
}

public Book( String bookname, String author, int price) {
	super();
	
	this.bookname = bookname;
	this.author = author;
	this.price = price;
}


public String getBookname() {
	return bookname;
}

public void setBookname(String bookname) {
	this.bookname = bookname;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

@Override
public String toString() {
	return "Book [  bookname=" + bookname + ", author=" + author + ", price=" + price + "]";
}

}
