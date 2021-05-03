package ca.sheridancollege.nguyenvt.repositories;
 
import java.util.List;

import ca.sheridancollege.nguyenvt.beans.*;

public interface ProductList {

	public List<Product> getProductList();
	public void setProductList(List<Product> productList);
	public void addProduct(Product product);
	public void emptyList();
	public void deleteProduct(String name);
	
}
