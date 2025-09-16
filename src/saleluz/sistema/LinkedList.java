package saleluz.sistema;

import saleluz.pedido.Item;
import saleluz.pedido.Pedido;

public class LinkedList {
	private Node head;
	
	public void adicionar_pedido(Pedido pedido) {
		Node node_pedido = new Node(pedido);
		
		if(head == null) {
			head = node_pedido;
			return;
		}
		
		Node atual_node = head;
		while(atual_node.getProx() != null) {
			atual_node = atual_node.getProx();
		}

		atual_node.setProx(node_pedido);
	}
	
	public void remover_pedido(int id) {
		if(head == null) {
			System.out.println("não existem pedidos!");
			return;
		}
		
		if(head.getInfo().getId_pedido() == id) {
			head = head.getProx();
			return;
		}
		
		Node atual_node = head;
		while(atual_node.getProx() != null && 
			  atual_node.getProx().getInfo().getId_pedido() != id) {
			
			atual_node = atual_node.getProx();
		}
		
		if(atual_node.getProx() == null) {
			System.out.printf("o pedido %d não existe\n", id);
		} else {
			atual_node.setProx(atual_node.getProx().getProx());
			System.out.println("Pedido removido com sucesso!");
		}
	}
	
	public void exibir_pedidos() {
		if (head == null) {
		    System.out.println("Não há pedidos regsitrados no sitema!");
		    return;
		}
		
		Node atual_node = head;
		while(atual_node != null){
			System.out.println("\n========================================"); 
			System.out.println("Pedido ID:" + atual_node.getInfo().getId_pedido());
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				System.out.println("Erro na pausa");
			}
			System.out.println("Cliente:" + atual_node.getInfo().getNome_cliente());
			System.out.println("----------------------------------------"); 
			System.out.println("Itens:");
			double valor_total = 0.0;
			
			for(Item item : atual_node.getInfo().getItens()) {
				System.out.println("-" + item.getNome_item() + " R$ " + item.getPreço_item());
				valor_total += item.getPreço_item();
			}
			System.out.println("----------------------------------------"); 
			System.out.println("Total: R$ " + valor_total); 
		
			atual_node = atual_node.getProx();
			
			
		}
	}
	
}
