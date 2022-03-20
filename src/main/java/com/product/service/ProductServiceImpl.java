package com.product.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.product.dto.Product;

@Service
public class ProductServiceImpl implements ProductService{

	
	List<Product> products = Arrays.asList(new Product(1, "Apple", "V123"), new Product(2, "Nokia", "V231"), new Product(3, "Samsung", "s1234"));
 	
	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return products.stream().filter(p -> p.getId()==id).findFirst().get();
	}

	
}
