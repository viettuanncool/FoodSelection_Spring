package ca.sheridancollege.nguyenvt.repositories;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import ca.sheridancollege.nguyenvt.beans.*;

@Component
public class ProductListImplmt implements ProductList{

	List<Product> productList = new CopyOnWriteArrayList<>();
	
	@Override
	//get the whole cart
	public List<Product> getProductList(){
		return productList;
	}

	@Override
	//setting cart
	public void setProductList(List<Product> pList) {
		this.productList = pList;
	}

	@Override
	//emptying cart
	public void emptyList() {
		productList.clear();
	}

	@Override
	//add a product to cart
	public void addProduct(Product product) {
		boolean exist = false;
		//loop through all product added
		for(Product p:productList) {
			//find existing product with same id
			if(Long.valueOf(p.getId())==Long.valueOf(product.getId())) {
				exist = true;
				p.setQuantity(p.getQuantity()+product.getQuantity());
				break;
			}
		}
		//add product into the list if it haven't
		if(!exist) {
			productList.add(product);
		}
	}

	@Override
	//delete product from cart
	public void deleteProduct(String name) {
		//illiterate through the cart
		for(Product p:productList) {
			if(p.getName().equalsIgnoreCase(name)) {
				productList.remove(p);
				break;
			}
		}

		
	}

	

}
