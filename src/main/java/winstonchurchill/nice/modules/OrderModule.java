package winstonchurchill.nice.modules;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import winstonchurchill.nice.configs.AppRunConfig;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.types.MemberGrade;
import winstonchurchill.nice.domain.order.entity.Order;
import winstonchurchill.nice.domain.order.services.IOrderService;
import winstonchurchill.nice.domain.order.services.OrderService;

public class OrderModule {
    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppRunConfig.class);
        final IOrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        final Member member = new Member(1L, "madmad", MemberGrade.VIP);
        final Order order = orderService.createOrder(2L, member.getId(), "mad-item", 1000);
        final Order result = orderService.findOrder(order.getId());
        System.out.println(result.toString());
    }
}
