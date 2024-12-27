package TDA;

public class ListaDE <T> extends Lista {

    NodoDE head;

    public ListaDE(NodoDE head){
        this.head = head;
    }

    public NodoDE getHead() {
        return head;
    }

    public void setHead(NodoDE node) {
        this.head = node;
    }

    @Override
    public int length() {
        int counter = 0;
        if (isEmpty()){
            return 0;
        }
        NodoDE currentNode = getHead();
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
        NodoDE currentNode = getHead();
        while (currentNode != null){
            if (counter == index) {
                return (T) currentNode.getVal();
            }
            currentNode = currentNode.getNext();
            counter++;
        }
        System.out.println("Out of Bounds");
        return null;
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
        if (head.getNext() == null){
            head.setNext((NodoDE) node);
        } else {
            NodoDE currentNode = getHead();
            while (currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext((NodoDE) node);
            ((NodoDE<T>) node).setPrev(currentNode);
        }
    }

    @Override
    public void insert(Nodo node, int index) {
        NodoDE currentNode = getHead(), prevNode = getHead();
        if (isEmpty() && index != 0){
            System.out.println("Out of Bounds");
        } else if (isEmpty() && index == 0){
            setHead((NodoDE) node);
        } else {
            int counter = 0, worked = length();
            while(currentNode != null){
                if(counter == index-1){
                    prevNode = currentNode;
                } else if (counter == index) {
                    ((NodoDE<T>) node).setNext(currentNode);
                    ((NodoDE<T>) node).setPrev(prevNode);
                    currentNode.setPrev((NodoDE) node);
                    prevNode.setNext((NodoDE) node);
                }
                currentNode = currentNode.getNext();
                counter++;
            }
            if (worked == length()) System.out.println("Out of Bounds");
        }
    }

    @Override
    public void delete(int index) {
        NodoDE currentNode = getHead(), prevNode = getHead(), delNode = null;
        int counter = 0;
        if (isEmpty()){
            System.out.println("Out of Bounds");
        } else if (index == 0) {
            delNode = currentNode;
            currentNode = currentNode.getNext();
            setHead(currentNode);
        } else {
            while (currentNode.getNext() != null){
                if(counter == index-1){
                    prevNode = currentNode;
                } else if (counter == index) {
                    delNode = currentNode;
                } else if (counter == index+1) {
                    prevNode.setNext(currentNode);
                    currentNode.setPrev(prevNode);
                }
                currentNode = currentNode.getNext();
                counter++;
            }
            if (counter == index+1) {
                prevNode.setNext(currentNode);
                currentNode.setPrev((prevNode));
            }
        }
        delNode.setPrev(null);
        delNode.setNext(null);
    }
    
    @Override
    public int search(Nodo node) {
        if (isEmpty()){
            return -1;
        }
        int counter = 0;
        NodoDE currentNode = getHead();
        while (currentNode != null){
            if (currentNode.getVal().toString().equals(node.getVal().toString())){
                return counter;
            }
            currentNode = currentNode.getNext();
            counter++;
        }
        System.out.println("Not on List");
        return -1;
    }

    @Override
    public String show(){
        String str = "";
        NodoDE currentNode = getHead();
        while(currentNode != null){
            str = str.concat(currentNode.getVal().toString());
            currentNode = currentNode.getNext();
        }
        return str;
    }
}
