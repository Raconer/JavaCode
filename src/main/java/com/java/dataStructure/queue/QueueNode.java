package com.java.dataStructure.queue;

import com.java.dataStructure.linkedList.LinkedList;

class QueueEx extends LinkedList {

    public QueueEx(){
        super();
    }

    @Override
    public void deleteEx(){
        Node temp = new Node();
        Node node = this.header.next;
        temp = node.next;
        this.header.next = temp; 
    }
}

public class QueueNode {
    public static void main(String[] args) {
        QueueEx ex = new QueueEx();
        ex.append(5);
        ex.append(4);
        ex.append(3);
        ex.append(2);
        ex.append(1);
        ex.retrieve();
        ex.deleteEx();
        ex.deleteEx();
        ex.deleteEx();
        ex.retrieve();   
    }
}