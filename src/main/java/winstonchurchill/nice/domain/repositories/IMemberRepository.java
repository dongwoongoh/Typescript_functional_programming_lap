package winstonchurchill.nice.domain.repositories;

import winstonchurchill.nice.domain.entites.Member;

public interface IMemberRepository {
    void save(Member member);
    Member findById(Long id);
}
