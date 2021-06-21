package in.stack.productApp.service;

import java.util.List;

import in.stack.productApp.entity.Product;

public interface ProductService {
	/**
	 * Add a product
	 * @param product
	 * @return
	 */
	public Product addProduct(Product product);
	/**
	 * get product by id
	 * @param productId
	 * @return
	 */
	public Product getProductById(int productId);
	/**
	 * update a product
	 * @param product 
	 * @param productId
	 * @return 
	 */
	public Product updateProduct(Product product, int productId);
	/**
	 * delete a product
	 * @param productId
	 * @return reponseStatus
	 */
	public boolean deleteProduct(int productId);
	/**
	 * fetch all products
	 * @return list of products
	 */
	public List<Product> getAllProducts();
}
