package winstonchurchill.nice.order.repositores;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import winstonchurchill.nice.domain.member.entity.Member;
import winstonchurchill.nice.domain.member.types.TGrade;
import winstonchurchill.nice.domain.order.entity.Order;
import winstonchurchill.nice.domain.order.repositories.IOrderRepository;
import winstonchurchill.nice.domain.order.repositories.MemoryOrderRepository;

public class MemoryOrderRepositoryTest {
    private final IOrderRepository orderRepository = new MemoryOrderRepository();

    @Test
    void save() {
        final Member mad = new Member(1L, "mad", TGrade.VIP);
        final Order newOrder = new Order(1L, mad.getId(), "tv", 12000, 2000);
        this.orderRepository.save(newOrder);
        final Order order = this.orderRepository.findById(newOrder.getId());
        Assertions.assertThat(newOrder.getId()).isEqualTo(order.getId());
        Assertions.assertThat(newOrder.getMemberId()).isEqualTo(order.getMemberId());
    }
}
