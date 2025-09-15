package sal.e.luz.ui;

import java.util.Scanner;

import sal.e.luz.pedido.Item;
import sal.e.luz.pedido.Pedido;
import sal.e.luz.sistema.LinkedList;

public class main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("-------------------------------------------");
		System.out.println("  Seja bem vindo ao restaurante Sal&Luz!");
		System.out.println("-------------------------------------------");
		
		LinkedList lista = new LinkedList();
		
		int n1;
		do {
			System.out.println("\n Menu principal:\n"
					+ "     1. Registrar Pedido.\n"
					+ "     2. Remover Pedido.\n"
					+ "     3. Listar Pedidos.\n"
					+ "     4. Sair.\n");
			System.out.println("--------------------------------------------------------");
			System.out.print("O que você deseja executar(digite o número respectivo)? ");
			System.out.println("\n--------------------------------------------------------");
			n1 = leitor.nextInt();
			
			leitor.nextLine();
			
			switch(n1) {
			case 1:
				Pedido pedido = new Pedido();
				lista.adicionar_pedido(pedido);
				
				System.out.print("Qual o seu nome? ");
				String nome_cliente = leitor.nextLine();
				pedido.setNome_cliente(nome_cliente);
				
				System.out.printf("Olá %s, quantos itens serão adicionados ao pedido? ", pedido.getNome_cliente());
				int n2 = leitor.nextInt();
				
				leitor.nextLine();
				
				for(int i = 1; i <= n2; i++) {
					Item item = new Item();
					
					if(n2 == 1) {
						System.out.print("Qual o nome do item? ");
						String nome_item = leitor.nextLine();
						item.setNome_item(nome_item);
					} else {
						System.out.printf("Qual o nome do %d° item? ", i);
						String nome_item = leitor.nextLine();
						item.setNome_item(nome_item);
					}
					
					System.out.printf("Digite o preço do item %s: ", item.getNome_item());
					double preço_item = leitor.nextDouble();
					item.setPreço_item(preço_item);
					
					leitor.nextLine();
					
					pedido.adicionar_item(item);
				}
				System.out.println("\nImprimindo nota fiscal.....");
				
				try {
					Thread.sleep(3000);
				} catch(InterruptedException e) {
					System.out.println("Erro na pausa");
				}
				
				System.out.println("\n========================================"); 
				System.out.println("    Restaurante Sal&Luz    "); 
				System.out.println("========================================"); 
				System.out.println("Pedido N°: " + pedido.getId_pedido()); 
				System.out.println("Cliente: " + pedido.getNome_cliente()); 
				System.out.println("----------------------------------------"); 
				System.out.println("Itens:");
				
				double valor_total = 0.0;
				
				for(Item item : pedido.getItens()) {
					System.out.printf("-" + item.getNome_item() + " R$ %.2f%n", item.getPreço_item());
					valor_total += item.getPreço_item();
				}
				System.out.println("----------------------------------------"); 
				System.out.printf("Total: R$ %.2f%n", valor_total); 
				System.out.println("========================================"); 
				System.out.println("   Obrigado pela preferência! :)    "); 
				System.out.println("========================================");
				
				break;
				
			case 2:
				System.out.print("Qual o id do pedido a ser removido? ");
				int id_pedido = leitor.nextInt();
				leitor.nextLine();
				
				lista.remover_pedido(id_pedido);
				
				break;
				
			case 3:
				System.out.println("Segue a lista de pedidos:");
				lista.exibir_pedidos();
				
				break;
				
			case 4:
				System.out.println("Obrigado pela preferência!");
				System.out.println("Encerrando......");
				
				break;
				
			default:
				System.out.println("Opção inválida!");
					
			} 
			
		} while(n1 != 4);		
		
	}

}
