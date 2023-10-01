package winstonchurchill.nice.applications.usecases;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.applications.usecases.discount.IDiscountPolicy;
import winstonchurchill.nice.applications.usecases.discount.RateDiscountPolicy;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.types.MemberGrade;

public class RateDiscountPolicyTest {

    private final IDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("should success 10% discount")
    void success() {
        final Member mad = new Member(1L, "mad", MemberGrade.VIP);
        final int discount = discountPolicy.discount(mad, 1000);
        Assertions.assertThat(discount).isEqualTo(100);
    }

    @Test
    @DisplayName("should failed 10% discount")
    void failed() {
        final Member mad = new Member(1L, "mad", MemberGrade.BASIC);
        final int discount = discountPolicy.discount(mad, 1000);
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
