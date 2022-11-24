package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {
    private static final double LOW_PRESSURE_VALUE = 14;
    private static final double HIGH_PRESSURE_VALUE = 25;
    private static final double NORMAL_PRESSURE_VALUE = 20;

    private Alarm alarm;
    private Sensor sensor;
    @Before
    public void prepare(){
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmShouldBeOnBecauseLowPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnBecauseHighPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOff(){
        when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE_VALUE);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

}