package ch01.ts;

import java.util.Date;
import javax.jws.WebService;

/**
 * The @WebService property endpointInterface links the
 * SIB (this class) to the SEI (ch01.ts.TimeServer).
 * Note that the method implementations are not annotated
 * as @WebMethods.
 */
@WebService(endpointInterface = "ch01.ts.TimeServer")
public class TimeServerImpl { // } implements TimeServer {
    public String getTimeAsString() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        return new Date().getTime()+  "";
    }

    public long getTimeAsElapsed() {
        return new Date().getTime();
    }
}