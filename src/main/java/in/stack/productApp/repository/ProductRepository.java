package in.stack.productApp.repository;

import java.util.List;

import in.stack.productApp.entity.Product;

public interface ProductRepository {
	/**
	 * 
	 * @param product
	 * @return
	 */
	public Product addProduct(Product product);
	/**
	 * 
	 * @return
	 */
	public List<Product> getAllProducts();
	/**
	 * 
	 * @param productId
	 * @return
	 */
	public Product getProductById(int productId);
	/**
	 * 
	 * @param productId
	 * @return
	 */
	public boolean deleteProduct(int productId);
	/**
	 * 
	 * @param product
	 * @param productId
	 * @return
	 */
	public Product updateProduct(Product product, int productId);

}
