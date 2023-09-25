package winstonchurchill.nice.applications.usecases.discount;

import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.types.MemberGrade;

public class FixDiscountPolicyApplication implements IDiscountPolicy {
    @Override
    public int discount(Member member) {
        if (member.getGrade() == MemberGrade.VIP) {
            return 1000;
        } else {
            return 0;
        }
    }
}
