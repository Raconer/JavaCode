package com.java.quiz;

import com.java.quiz.common.LinkedList;
import com.java.quiz.common.LinkedList.Node;

/*
 * 어떤 숫자를 자리수 별로 한개씩 Linked List에 담았다.
 * 그런데 1의 자리가 헤더에 오도록 거꾸로 담았다.
 * 이런식의 Linked List두개를 받아서 합산하고 같은 식으로 
 * Linked List에 담아서 반환하라
 * EX) 
 *  LinkedList1 = 9 -> 1 -> 4 = 419
 *  LinkedList2 = 6 -> 4 -> 3 = 346
 *  419 + 346 = 765
 *  result = 5 -> 6 -> 7
 */
public class AllAddDigitNumber {
    // 만약 자리수가 다르면 빈공간을 0으로 채워야 한다.
    public static void main(String[] args) {
        Node result = null;
        
        // LinkedList ll1 = new LinkedList();
        // ll1.append(9);
        // ll1.append(1);
        // ll1.append(4);
        // LinkedList ll2 = new LinkedList();
        // ll2.append(6);
        // ll2.append(4);
        // ll2.append(3);

        // result = sumLists(ll1.get(1), ll2.get(1), 0);
        // while(result.next != null){
        //     System.out.print(result.data + "->");
        //     result = result.next;
        // }
        // System.out.println(result.data);

        LinkedList ll3 = new LinkedList();
        ll3.append(9);
        ll3.append(1);
        LinkedList ll4 = new LinkedList();
        ll4.append(1);
        ll4.append(1);
        
        result = sumNodeList2(ll3.get(1), ll4.get(1));
        while(result.next != null){
            System.out.print(result.data + "->");
            result = result.next;
        }
        System.out.println(result.data);

    }
    // 해답
    private static Node sumLists(Node l1, Node l2, int carry){
        if( l1 == null && l2 == null && carry == 0){
            return null;
        }

        Node result = new Node();
        int value = carry;
        if(l1 != null){
            value += l1.data;
        }
        if(l2 != null){
            value += l2.data;
        }

        result.data = value % 10;

        if(l1 != null || l2 != null){
            Node next = sumLists(   l1 == null? null: l1.next, 
                                    l2 == null? null: l2.next, 
                                    value >= 10? 1: 0);
            result.next = next;
        }
        return result;
    }

    public static class Storage{
        Node result;
        int carry;
    }

    // 만약 제대로 숫자를 넣었다면?
    private static Node sumNodeList2(Node n1, Node n2){
        int len1 = getListLength(n1);
        int len2 = getListLength(n2);

        if(len1 < len2){
            n1 = LPadList(n1, len2 - len1);
        } else{
            n2 = LPadList(n2, len1 - len2);
        }
        
        Storage storage = addLists(n1, n2);
        if(storage.carry == 0){
            storage.result = insertBefore(storage.result, storage.carry);
        } 
        return storage.result;
    }

    private static Storage addLists(Node n1, Node n2){
        if(n1 == null && n2 == null){
            Storage storage = new Storage();
            return storage;
        }
        Storage storage = addLists(n1.next, n2.next);
        int value = storage.carry + n1.data + n2.data;
        int data = value % 10;
        storage.result = insertBefore(storage.result, data);
        storage.carry = value / 10;
        return storage;
    }

    private static int getListLength(Node n){
        int total = 0;
        while( n != null){
            total++;
            n = n.next;
        }
        return total;
    }

    private static Node insertBefore(Node node, int data){
        Node header = new Node(data);
        if(node != null){
            header.next = node;    
        }
        return header;
    }

    private static Node LPadList(Node l, int length){
        Node header = l;
        for(int i = 0; i < length; i++){
            header = insertBefore(header, 0);
        }
        
        return header; 
    }
}