package winstonchurchill.nice.applications.usecases.discount;

import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.types.MemberGrade;

public class RateDiscountPolicy implements IDiscountPolicy {

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == MemberGrade.VIP) {
            return price * 10 / 100;
        } else {
            return 0;
        }
    }
}
