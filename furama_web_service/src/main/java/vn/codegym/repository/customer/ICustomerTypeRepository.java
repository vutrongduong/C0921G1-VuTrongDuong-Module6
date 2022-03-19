package vn.codegym.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.customer.CustomerType;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
