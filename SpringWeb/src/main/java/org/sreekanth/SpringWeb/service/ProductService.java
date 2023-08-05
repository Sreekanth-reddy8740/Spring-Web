package org.sreekanth.SpringWeb.service;

import java.util.List;

import org.sreekanth.SpringWeb.entity.ProductEntity;

public interface ProductService {

	public void saveProduct(ProductEntity productEntity);
	
	public List<ProductEntity> findProductById(Long id);
	
	public List<ProductEntity> findAllProduct();
	
	public List findProductQuantityById(Long id);
	
	public void deleteProductById(Long id);
	
	public  List<ProductEntity> findAllProductSortByName();
	
	public List<ProductEntity> getProductByName(String name);

	public List<ProductEntity> getProductRange(double lowerPrice, double higerPrice);
	
	public double findProductPriceById(Long id);
}
