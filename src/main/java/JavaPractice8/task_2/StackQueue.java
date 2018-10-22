package com.akhmetyanov.task_2;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackQueue<E> implements Queue<E> {
    private Stack<E> stackForAdd;
    private Stack<E> stackForPoll;

    public boolean add(E e) {
        try {
            while( !stackForPoll.empty()) {
                stackForAdd.push(stackForPoll.pop());
            }
            stackForAdd.push(e);
            return true;
        } catch (Exception error){
            return false;
        }
    }

    public E poll() {
        try{
            while( !stackForAdd.empty() ) {
                stackForPoll.push(stackForAdd.pop());
            }
            return stackForPoll.pop();
        } catch (EmptyStackException error){
            System.out.println("Queue is empty.");
            return null;
        }
    }
}
