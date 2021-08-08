package com.java.quiz;
// Second Contents

import com.java.quiz.common.LinkedList;

/* 
    이전 예제(NodeEx.java)는 매우 불완전한 상태이다.
    처음 선언된 header를 삭제를 하게 되면 그 뒤에 Node까지 전부 잃게 되기 때문이다.
    그래서 이를 위해 보완하기 위해 Node를 감싸는 LinkedListNode내용을 만들어 볼려한다.
*/

public class SinglyLinkedListNode {
    public static void main(String[] args) {
        LinkedList lln = new LinkedList();
        lln.append(1);
        lln.append(2);
        lln.append(3);
        lln.append(4);
        lln.append(5);
        lln.retrieve();
        lln.delete(1);
        lln.retrieve();
    }
}