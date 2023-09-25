package winstonchurchill.nice.domain.order.applications.usecases.discount;

import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.types.TGrade;

public class FixDiscountPolicyApplication implements IDiscountPolicy {
    @Override
    public int discount(Member member) {
        if (member.getGrade() == TGrade.VIP) {
            return 1000;
        } else {
            return 0;
        }
    }
}
