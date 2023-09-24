package winstonchurchill.nice.domain.order.repositories;

import winstonchurchill.nice.domain.order.entity.Order;

public interface IOrderRepository {
    void save(Order order);

    Order findById(Long id);
}
