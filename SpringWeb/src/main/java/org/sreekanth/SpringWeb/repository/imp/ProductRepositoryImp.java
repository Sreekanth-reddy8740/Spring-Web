package org.sreekanth.SpringWeb.repository.imp;

import java.util.List;
import java.util.stream.Collector;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sreekanth.SpringWeb.entity.ProductEntity;
import org.sreekanth.SpringWeb.repository.ProductRepository;

@Repository
public class ProductRepositoryImp implements ProductRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveProduct(ProductEntity productEntity) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(productEntity);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	@Override
	public List<ProductEntity> findProductById(Long id) {
		String hqlQry="from ProductEntity where id=:n";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hqlQry);
		query.setParameter("n", id);
		List resultList = query.getResultList();
		return resultList;
	}
	
	@Override
	public void deleteProductById(Long id) {
		String hqlQry="delete from ProductEntity where id=:n";
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hqlQry);
		query.setParameter("n", id);
		query.executeUpdate();
		transaction.commit();
		
	}

	@Override
	public List<ProductEntity> findAllProduct() {
		try {
			String hqlQry="from ProductEntity";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hqlQry);
			List resultList = query.getResultList();
			return resultList;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		//return Collector.EMPTY_LIST;
	
	}

	@Override
	public List findProductQuantityById(Long id) {
		try {
			
			String hqlQry="select quantity from ProductEntity where id=:n";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hqlQry);
			query.setParameter("n", id);
			List resultList = query.getResultList();
			return resultList;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

	//@SuppressWarnings("deprecation")
	@Override
	public List<ProductEntity> findAllProductSortByName() {
	
		try {
			String hqlQry="from ProductEntity order by name desc";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hqlQry);
			List resultList = query.getResultList();
			return resultList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {
		try {
			
			String hqlQry="from ProductEntity where name=:n";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hqlQry);
			query.setParameter("n", name);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<ProductEntity> getProductRange(double lowerPrice, double higerPrice) {
		try {
			String hqlQry="from ProductEntity where price between :n and :m";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hqlQry);
			query.setParameter("n", lowerPrice);
			query.setParameter("m", higerPrice);
			return query.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public double findProductPriceById(Long id) {
		try {
			String hqlQry="select price from ProductEntity where id=:n";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hqlQry);
			query.setParameter("n", id);
			Object result = query.getSingleResult();
			return (double) result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return 0.0;
	}
}
