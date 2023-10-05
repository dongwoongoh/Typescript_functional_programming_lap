package winstonchurchill.nice.domain.point.repositories;

import winstonchurchill.nice.domain.point.entity.Point;

public interface IPointRepository {
    void update(Long memberId, Point point);

    Point find(Long memberId);
}
