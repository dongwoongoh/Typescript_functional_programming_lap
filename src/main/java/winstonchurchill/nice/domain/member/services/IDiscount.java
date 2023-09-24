package winstonchurchill.nice.domain.member.services;

import winstonchurchill.nice.domain.member.entity.Member;

public interface IDiscount {
    int discount(Member member);
}
