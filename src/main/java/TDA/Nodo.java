package TDA;

import java.io.Serializable;

public class Nodo<T> implements Serializable{
    protected T val;

    public Nodo(T val){
        this.val = val;
    }

    public T getVal(){
        return val;
    }
    public void setVal(T val){ this.val = val;}
}
