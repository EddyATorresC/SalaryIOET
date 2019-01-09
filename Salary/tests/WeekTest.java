import Logic.WeekLogic;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeekTest {

    @Test
    public void toBePaidSameInterval() {
        WeekLogic week = new WeekLogic();
        assertEquals(215,week.toBePaid(
                "MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00"),0.01);
    }

    @Test
    public void toBePaidDifferentIntervalA() {
        WeekLogic week = new WeekLogic();
        assertEquals(105,week.toBePaid("MO08:00-12:00,TU17:00-19:00"),0.01);
    }

    @Test
    public void toBePaidDifferentIntervalLong() {
        WeekLogic week = new WeekLogic();
        assertEquals(445,week.toBePaid(
                "MO08:00-22:00,TU07:00-19:00"),0.01);
    }

    @Test
    public void toBePaidOneMinuteLong() {
        WeekLogic week = new WeekLogic();
        assertEquals(1,week.toBePaid(
                "MO00:00-00:01,TU09:00-09:01,WE18:00-18:01"),0.01);
    }
    @Test
    public void toBePaidOneMinuteDifferentIntervals() {
        WeekLogic week = new WeekLogic();
        assertEquals(1.25,week.toBePaid(
                "MO08:59-09:01,TU17:59-18:01"),0.01);
    }
}