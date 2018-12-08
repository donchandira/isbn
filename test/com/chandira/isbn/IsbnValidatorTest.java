package com.chandira.isbn;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsbnValidatorTest {
	
	private String input;
	
	private boolean expectedValue;
	
	public IsbnValidatorTest(boolean expectedValue, String actualValue) {
		this.input = actualValue;
		this.expectedValue = expectedValue;
	}

    IsbnValidator isbnValidator = new IsbnValidator();
    
    @Parameters
    public static Collection<Object[]> testConditions()
    {
    	Object expectedOutputs[][] = {
    				/* All the valid cases */
    				/* ISBN 13 */
    			 {true,"9780470059029"},
    			 {true, "978 0 471 48648 0"},
    			 {true, "978-0596809485"},
    			 {true, "978-0-13-149505-0"},
    			 {true, "978-0-262-13472-9"},
    			 	/* All the valid cases */
    			 	/* ISBN 10 */
    			 {true, "0471958697"},
    			 {true, "0 471 60695 2"},
    			 {true, "0-470-84525-2"},
    			 {true, "0-321-14653-0"},
    			 	/* All the invalid cases */
 			 		/* ISBN 13 */
    			 {false, "9ab-0-262-13472-9"},
    			 {false, "9ab-0-262-13472-S"},
    			 {false, "9ab-0-26213472-1"}
    	 };
    	return Arrays.asList(expectedOutputs);
    }

    @Test
    public void test_checkValidIsbn() {
        assertEquals(expectedValue, isbnValidator.checkValidIsbn(input));                
    }
   
}

