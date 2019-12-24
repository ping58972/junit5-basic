package io.ping;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("'when running MathUtils")
class MathUtilsTest {

	//int cachedValue = 0;
	MathUtils mathUtils;
	
	TestInfo testInfo;
	TestReporter testReporter;
	
//	@BeforeAll
//	static void beforeAllInit() {
//		System.out.println("This needs to run before all.");
//	}
	
//	//after add "@TestInstance(TestInstance.Lifecycle.PER_CLASS)" we can take off static
//	@BeforeAll
//	void beforeAllInit() {
//		System.out.println("This needs to run before all.");
//	}
	
	@BeforeEach
	void Init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		 mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning Up...");

	}
	
	@Test
	void test() {
		
		int expected = 5;
		

		
		int actual = mathUtils.add(1, 4);
		
		assertEquals(expected, actual, "the add method should add two numbers ");
		
	}
	
	//Using nested test class
	@DisplayName("Add method")
	@Nested
	@Tag("Math")
	class AddTest {
		@Test
		@DisplayName("When adding Testing add positive method")
		void testAddPositive() {
			int i = 89;
			assertEquals(-2, mathUtils.add(-1, -1), 
					"the add method should add two numbers" + i);
		}
		@Test
		@DisplayName("Testing add negative method")
		void testAddNegative() {
			int j = 45;
			assertEquals(2, mathUtils.add(3, 1), () -> "the add method should add two numbers"+j);
		}
	}
	
	
	//@Test
	@RepeatedTest(3)
	@Tag("circle")
	void testComputeCircleRadius() {
		
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
	}
	
		
	@Test
	//@EnabledOnOs(OS.LINUX)
	@Tag("Math")
	void testDivide() {
		
		
		//int expected = mathUtils.divide(1, 0);
		
		boolean isServeUp = false;
		//assumeTrue(isServeUp);
		
		assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1,0), "Divide by zero Should throw exception");
		//assertThrows(NullPointerException.class, ()-> mathUtils.divide(1,0), "Divide by zero Should throw exception");
	}
//	@Test
//	@DisplayName("test Multiply method")
//	void testMultiply() {
//		int expected = 6;
//		int actual = mathUtils.multiply(2, 3);
//		assertEquals(expected, actual, "Should multiply two numbers");
//		
//	}
	
	@Test
	@DisplayName("test Multiply method by assertAll")
	@Tag("Math")
	void testMultiply() {
		
		String value = "Running " + testInfo.getDisplayName() + " wthi tags " + testInfo.getTags();
		//System.out.println("Running " + testInfo.getDisplayName() + " wthi tags " + testInfo.getTags());
		testReporter.publishEntry(value);	
		
		int expected = 6;
		int actual = mathUtils.multiply(2, 3);
		//assertEquals(expected, actual, "Should multiply two numbers");
		assertAll(
				()-> assertEquals(expected, actual, "Should multiply two numbers"),
				()-> assertEquals(16, mathUtils.multiply(4, 4), "Should multiply two numbers"),
				()-> assertEquals(-2, mathUtils.multiply(-1, 2), "Should multiply two numbers")
				);
		
	}
	
	@Disabled
	@Test
	@DisplayName("Testing and method")
	void testDisable() {
		fail("This test should be disabled");
	}

}
