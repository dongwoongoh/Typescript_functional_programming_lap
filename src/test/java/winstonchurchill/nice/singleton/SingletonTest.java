package winstonchurchill.nice.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {


    @Test
    @DisplayName("should same this two service")
    public void callService() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("should not same this two service")
    public void callDiffService() {
        SingletonTest test1 = new SingletonTest();
        SingletonTest test2 = new SingletonTest();
        Assertions.assertThat(test1).isNotSameAs(test2);
    }
}
