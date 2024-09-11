package com.tequila.ecommerce.vinoteca.services;

import com.tequila.ecommerce.vinoteca.models.Order;
import com.tequila.ecommerce.vinoteca.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByFechaCreacion(LocalDateTime fechaCreacion) {
        return orderRepository.findByFechaCreacion(fechaCreacion);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByEstado(String estado) {
        return orderRepository.findByEstado(estado);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUser_Id(userId);
    }

    public List<Order> getOrdersByFechaCreacionBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return orderRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);
    }

    public Page<Order> getAllOrdersPaginated(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Page<Order> getOrdersByEstadoPaginated(String estado, Pageable pageable) {
        return orderRepository.findByEstado(estado, pageable);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
