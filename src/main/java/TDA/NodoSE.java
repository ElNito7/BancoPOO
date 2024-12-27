package TDA;

import java.io.Serializable;

public class NodoSE <T> extends Nodo implements Serializable{

    protected NodoSE next;
    public NodoSE(T val, NodoSE next){
        super(val);
        this.next = next;
    }
    public NodoSE getNext(){
        return next;
    }
    public void setNext(NodoSE node){
        this.next = node;
    }
}
