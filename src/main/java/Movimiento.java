
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Keloc
 */
public abstract class Movimiento implements Serializable{
    protected int clienteId;
    protected int cuentaId;
    protected double monto;
    
    public Movimiento(int clienteId, int cuentaId, double monto){
        this.clienteId = clienteId;
        this.cuentaId = cuentaId;
        this.monto = monto;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
   public abstract void guardar();
    
}
