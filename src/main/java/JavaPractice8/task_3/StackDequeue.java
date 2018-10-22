package com.akhmetyanov.task_3;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDequeue<E> implements Dequeue<E> {
    private Stack<E> stackForAdd;
    private Stack<E> stackForPoll;

    public boolean add(E e, boolean first) {
        try {
            if( !first ) {
                while( !stackForPoll.empty()) {
                    stackForAdd.push(stackForPoll.pop());
                }
                stackForAdd.push(e);
            } else {
                while( !stackForAdd.empty()) {
                    stackForPoll.push(stackForAdd.pop());
                }
                stackForAdd.push(e);
                while( !stackForPoll.empty()) {
                    stackForAdd.push(stackForPoll.pop());
                }
            }
            return true;
        } catch (Exception error){
            return false;
        }
    }

    public E poll(boolean first) {
        try {
            if(first) {
                while( !stackForAdd.empty() ) {
                    stackForPoll.push(stackForAdd.pop());
                }
                return stackForPoll.pop();
            } else {
                while(!stackForPoll.empty()){
                    stackForAdd.push(stackForPoll.pop());
                }
                return stackForAdd.pop();
            }
        } catch (EmptyStackException error){
            System.out.println("Queue is empty.");
            return null;
        }
    }
}
