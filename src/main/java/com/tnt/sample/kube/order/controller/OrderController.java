package com.tnt.sample.kube.order.controller;

import com.tnt.sample.kube.order.dto.OrderDto;
import com.tnt.sample.kube.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    final OrderService orderService;
    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto dto) {
        log.info("Received create order with following data: {}", dto);
        return ResponseEntity.ok(orderService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll() {
        log.info("Received get all order with following data");
        return ResponseEntity.ok(orderService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Received delete order with following id: {}", id);
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
