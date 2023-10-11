package winstonchurchill.nice.modules;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import winstonchurchill.nice.configs.AppRunConfig;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.services.MemberService;

public class MemberModule {
    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppRunConfig.class);
        final IMemberService memberService = applicationContext.getBean("memberService", MemberService.class);

    }
}
