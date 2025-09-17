package saleluz.sistema;

import saleluz.pedido.Item;
import saleluz.pedido.Pedido;

public class LinkedList {
	private Node first;
	
	public void adicionar_pedido(Pedido pedido) {
		Node node_pedido = new Node(pedido);
		
		if(first == null) {
			first = node_pedido;
			return;
		}
		
		Node atual_node = first;
		//percorre a lista inteira até chegar no último elemento
		while(atual_node.getProx() != null) {
			atual_node = atual_node.getProx();
		}
		//adiciona o pedido no fim da lista
		atual_node.setProx(node_pedido);
	}
	
	public void remover_pedido(int id) {
		
		if(first == null) {
			System.out.println("não existem pedidos!"); //lista vazia
			return;
		}
		//caso o id seja 1
		if(first.getInfo().getId_pedido() == id) {
			first = first.getProx();
			return;
		}
		
		Node atual_node = first;
		//percorre a lista até chegar no pedido anterior ao pedido que será removido 
		while(atual_node.getProx() != null && 
			  atual_node.getProx().getInfo().getId_pedido() != id) {
			
			atual_node = atual_node.getProx();
		}
		
		if(atual_node.getProx() == null) {
			System.out.printf("o pedido %d não existe\n", id);
		} else { //o pedido atual, que aponta para o pedido que será removido, passa a apontar para o pedido seguinte
			atual_node.setProx(atual_node.getProx().getProx());
			System.out.println("Pedido removido com sucesso!");
		}
	}
	
	public void exibir_pedidos() {
		if (first == null) {
		    System.out.println("Não há pedidos regsitrados no sitema!");
		    return;
		}
		
		Node atual_node = first;
		//percorre a lista e imprime os pedidos
		while(atual_node != null){
			System.out.println("\n========================================"); 
			System.out.println("Pedido ID:" + atual_node.getInfo().getId_pedido());
			
			//pausa de 3 segundos entre os pedidos
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
			
			//passa para o próximo peddido
			atual_node = atual_node.getProx();
			
		}
		
	}
	
}
