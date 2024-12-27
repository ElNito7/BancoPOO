/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable;
/**
 *
 * @author Keloc
 */
public class Deposito extends Movimiento implements Serializable{
    private String nombre;
    public Deposito(int clienteId, int cuentaId, double monto, String nombre){
        super(clienteId, cuentaId, monto);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return "[ID del Cliente: "+getClienteId()+", ID de la Cuenta: "+getCuentaId()+", Deposito: "+getMonto()+", Depositante: "+getNombre()+"`]";
    }
    
    public void guardar() {
        
    }
}
