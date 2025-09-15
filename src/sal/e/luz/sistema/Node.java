package sal.e.luz.sistema;

import sal.e.luz.pedido.Pedido;

public class Node {
	private Pedido info;
	private Node prox;
	

	public Node(Pedido info) {
		this.info = info;
		prox = null;
	}
	
	public Pedido getInfo() {
		return info;
	}
	
	public void setProx(Node prox) {
		this.prox = prox;
	}
	
	public Node getProx() {
		return prox;
	}

}
