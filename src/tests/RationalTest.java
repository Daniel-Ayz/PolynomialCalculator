package tests;

import Calculator.Scalar;
import Calculator.Integer;
import Calculator.Rational;
import org.junit.jupiter.api.*;

class RationalTest {

    public Rational s0;
    public Rational s1;
    public Scalar s2;
    public Integer s3;
    public Rational s4;
    public Rational s5;

    @BeforeEach
    void setUp() {
        s0 = new Rational(0,1);
        s1 = new Rational(1, 2);
        s2 = new Integer(5);
        s3 = new Integer(2);
        s4 = new Rational(1, 3);
        s5 = new Rational(2, 3);
    }

    @Test
    void add1() {
        Assertions.assertEquals(new Rational(5, 6), s1.add(s4));
    }

    @Test
    void add2() {
        Assertions.assertEquals(new Rational(11, 2), s1.add(s2));
    }

    @Test
    void add3() {
        Assertions.assertEquals(new Rational(5, 2), s1.add(s3));
    }

    @Test
    void mul1() {
        Assertions.assertEquals(new Rational(1, 6), s1.mul(s4));
    }

    @Test
    void mul2() {
        Assertions.assertEquals(new Rational(5, 2), s1.mul(s2));
    }

    @Test
    void mul3() {
        Assertions.assertEquals(new Rational(2, 2), s1.mul(s3));
    }


    @Test
    void neg() {
        Assertions.assertEquals(new Rational(-1, 2), s1.neg());
    }

    @Test
    void power1() {
        Assertions.assertEquals(new Rational(1, 4), s1.power(2));
    }

    @Test
    void power2() {
        Assertions.assertEquals(new Rational(4, 9), s5.power(2));
    }

    @Test
    void sign1() {
        Assertions.assertEquals(1, s1.sign());
    }

    @Test
    void sign2() {
        Assertions.assertEquals(-1, s1.neg().sign());
    }

    @Test
    void sign3() {
        Assertions.assertEquals(0, s0.sign());
    }

    @Test
    void reduce1() {
        Assertions.assertEquals(s1, new Rational(2, 4));
    }

    @Test
    void reduce2() {
        Assertions.assertEquals(s1.neg(), new Rational(2, -4));
    }

    @Test
    void reduce3() {
        Assertions.assertEquals(s3, new Rational(4, 2));
    }

    @Test
    void testToString1() {
        Assertions.assertEquals("1/2", s1.toString());
    }

    @Test
    void testToString2() {
        Assertions.assertEquals("3", new Rational(3, 1).toString());
    }

    @Test
    void testToString3() {
        Assertions.assertEquals("-1/2", s1.neg().toString());
    }
}