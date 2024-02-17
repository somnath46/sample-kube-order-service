package com.tnt.sample.kube.order.repository;

import com.tnt.sample.kube.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
