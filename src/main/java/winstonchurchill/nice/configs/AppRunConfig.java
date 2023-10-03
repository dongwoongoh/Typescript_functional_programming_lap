package winstonchurchill.nice.configs;

import winstonchurchill.nice.applications.usecases.discount.IDiscountPolicy;
import winstonchurchill.nice.applications.usecases.discount.RateDiscountPolicy;
import winstonchurchill.nice.domain.member.repositores.IMemberRepository;
import winstonchurchill.nice.domain.member.repositores.MemoryMemberRepository;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.services.MemberService;
import winstonchurchill.nice.domain.order.repositories.IOrderRepository;
import winstonchurchill.nice.domain.order.repositories.MemoryOrderRepository;
import winstonchurchill.nice.domain.order.services.IOrderService;
import winstonchurchill.nice.domain.order.services.OrderService;

public class AppRunConfig {

    private final IMemberRepository memberRepository = new MemoryMemberRepository();
    private final IOrderRepository orderRepository = new MemoryOrderRepository();
    private final IDiscountPolicy discountPolicy = new RateDiscountPolicy();

    public IMemberService memberService() {
        return new MemberService(this.memberRepository);
    }

    public IOrderService orderService() {
        return new OrderService(this.orderRepository, this.discountPolicy, this.memberRepository);
    }
}
