package com.zagado.sysarch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.zagado.sysarch.model.Order;

import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    // -Use the inherited method from MongoRepository
    Optional<Order> findById(String id);
}
