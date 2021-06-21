package in.stack.productApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.stack.productApp.entity.Product;
import in.stack.productApp.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product addProduct(Product product) {
		return productRepo.addProduct(product);
	}

	@Override
	public Product getProductById(int productId) {
		return productRepo.getProductById(productId);
	}

	@Override
	public Product updateProduct(Product product,int productId) {
		return productRepo.updateProduct(product,productId);
		
	}

	@Override
	public boolean deleteProduct(int productId) {
		return productRepo.deleteProduct(productId);
		
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.getAllProducts();
	}

}
