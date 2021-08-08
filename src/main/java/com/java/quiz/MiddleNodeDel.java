package com.java.quiz;

import com.java.quiz.common.LinkedList;
import com.java.quiz.common.LinkedList.Node;

// 5th 
/* 
 * 단방향 Linked List에서 중간에 있는 노드를 삭제 하시요
 * (단. 당신은 첫번째 노드가 어디 있는지 모르고 삭제할 노드만 알고있다.)
 * 해결방법. 삭제할 노드 다음을
 */

public class MiddleNodeDel {
    public static void main(String[] args) {
        LinkedList lld = new LinkedList();
        lld.append(2);
        lld.append(5);
        lld.append(3);
        lld.append(2);
        lld.append(4);
        lld.append(2);
        lld.append(2);
        lld.retrieve();
        deleteNode(lld.get(3));
        lld.retrieve();
    }   

    private static boolean deleteNode(Node node) {
        if (node == null || node.next == null)
            return false;

        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        
        return true;
    }
}