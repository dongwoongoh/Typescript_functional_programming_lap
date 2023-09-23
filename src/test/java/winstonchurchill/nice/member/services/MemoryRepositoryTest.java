package winstonchurchill.nice.member.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.domain.entites.Member;
import winstonchurchill.nice.domain.repositories.IMemberRepository;
import winstonchurchill.nice.domain.repositories.MemoryMemberRepository;
import winstonchurchill.nice.domain.types.TGrade;

public class MemoryRepositoryTest {
    private final IMemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void save() {
        final Member mad = new Member(1L, "mad", TGrade.BASIC);
        this.memberRepository.save(mad);
        final Member member = this.memberRepository.findById(mad.getId());
        Assertions.assertThat(mad.getId()).isEqualTo(member.getId());
        Assertions.assertThat(mad.getName()).isEqualTo(member.getName());
    }
}
