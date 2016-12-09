package com.cybage.bean;

public class Review {
String comment;
String bookname;
String user;

public Review() {
	super();
}

public Review(String comment, String bookname, String user) {
	super();
	this.comment = comment;
	this.bookname = bookname;
	this.user = user;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public String getBookname() {
	return bookname;
}

public void setBookname(String bookname) {
	this.bookname = bookname;
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

@Override
public String toString() {
	return "Review [comment=" + comment + ", bookname=" + bookname + ", user=" + user + "]";
}

}
