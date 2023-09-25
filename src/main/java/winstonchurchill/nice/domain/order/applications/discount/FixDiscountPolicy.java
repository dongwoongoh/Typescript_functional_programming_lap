package winstonchurchill.nice.domain.order.applications.discount;

import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.types.TGrade;

public class FixDiscountPolicy implements IDiscountPolicy {
    @Override
    public int discount(Member member) {
        if (member.getGrade() == TGrade.VIP) {
            return 1000;
        } else {
            return 0;
        }
    }
}
