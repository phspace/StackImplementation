package com.assignment.hungpham.stack;

import java.util.Arrays;

//#Ralf: I tried to re-use this stack in my Towers of Hanoi program and I got some errors when I used input problem greater than 32 disks.
//#Hung: Can you please tell me what the errors are? Thanks!

//#Carl: again, camel case 
//#Hung: thanks, I change it now.

public class StacksOfObject<T> implements Stack<T> {
	private Object[] items;

	// #Carl: I did not understand why you store the top most element in a special variable? How can I push then a string to the top???
	// #Carl: why is the top value is 0, I do not understand.
	// #Hung: @Carl: the top variable here is just like a pointer that points to the top element, so it is not the top object.

	private int top;

	/**
	 * create new stack with a specified size
	 * 
	 * @param size
	 */
	public StacksOfObject(int size) {
		items = new Object[size];
		top = 0;
	}

	// #Peter: This synchronization has big performance overhead. Can you optimize it?
	// #Hung: @Peter: I changed a little bit. But I just know the synchronization and concurrent list (which I cannot use here because of the restriction of assignment requirements)
	// #Hung: So I will be very happy if you can show me some way to optimize it. Thank you!
	
	@Override
	public void push(T newObject) {
		// #Ralf: This is not how wanted the push method to be implemented, you can push "null" which does not make sense.
		// #Peter: If you cannot push "null" we could not use this stack in our JVM implementation.
		// #Ralf: @Peter: this user story is for our billing system only and we know null objects cannot happen here.
		// #Peter: @Ralf: So what? We will end up with 10 stack implementations.
		// #Ralf: @Peter: with your additional requirements this user story will take one week longer and we need to de-commit the whole sprint and the project plan will be late. Do you really want this?
		// #Mike: @Hung: can you organize a meeting with Peter and Ralf to clarify our wanted requirements and find a solution?

		// #Hung: @Ralf, @Peter, @Mike: I am not sure about the "null". Because @Tom just told me to implement a data type Stack of Object in the assignment requirements, so I don't really know what object it is, and I forgot to ask @Tom. It was my mistake, sorry.
		// #Hung: if it is possible, we can arrange a meeting to discuss more about this.

		synchronized (items) {
			if (top == items.length) { // if top == length of stack, then stack is full
				// #Carl: this exception is not documented.
				throw new IllegalStateException("Stack is full, please grow the stack size first!");
			}
			// #Peter: the next two lines could be written in one, couldn't they?
			// #Hung: Yes, I changed it, thanks.
			items[top++] = newObject;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		T topItem;
		synchronized (items) {
			if (top == 0) { // if top == 0, the stack is empty
				// #Carl: this exception is not documented.
				// #Hung: I'm sorry but how can I document it? Thanks.
				throw new IllegalStateException("Cannot pop from an empty stack.");
			}
			topItem = (T) items[top - 1];
			items[--top] = null;
		}
		return topItem;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if (top == 0) {
			// #Carl: this exception is not documented.
			throw new IllegalStateException("Cannot peek from an empty stack.");
		}
		return (T) items[top - 1];
	}

	@Override
	public void growSize(int newSize) throws IllegalArgumentException {
		// #Evelin: code block without brackets are bad maintainable code. There was a already rocket that exploded because of this...!!!
		// #Hung: @Evelin: thanks, I change it now.

		// #Tanja: One of my integration test with a StacksofObject(50) failed with this error message, but I did not understand why it failed for IntStream.parallel().rangeClosed(0,50).iterate(i->stack.push(i))

		synchronized (items) {
			if (newSize < items.length) {
				throw new IllegalArgumentException("Cannot grow the stack because the new size is smaller than current size!");
			}
			items = Arrays.copyOf(items, newSize);
		}
	}

	@Override
	public boolean isFull() {
		return (top == items.length);
	}

	@Override
	public boolean isEmpty() {
		return (top == 0);
	}

	@Override
	public int getNumberOfItems() {
		return top;
	}

	@Override
	public int getSize() {
		return items.length;
	}

	@Override
	public void reset() {
		// #Ralf: I spoke to a friend of mine in the security department and he says he would never except such code for our billing system, as it could reveal secret credit card data from a previous grown stack of a smaller size if you create a dump.
		// #Hung: thanks, I fix it now.
		
		synchronized (items) {
			for (int i = 0; i < top; i++) {
				items[i] = null;
			}
			top = 0;
		}
	}

}
