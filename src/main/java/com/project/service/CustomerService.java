package com.project.service;

import com.project.model.Cart;
import com.project.model.Customer;
import com.project.model.Product;
import com.project.repository.CustomerRepository;
import com.project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;


    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Cart getCart(Long id) {
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        return customer.getCart();
    }


    public Cart addProductToCart(Long id, Long productId) {
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        Cart cart = customer.getCart();
        Product product = productRepository.findById(productId).orElse(new Product());

        List<Product> productList = cart.getProducts();
        productList.add(product);
        cart.setProducts(productList);

        return customer.getCart();
    }

    public Cart removeProductFromCart(Long id, Long productId) {
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        Cart cart = customer.getCart();
        Product product = productRepository.findById(productId).orElse(new Product());

        List<Product> productList = cart.getProducts();
        productList.remove(product);
        cart.setProducts(productList);

        return customer.getCart();
    }


    public void emptyCart(Long id) {
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        customer.setCart(null);
    }

    public void updateCart(Long id, Cart updatedCart) {
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        customer.setCart(updatedCart);
    }

}
