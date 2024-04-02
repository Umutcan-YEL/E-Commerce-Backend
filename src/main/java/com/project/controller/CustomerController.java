package com.project.controller;

import com.project.model.Cart;
import com.project.model.Customer;
import com.project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public Customer AddCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }


    @GetMapping("/get/{id}")
    public Cart GetCart(@RequestParam Long id) {
        return customerService.getCart(id);

    }

    @PostMapping("/addtocart/{id}")
    public Cart AddProductToCart(@RequestParam Long id, @RequestBody Long ProductId) {
        return customerService.addProductToCart(id, ProductId);
    }

    @PostMapping("/removefromcart/{id}")
    public Cart RemoveProductFromCart(@RequestParam Long id, @RequestBody Long ProductId) {
        return customerService.removeProductFromCart(id, ProductId);
    }

    @PostMapping("/empty/{id}")
    public ResponseEntity<?> emptyCart(@RequestParam Long id) {
        customerService.emptyCart(id);
        return ResponseEntity.ok("Cart is emptied");
    }

    @PutMapping("/empty/{id}")
    public ResponseEntity<?> updateCart(@RequestParam Long id, @RequestBody Cart cart) {
        customerService.updateCart(id, cart);
        return ResponseEntity.ok("Cart is updated");
    }


}
