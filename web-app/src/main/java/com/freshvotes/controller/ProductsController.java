package com.freshvotes.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@GetMapping("/products/{productId}")
	public String getproduct(@PathVariable Integer productId, ModelMap model, HttpServletResponse response)
			throws IOException {
		Optional<Products> productObt = productRepositorty.findById(productId);

		if (productObt.isPresent()) {
			Products product = productObt.get();
			model.put("product", product);
		} else

		{
			response.sendError(HttpStatus.NOT_FOUND.value(), "Not Found " + productId + " with this ID");
			return "newproducts";
		}
		return "newproducts";
	}

	@PostMapping("/products")
	public String creatproduct(@AuthenticationPrincipal Users users) {
		Products product = new Products();
		product.setPublished(false);
		product.setUsers(users);

		product = productRepositorty.save(product);

		return "redirect:/products/" + product.getId();

	}


//	@PostMapping("/products/{productId}")
//	public String saveproduct(@PathVariable Integer productId , Products product) {
//		System.out.println(product);
//		product = productRepositorty.save(product);
//		return "redirect:/products/" + product.getId();
//	}

}
