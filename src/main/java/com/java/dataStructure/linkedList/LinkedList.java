package com.java.dataStructure.linkedList;

public abstract class LinkedList {
    public Node header;
    
    public LinkedList(){
        header = new Node();
    }

    public class Node{
        public int data;
        public Node next = null;

        public Node(){}
        public Node(int data){
            this.data = data;   
        }
    }
    
    public void append(int data){
        Node end = new Node(data);
        Node node = header;
        while( node.next != null){
            node = node.next;
        }
        node.next = end;
    }

    public void delete(int data){
        Node node = header;
        while( node.next != null){
            if(node.next.data == data){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
    }

    public void retrieve(){
        Node node = this.header.next;
        while( node.next != null){
            System.out.print(node.data + " - > ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    public abstract void deleteEx();
    
}
