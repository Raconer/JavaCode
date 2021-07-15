package com.java.dataStructure.queue;

import org.junit.Test;

public class QueueTest {
    
    @Test
    public void queueTest(){
        
        // array 로 만들시 단점 : maxSize를 넘지 못한다.
        Queue queue = new Queue(10);
        queue.insert(3);
        queue.insert(2);
        queue.insert(1);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
        queue.printStack();
        queue.peek();
        queue.remove(); //  최초 3이 제거 됨
        queue.insert(8);
        
        queue.printStack();
    }    
}
