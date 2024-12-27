
import java.io.Serializable;

public class Cuenta implements Serializable {
    private int id;
    private double saldo;
    private int pos;
    private String moneda;

    public Cuenta(int id, double saldo, int pos, String moneda){
        this.id = id;
        this.saldo = saldo;
        this.pos = pos;
        this.moneda = moneda;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    

    @Override
    public String toString() {
        return "[Id: "+getId()+", Saldo: "+getSaldo()+", Moneda: "+getMoneda()+"]";
    }
}
