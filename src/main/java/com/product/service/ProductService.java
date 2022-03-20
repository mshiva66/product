package com.product.service;

import java.util.List;

import com.product.dto.Product;

public interface ProductService {

	List<Product> listAllProducts();

	Product getProductById(int id);

}
