package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;

// 파라미터를 넘기지 않고도 TraceId를 동기화할 수 있도록, 구현체에서 구현한다!
public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
