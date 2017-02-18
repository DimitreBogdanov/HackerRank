package com.application.structures;

import java.util.Stack;

//https://www.hackerrank.com/challenges/queue-using-two-stacks
public class Queue<E> {

	private Stack<E> main;
	private Stack<E> secondary;

	public Queue() {
		main = new Stack<E>();
		secondary = new Stack<E>();
	}

	public void enqueue(E element) {
		main.add(element);
	}

	public E dequeue() {
		return lastElement(true);
	}

	public E front() {
		return lastElement(false);
	}

	private E lastElement(boolean pop) {
		if(secondary.isEmpty()){
			while(!main.isEmpty()){
				secondary.push(main.pop());
			}
		}

		E element = null;
		if (pop)
			element = secondary.pop();
		else
			element = secondary.peek();

		return element;
	}
}
