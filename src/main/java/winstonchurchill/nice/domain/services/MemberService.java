package winstonchurchill.nice.domain.services;

import winstonchurchill.nice.domain.entites.Member;
import winstonchurchill.nice.domain.repositories.IMemberRepository;
import winstonchurchill.nice.domain.repositories.MemoryMemberRepository;

public class MemberService implements IMemberService {

    private final IMemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        this.memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return this.memberRepository.findById(memberId);
    }
}
