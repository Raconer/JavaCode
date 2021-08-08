package com.java.dataStructure.stack;

import com.java.dataStructure.linkedList.LinkedList;

class StackEx extends LinkedList{
    StackEx(){
        super();
    }
    @Override
    public void deleteEx() {
        Node node = this.header;
        while( node.next != null){
            if(node.next.next == null){
                node.next = null;
                break;
            }
            node = node.next;
        }
    }
}

public class StackNode {
    public static void main(String[] args) {
        StackEx stackEx = new StackEx();
        stackEx.append(5);
        stackEx.append(4);
        stackEx.append(3);
        stackEx.append(2);
        stackEx.append(1);
        stackEx.retrieve();
        stackEx.deleteEx();
        stackEx.deleteEx();
        stackEx.deleteEx();
        stackEx.retrieve();
    }
}