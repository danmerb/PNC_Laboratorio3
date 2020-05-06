package com.uca.capas.ejemplo5.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.ejemplo5.Domain.Product;

@Controller
public class ProductController {


	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/comprarProducto")
	public ModelAndView comprarProducto() {

		
		productos.add(new Product(0,"Pasta","10"));
		productos.add(new Product(1,"Pizza","15"));
		productos.add(new Product(2,"Sopa de Tomate","77"));
		productos.add(new Product(3,"Nachos","69"));
		productos.add(new Product(4,"Pollo","8"));
		productos.add(new Product(5,"Tacos","44"));
		

		ModelAndView mav = new ModelAndView();
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("productos", productos);
		
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		
		if(Integer.parseInt(product.getCantidad())<=Integer.parseInt(productos.get(product.getId()).getCantidad())) {
			mav.setViewName("compra");
		}else {
			mav.setViewName("error");
		}
		
		mav.addObject("nombre",productos.get(product.getId()).getNombre());
		return mav;
	}
}