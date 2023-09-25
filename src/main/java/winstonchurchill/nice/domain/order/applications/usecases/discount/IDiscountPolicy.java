package winstonchurchill.nice.domain.order.applications.usecases.discount;

import winstonchurchill.nice.domain.member.entity.Member;

public interface IDiscountPolicy {
    int discount(Member member);
}
