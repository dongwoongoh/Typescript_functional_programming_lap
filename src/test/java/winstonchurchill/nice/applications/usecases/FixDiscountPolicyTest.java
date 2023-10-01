package winstonchurchill.nice.applications.usecases;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.applications.usecases.discount.FixDiscountPolicyApplication;
import winstonchurchill.nice.applications.usecases.discount.IDiscountPolicy;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.types.MemberGrade;

public class FixDiscountPolicyTest {

    private final IDiscountPolicy discountPolicy = new FixDiscountPolicyApplication();

    @Test
    @DisplayName("should success fix discount value")
    void success() {
        final Member mad = new Member(1L, "mad", MemberGrade.VIP);
        final int discount = this.discountPolicy.discount(mad, 11000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("should failed fix discount value")
    void failed() {
        final Member mad = new Member(1L, "mad", MemberGrade.BASIC);
        final int discount = this.discountPolicy.discount(mad, 11000);
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
