package winstonchurchill.nice.member.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.repositores.IMemberRepository;
import winstonchurchill.nice.domain.member.repositores.MemoryMemberRepository;
import winstonchurchill.nice.domain.member.types.TGrade;

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
