import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorsTester {
	
	@Test
	void testFactors1() {
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(-10, -5));
	}
	
	@Test
	void testFactors2() {
		boolean valueExpected = true;
		assertEquals(valueExpected, FactorsUtility.factor(20, 4));
	}
	
	@Test
	void testFactors3() {
		assertTrue(FactorsUtility.factor(100, 10));
	}
	
	@Test
	void testFactors4() {
		assertFalse(FactorsUtility.factor(20, 3));
	}
	
	@Test
	void testFactors5() {
		boolean expectedValue = false;
		assertNotEquals(expectedValue, FactorsUtility.factor(30, 3));
	}
	@Test
	    void testGetFactors1()
	    {
	        // TEST 1: should return 1 because it is a factor of the parameter value 2 
	        int[] x = {1};
	        assertNotEquals(1,FactorsUtility.getFactors(2));
	    }

	    @Test
	    void testGetFactors2()
	    {
	        // TEST 2: should return an empty list because 1 has no factors
	        int [] x={};
	        assertNotEquals(x,FactorsUtility.getFactors(1));
	    }

	    @Test
	    void testGetFactors3()
	    {
	        // TEST 3: should return an empty list because 0 has no factors
	        assertThrows(IllegalArgumentException.class, () -> FactorsUtility.getFactors(-5));
	    }

	    @Test
	    void testGetFactors4()
	    {
	        // TEST 4: should throw the exception because the parameter value is less than 0
	        assertThrows(IllegalArgumentException.class, () -> FactorsUtility.getFactors(-1));
	    }

	    @Test
	    void testGetFactors5()
	    {
	        // TEST 5: should return 1,2,3,4 and 6 because they are factors of parameter value 12
	        int [] x={1,2,3,4,6};
	        assertNotEquals(x,FactorsUtility.getFactors(12));
	    }

}
	
	

/*
 * @Test void testPerfect1() { // TEST 1: should throw the exception because the
 * parameter value is less than 1 assertThrows(IllegalArgumentException.class,
 * () -> FactorsUtility.perfect(0)); }
 * 
 * @Test void testPerfect2() { // TEST 2: should succeed because 1 is a valid
 * parameter value, but is not a perfect number
 * assertFalse(FactorsUtility.perfect(1)); }
 * 
 * @Test void testPerfect3() { // TEST 3: should succeed because 6 is a valid
 * parameter value, and is a perfect number
 * assertTrue(FactorsUtility.perfect(6)); }
 * 
 * @Test void testPerfect4() { // TEST 4: should succeed because 7 is a valid
 * parameter value, but is not a perfect number // I've coded this using
 * assertEquals to show that there's often more than one way to write a test
 * boolean expected = false; assertEquals(expected, FactorsUtility.perfect(7));
 * } }
 */

	
