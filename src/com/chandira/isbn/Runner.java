package com.chandira.isbn;

public class Runner {

	public static void main(String[] args) {
		try {
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		String isbn = "04719583sX";
		
		System.out.println(isbn.substring(0, 9).matches("\\d+"));
	}

}
