package com.training.preassess.repository;

import com.training.preassess.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findByName (String name);

    List<Customer> findByUserId (int userId);

    Customer findByUserIdAndCustomerId (int userId, int customerId);

//    @Query(value = "SELECT * FROM Customers where User_Id = :userId", nativeQuery = true)
//    List<Customer> findByUserId (@Param("userId") int userId);


}
