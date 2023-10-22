package winstonchurchill.nice.modules;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import winstonchurchill.nice.configs.AppRunConfig;
import winstonchurchill.nice.domain.member.services.IMemberService;
import winstonchurchill.nice.domain.member.services.MemberService;
import winstonchurchill.nice.domain.order.services.IOrderService;
import winstonchurchill.nice.domain.order.services.OrderService;

public class ApplicationContextTest {

    final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppRunConfig.class);

    @Test
    @DisplayName("should find all bean")
    void findAll() {
        final String[] getBeanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String getBeanDefinitionName : getBeanDefinitionNames) {
            final BeanDefinition beanDefinition = applicationContext.getBeanDefinition(getBeanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                final Object bean = applicationContext.getBean(getBeanDefinitionName);
                System.out.println("name = " + getBeanDefinitionName + " bean = " + bean);
            }
        }
    }

    @Test
    @DisplayName("should find by input bean name")
    void findBeanService() {
        final IMemberService memberService = applicationContext.getBean(IMemberService.class);
        final IOrderService orderService = applicationContext.getBean(IOrderService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
        Assertions.assertThat(orderService).isInstanceOf(OrderService.class);
    }
}
