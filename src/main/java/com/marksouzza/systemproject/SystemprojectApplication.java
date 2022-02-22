package com.marksouzza.systemproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marksouzza.systemproject.domain.Category;
import com.marksouzza.systemproject.domain.Cidade;
import com.marksouzza.systemproject.domain.Cliente;
import com.marksouzza.systemproject.domain.Endereco;
import com.marksouzza.systemproject.domain.Estado;
import com.marksouzza.systemproject.domain.Product;
import com.marksouzza.systemproject.domain.enums.TipoCliente;
import com.marksouzza.systemproject.repositories.CategoryRepository;
import com.marksouzza.systemproject.repositories.CidadeRepository;
import com.marksouzza.systemproject.repositories.ClienteRepository;
import com.marksouzza.systemproject.repositories.EnderecoRepository;
import com.marksouzza.systemproject.repositories.EstadoRepository;
import com.marksouzza.systemproject.repositories.ProductRepository;

@SpringBootApplication
public class SystemprojectApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SystemprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computador", 3500.00);
		Product p2 = new Product(null, "Impressora", 760.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
			
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Rio Grande do Sul");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Pelotas", est1);
		Cidade c2 = new Cidade(null, "Campinas", est2);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));	
		
		Cliente cli1 = new Cliente(null, "Emily Xavier", "emily.oliveira.xavier@gmail.com", "49855548809", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Mark Santo de Souza", "marksanto.dev@gmail.com", "05120040055", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("11 99538-2888"));
		cli2.getTelefones().addAll(Arrays.asList("53 98112-1262"));
		
		Endereco e1 = new Endereco(null, "Rua Zumbi dos Palmares", "258", "Apto 401 - Bloco 01", "Parque São Vicente", "09371-076", cli1, c3);
		Endereco e2 = new Endereco(null, "Rua Elgar Carlos Hadler" , "1814", "Apto 201 - Bloco 01", "São Gonçalo", "96085-357", cli2, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
		
	}
}
