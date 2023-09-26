package winstonchurchill.nice.applications.usecases.point;

import winstonchurchill.nice.domain.member.entity.Member;

public class PointPolicyApplication implements IPointPolicy {

    @Override
    public int increase(Member member, int point) {
        if (point < 1) {
            throw new IllegalArgumentException("point must be greater than 0");
        } else {
            if (member != null) {

            }
        }
        return 0;
    }

    @Override
    public int decrease(Member member, int point) {
        if (point < 1) {
            throw new IllegalArgumentException("point must be greater than 0");
        } else {
            if (member != null) {

            }
        }
        return 0;
    }
}
