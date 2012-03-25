package ch02.ts;

import javax.jws.*;
import java.util.*;

/**
 * The @WebService property endpointInterface links the
 * SIB (this class) to the SEI (ch01.ts.TimeServer).
 * Note that the method implementations are not annotated
 * as @WebMethods.
 */
@WebService(endpointInterface = "ch02.ts.TimeServer")
public class TimeServerImpl implements TimeServer{ // } implements TimeServer {


    public String getTimeAsString() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
        return new Date().getTime() + "";
    }


    public long getTimeAsElapsed() {
        return new Date().getTime();
    }
}