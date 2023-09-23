package winstonchurchill.nice.domain.repositories;

import winstonchurchill.nice.domain.entity.Member;

public interface IMemberRepository {
    void save(Member member);
    Member findById(Long id);
}
