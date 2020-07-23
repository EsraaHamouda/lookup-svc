package com.lookup.service.lookup.controller;

import com.lookup.service.lookup.dao.OrderItemRepository;
import com.lookup.service.lookup.model.OrderItem;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OrderItem")
@Api(tags = "Order Item endpoints")
public class OrderItemController {

    @Autowired
    OrderItemRepository orderItemRepository;

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        orderItemRepository.save(orderItem);
        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItem orderItem, @PathVariable("uuid")
            String uuid) {
        orderItem.setUuid(uuid);
        orderItemRepository.save(orderItem);
        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderItem> findById(@PathVariable("uuid") String uuid) {
        Optional<OrderItem> result = orderItemRepository.findById(uuid);
        return result.map(value -> new ResponseEntity<OrderItem>(result.get(), HttpStatus.OK)).orElseGet(
                () -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/order/{uuid}")
    public ResponseEntity<List<OrderItem>> findByOrderId(@PathVariable("uuid") String uuid) {
        List<OrderItem> result = orderItemRepository.findByOrderUuid(uuid);
        return new ResponseEntity<List<OrderItem>>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteById(@PathVariable("uuid") String uuid) {
        orderItemRepository.deleteById(uuid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);

    }


}
