package com.sqldatabaseandnosql.dao;

import com.sqldatabaseandnosql.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByLogin(String login);
    List<Customer> findByLoginEndsWith(String suffix);
    List<Customer> findByLoginLikeOrCity(String login, String city);
}
