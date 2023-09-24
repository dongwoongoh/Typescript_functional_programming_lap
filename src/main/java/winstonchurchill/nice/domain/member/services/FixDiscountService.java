package winstonchurchill.nice.domain.member.services;

import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.types.TGrade;

public class FixDiscountService implements IDiscount {

    private final int discountAmount = 1000;

    @Override
    public int discount(Member member) {
        if (member.getGrade() == TGrade.VIP) {
            return this.discountAmount;
        } else {
            return 0;
        }
    }
}
