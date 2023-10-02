package winstonchurchill.nice.order.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.configs.AppRunConfig;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.types.MemberGrade;
import winstonchurchill.nice.domain.order.entity.Order;
import winstonchurchill.nice.domain.order.services.IOrderService;

public class OrderServiceTest {
    private IOrderService orderService;
    private IMemberService memberService;

    @BeforeEach
    public void before() {
        final AppRunConfig appRunConfig = new AppRunConfig();
        this.orderService = appRunConfig.orderService();
        this.memberService = appRunConfig.memberService();
    }

    final int itemPrice = 11000;
    final String itemName = "mad-item";

    @Test
    @DisplayName("should register new order")
    void register() {
        final Member mad = new Member(1L, "mad", MemberGrade.VIP);
        this.memberService.join(mad);
        final Order order = this.orderService.createOrder(1L, mad.getId(), this.itemName, this.itemPrice);
        Assertions.assertThat(order.getId()).isEqualTo(1L);
        Assertions.assertThat(order.getMemberId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("should find item by id")
    void find() {
        final Member mad = new Member(99L, "mad", MemberGrade.VIP);
        this.memberService.join(mad);
        this.orderService.createOrder(99L, mad.getId(), this.itemName, this.itemPrice);
        final Order order = this.orderService.findOrder(99L);
        Assertions.assertThat(order.getId()).isEqualTo(99L);
        Assertions.assertThat(order.getMemberId()).isEqualTo(99L);
    }
}
