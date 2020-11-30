
package aplicacao;

import java.time.LocalDate;
import fachada.Fachada;
import modelo.Produto;
import modelo.Cliente;
import modelo.Pedido;

public class Programa {

	public static void main(String[] args) throws Exception {}
	public Programa() {
		String texto;
		try {
			// Adicionando produtos

			Fachada.cadastrarProduto("TV", 2000.0);
			Fachada.cadastrarProduto("NOTEBOOK", 3000.0);
			Fachada.cadastrarProduto("PS4", 2000.0);
			Fachada.cadastrarProduto("TABLET", 3500.0);
			Fachada.cadastrarProduto("CELULAR", 2500.0);

			System.out.println(texto);
			
			System.out.println("\n Teste de Excecoes: \n");
			try {
				Fachada.cadastrarProduto("CELULAR", 2500.0);
			}catch (Exception e){
				System.out.println(e.getMessage());
				
			}
			try {
				Fachada.cadastrarCliente("984444444", "Fatima", "Alemanha");
			}catch (Exception e){
				System.out.println(e.getMessage());
				
			}
			try {
				Fachada.adicionarProdutoPedido(7, 2);
				Fachada.adicionarProdutoPedido(7, 2);
			}catch (Exception e){
				System.out.println(e.getMessage());
				
			}
			try {
				Fachada.pagarPedido(1,"Joao");
			}catch (Exception e){
				System.out.println(e.getMessage());
				
			}
			try {
				Fachada.cancelarPedido(3);
			}catch (Exception e){
				System.out.println(e.getMessage());
				
			}
		}

