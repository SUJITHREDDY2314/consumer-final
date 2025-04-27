
package com.inn.kafkaconsumer.SpringBootConsumer.service;
import com.inn.kafkaconsumer.SpringBootConsumer.dao.OrderRepository;
import com.inn.kafkaconsumer.SpringBootConsumer.entity.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@Service
public class KafkaOrderConsumer {

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(topics = "kafka1", groupId = "order-group")
    public void consume(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        OrderTable order = mapper.readValue(message, OrderTable.class);
        orderRepository.save(order);
        //System.out.println("Saved order: " + order.getCustomerName());
        System.out.println("Received order: " + order);
        System.out.println("Customer Name: " + order.getCustomerName());
    }
}







/*


package com.inn.kafkaconsumer.SpringBootConsumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.kafkaconsumer.SpringBootConsumer.dao.OrderRepository;
import com.inn.kafkaconsumer.SpringBootConsumer.entity.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Service
public class KafkaOrderConsumer {

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(
        topics = "order-topic", 
        groupId = "order-group"
       // containerFactory = "orderKafkaListenerContainerFactory"
    )
    public void consume(@Payload OrderTable order) {
        orderRepository.save(order);
        System.out.println("Received order: " + order);
        System.out.println("Customer Name: " + order.getCustomerName());
    }
}


*/
