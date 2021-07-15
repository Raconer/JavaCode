package com.java.dataStructure.linkedList.q;

import com.java.dataStructure.linkedList.LinkedList;
import com.java.dataStructure.linkedList.LinkedList.Node;

// 4th Content

/* 
    단방향 LinkedList의 끝에서 K번째 노드를 찾는 알고리즘을 구현하시요 
*/

public class BackCntFindNode {
    public static void main(String[] args) {
        LinkedList ll2 = new LinkedList();
        ll2.append(1);
        ll2.append(2);
        ll2.append(3);
        ll2.append(4);
        int k = 1;
        // 방법 1
        // Node n = kthtoLast(ll2.header, k);
        // System.out.println(k + "th to last node is "+ n.data);
        
        // 방법 2
        // Reference r = new Reference();
        // Node found = kthtoLast2(ll2.header, k, r);
        // System.out.println(k + "th to last node is "+ found.data);
   
        // 방법 3
        Node found = kthtoLast3(ll2.header, k);
        System.out.println(k + "th to last node is "+ found.data);
   
    }
    // 방법 1
    private static Node kthtoLast(Node header, int k) {
        Node n = header;
        int total = 1;
        while (n.next != null) {
            total++;
            n = n.next;
        }
        n = header;
        for( int i = 1; i < total - k + 1; i++){
            n = n.next;
        }
        return n;
    }

    // 방법 2 재귀 호출
    private static class Reference{
        public int count = 0;
    }

    private static Node kthtoLast2(Node n, int k, Reference r){
        if(n == null){
            return null;
        }
        Node found = kthtoLast2(n.next, k, r);
        r.count++;
        if(r.count == k){
            return n;
        }
        return found;
    }

    // 방법 3 포인터
    private static Node kthtoLast3(Node header, int k) {
        Node p1 = header;
        Node p2 = header;

        for(int i = 0; i < k; i++){
            if(p1 == null) return null;
            p1 = p1.next;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }   
}