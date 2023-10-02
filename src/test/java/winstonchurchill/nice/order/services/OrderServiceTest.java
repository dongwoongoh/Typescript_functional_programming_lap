package winstonchurchill.nice.order.services;

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
        System.out.println(order.toString());
    }

}
