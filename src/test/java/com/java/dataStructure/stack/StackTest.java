package com.java.dataStructure.stack;

import org.junit.Test;

public class StackTest {
    @Test
    public void stackTest(){
        Stack stack = new Stack(7);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.printStack();
        stack.isFull();
        stack.pop();
        stack.printStack();
        stack.isFull();
    }
}
