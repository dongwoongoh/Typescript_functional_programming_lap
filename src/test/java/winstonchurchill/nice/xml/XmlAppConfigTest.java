package winstonchurchill.nice.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import winstonchurchill.nice.domain.member.services.IMemberService;

public class XmlAppConfigTest {

    @Test
    void xmlAppContext() {
        final GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext("appConfig.xml");
        final IMemberService memberService = genericXmlApplicationContext.getBean(IMemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(IMemberService.class);
    }
}
