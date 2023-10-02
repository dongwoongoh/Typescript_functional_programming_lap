package winstonchurchill.nice.domain.order.services;

import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.repositores.IMemberRepository;
import winstonchurchill.nice.applications.usecases.discount.IDiscountPolicy;
import winstonchurchill.nice.domain.order.entity.Order;
import winstonchurchill.nice.domain.order.repositories.IOrderRepository;

public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IDiscountPolicy discountPolicy;
    private final IMemberRepository memberRepository;

    public OrderService(IOrderRepository orderRepository, IDiscountPolicy discountPolicy, IMemberRepository memberRepository) {
        this.orderRepository = orderRepository;
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long id, Long memberId, String itemName, int itemPrice) {
        final Member member = this.memberRepository.findById(memberId);
        final int discountPrice = this.discountPolicy.discount(member, itemPrice);
        final Order order = new Order(id, memberId, "mad-item", 11000, discountPrice);
        this.orderRepository.save(order);
        return order;
    }

    @Override
    public Order findOrder(Long id) {
        final Order order = this.orderRepository.findById(id);
        if (order == null) throw new IllegalArgumentException("orderId doesn't exist");
        return order;
    }
}
