package ac.cr.una.springaopexception.service;

import ac.cr.una.springaopexception.model.Order;

public interface OrderService {
    public String getOrderDescription();
    public String getOrderStringCode();
    public Order getOrder(int id);
    public Order createOrder(Order order);
}
