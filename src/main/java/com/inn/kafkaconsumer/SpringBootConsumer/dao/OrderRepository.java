package com.inn.kafkaconsumer.SpringBootConsumer.dao;
import com.inn.kafkaconsumer.SpringBootConsumer.entity.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderTable, String> {
}
