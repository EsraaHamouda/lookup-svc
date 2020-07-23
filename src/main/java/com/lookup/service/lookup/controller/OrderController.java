package com.lookup.service.lookup.controller;

import com.lookup.service.lookup.dao.OrderRepository;
import com.lookup.service.lookup.model.DateRange;
import com.lookup.service.lookup.model.Order;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@Api(tags = "order endpoints")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    // find total number of order of date
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteOrder(@PathVariable("uuid") String orderUuid) {
        orderRepository.deleteById(orderUuid);
        return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("uuid") String orderUuid) {
        order.setUuid(orderUuid);
        orderRepository.save(order);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<Order> findById(@PathVariable("uuid") String orderUuid) {

        Optional<Order> result = orderRepository.findById(orderUuid);
        return result.map(value -> new ResponseEntity<>(result.get(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{uuid}")
    public ResponseEntity<List<Order>> search(@PathVariable("uuid") String userUuid) {
        List<Order> result = orderRepository.findByUserUuid(userUuid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/count")
    public int getOrderCountInDateRange(@RequestBody DateRange dateRange) {
        List<Order> result = orderRepository.getOrderCountInDateRange(dateRange.getStartDate(), dateRange.getEndDate());
        return result.size();
    }


}
