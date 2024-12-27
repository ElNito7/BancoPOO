/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable;
/**
 *
 * @author Keloc
 */
public class Retiro extends Movimiento implements Serializable{
    public Retiro(int clienteId, int cuentaId, double monto) {
        super(clienteId, cuentaId, monto);
    }
    
    public void guardar(){
        System.out.println("saved");
    }
    
    @Override
    public String toString(){
        return "[ID del Cliente: "+getClienteId()+", ID de la Cuenta: "+getCuentaId()+", Deposito: "+getMonto()+"]";
    }
}
