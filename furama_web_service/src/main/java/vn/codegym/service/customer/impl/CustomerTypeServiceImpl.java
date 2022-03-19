package vn.codegym.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.customer.CustomerType;
import vn.codegym.repository.customer.ICustomerTypeRepository;
import vn.codegym.service.customer.ICustomerTypeService;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository repository;

    @Override
    public List<CustomerType> findAll() {
        return repository.findAll();
    }
}
