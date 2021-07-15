package com.java.dataStructure.linkedList.q;
// Third Contents

import com.java.dataStructure.linkedList.LinkedList;

// 중복 제거
// 공간 복잡도 O(1), 시간 복잡도 O(N^2)
public class OverlapLinkedList {
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
        lld.removeDups();
        lld.retrieve();
    }
}