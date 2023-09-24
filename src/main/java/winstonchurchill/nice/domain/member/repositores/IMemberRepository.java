package winstonchurchill.nice.domain.member.repositores;

import winstonchurchill.nice.domain.member.entity.Member;

public interface IMemberRepository {
    void save(Member member);
    Member findById(Long id);
}
