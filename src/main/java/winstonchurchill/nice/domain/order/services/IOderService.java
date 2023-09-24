package winstonchurchill.nice.domain.order.services;

import winstonchurchill.nice.domain.order.entity.Order;

public interface IOderService {
    Order createOrder(Long id, Long memberId, String itemName, int itemPrice);
}
