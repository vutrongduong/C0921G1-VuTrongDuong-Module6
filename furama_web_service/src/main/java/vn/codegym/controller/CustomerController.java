package vn.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.customer.Customer;
import vn.codegym.model.customer.CustomerType;
import vn.codegym.service.customer.ICustomerService;
import vn.codegym.service.customer.ICustomerTypeService;

import java.util.List;
import java.util.Optional;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

//    @GetMapping()
//    public ResponseEntity<Iterable<Customer>> findAllCustomer(@RequestParam int page) {
//        Pageable pageable = PageRequest.of(page, 3);
//        Page<Customer> customers = customerService.findAllCustomer(pageable);
//        if (customers.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }

    @GetMapping("/customerType")
    public ResponseEntity<Iterable<CustomerType>> findAllCustomerType() {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        if (customerTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerTypeList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        customerService.add(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable String id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setCustomerId(customerOptional.get().getCustomerId());
        customerService.add(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Customer>> findAllCustomer(@RequestParam int page,
                                                              @RequestParam(defaultValue = "") String customerName,
                                                              @RequestParam(defaultValue = "") String customerAddress,
                                                              @RequestParam(defaultValue = "") String customerType) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Customer> customers = customerService.find(customerName, customerAddress, customerType, pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
