package vn.codegym.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.model.customer.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT * FROM  Customer where customer_name like concat('%',:customerName,'%') " +
            " and  customer_address like concat('%',:customerAdress,'%')  and customer_type_id like concat('%',:customerTypeId,'%') and status = 1", nativeQuery = true)
    Page<Customer> searchCustomer(@Param("customerName") String customerName,
                                  @Param("customerAdress") String customerAdress,
                                  @Param("customerTypeId") String customerTypeId,
                                  Pageable pagle);

    @Query(value = "SELECT * FROM  Customer where (customer_name like concat('%',:keyword,'%') " +
            " or  customer_address like concat('%',:keyword,'%')  or customer_type_id like concat('%',:keyword,'%')) and status = 1", nativeQuery = true)
    Page<Customer> searchFull(@Param("keyword") String keyword,
                              Pageable pagle);

    @Query(value = "SELECT * FROM  Customer where status = 1", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pagle);
}
