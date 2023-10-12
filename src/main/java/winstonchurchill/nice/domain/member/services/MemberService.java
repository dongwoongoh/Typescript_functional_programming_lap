package winstonchurchill.nice.domain.member.services;

import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.repositores.IMemberRepository;
import winstonchurchill.nice.domain.member.repositores.MemoryMemberRepository;

public class MemberService implements IMemberService {

    private final IMemberRepository memberRepository;

    public MemberService(IMemberRepository memoryMemberRepository) {
        this.memberRepository = memoryMemberRepository;
    }

    @Override
    public void join(Member member) {
        this.memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        final Member member = this.memberRepository.findById(memberId);
        if (member == null) throw new IllegalArgumentException("does not exist id");
        return member;
    }
}
