package winstonchurchill.nice.applications.usecases.point;

import winstonchurchill.nice.domain.member.entity.Member;

public interface IPointPolicy {
    int increase(Member member, int point);

    int decrease(Member member, int point);
}
