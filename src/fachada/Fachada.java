package fachada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import modelo.Cliente;
import modelo.Pedido;
import modelo.PedidoExpress;
import modelo.Produto;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();
	private static int idproduto = 0;
	private static int idpedido = 0;

	public static ArrayList<Produto> listarProdutos(String text) {
		return repositorio.getProdutos(text);
	}

	public static ArrayList<Cliente> listarClientes() {
		return repositorio.getClientes();
	}

	public static ArrayList<Pedido> listarPedidos() {
		return repositorio.getPedidos();
	}
	
	public static ArrayList<Pedido> listarPedidos(String tel, int tipo) {
		return repositorio.getPedidoByTel_Tipo(tel, tipo);
	}

	public static Pedido getPedidoById(int idpedido)  throws Exception {
		if (repositorio.localizarPedido(idpedido) != null) {
			return repositorio.localizarPedido(idpedido);
		}else {
			throw new Exception("Id do pedido n�o encontrado");
		}
	}


	public static Produto cadastrarProduto(String nome, double preco)  throws Exception {
		idproduto++;
		ArrayList<Pedido> ped = new ArrayList<>();
		;
		Produto produto;
		produto = new Produto(idproduto, nome, preco, ped);
		if(repositorio.localizarProduto(nome) == null) {
			repositorio.adicionar(produto);
			return produto;
		}else {
			throw new Exception("Produto com esse exato nome j� existe");
		}
	}

	public static Cliente cadastrarCliente(String telefone, String nome, String endereco) throws Exception {
		Cliente cliente;
		ArrayList<Pedido> pedidos = new ArrayList<>();
		cliente = new Cliente(telefone, nome, endereco, pedidos);
		if(repositorio.localizarCliente(telefone) == null) {
			repositorio.adicionar(cliente);
			return cliente;
		}else {
			throw new Exception("Cliente com esse telefone j� existe");
		}
	}

	public static Pedido criarPedido(String telefone) throws Exception {
        idpedido++;
        Cliente cli = null;
        LocalDateTime agora = LocalDateTime.now();
        ArrayList<Produto> prod = new ArrayList<>();
        Pedido pedido;
        cli = repositorio.localizarCliente(telefone);
        if (cli != null) {
            pedido = new Pedido(idpedido, agora, 0, null, false, cli, prod);
            repositorio.adicionar(pedido);
            return pedido;
        }
        else {
            throw new Exception("Cliente n�o existe");
        }
    }

	public static Pedido criarPedido(String telefone, double taxaentrega)  throws Exception {
        idpedido++;
        Cliente cli = null;
        LocalDateTime agora = LocalDateTime.now();
        
        ArrayList<Produto> prod = new ArrayList<>();
        Pedido pedido;
        cli = repositorio.localizarCliente(telefone);
        if (cli != null) {
            pedido = new PedidoExpress(idpedido, agora, 0, null, false, cli, prod, taxaentrega);
            repositorio.adicionar(pedido);
            return pedido;
            }
        throw new Exception("Cliente n�o existe");
	}
	
	public static void adicionarProdutoPedido(int idpedido, int idproduto) throws Exception {
		Pedido pe;
		Produto pr;
		pe = repositorio.localizarPedido(idpedido);
		pr = repositorio.localizarProduto(idproduto);
		if (pe != null) {
			if (pr != null) {
					pe.addProduto(pr);
					pr.addPedido(pe);
					pe.getCliente().addPedido(pe);
			}else {
					throw new Exception("Produto com esse id n�o existe");
					}
		}else {
			throw new Exception("Pedido com esse id n�o existe");
				}
			}

	public static void removerProdutoPedido(int idpedido, int idproduto)  throws Exception {
		Pedido pe;
		Produto pr;
		pe = repositorio.localizarPedido(idpedido);
		pr = repositorio.localizarProduto(idproduto);
		if (pe != null) {
			if (pr != null) {
				if (pe.getProdutosIds().contains(idproduto)) {
					pe.remProduto(pr);
					pr.remPedido(pe);
				}else {
					throw new Exception("Produto com esse id n�o existe dentro desse Pedido");
					}
			}else {
					throw new Exception("Produto com esse id n�o existe");
					}
		}else {
			throw new Exception("Pedido com esse id n�o existe");
				}
			}

	public static Pedido consultarPedido(int idpedido) throws Exception {
		Pedido res;
		res = repositorio.localizarPedido(idpedido);
		if (res != null) {
			return res;
		} else {
			throw new Exception("N�o existe esse pedido");
		}
	}

	public static void pagarPedido(int idpedido, String nomeentregador) throws Exception {
		Pedido res;
		res = repositorio.localizarPedido(idpedido);
		if (res == null) {
			throw new Exception("N�o existe esse pedido");
		}
		res.setEntregador(nomeentregador);
		res.setPago(true);

	}

	public static void cancelarPedido(int idpedido) throws Exception {
		Pedido res;
		res = repositorio.localizarPedido(idpedido);
		if (res == null) {
			throw new Exception("N�o existe esse pedido!");
		}
		for (Produto pr : repositorio.getProdutos("")) {
			if (pr.getPedidos().contains(res)) {
				pr.getPedidos().remove(res);
			}
		}

		res.getCliente().getPedidos().remove(res);
		
		repositorio.remover(res);

	}

	public static double consultarArrecadacao(Integer dia) {
		double total = 0;
		for (Pedido p : repositorio.getPedidos()) {
			if (p.isPago() == true &  p.getDatahora().getDayOfMonth() == dia ) {
				total = total + p.getValortotal();
			}
		}
		return total;
	}

	public static ArrayList<Produto> consultarProdutoTop() {
		ArrayList<Produto> res = new ArrayList<>();
		HashMap<Produto, Integer> contagem = new HashMap<>();

		for (Pedido pe : repositorio.getPedidos()) {
			for (Produto prod : pe.getProdutos()) {
				if (contagem.containsKey(prod)) {
					contagem.put(prod, contagem.get(prod) + 1);
				} else {
					contagem.put(prod, 1);
				}
			}
		}

		Map<Produto, Integer> sortedNewMap = contagem.entrySet().stream()
				.sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		sortedNewMap.forEach((key, val) -> {
			//System.out.println(key + " = " + val.toString());
			res.add(key);
		});

		return res;

	}
}