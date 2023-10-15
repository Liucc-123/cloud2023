import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class Test1 {

    @Test
    public void test(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
