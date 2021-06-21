package in.stack.productApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.stack.productApp.entity.Product;
import in.stack.productApp.service.ProductService;

@RestController
@RequestMapping("/productservice")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	ResponseEntity<?> response=null;
	/**
	 * adding new product
	 * 
	 * @param newProduct
	 * @param session
	 * @return ResponseEntity
	 */
	@PostMapping("/addproduct")
	public ResponseEntity<?> saveProdcut(@RequestBody Product newProduct ,HttpSession session){
		ResponseEntity<?> response= null;
		
		try {
				Product responseProduct = productService.addProduct(newProduct);
				if (responseProduct !=null) {
					response= new ResponseEntity<Product>(responseProduct,HttpStatus.CREATED);
				}else {
					response = new ResponseEntity<String>("Conflict Data",HttpStatus.CONFLICT);
				}
			
		}catch (Exception ex) {
			ex.printStackTrace();
			response = new ResponseEntity<String>("Internal Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	/**
	 * fetch all products
	 * @return ResponseEntity
	 */
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts(){
		List<Product> allProducts = productService.getAllProducts();
		return new ResponseEntity< List<Product> >(allProducts,HttpStatus.OK);
	}
	
	@GetMapping("{productid}")
	public ResponseEntity<?> getProductById(@PathVariable int productid){
		ResponseEntity<?> response = null;
		Product responseProduct = productService.getProductById(productid);
		if (responseProduct !=null) {
			response= new ResponseEntity<Product>(responseProduct,HttpStatus.FOUND);
		}else {
			response = new ResponseEntity<String>("Product Data not found",HttpStatus.NOT_FOUND);
		}
		return response;
		
	}
	
	@DeleteMapping("{productid}")
	public ResponseEntity<?> deleteProduct(@PathVariable int productid){
		ResponseEntity<?> response = null;
		boolean reponseStatus = productService.deleteProduct(productid);
		if(reponseStatus) {
			response= new ResponseEntity<String>("Product Deleted" ,HttpStatus.OK);
		}else {
			response = new ResponseEntity<String>("Product Data not found",HttpStatus.NOT_FOUND);
		}
		return response;
		
	}
	
	@PutMapping("{productid}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product,
			  @PathVariable int productid){
				Product responseProduct = productService.updateProduct(product,productid);
				if (responseProduct !=null) {
					response= new ResponseEntity<Product>(responseProduct,HttpStatus.OK);
				}else {
					response = new ResponseEntity<String>("Product Data not found",HttpStatus.NOT_FOUND);
				}
				return response;
		
	}
}
