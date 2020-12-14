package com.example.lojavirtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lojavirtual.model.Adm;
import com.example.lojavirtual.model.Carrinho;
import com.example.lojavirtual.model.Cliente;
import com.example.lojavirtual.model.Login;
import com.example.lojavirtual.model.Produto;
import com.example.lojavirtual.repository.AdmRepository;
import com.example.lojavirtual.repository.CarrinhoRepository;
import com.example.lojavirtual.repository.ClienteRepository;
import com.example.lojavirtual.repository.ProdutoRepository;

@RestController
@RequestMapping("/Adm")
public class AdmController implements Login{
	@Autowired
	private AdmRepository admRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	/*@Autowired
	public AdmController(AdmRepository admRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository, CarrinhoRepository carrinhoRepository) {
		this.admRepository = admRepository;
		this.produtoRepository = produtoRepository;
		this.clienteRepository = clienteRepository;
		this.carrinhoRepository = carrinhoRepository;
	}*/
	
	@Override
	@GetMapping("/loginAdm")
	public boolean login(@RequestBody String login, String senha, Adm adm) {
		if(admRepository.findById(adm.getId())!=null) {
			if(adm.getLogin().equals(login)) {
				if(adm.getSenha().equals(senha)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@PostMapping("/addProduto")
	public boolean CadastroProduto(@RequestBody Produto produto) {
		if(produtoRepository.findByCodigoBarra(produto.getCodigoBarra())==null) {
			produtoRepository.save(produto);
			return true;
		}
		else {
			System.out.println("Codigo de Barras já existente");
			return false;
		}
	}
	
	@PostMapping("/addCliente")
	public boolean CadastroCliente(@RequestBody Cliente cliente) {
		if(clienteRepository.findByCpf(cliente.getCpf())==null) {
			clienteRepository.save(cliente);
			return true;
		}
		else {
			System.out.println("CPF já existente");
			return false;
		}
	}
	
	//é possivel essa logica de adicionar o carrinho a um produto e depois adicionar o produto a um carrinho (não fica semelhante)
	public boolean AdicionarProdutoCarrinho(Integer id, Carrinho carrinho, Integer codigoBarra, Produto produto, int quantidade) {
		if(carrinhoRepository.findById(carrinho.getId())!=null) {
			if(produtoRepository.findByCodigoBarra(produto.getCodigoBarra())!=null) {
				produto.setCarrinho(carrinho);
				carrinho.setProdutos(produto);
				carrinho.setQuantidade(quantidade);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public List<Cliente> ListaCliente(String cpf, Cliente cliente){
		if(clienteRepository.findByCpf(cliente.getCpf())!=null) {
			return clienteRepository.findAll();
		}
		else {
			return null;
		}
	}
}
