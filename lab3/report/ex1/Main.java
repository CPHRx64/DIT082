import org.junit.*;
import static org.junit.Assert.*;

public class Main
{
    WorkSchedule schedule1;

    @Before public void Setup ()
    {
        schedule1 = new WorkSchedule(8);
        schedule1.setRequiredNumber(2, 0, 7);
    }

    /*
     * addWorkingPeriod
     */
    @Test public void TestStartLessThanZero ()
    {
        // starttime < 0
        boolean result = schedule1.addWorkingPeriod("benny", -1, 1);
        assertFalse(result);
    }

    @Test public void TestEndtimeGreaterThanSize ()
    {
        // endtime >= size
        boolean result = schedule1.addWorkingPeriod("benny", 8, 9);
        assertFalse(result);
    }

    // this is the bug
    @Test public void TestStarttimeGreaterThanEndtime ()
    {
        // starttime > endtime
        boolean result = schedule1.addWorkingPeriod("benny", 7, 2);
        assertFalse(result);
    }

    @Test public void TestEqualEmployee ()
    {
        // starttime > endtime
        schedule1.addWorkingPeriod("benny", 0, 1);
        boolean result = schedule1.addWorkingPeriod("benny", 0, 1);
        assertFalse(result);
    }

    @Test public void TestNormalCase ()
    {
        // normal case
        boolean result = schedule1.addWorkingPeriod("benny", 0, 1);
        assertTrue(result);
    }

    @Test public void TestLengthLessThanRequiredNUmber ()
    {
        // workingEmployees.length < requiredNumber
        schedule1.addWorkingPeriod("benny", 1, 2);
        schedule1.addWorkingPeriod("agnetha", 1, 2);
        boolean result = schedule1.addWorkingPeriod("björn", 1, 2);
        assertFalse(result);
    }

    /*
     * workingEmployees
     */
    @Test public void TestWorkingEmployees ()
    {
        schedule1.addWorkingPeriod("Jordan",0,1);
        schedule1.addWorkingPeriod("Lars",1,2);
        String[] result = schedule1.workingEmployees(0,2);
        assertTrue(result.length == 2);
        assertTrue(result[0].equals("Jordan") && result[1].equals("Lars"));

    }

    // bug here
    @Test public void TestEmployeesEmpty ()
    {
        schedule1.addWorkingPeriod("Jordan",0,1);
        schedule1.addWorkingPeriod("Lars",1,2);
        String[] result = schedule1.workingEmployees(2,0);
        assertTrue(result.length == 0);

    }
}
