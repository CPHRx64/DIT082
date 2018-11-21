import org.junit.Test;
import static org.junit.Assert.*;

public class Main
{
    WorkSchedule s0;
    WorkSchedule s1;
    WorkSchedule s2;
    WorkSchedule s3;

    @Test
    public void test0 () {
        WorkSchedule s0 = new WorkSchedule(10);
        s0.setRequiredNumber(10,0,9);

        //

        boolean bool = s0.addWorkingPeriod("e0", 0,1);
        assertTrue(bool);
    }

    /*
    @Test
    public void test1 () {
        WorkSchedule s = new WorkSchedule(1);

    } */
}
