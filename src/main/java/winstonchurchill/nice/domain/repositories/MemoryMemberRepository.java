package winstonchurchill.nice.domain.repositories;

import winstonchurchill.nice.domain.entites.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements IMemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }
}
