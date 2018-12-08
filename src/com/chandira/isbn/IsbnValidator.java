package com.chandira.isbn;

public class IsbnValidator {
	public boolean checkValidIsbn(String isbn) {
	    
        // Validation
        // remove all the hyphens and spaces if any
        
        isbn = isbn.replaceAll("\\s+","");
        isbn = isbn.replaceAll("-", "");

        
        // check if the isbn is 13 or 10
        
        if(isbn.length()==13)
        {
        
            // check all the digits are numeric

            if(isbn.matches("\\d+") == false)
            {
                return false;
            }
 
            int total = 0;
            
            // ISBN-13 is calculated by multiplying each digit alternately by 1 or 3
            // summing these products together
            // (i.e., 1 x 1st digit, 3 x 2nd digit, 1 x 3rd digit, 3 x 4th digit, etc.)
            
            for(int i = 0; i < 12; i++)
            {
                int digit = Integer.parseInt(isbn.substring(i, i+1));
                total += (i % 2 == 0) ? digit * 1 : digit * 3;
            }
            
            // taking modulo 10 of the result
            // subtracting this value from 10, and then taking the
            // modulo 10 of the result again to produce a single digit
            
            total = 10 - (total % 10);
            int checkDigit = total % 10;

            return (checkDigit == Integer.parseInt(isbn.substring(12)));
            
        }
        else if(isbn.length()==10)
        {
            // The check digit for ISBN-10 is calculated by multiplying
            // each digit by its position (i.e., 1 x 1st digit, 2 x 2nd digit, etc.)
            // summing these products together
         
           
            int checkDigit, total = 0;

            for(int i = 0; i < 9; i++)
            {
                total += ((i+1) * Integer.parseInt(isbn.substring(i, i+1)));
            }
            
            // and taking modulo 11 of the result (with 'X' being used if the result is 10).
            
            checkDigit = total % 11;
            
            if(checkDigit==10)
            {
                return (isbn.substring(10) == "X");
            }
            
            return (checkDigit == Integer.parseInt(isbn.substring(9)));
        }
    
        return false;
    }
    
    

}
