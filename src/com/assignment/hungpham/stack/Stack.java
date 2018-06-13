package com.assignment.hungpham.stack;
//#Carl: Why did you put this class into the default package? If everyone in this company would do this we would have 100'000 classes in this package an nobody would find his class again.
//#Hung: @Carl: I am really sorry about this, it's a big mig mistake, and I fix it now.

//#Carl: The class name violates coding convention �45: class names are nouns in singular form.
//#Hung: @Carl: I changed it, thank you.

//#Evelin: This stack implemenatation in not type safe! If we push Strings and Numbers mixed in one stack, there may be type errors when pop-ing the from the stack. 
//#Hung: @Evelin: I am sorry. Because @Tom just asked me to write a stack of Objects in the assignment requirements so I just used the superclass Object for all types.
//#Hung: I changed a little bit in my code, so the implementation can be type safe or not, which depends on the user's requirement.

//#Ralf: It is possible to use this stack without a type cast?
//#Hung: @Ralf: I think yes. Integer or Double or String can be pushed directly to the stack because of the auto-boxing.

public interface Stack<T> {

	// #Carl: There is a grammar problem, so reader does not know if something is push on top of or on the bottom of the stack. "push ... to" --> "push ...on"
	// #Hung: @Carl: My mistake, I am sorry, I fix it now.
	// #Carl: Javadoc problem: this method has a side effect that is not documented
	// #Carl: Javadoc problem: parameter not documented
	/**
	 * push new object on the top of the stack
	 * 
	 * @param newObject
	 */
	// Evelin: public is not necessary in interface
	// #Hung: @Evelin: thank you, I changed it.
	void push(T newObject);

	// #Carl: side effect not documented
	// #Hung: @Carl: thanks, I make it more clearly now.
	/**
	 * return the top object of the stack, and remove it
	 * 
	 * @return Object
	 */
	T pop();

	/**
	 * return the top object of the stack
	 * 
	 * @return Object
	 */
	T peek();

	// #Carl: side effect not documented
	// #Hung: @Carl: thanks, I changed the description.
	/**
	 * clear the stack all items in the stack will be removed
	 */
	void reset();

	// #Carl: side effect not documented
	// #Hung: @Carl: I changed it.
	/**
	 * grow the size of the stack to the new size the new stack has the size of
	 * newSize
	 * 
	 * @param newSize
	 */
	void growSize(int newSize);

	// #Carl: Javadoc problem: unclear what true/false value means
	// #Hung: @Carl: thanks, I changed it.
	/**
	 * check if the stack is full
	 * 
	 * @return true if it is full, false if it is not full
	 */
	boolean isFull();

	/**
	 * check if the stack is empty
	 * 
	 * @return true if it is empty, false if it is not empty
	 */
	boolean isEmpty();

	/**
	 * get the total size of the stack
	 * 
	 * @return
	 */
	int getSize();

	/**
	 * @return number of items inside the stack
	 */
	// #Carl: camel case violation in method name
	//#Hung: @Carl: thanks, I changed it.
	// #Carl: side effect not documented
	//#Hung: @Carl: Can you please tell me what the side effect is? Because I don't really know about it. Thanks.
	int getNumberOfItems();
}
