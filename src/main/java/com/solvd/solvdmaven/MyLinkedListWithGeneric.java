package com.solvd.solvdmaven;

import java.util.LinkedList;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//first of 2 classes in this file
//this is a helper class
class Node<T> {
    T dataStoredInHere;
    Node<T> nextNode;

    Node(T givenData) {
        this.dataStoredInHere = givenData;
        this.nextNode = null;
    }
}

//second of 2 classes in this file
//this is the class we focus on
public class MyLinkedListWithGeneric<T> {
    private Node<T> headOfList;
    private int length;
    private static final Logger LOGGER = LogManager.getLogger(MyLinkedListWithGeneric.class);

    public MyLinkedListWithGeneric() {
        headOfList = null;
        length = 0;
    }

    public void add(T something) {
        Node<T> nodeToBeAdded = new Node<>(something);
        Node<T> temporary = headOfList;
        if (temporary == null) {
            headOfList = nodeToBeAdded;
        } else {
            temporary = temporary.nextNode;
            while (temporary.nextNode != null) {
                temporary = temporary.nextNode;
            }
            temporary.nextNode = nodeToBeAdded;
        }
        length += 1;
    }

    public T get(int index) {
        Node<T> currentNode = headOfList;
        for (int i = 0; i < index && currentNode != null; i++) {
            currentNode = currentNode.nextNode;
        }
        if (currentNode != null) {
            return currentNode.dataStoredInHere;
        } else {
            return null;
        }
    }

    public void remove(T elementToDelete) {
        if (headOfList == null) {
            return;
        }

        if (headOfList.dataStoredInHere.equals(elementToDelete)) {
            headOfList = headOfList.nextNode;
            return;
        }

        Node<T> curr = headOfList;
        while (!(curr.nextNode == null || curr.nextNode.dataStoredInHere.equals(elementToDelete))) {
            curr = curr.nextNode;
        }

        if (curr.nextNode != null) {
            curr.nextNode = curr.nextNode.nextNode;
        }
    }

    public void remove(int i) {
        remove(this.get(i));
    }

    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return length;
    }
}
