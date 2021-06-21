package in.stack.productApp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.stack.productApp.entity.Product;

@Repository
@Transactional
public class ProductRepositoryImp implements ProductRepository {
	
	@Autowired
	private SessionFactory factory;
	
	private Session getCurrentSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public Product addProduct(Product product) {
		Product returnProduct=null;
		
		if(getCurrentSession().save(product)!=null) {	
			returnProduct=product;
	   }
		return returnProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> allProducts = getCurrentSession().createQuery("from Product",Product.class).list();
		return allProducts;
	}

	@Override
	public Product getProductById(int productId) {
		Product fetchedProduct = getCurrentSession().find(Product.class, productId);
		return fetchedProduct;
	}

	@Override
	public boolean deleteProduct(int productId) {
		boolean status = false;
		Product fetchedProduct = getCurrentSession().find(Product.class, productId);
		try {
			if(fetchedProduct != null) {
				getCurrentSession().remove(fetchedProduct);
				status=true;
			}
		}catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Product updateProduct(Product product, int productId) {
		Product fetchedProduct = getCurrentSession().find(Product.class, productId);
		if(fetchedProduct!=null) {
			fetchedProduct.setProductName(product.getProductName());
			fetchedProduct.setPrice(product.getPrice());
			fetchedProduct.setQuantity(product.getQuantity());
			getCurrentSession().update(fetchedProduct);
		}
		return fetchedProduct;
	}

}
