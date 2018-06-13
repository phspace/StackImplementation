package com.assignment.hungpham.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestStackString extends UnitTestStack {

	/**
	 * Test the push, peek, and pop function respectively.
	 * The result is green if the item is pushed on the top, then peek, and pop out of the stack successfully.
	 */
	@Test
	public void testPushPeekPop() {
		String message = "Hello World!!";
		stackString.push(message);
		assertEquals(stackString.peek(), message);
		assertEquals(stackString.getNumberOfItems(), 1);
		assertEquals(stackString.pop(), message);
		assertEquals(stackString.getNumberOfItems(), 0);
		System.out.println("Successfully push an item to stack then peek and pop");
	}

	/**
	 * Test push() function by adding items to the stack until it is full.
	 * The result is green if the stack is fully filled successfully.
	 */
	@Test
	public void testPushAllString() {
		for (int i = 0; i < size; i++) {
			stackString.push(String.valueOf(i));
			assertEquals(String.valueOf(i), stackString.peek());
			// System.out.println(stackString.peek());
		}
		assertFalse(stackString.isEmpty());
		assertEquals(stackString.getNumberOfItems(), size);
		System.out.println("Successfully push all strings to stack");
	}

	/**
	 * Test pop() function by adding items to the stack until it is full, and then pop all items out.
	 * The result is green if the stack is fully filled and then all items pop out successfully.
	 */
	@Test
	public void testPopAllString() {
		int check = size - 1;
		for (int i = 0; i < size; i++) {
			stackString.push(String.valueOf(i));
			assertEquals(String.valueOf(i), stackString.peek());
			// System.out.println(stackString.peek());
		}
		assertFalse(stackString.isEmpty());
		assertEquals(stackString.getNumberOfItems(), size);

		for (int i = 0; i < size; i++) {
			assertEquals(stackString.pop(), String.valueOf(check--));
			// System.out.println(stackString.pop());
		}
		assertEquals(stackString.getNumberOfItems(), 0);
		assertTrue(stackString.isEmpty());
		System.out.println("Successfully pop all string");
	}
}
