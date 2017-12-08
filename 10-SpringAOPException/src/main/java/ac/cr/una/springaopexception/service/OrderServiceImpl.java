package ac.cr.una.springaopexception.service;

import ac.cr.una.springaopexception.model.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    public String getOrderDescription() {
        Order existingOrder = new Order();
        existingOrder.setDescription("Order for XYZ in units");
        return "Description: " + existingOrder.getDescription();
    }

    public String getOrderStringCode() {
        Order existingOrder = new Order();
        existingOrder.setSecurityCode("XYZ");
        return "Account Code: " + existingOrder.getSecurityCode();
    }

    public Order createOrder(Order order) {
        // Throwing an exception
        // EXAMPLE
        throw new NullPointerException("ID not found");
    }

    public Order getOrder(int id) {
        Order newOrder = new Order();
        newOrder.setOrderId(new Random().nextInt());
        newOrder.setSecurityCode("XYZ");
        newOrder.setOrderStatus("COMPLETED");
        newOrder.setOrderDate(new Date());
        newOrder.setDescription("This is the new XYZ order");
        return newOrder;
    }
}
