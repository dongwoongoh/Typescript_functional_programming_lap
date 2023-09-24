package winstonchurchill.nice.domain.member.services;

import winstonchurchill.nice.domain.member.entity.Member;

public interface IMemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
