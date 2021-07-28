package ru.vasilyevVA.homeWorks.lesson6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.vasilyevVA.homeWorks.lesson6.entity.Customer;
import ru.vasilyevVA.homeWorks.lesson6.entity.Price;
import ru.vasilyevVA.homeWorks.lesson6.entity.Product;
import ru.vasilyevVA.homeWorks.lesson6.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Optional<List<Price>> getCustomPriceList(long customerId){
        Customer customer = customerRepository.getCustomer(customerId);
        if (customer == null) return Optional.empty();
        return Optional.of(customer.getCustomPriceList());
    }

    public Optional<List<Product>> getProductList(long customerId){
        Customer customer = customerRepository.getCustomer(customerId);
        if (customer == null) return Optional.empty();
        return Optional.of(customer.getCustomPriceList()
                .stream()
                .map(price -> price.getProduct())
                .collect(Collectors.toList()));

    }

    public Optional<List<Customer>> getCustomers(){
        return customerRepository.getCustomers();
    }

}