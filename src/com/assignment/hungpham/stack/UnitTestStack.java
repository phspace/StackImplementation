package com.assignment.hungpham.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class UnitTestStack {
	
	// #Carl: Why didn't you use our JUnit test framework? First I though all test are green, but then I was shocked that there are not any test.
	// #Tanja: I did not really get what test scenarios you have. Do you want to test int or string now???
	// #Tanja: I don't believe that your test metrics are doing well. Did you  measure how good your test is?
	// #Hung: Sorry, my big mistake, I use the unit test to check it now.	

	// #SonarQube: Issue #435: resolve TODO
	// #Hung: thanks, I deleted TODO
	
	// #Peter: auto-boxing?
	// #Hung: Yes, but I think it is not necessary to use auto-boxing here. Integer or String can be put directly.
	
	protected Stack<String> stackString;
	protected Stack<Integer> stackInt;
	
	protected final int size = 5000000;
	
	/**
	 * Create new stacks of String and Integer before all the test
	 */
	@Before
	public void testNewStack() {
		stackString = new StacksOfObject<String>(size);
		stackInt = new StacksOfObject<Integer>(size);
		assertEquals(size, stackString.getSize());
		assertEquals(0, stackString.getNumberOfItems());
		assertEquals(size, stackInt.getSize());
		assertEquals(0, stackInt.getNumberOfItems());
		//System.out.println("Successfully create a stack of String with the size 5");
	}
	
	@Test
	public void testGrowSize() {
		stackString.growSize(2 * size);
		stackInt.growSize(2 * size);
		assertEquals(2 * size, stackString.getSize());
		assertEquals(0, stackString.getNumberOfItems());
		assertEquals(2 * size, stackInt.getSize());
		assertEquals(0, stackInt.getNumberOfItems());
		System.out.println("Successfully grow the tacks to the new size (double the old size)");
	}

	/**
	 * Test if the stacks are empty or not.
	 * The result is green if the stacks are empty.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(stackString.isEmpty());
		assertEquals(stackString.getNumberOfItems(), 0);
		assertTrue(stackInt.isEmpty());
		assertEquals(stackInt.getNumberOfItems(), 0);
		System.out.println("The stack is empty");
	}
	
	/**
	 * Test pop() function when the stacks are empty.
	 * The result is green when it catches IllegalStateException.
	 */
	@Test(expected = IllegalStateException.class)
	public void testPopOnEmptyStack() {
		assertTrue(stackString.isEmpty());
		assertEquals(0, stackString.getNumberOfItems());
		assertTrue(stackInt.isEmpty());
		assertEquals(0, stackInt.getNumberOfItems());
		stackString.pop();
	}

	/**
	 * Test peek() function when the stacks are empty.
	 * The result is green when it catches IllegalStateException.
	 */
	@Test(expected = IllegalStateException.class)
	public void testPeekIntoEmptyStack() {
		assertTrue(stackString.isEmpty());
		assertEquals(0, stackString.getNumberOfItems());
		assertTrue(stackInt.isEmpty());
		assertEquals(0, stackInt.getNumberOfItems());
		stackString.peek();
	}
}
