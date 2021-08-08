package com.java.dataStructure.stack;


/* 
 * 선입 후출
 * 
 * pop
 * push
 * peek : 마지막 데이터 확인
 * isEmpty : 비어있는지 확인
 */

/**
 * InnerStack
 */
public class Stack {
    int top;
    int size;
    int[] stack;

    Stack(int size){
        this.top = -1;
        this.size = size;
        this.stack = new int[size];
    }

    protected void push(int value){
        stack[++top] = value;
    }

    protected void pop(){
        top--;
    }

    protected int peek(){
        return stack[top];
    }

    protected void printStack(){
        for(int i = 0; i < top; i++){
            System.out.print(stack[i] + " -> ");
        }
        System.out.println(stack[top]);
    }

    protected void isFull(){
        boolean isFull = this.top+1 == this.size;
        System.out.println("isFull : " + isFull);
    }

}
