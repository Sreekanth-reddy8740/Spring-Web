package org.sreekanth.SpringWeb.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sreekanth.SpringWeb.entity.ProductEntity;
import org.sreekanth.SpringWeb.repository.imp.ProductRepositoryImp;
import org.sreekanth.SpringWeb.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductRepositoryImp productRepositoryImp;
	
	@Override
	public void saveProduct(ProductEntity productEntity) {
		productRepositoryImp.saveProduct(productEntity);
	}

	@Override
	public  List<ProductEntity> findProductById(Long id) {
		return productRepositoryImp.findProductById(id);
	}
	
	@Override
	public void deleteProductById(Long id) {
		productRepositoryImp.deleteProductById(id);
	}

	@Override
	public List<ProductEntity> findAllProduct() {
		return productRepositoryImp.findAllProduct();
	}

	@Override
	public List findProductQuantityById(Long id) {
		return productRepositoryImp.findProductQuantityById(id);
	}

	@Override
	public List<ProductEntity> findAllProductSortByName() {
		return productRepositoryImp.findAllProductSortByName();
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {
		return productRepositoryImp.getProductByName(name);
	}

	@Override
	public List<ProductEntity> getProductRange(double lowerPrice, double higerPrice) {
		return productRepositoryImp.getProductRange(lowerPrice, higerPrice);
	}

	@Override
	public double findProductPriceById(Long id) {
		return productRepositoryImp.findProductPriceById(id);
	}

}
