package winstonchurchill.nice.configs;

import winstonchurchill.nice.domain.member.repositores.MemoryMemberRepository;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.services.MemberService;

public class AppRunConfig {

    public IMemberService memberService() {
        return new MemberService(new MemoryMemberRepository());
    }
}
