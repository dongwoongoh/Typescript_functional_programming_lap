package winstonchurchill.nice.configs;

import winstonchurchill.nice.applications.usecases.discount.RateDiscountPolicy;
import winstonchurchill.nice.domain.member.repositores.MemoryMemberRepository;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.services.MemberService;
import winstonchurchill.nice.domain.order.repositories.IOrderRepository;
import winstonchurchill.nice.domain.order.repositories.MemoryOrderRepository;
import winstonchurchill.nice.domain.order.services.IOrderService;
import winstonchurchill.nice.domain.order.services.OrderService;

public class AppRunConfig {

    public IMemberService memberService() {
        return new MemberService(new MemoryMemberRepository());
    }

    public IOrderService orderService() {
        return new OrderService(new MemoryOrderRepository(), new RateDiscountPolicy(), new MemoryMemberRepository());
    }
}
