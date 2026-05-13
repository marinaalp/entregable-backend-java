package service;

import java.util.ArrayList;
import java.util.List;
import pedidos.Pedido;

public class PedidoService {
    private List<Pedido> pedidos;
    private static int contadorID = 1;
    public PedidoService() {
        this.pedidos = new ArrayList<>();
    }
    public Pedido crearPedido(Pedido pedido) {
        pedido.setId(contadorID);
        contadorID++;
        pedidos.add(pedido);
        return pedido;
    }
    public List<Pedido> listarPedidos() {
        return pedidos;
    }
    
    
    
}
