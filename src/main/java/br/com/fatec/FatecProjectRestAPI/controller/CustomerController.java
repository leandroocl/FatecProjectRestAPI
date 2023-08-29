package br.com.fatec.FatecProjectRestAPI.controller;


import br.com.fatec.FatecProjectRestAPI.exception.ResponseGenericException;
import br.com.fatec.FatecProjectRestAPI.repository.CustomerRepository;
import br.com.fatec.FatecProjectRestAPI.service.CustomerService;
import br.com.fatec.FatecProjectRestAPI.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> list() {
        List<Customer> result = customerService.getInfoCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseGenericException.response(result));
    }

@PostMapping(value = "/create")

    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer) {
        Customer result = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseGenericException.response(result));
}

}
