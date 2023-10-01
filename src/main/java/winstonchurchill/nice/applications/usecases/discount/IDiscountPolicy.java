package winstonchurchill.nice.applications.usecases.discount;

import winstonchurchill.nice.domain.member.entity.Member;

public interface IDiscountPolicy {
    int discount(Member member, int price);
}
