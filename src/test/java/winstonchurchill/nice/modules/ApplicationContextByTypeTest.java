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
}
