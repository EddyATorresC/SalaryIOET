import Classes.Entity;
import Logic.EntityLogic;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityTest {
    EntityLogic entity = new EntityLogic();
    @Test
    public void correctDefinitionSameInterval() {
        assertTrue(entity.calculateSalary
                ("RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00"));
    }
    @Test (expected = AssertionError.class)
    public void notAPossibleDay() {
        assertFalse(entity.calculateSalary
                ("RENE=MI10:00-12:00"));
    }
    @Test (expected = AssertionError.class)
    public void firstHourBiggerThanSecondOne() {
        assertFalse(entity.calculateSalary
                ("RENE=MO15:00-12:00"));
    }
    @Test (expected = AssertionError.class)
    public void hoursBiggerThan24orImpossible() {
        assertFalse(entity.calculateSalary
                ("RENE=MO20:00-24:01"));
    }
    @Test (expected = AssertionError.class)
    public void emptyParameter() {
        assertFalse(entity.calculateSalary
                (""));
    }
    @Test (expected = AssertionError.class)
    public void aleatoryStringCombination() {
        assertFalse(entity.calculateSalary
                ("WG65zbfx4AvNOf6=f8rNLeIGjIPjKj4,M4KjEwVxuF1Fp5R"));
    }
}