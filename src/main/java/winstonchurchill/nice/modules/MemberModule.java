package winstonchurchill.nice.modules;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import winstonchurchill.nice.configs.AppRunConfig;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.services.MemberService;
import winstonchurchill.nice.domain.member.types.MemberGrade;

public class MemberModule {
    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppRunConfig.class);
        final IMemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        final Member member = new Member(1L, "mad", MemberGrade.VIP);
        memberService.join(member);
        final Member result = memberService.findMember(member.getId());
        System.out.println(result.toString());
    }
}
