package winstonchurchill.nice.modules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import winstonchurchill.nice.domain.member.repositores.IMemberRepository;
import winstonchurchill.nice.domain.member.repositores.MemoryMemberRepository;

public class ApplicationContextTestOfType {
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
}
