package ac.cr.una.springtesting.service;

import ac.cr.una.springtesting.model.Order;

public interface OrderService {
    public String getOrderDescription();
    public String getOrderStringCode();
    public Order getOrder(int id);
    public Order createOrder(Order order);
}
