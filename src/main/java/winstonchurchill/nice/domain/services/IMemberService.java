package winstonchurchill.nice.domain.services;

import winstonchurchill.nice.domain.entity.Member;

public interface IMemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
