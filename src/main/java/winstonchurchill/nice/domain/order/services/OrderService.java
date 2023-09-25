package winstonchurchill.nice.domain.order.services;

import winstonchurchill.nice.domain.order.applications.discount.FixDiscountPolicy;
import winstonchurchill.nice.domain.order.applications.discount.IDiscountPolicy;
import winstonchurchill.nice.domain.order.entity.Order;
import winstonchurchill.nice.domain.order.repositories.IOrderRepository;
import winstonchurchill.nice.domain.order.repositories.MemoryOrderRepository;

public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository = new MemoryOrderRepository();
    private final IDiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long id, Long memberId, String itemName, int itemPrice) {
        return null;
    }
}
