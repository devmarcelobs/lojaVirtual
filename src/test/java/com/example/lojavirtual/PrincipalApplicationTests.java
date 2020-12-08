package com.example.lojavirtual;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.lojavirtual.model.Cliente;
import com.example.lojavirtual.model.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class PrincipalApplicationTests {
	
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	ObjectMapper om = new ObjectMapper();
	
	@BeforeEach
	private void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testeLogin() throws Exception {
		
	}
	
	@Test
	public void testeCadastro_produto() throws Exception {
		Produto produto1 = new Produto();
		produto1.setCodigoBarra(123);
		produto1.setNome("teste");
		produto1.setCategoria("teste");
		produto1.setValor(100.00);
		produto1.setCarrinho(null);
		
		String jsonRequest = om.writeValueAsString(produto1);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/Adm/addProduto")
				.content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
			
		boolean x = om.readValue(result.getResponse().getContentAsString(), Boolean.class);
		
		assertTrue(x == Boolean.TRUE);
	}
	
	@Test
	public void testeCadastro_cliente() throws Exception{
		Cliente cliente = new Cliente();
		cliente.setCpf("238974892");
		cliente.setEndereco("teste");
		cliente.setNome("marcelo");
		
		String jsonRequest = om.writeValueAsString(cliente);
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/Adm/addCliente")
				.content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		
		boolean x = om.readValue(result.getResponse().getContentAsString(), Boolean.class);
		
		assertTrue(x == Boolean.TRUE);
	}
	
	@Test
	public void testeAdicionaProduto_carrinho() throws Exception{
		
	}
	
	@Test
	public void testeListaCliente_cliente() throws Exception{
		
	}

}
