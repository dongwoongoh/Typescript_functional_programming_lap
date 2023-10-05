package winstonchurchill.nice.domain.point.repositories;

import winstonchurchill.nice.domain.point.entity.Point;

import java.util.HashMap;
import java.util.Map;

public class MemoryPointRepository implements IPointRepository {

    private static final Map<Long, Point> store = new HashMap<>();

    @Override
    public void update(Long memberId, Point point) {
        store.put(memberId, point);
    }

    @Override
    public Point find(Long memberId) {
        return store.get(memberId);
    }
}
