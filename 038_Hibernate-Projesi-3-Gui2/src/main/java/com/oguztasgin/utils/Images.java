package com.oguztasgin.utils;

public class Images {
	
	public Images() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPhoto(int id) {
		switch (id) {
		case 2:
			return "C:\\Users\\Irem\\Downloads\\Messi.png";
		case 3:
			return "C:\\Users\\Irem\\Downloads\\Ronaldo.png";
		case 4:
			return "C:\\Users\\Irem\\Downloads\\Mbappe.png";
		default:
			return "C:\\Users\\Irem\\Downloads\\default.png";
		}
	}
}
