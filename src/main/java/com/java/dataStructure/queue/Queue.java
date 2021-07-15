package com.java.dataStructure.queue;

public class Queue {
    private int front; // 가장 첫 원소
    private int rear; // 가장 끝 원소
    private int maxSize;
    private int[] queue;

    Queue(int maxSize){
        this.maxSize = maxSize;
        this.front = 0; 
        this.rear = -1; 
        this.queue = new int[maxSize];
    }

    protected void peek(){
        System.out.println(queue[front]);
    }

    protected void isFull(){
        System.out.println("isFull : " + ( rear+1 == maxSize ));
    }

    protected void isEmpty(){
        System.out.println("isEmpty : " + (front == rear +1));
    }

    protected void insert(int data){
        queue[++rear] = data;
    }

    protected void remove(){
        front++;
    }

    protected void printStack(){
        for(int i = front; i < rear; i++){
            System.out.print(queue[i] + " -> ");
        }
        System.out.println(queue[rear]);
    }   
}