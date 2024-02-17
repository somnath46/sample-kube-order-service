package com.tnt.sample.kube.order.service;

import com.tnt.sample.kube.order.dto.OrderDto;
import com.tnt.sample.kube.order.entity.Order;
import com.tnt.sample.kube.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDto create(OrderDto dto) {
        log.info("Creating order with following data: {}", dto);
        final var entity = new Order(null, dto.getItemName(), dto.getQty(), dto.getPrice());
        final var savedEntity = orderRepository.save(entity);
        log.info("Order created with following data: {}", savedEntity);

        return new OrderDto(savedEntity.getId(), savedEntity.getItemName(), savedEntity.getQty(), savedEntity.getPrice());
    }

    public List<OrderDto> getAll() {
        log.info("Getting all orders");
        final var entities = orderRepository.findAll();
        final var dtos = new ArrayList<OrderDto>();
        entities.forEach(e -> dtos.add(new OrderDto(e.getId(), e.getItemName(), e.getQty(), e.getPrice())));

        return  dtos;
    }

    public void delete(Long id) {
        log.info("Deleting order with following id: {}", id);
        orderRepository.deleteById(id);
        log.info("Order deleted with following id: {}", id);
    }

}
