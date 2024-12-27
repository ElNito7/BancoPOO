package TDA;

import java.io.Serializable;

public abstract class Lista <T> implements Serializable{
    public abstract int length();
    public abstract T get(int index);
    public abstract boolean isEmpty();
    public abstract void add(Nodo node);
    public abstract void insert(Nodo node, int index);
    public abstract void delete(int index);
    public abstract int search(Nodo node);
    public abstract String show();
}
