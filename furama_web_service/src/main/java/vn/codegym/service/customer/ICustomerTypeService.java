package vn.codegym.service.customer;

import vn.codegym.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
