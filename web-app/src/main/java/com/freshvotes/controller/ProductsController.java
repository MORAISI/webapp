package com.freshvotes.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.domain.Products;
import com.freshvotes.domain.Users;
import com.freshvotes.repositories.ProductRepositorty;



@Controller
public class ProductsController {

	@Autowired
	private ProductRepositorty productRepositorty;

	@GetMapping("/products")
	public String getproducts(ModelMap model) {
		model.put("product", new Products());
		return "products";
	}

//	@GetMapping("/products/{productId}")
//	public String product(@PathVariable int productId , ModelMap modelMap , HttpServletResponse response) throws IOException {
//		Optional<Products> productObt =  productRepositorty.findById(productId);
//		
//		if(productObt.isPresent()) {
//			Products product =  productObt.get();
//			modelMap.put("product", product);
//		}else
//
//	{
//			response.sendError(HttpStatus.NOT_FOUND.value(), "Not Found "+productId+" with this ID");
//	}
//		return "products";
//	}
	@PostMapping("/products")
	public String newproduct(@AuthenticationPrincipal Users users) {
		Products product = new Products();
		product.setPublished(false);
		product.setUsers(users);

		productRepositorty.save(product);

		return "redirect:/products/" + product.getId();
	}
	
	@PostMapping("/products/{productId}")
	public String saveproduct(@PathVariable Integer productId , Products product) {
		System.out.println(product);
	

		return "redirect:/products/" + product.getId();
	}

}
