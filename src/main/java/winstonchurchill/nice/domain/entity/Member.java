package winstonchurchill.nice.domain.entity;

import winstonchurchill.nice.domain.types.TGrade;

public class Member {
    private Long id;
    private String name;
    private TGrade grade;

    public Member(Long id, String name, TGrade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TGrade getGrade() {
        return grade;
    }

    public void setGrade(TGrade grade) {
        this.grade = grade;
    }
}
