package saleluz.pedido;

import java.util.ArrayList;

public class Pedido {
	private static int id = 1;
	private int id_pedido;
	private String nome_cliente;
	private ArrayList<Item> itens = new ArrayList<Item>();
	
	public Pedido() {
		id_pedido = id++;
	}
	
	public int getId_pedido() {
		return id_pedido;
	}
	
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	
	public String getNome_cliente() {
		return nome_cliente;
	}
	
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	
	public void adicionar_item(Item item) {
		itens.add(item);
	}
	
	public ArrayList<Item> getItens() {
		return itens;
	}
	
}
