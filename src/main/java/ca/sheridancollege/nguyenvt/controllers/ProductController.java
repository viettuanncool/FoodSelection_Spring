package ca.sheridancollege.nguyenvt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.nguyenvt.beans.Product;
import ca.sheridancollege.nguyenvt.repositories.ProductList;

@Controller
public class ProductController {
	
	@Autowired
	private ProductList productList;
	
	private ArrayList price;
	
	//controller for when page first loads
	@GetMapping("/")
	public String home(Model m) {
		productList.emptyList();
		m.addAttribute("productList",productList.getProductList());
		m.addAttribute("product",new Product());
		return "index.html";
	}
	
	//controller for when users add a product
	@PostMapping("/orderProcess")
	public String process(Model m, @ModelAttribute Product product) {
		productList.addProduct(product);
		m.addAttribute("productList",productList.getProductList());
		m.addAttribute("product",new Product());
		return "index.html";
	}
	
	//controller to give check out on the cart
	@GetMapping("/checkOut")
	public String checkout(Model m) {
		double total = 0;
		//get the total of all the items in cart
		for(Product p:(productList.getProductList())) {
			p.setTotal(p.getPrice()*p.getQuantity());
			total += p.getTotal();
		}
		String Stotal = "$"+total;
		m.addAttribute("total", Stotal);
		m.addAttribute("productList",productList.getProductList());
		return "checkout.html";
	}
	
	//controller mapping to remove an item
	@PostMapping("/delete")
	public String delete(Model m,@RequestParam String name) {
		productList.deleteProduct(name);
		m.addAttribute("productList",productList.getProductList());
		m.addAttribute("product",new Product());
		return "index.html";
	}
	
	
}
