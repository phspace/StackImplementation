package com.assignment.hungpham.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestStackInt extends UnitTestStack {

	/**
	 * Test the push, peek, and pop function respectively.
	 * The result is green if the item is pushed on the top, then peek, and pop out of the stack successfully.
	 */
	@Test
	public void testPushPeekPop() {
		int number = 100;
		stackInt.push(number);
		assertTrue(stackInt.peek()==number);
		assertEquals(stackInt.getNumberOfItems(), 1);
		assertTrue(stackInt.pop() == number);
		assertEquals(stackInt.getNumberOfItems(), 0);
		System.out.println("Successfully push a number to stack then peek and pop");
	}

	/**
	 * Test push() function by adding items to the stack until it is full.
	 * The result is green if the stack is fully filled successfully.
	 */
	@Test
	public void testPushAllInt() {
		for (int i = 0; i < size; i++) {
			stackInt.push(i);
			assertTrue(stackInt.peek() == i);
			// System.out.println(stackString.peek());
		}
		assertFalse(stackInt.isEmpty());
		assertEquals(stackInt.getNumberOfItems(), size);
		System.out.println("Successfully push all integer to stack");
	}

	/**
	 * Test pop() function by adding items to the stack until it is full, and then pop all items out.
	 * The result is green if the stack is fully filled and then all items pop out successfully.
	 */
	@Test
	public void testPopAllInt() {
		int check = size - 1;
		for (int i = 0; i < size; i++) {
			stackInt.push(i);
			assertTrue(stackInt.peek() == i);
		}
		assertFalse(stackInt.isEmpty());
		assertEquals(stackInt.getNumberOfItems(), size);

		for (int i = 0; i < size; i++) {
			assertTrue(stackInt.pop() == (check--));
			// System.out.println(stackString.pop());
		}
		assertEquals(stackInt.getNumberOfItems(), 0);
		assertTrue(stackInt.isEmpty());
		System.out.println("Successfully pop all integers");
	}
}
