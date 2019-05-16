package com.training.preassess.controllers;

import com.training.preassess.entities.Customer;
import com.training.preassess.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    Customer customer;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/myCustomers", method = RequestMethod.GET)
    public String customersPage(Model model) {
        return "customers";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public @ResponseBody
    List<Customer> customers(@RequestParam("userId") int userId) {
        return customerRepository.findByUserId(userId);
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public void saveCustomer(@RequestParam("name") String name, @RequestParam("score") int score) {
        customer.setUserId(1);
        customer.setName(name);
        customer.setScore(score);
        customerRepository.save(customer);
    }

    @RequestMapping(value = "/removeCustomer", method = RequestMethod.POST)
    public void removeProperty(@RequestParam("userId") int userId, @RequestParam("customerId") int customerId) {
        customer = customerRepository.findByUserIdAndCustomerId(userId, customerId);
        customerRepository.delete(customer);
    }
}
