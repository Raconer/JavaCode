package com.java.dataStructure.linkedList.q;
// First Contents
/* 단방향 Linked List */
class Node{
    int data;
    Node next = null;

    Node(int data){
        this.data = data;
    }

    void append(int data){
        Node end = new Node(data);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data){
        Node n = this;
        while(n.next != null){
            /* 
                if문 에서 n.next.data를 비교하여 next 값을 변경을하면 첫번째 데이터는 비교를 안한다는 문제가있다.
                이를 다음 SingleLinkedList2.java에서 보완해서 개발을 한다.
                현재 SingleLinkedList.java 에서는 이해하기 쉽게 하기 위해 만들었다고 생각 하면된다.
            */
            if(n.next.data == data){ 
                n.next = n.next.next;
            }else{
                n = n.next;
            }
        }
    }

    void retrieve(){
        Node n = this;
        while( n.next != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
}

public class NodeEx{
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);
        head.retrieve();
        head.delete(3);
        head.delete(5);
        head.delete(1);
        head.retrieve();
    }
}