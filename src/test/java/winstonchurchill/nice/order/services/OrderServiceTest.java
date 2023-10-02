package winstonchurchill.nice.order.services;

import org.junit.jupiter.api.BeforeEach;
import winstonchurchill.nice.configs.AppRunConfig;
import winstonchurchill.nice.domain.order.services.IOrderService;

public class OrderServiceTest {
    private IOrderService orderService;

    @BeforeEach
    public void before() {
        final AppRunConfig appRunConfig = new AppRunConfig();
        this.orderService = appRunConfig.orderService();
    }

    final int itemPrice = 11000;
    final String itemName = "mad-item";

}
