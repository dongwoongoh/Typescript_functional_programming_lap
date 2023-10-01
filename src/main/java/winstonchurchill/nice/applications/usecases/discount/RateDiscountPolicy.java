package winstonchurchill.nice.applications.usecases.discount;

import winstonchurchill.nice.domain.member.entity.Member;

public class RateDiscountPolicy implements IDiscountPolicy {

    @Override
    public int discount(Member member, int price) {
        return 0;
    }
}
