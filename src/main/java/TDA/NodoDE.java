package TDA;
import java.io.Serializable;

public class NodoDE <T> extends Nodo implements Serializable{
    private NodoDE next;
    private NodoDE prev;
    public NodoDE(T val, NodoDE next, NodoDE prev){
        super(val);
        this.next = next;
        this.prev = prev;
    }

    public NodoDE getNext(){
        return next;
    }
    public NodoDE getPrev(){
        return prev;
    }

    public void setNext(NodoDE node){
        this.next = node;
    }
    public void setPrev(NodoDE node){
        this.prev = node;
    }
}
