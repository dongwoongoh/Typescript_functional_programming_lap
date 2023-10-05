package winstonchurchill.nice.point.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.configs.AppRunConfig;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.types.MemberGrade;
import winstonchurchill.nice.domain.point.entity.Point;
import winstonchurchill.nice.domain.point.repositories.IPointRepository;
import winstonchurchill.nice.domain.point.repositories.MemoryPointRepository;

public class MemoryPointRepositoryTest {
    private final IPointRepository pointRepository = new MemoryPointRepository();
    private IMemberService memberService;

    @BeforeEach
    public void before() {
        final AppRunConfig appRunConfig = new AppRunConfig();
        this.memberService = appRunConfig.memberService();
    }

    @Test
    void update() {
        final Member member = new Member(1L, "mad", MemberGrade.VIP);
        this.memberService.join(member);
        final Point point = new Point(2L, member.getId(), 100);
        this.pointRepository.update(member.getId(), point);
        final Point result = this.pointRepository.find(1L);
        Assertions.assertThat(result.getId()).isEqualTo(point.getId());
        Assertions.assertThat(result.getMemberId()).isEqualTo(member.getId());
        Assertions.assertThat(result.getCount()).isEqualTo(point.getCount());
    }
}
