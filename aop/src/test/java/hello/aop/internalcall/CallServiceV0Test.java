package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV0Test {

    @Autowired CallServiceV0 callServiceV0;

    @Test
    void external() {
        callServiceV0.external(); // 내부에서 internal() 호출 시, 프록시를 거치지 않기 때문에 CallLogAspect 어드바이스가 적용되지 않는다.
    }

    @Test
    void internal() {
        callServiceV0.internal(); // 프록시를 거치기 때문에 CallLogAspect 어드바이스가 적용된다.
    }
}