package ac.cr.una.springaoplogging.service;

import ac.cr.una.springaoplogging.model.Order;

public interface OrderService {
    public String getOrderDescription();
    public String getOrderStringCode();
    public Order getOrder(int id);
    public Order createOrder(Order order);
}
