package lab4.main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;
    public final static double EPS = 1e-9;

    @BeforeEach
    void setUp() {

        main = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFun31() {
        double x = 0.1;
        double expected = -8.043;
        double result = main.f(x);
        assertEquals(expected,result,1e-3);
    }

    @Test
    void testFun32() {
        double x = 1;
        double expected = 2.098;
        double result = main.f(x);
        assertEquals(expected,result,1e-3);
    }

    @Test
    void testFun33() {
        double x = 0.9;
        double expected = 0.4593;
        double result = main.f(x);
        assertEquals(expected,result,1e-4);
    }

    @Test
    void testFunCount() {

        double x1 = 0.2;
        double x2 = 2;
        double h = 0.004;
        int expected = 451;
        int result = main.countSteps(x1,x2,h);
        assertEquals(expected,result);
    }

    @Test
    void testFunArrayY() {

        double x1 = 0.2;
        double x2 = 2;
        double h = 0.004;
        double[] x = main.funArrayX(x1,x2,h);
        double[] expected = {-2.66,0.45,1.4};
        double[] result = main.funArrayY(x);
        assertArrayEquals(expected,new double[]{result[0],result[175], result[450]},1e-2);
    }

    @Test
    void testFunArrayX() {

        double x1 = 0.2;
        double x2 = 2;
        double h = 0.004;
        double[] expected = {0.2,0.9,2};
        double[] result = main.funArrayX(x1,x2,h);
        assertArrayEquals(expected,new double[]{result[0],result[175], result[450]},EPS);
    }


    @Test
    void testIndMax() {

        double[] arr = {-3.1,2,0,1,3.4,10,-100};
        int expected = 5;
        int result = main.maxIndex(arr);
        assertEquals(expected,result);
    }

    @Test
    void testIndMin() {

        double[] arr = {-3.1,2,0,1,3.4,10,-100};
        int expected = 6;
        int result = main.minIndex(arr);
        assertEquals(expected,result);
    }

    @Test
    void testArraySum() {

        double[] arr = {-1.1,2,0,1,3.4,10,-2};
        double expected = 13.30;
        double result = main.sum(arr);
        assertEquals(expected,result,1e-2);
    }

    @Test
    void testArrayAverage() {

        double[] arr = {-1,3.4,2.2,6,-4,0};
        double expected = 1.1;
        double result = main.average(arr);
        assertEquals(expected,result,1e-1);
    }
}