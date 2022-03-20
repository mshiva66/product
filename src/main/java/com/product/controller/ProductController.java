package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.Product;
import com.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Product Controller", description = "APIs to fetch product details")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping(value = "/get-products", produces = { "application/json" })
	@Operation(summary = "Products", description = "Get All Products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful ", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Product.class)))) })
	public List<Product> getProducts() {
		return service.listAllProducts();
	}

	@GetMapping(value = "/{id}", produces = { "application/json" })
	@Operation(summary = "Find product by ID", description = "Returns a single product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Product.class))),
			@ApiResponse(responseCode = "404", description = "Contact not found") })

	public Product showProduct(@PathVariable int id) {

		return service.getProductById(id);
	}

}
