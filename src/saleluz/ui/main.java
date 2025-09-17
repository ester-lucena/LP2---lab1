package saleluz.ui;

import java.util.Scanner;

import saleluz.pedido.Item;
import saleluz.pedido.Pedido;
import saleluz.sistema.LinkedList;

public class main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("-------------------------------------------");
		System.out.println("  Seja bem vindo ao restaurante Sal&Luz!");
		System.out.println("-------------------------------------------");
		
		LinkedList lista = new LinkedList();
		
		String n1;
		int número;
		do { //chama o menu até a opção 4 ser escolhida
			System.out.println("\n Menu principal:\n"
					+ "     1. Registrar Pedido.\n"
					+ "     2. Remover Pedido.\n"
					+ "     3. Listar Pedidos.\n"
					+ "     4. Sair.\n");
			
			do { //permite que só números inteiros positivos sejam digitados
				System.out.println("--------------------------------------------------------");
				System.out.print("O que você deseja executar(digite o número respectivo)? ");
				System.out.println("\n--------------------------------------------------------");
				n1 = leitor.nextLine();
				
				if(n1.matches("\\d+")) {
					número = Integer.parseInt(n1);
					break;
				} else {
			        System.out.println("Entrada inválida: digite apenas números.");
			    }
			} while(true);
			
			switch(número) {
			case 1:
				Pedido pedido = new Pedido();
				lista.adicionar_pedido(pedido);
				
				String nome_cliente;
				do { //permite que só texto seja digitado
					System.out.print("Qual o seu nome? ");
					nome_cliente = leitor.nextLine();
					
					if(nome_cliente.matches("[a-zA-ZáéíóúãõâêôçÁÉÍÓÚÃÕÂÊÔÇ ]+")) {
						break;
					} else {
						System.out.println("Entrada inválida: apenas texto é permitido.");
					}
				}while(true);
		
				pedido.setNome_cliente(nome_cliente);
				
				do { //permite que só números inteiros positivos sejam digitados
					System.out.printf("Olá %s, quantos itens serão adicionados ao pedido? ", pedido.getNome_cliente());
					String n2 = leitor.nextLine();
					
					if(n2.matches("\\d+")) {
						número = Integer.parseInt(n2);
						break;
					} else {
						System.out.println("Entrada inválida: digite apenas números.");
					}
				} while(true);
				
				//adiciona os itens escolhidos pelo cliente
				for(int i = 1; i <= número; i++) {
					Item item = new Item();
					
					String nome_item;
					if(número == 1) {
						do { //permite que só texto seja digitado
							System.out.print("Qual o nome do item? ");
							nome_item = leitor.nextLine();
							
							if(nome_item.matches("[a-zA-ZáéíóúãõâêôçÁÉÍÓÚÃÕÂÊÔÇ ]+")) {
								break;
							} else {
								System.out.println("Entrada inválida: apenas texto é permitido.");
							}
							
						} while(true);
						
					} else {
						do { //permite que só texto seja digitado
							System.out.printf("Qual o nome do %d° item? ", i);
							nome_item = leitor.nextLine();
							
							if(nome_item.matches("[a-zA-ZáéíóúãõâêôçÁÉÍÓÚÃÕÂÊÔÇ ]+")) {
								break;
							} else {
								System.out.println("Entrada inválida: apenas texto é permitido.");
							}
							
						} while(true);
					
					}
					item.setNome_item(nome_item);
					
					double valor;
					do { //permite que só números positivos, com até 2 casas decimais, sejam digitados
						System.out.printf("Digite o preço do item %s: ", item.getNome_item());
						String preço_item = leitor.nextLine();
						
						preço_item = preço_item.replace(",", ".");
						
						if(preço_item.matches("\\d+(\\.\\d{1,2})?")) {
							valor = Double.parseDouble(preço_item);
							break;
						} else {
							System.out.println("Entrada inválida: digite um preço válido.");
						}
						
					} while(true);
					item.setPreço_item(valor);
					
					pedido.adicionar_item(item);
				}
				System.out.println("\nImprimindo nota fiscal.....");
				
				//pausa de 3 segundos para imprimir a nota fiscal
				try {
					Thread.sleep(3000);
				} catch(InterruptedException e) {
					System.out.println("Erro na pausa");
				}
				
				System.out.println("\n========================================"); 
				System.out.println("          Restaurante Sal&Luz    "); 
				System.out.println("========================================"); 
				System.out.println("Pedido N°: " + pedido.getId_pedido()); 
				System.out.println("Cliente: " + pedido.getNome_cliente()); 
				System.out.println("----------------------------------------"); 
				System.out.println("Itens:");
				
				double valor_total = 0.0;
				
				for(Item item : pedido.getItens()) {
					System.out.println("-" + item.getNome_item() + " R$ " + item.getPreço_item());
					valor_total += item.getPreço_item();
				}
				System.out.println("----------------------------------------"); 
				System.out.println("Total: R$ " + valor_total); 
				System.out.println("========================================"); 
				System.out.println("   Obrigado pela preferência! :)    "); 
				System.out.println("========================================");
				
				break;
				
			case 2:
				do { //permite que só números inteiros positivos sejam digitados
					System.out.print("Qual o id do pedido a ser removido? ");
					String id_pedido = leitor.nextLine();
					
					if(id_pedido.matches("\\d+")) {
						número = Integer.parseInt(id_pedido);
						break;
					} else {
						System.out.println("Entrada inválida:digite apenas números.");
					}
					
				} while(true);
				
				lista.remover_pedido(número);
				
				break;
				
			case 3:
				System.out.println("Imprimindo a lista de pedidos......");
				
				//pausa de 3 segundos para imprimir os pedidos
				try {
					Thread.sleep(3000);
				} catch(InterruptedException e) {
					System.out.println("Erro na pausa");
				}
				
				lista.exibir_pedidos();
				
				break;
				
			case 4:
				System.out.println("Obrigado pela preferência!");
				System.out.println("Encerrando......");
				
				break;
				
			default:
				System.out.println("Opção inválida!");
					
			} 
			
		} while(número != 4);		
		
	}

}
