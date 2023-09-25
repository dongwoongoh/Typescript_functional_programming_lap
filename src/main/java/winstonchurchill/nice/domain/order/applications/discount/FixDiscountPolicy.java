package winstonchurchill.nice.domain.order.applications.discount;

import winstonchurchill.nice.domain.member.entity.Member;

public class FixDiscountPolicy implements IDiscountPolicy {
    @Override
    public int discount(Member member) {
        return 0;
    }
}
