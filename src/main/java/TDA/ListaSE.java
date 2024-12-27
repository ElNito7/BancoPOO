package TDA;

import java.io.Serializable;

public class ListaSE <T> extends Lista implements Serializable{

    NodoSE<T> head;
    public ListaSE(NodoSE head){
        this.head = head;
    }

    public NodoSE getHead() {
        return head;
    }

    public void setHead(NodoSE node) {
        this.head = node;
    }

    @Override
    public int length() {
        int counter = 0;
        if (isEmpty()){
            return 0;
        }
        NodoSE currentNode = getHead();
        while (currentNode != null){
            currentNode = currentNode.getNext();
            counter++;
        }
        return counter;
    }

    @Override
    public T get(int index) {
        if (this.isEmpty()){
            return null;
        }
        int counter = 0;
        NodoSE currentNode = getHead();
        while (currentNode.getNext() != null){
            if (counter == index) {
                return (T) currentNode.getVal();
            }
            currentNode = currentNode.getNext();
            counter++;
        }
        if (counter == index) {
            return (T) currentNode.getVal();
        } else {
            System.out.println("Out of Bounds");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (getHead() == null){
            return true;
        }
        return false;
    }

    @Override
    public void add(Nodo node) {
        if (getHead() == null){
            setHead((NodoSE) node);
        } else {
            NodoSE currentNode = getHead();
            while (currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext((NodoSE) node);
        }
    }

    @Override
    public void insert(Nodo node, int index) {
        if (isEmpty() && index != 0){
            System.out.println("Out of Bounds");
        } else if (isEmpty() && index == 0){
            setHead((NodoSE) node);
        }
        int counter = 0, worked = length();
        NodoSE currentNode = getHead(), prevNode = getHead();
        while(currentNode != null){
            if(counter == index-1){
                prevNode = currentNode;
            } else if (counter == index) {
                ((NodoSE<?>) node).setNext(currentNode);
                prevNode.setNext((NodoSE) node);
            }
            currentNode = currentNode.getNext();
            counter++;
        }
        if (worked == length()) System.out.println("Out of Bounds");
    }

    @Override
    public void delete(int index) {
        NodoSE currentNode = getHead(), prevNode = getHead(), delNode = null;
        int counter = 0;
        if (isEmpty()){
            System.out.println("Out of Bounds");
        } else if (index == 0) {
            delNode = currentNode;
            currentNode = currentNode.getNext();
            delNode.setNext(null);
            setHead(currentNode);
        } else {
            while (currentNode != null){
                if(counter == index-1){
                    prevNode = currentNode;
                } else if (counter == index) {
                    delNode = currentNode;
                } else if (counter == index+1) {
                    prevNode.setNext(currentNode);

                }
                currentNode = currentNode.getNext();
                counter++;
            }
            if (counter == index+1) {
                prevNode.setNext(currentNode);
            }
        }
        if (delNode != null) delNode.setNext(null);
    }

    @Override
    public int search(Nodo node) {
        if (isEmpty()){
            return -1;
        }
        int counter = 0;
        NodoSE currentNode = getHead();
        while (currentNode != null){
            if (currentNode.getVal().toString().equals(node.getVal().toString())){
                return counter;
            }
            System.out.println(currentNode.getVal().toString());
            System.out.println(node.getVal().toString());
            currentNode = currentNode.getNext();
            counter++;
        }
        System.out.println("Not on List");
        return -1;
    }

    @Override
    public String show(){
        String str = "";
        NodoSE currentNode = getHead();
        while(currentNode != null){
            str = str.concat(currentNode.getVal().toString()+"\n");
            currentNode = currentNode.getNext();
        }
        return str;
    }
}
