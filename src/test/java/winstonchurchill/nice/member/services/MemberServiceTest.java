package winstonchurchill.nice.member.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.configs.AppRunConfig;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.services.MemberService;
import winstonchurchill.nice.domain.member.types.MemberGrade;

public class MemberServiceTest {

    private IMemberService memberService;

    @BeforeEach
    public void before() {
        final AppRunConfig appRunConfig = new AppRunConfig();
        this.memberService = appRunConfig.memberService();
    }

    @Test
    void join() {
        final Member member = new Member(1L, "mad", MemberGrade.BASIC);
        this.memberService.join(member);
        final Member result = this.memberService.findMember(member.getId());
        System.out.println(result.toString());
        Assertions.assertThat(member.getId()).isEqualTo(result.getId());
    }

    @Test
    void find_success() {
        final Member member = new Member(22L, "maaaaaad", MemberGrade.VIP);
        this.memberService.join(member);
        final Member result = this.memberService.findMember(22L);
        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    void find_failed() {
        Assertions.assertThatThrownBy(() -> {
            this.memberService.findMember(234L);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("does not exist id");
    }
}
