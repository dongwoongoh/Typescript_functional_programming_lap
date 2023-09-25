package winstonchurchill.nice.domain.order.services;

import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.repositores.IMemberRepository;
import winstonchurchill.nice.domain.member.repositores.MemoryMemberRepository;
import winstonchurchill.nice.domain.order.applications.usecases.discount.FixDiscountPolicyApplication;
import winstonchurchill.nice.domain.order.applications.usecases.discount.IDiscountPolicy;
import winstonchurchill.nice.domain.order.entity.Order;
import winstonchurchill.nice.domain.order.repositories.IOrderRepository;
import winstonchurchill.nice.domain.order.repositories.MemoryOrderRepository;

public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository = new MemoryOrderRepository();
    private final IDiscountPolicy discountPolicy = new FixDiscountPolicyApplication();
    private final IMemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Order createOrder(Long id, Long memberId, String itemName, int itemPrice) {
        final Member member = this.memberRepository.findById(memberId);
        final int discountPrice = this.discountPolicy.discount(member);
        final Order order = new Order(id, memberId, "mad-item", 11000, discountPrice);
        System.out.println(order.toString());
        this.orderRepository.save(order);
        return order;
    }
}
