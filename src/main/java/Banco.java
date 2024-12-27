import TDA.*;
import javax.swing.JOptionPane;

public class Banco <T> {

    private ListaSE<Cliente> listaDeClientes;
    private ListaSE<Deposito> listaDeDepositos;
    private ListaSE<Retiro> listaDeRetiros;

    public Banco(ListaSE<Cliente> listaDeClientes, ListaSE<Deposito> listaDeDepositos,
    ListaSE<Retiro> listaDeRetiros){
        this.listaDeClientes = listaDeClientes;
        this.listaDeDepositos = listaDeDepositos;
        this.listaDeRetiros = listaDeRetiros;
    }

    public ListaSE<Cliente> getListaDeClientes(){
        return listaDeClientes;
    }
    public void setListaDeClientes(ListaSE<Cliente> listaDeClientes){
        this.listaDeClientes = listaDeClientes;
    }

    public ListaSE<Deposito> getListaDeDepositos() {
        return listaDeDepositos;
    }

    public void setListaDeDepositos(ListaSE<Deposito> listaDeDepositos) {
        this.listaDeDepositos = listaDeDepositos;
    }

    public ListaSE<Retiro> getListaDeRetiros() {
        return listaDeRetiros;
    }

    public void setListaDeRetiros(ListaSE<Retiro> listaDeRetiros) {
        this.listaDeRetiros = listaDeRetiros;
    }

    public int verificarCuenta(int idCliente, int idCuenta){
        int count = 0;
        Cliente cl = buscarClientePorId(idCliente);
        NodoSE<Cuenta> temp = cl.getCuentas().getHead();
        while (temp != null){
            Cuenta cuenta = (Cuenta) temp.getVal();
            int id = cuenta.getId();
            if (id == idCuenta){
                return cuenta.getPos();
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    };


    public void otroAñadir(int id, Cliente cliente, double apertura, String moneda){
        int pos = 0;
        NodoSE<Cuenta> temp = listaDeClientes.getHead();
        Cuenta cuenta;
        int cl = listaDeClientes.search(new NodoSE(cliente, null));
        Cuenta prev;
        if (listaDeClientes.isEmpty()){
            cuenta = new Cuenta(id, apertura, 0, moneda);
            NodoSE<Cuenta> nodoCuenta = new NodoSE<Cuenta>(cuenta, null);
            cliente.getCuentas().setHead(nodoCuenta);
            NodoSE nodoCliente = new NodoSE<Cliente>(cliente, null);
            listaDeClientes.setHead(nodoCliente);
        } else if(cl != -1){
            Cliente elCl = buscarClientePorId(cliente.getIdCliente());
            temp = elCl.getCuentas().getHead();
            while (temp != null){
                if (temp.getNext() == null){
                    prev = (Cuenta) temp.getVal();
                    pos = prev.getPos();
                }
                temp = temp.getNext();
            }
            cuenta = new Cuenta(id, apertura, pos+1, moneda);
            temp = new NodoSE(cuenta, null);
            elCl.getCuentas().add(temp);
            System.out.println(cuenta.toString());
            System.out.println(cliente.getCuentas().show());
        } 
        else {
            cuenta = new Cuenta(id, apertura, 0, moneda);
            NodoSE nodoCuenta = new NodoSE<Cuenta>(cuenta, null);
            cliente.getCuentas().setHead(nodoCuenta);
            NodoSE<Cliente> nodoCliente = new NodoSE<Cliente>(cliente, null);
            listaDeClientes.add(nodoCliente);
        }
    }

    public void otroBorrar(int id, int idCliente){
        int counter = 0;
        Cliente cliente = buscarClientePorId(idCliente);
        NodoSE temp = cliente.getCuentas().getHead();
        Cuenta cuenta;
        while (temp != null){
            cuenta = (Cuenta) temp.getVal();
            if (id == cuenta.getId()){
                temp = temp.getNext();
                cliente.getCuentas().delete(cuenta.getPos());
            } else {
                temp = temp.getNext();
                cuenta.setPos(counter);
                counter++;
            }
        }
        if (cliente.getCuentas().isEmpty()){
            int posCl = listaDeClientes.search(new NodoSE(cliente, null));
            listaDeClientes.delete(posCl);
        }
    }
    
    public int buscarCuenta(int id){
        NodoSE<Cuenta> temp = listaDeClientes.getHead();
        int count = 0;
        while (temp != null){
            for (int i = 0; i < listaDeClientes.get(count).getCuentas().length(); i++){
                Cuenta cuenta = listaDeClientes.get(count).getCuentas().get(i);
                if (cuenta.getId() == id){
                    return cuenta.getPos();
                }
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    }
    
    public Cliente buscarClientePorId(int id){
        NodoSE<Cliente> temp = listaDeClientes.getHead();
        int count = 0;
        while (temp != null){
            int idCliente = listaDeClientes.get(count).getIdCliente();
            if (id == idCliente){
                return listaDeClientes.get(count);
            }
            temp = temp.getNext();
            count++;
        }
        return null;
    }
    
    public ListaSE<Deposito> getDepsCliente(int idC){
        ListaSE<Deposito> deps = new ListaSE(null);
        for(int i = 0; i < getListaDeDepositos().length(); i++){
            Deposito temp = (Deposito) getListaDeDepositos().get(i);
            if (idC == temp.getClienteId()){
                deps.add(new NodoSE(temp, null));
            }
        }
        return deps;
    }
    
    public ListaSE<Retiro> getRetsCliente(int idC){
        ListaSE<Retiro> rets = new ListaSE(null);
        for(int i = 0; i < getListaDeRetiros().length(); i++){
            Retiro temp = (Retiro) getListaDeRetiros().get(i);
            if (idC == temp.getClienteId()){
                rets.add(new NodoSE(temp, null));
            }
        }
        return rets;
    }
    
    public void darDeBaja(int idCliente){
        Cliente cliente = buscarClientePorId(idCliente);
        int len = cliente.getCuentas().length();
        for (int i = 0; i < len; i++){
            cliente.getCuentas().delete(0);
            i++;
        }
        listaDeClientes.delete(listaDeClientes.search(new NodoSE(cliente, null)));
    }
}
