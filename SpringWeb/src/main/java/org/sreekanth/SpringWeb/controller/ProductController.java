package org.sreekanth.SpringWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sreekanth.SpringWeb.entity.ProductEntity;
import org.sreekanth.SpringWeb.service.imp.ProductServiceImp;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImp productServiceImp;
	
	@PostMapping(value = "/saveProduct")
	public void saveProduct(@RequestBody ProductEntity productEntity) {
		productServiceImp.saveProduct(productEntity);
		
	}
	@GetMapping(value = "findProductById/{alt_key}")
	public @ResponseBody List<ProductEntity> findProductById(@PathVariable("alt_key") Long id) {
		return productServiceImp.findProductById(id);
				
	}
	
	@GetMapping(value = "/findAllProduct")
	public @ResponseBody List<ProductEntity> findAllProduct() {
		return productServiceImp.findAllProduct();
	}
	
	@GetMapping(value = "/findProductQuantityById/{alt_key}")
	public @ResponseBody List findProductQuantityById(@PathVariable("alt_key") Long id) {
		return productServiceImp.findProductQuantityById(id);
	}

	@DeleteMapping(value = "deleteProductById/{alt_key}")
	public void deleteProductById(@PathVariable("alt_key") Long id) {
		productServiceImp.deleteProductById(id);
	}
	
	@GetMapping(value = "/findAllProductSortByName")
	public @ResponseBody List<ProductEntity> findAllProductSortByName() {
		return productServiceImp.findAllProductSortByName();
	}
	
	// @RequestParam --> is used to fetch the data form the parameter Request
	@GetMapping(value = "getProductByName")
	public List<ProductEntity> getProductByName(@RequestParam ("name") String name) {
		return productServiceImp.getProductByName(name);
	}
	
	@GetMapping(value = "getProductRange")
	public List<ProductEntity> getProductRange(@RequestParam double lowerPrice, double higerPrice) {
		return productServiceImp.getProductRange(lowerPrice, higerPrice);
	}
	
	@GetMapping(value = "findProductPriceById/{alt_key}")
	public double findProductPriceById(@PathVariable("alt_key") long id) {
//		System.out.println("productId : "+productId);
		return productServiceImp.findProductPriceById(id);
	}
}
