package winstonchurchill.nice.domain.point.entity;

public class Point {
    private Long id;
    private Long MemberId;
    private int count;

    public Point(Long id, Long memberId, int count) {
        this.id = id;
        MemberId = memberId;
        this.count = count;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return MemberId;
    }

    public void setMemberId(Long memberId) {
        MemberId = memberId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Point{" + "id=" + id + ", MemberId=" + MemberId + ", count=" + count + '}';
    }
}
