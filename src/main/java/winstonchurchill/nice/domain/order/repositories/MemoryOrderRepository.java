package winstonchurchill.nice.domain.order.repositories;

import winstonchurchill.nice.domain.order.entity.Order;

import java.util.HashMap;
import java.util.Map;

public class MemoryOrderRepository implements IOrderRepository {

    private static final Map<Long, Order> store = new HashMap<>();

    @Override
    public void save(Order order) {
        store.put(order.getId(), order);
    }

    @Override
    public Order findById(Long id) {
        return store.get(id);
    }
}
