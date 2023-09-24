package winstonchurchill.nice.member.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.services.MemberService;
import winstonchurchill.nice.domain.member.types.TGrade;

public class MemberServiceTest {

    private final IMemberService memberService = new MemberService();

    @Test
    void join() {
        final Member member = new Member(1L, "mad", TGrade.BASIC);
        this.memberService.join(member);
        final Member result = this.memberService.findMember(member.getId());
        Assertions.assertThat(member.getId()).isEqualTo(result.getId());
    }
}
