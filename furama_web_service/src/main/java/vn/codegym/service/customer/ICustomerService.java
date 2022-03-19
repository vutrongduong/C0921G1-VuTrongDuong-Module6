package vn.codegym.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.customer.Customer;

import java.util.Optional;


public interface ICustomerService {

    void add(Customer customer);

    Optional<Customer> findById(String id);

    void delete(String id);

    Page<Customer> findAllCustomer(Pageable pageable);

    Page<Customer> find(String name, String address, String typeId, Pageable pageable);

    Page<Customer> findFull(String keyword, Pageable pageable);
}
