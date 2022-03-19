package vn.codegym.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.customer.Customer;
import vn.codegym.repository.customer.ICustomerRepository;
import vn.codegym.service.customer.ICustomerService;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository repository;

    @Override
    public void add(Customer customer) {
        customer.setStatus(1);
        repository.save(customer);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return repository.findAllCustomer(pageable);
    }

    @Override
    public Page<Customer> find(String name, String address, String typeId, Pageable pageable) {
        return repository.searchCustomer(name, address, typeId, pageable);
    }

    @Override
    public Page<Customer> findFull(String keyword, Pageable pageable) {
        return repository.searchFull(keyword, pageable);
    }
}
