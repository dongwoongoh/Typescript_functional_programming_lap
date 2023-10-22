package winstonchurchill.nice.modules;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import winstonchurchill.nice.configs.AppRunConfig;

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

}
