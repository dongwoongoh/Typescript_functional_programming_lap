package winstonchurchill.nice.modules;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import winstonchurchill.nice.domain.member.repositores.IMemberRepository;
import winstonchurchill.nice.domain.member.repositores.MemoryMemberRepository;

import java.util.Map;

public class ApplicationContextByTypeTest {
    private final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SameBeenConfig.class);


    @Configuration
    static class SameBeenConfig {
        @Bean
        public IMemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public IMemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

    @Test
    @DisplayName("should duplicated bean")
    public void findBeanByType() {
        Assertions.assertThatThrownBy(() -> applicationContext.getBean(IMemberRepository.class)).isInstanceOf(NoUniqueBeanDefinitionException.class);
    }

    @Test
    @DisplayName("should find bean type by name")
    public void findBeanTypeByName() {
        final IMemberRepository bean = applicationContext.getBean("memberRepository1", IMemberRepository.class);
        Assertions.assertThat(bean).isInstanceOf(IMemberRepository.class);
    }

    @Test
    @DisplayName("should find all beans by type")
    public void findBeansByType() {
        Map<String, IMemberRepository> beansOfType = applicationContext.getBeansOfType(IMemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value = " + beansOfType.get(key));
        }
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }
}
