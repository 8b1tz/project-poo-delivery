package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pedido {
	private int id;
	private LocalDateTime datahora;
	private double valortotal;
	private String entregador;
	private boolean pago;
	private ArrayList<Produto> produtos;
	private Cliente cliente;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


	public Pedido(int id, LocalDateTime datahora, double valortotal, String entregador, boolean pago, Cliente cliente,
			ArrayList<Produto> produtos) {
		this.id = id;
		this.datahora = datahora;
		this.valortotal = valortotal;
		this.entregador = entregador;
		this.pago = pago;
		this.cliente = cliente;
		this.produtos = produtos;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public String getEntregador() {
		return entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}

	// Retorna  todos os Produtos do Pedido
	public ArrayList<Produto> getProdutos() {
		return this.produtos;
	}


	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	// Retorna true ou false 
	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Adiciona Produto na lista de Produtos do Pedido
	public void addProduto(Produto pr) {
		this.produtos.add(pr);

	}

	// Remove Produto da lista de Produtos do Pedido
	public void remProduto(Produto p) {
		this.getProdutos().remove(p);

	}
	
	// Retorna a soma dos precos de todos Produtos do Pedido
	public double geraValortotal() {
		double total = 0.0;
		for(Produto p : this.getProdutos()) {
			total = total + p.getPreco();
		}
		return total;
	}

	// Retorna todos ids dos Produtos do Pedido
	public ArrayList<Integer> getProdutosIds() {
		ArrayList<Integer> res = new ArrayList<>();
		for (Produto p : getProdutos()) {
			res.add(p.getId());
		}
		return res;
	}

	@Override
	public String toString() {
		String formatada = datahora.format(formatter);
		return "Pedido [id: " + id + ", cliente: " + cliente.getNome() + ", entregador: " + entregador + ", datahora: "
				+ formatada + ", valortotal: " + geraValortotal() + ", pago: " + pago + ", idProdutos: " +  getProdutosIds() + "]";
	}
}