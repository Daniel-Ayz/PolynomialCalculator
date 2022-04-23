package tests;

import Calculator.Scalar;
import Calculator.Integer;
import Calculator.Rational;
import org.junit.jupiter.api.*;

class IntegerTest {

    public Integer s0;
    public Integer s1;
    public Scalar s2;
    public Rational s3;
    public Integer s4;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        s0 = new Integer(0);
        s1 = new Integer(1);
        s2 = new Integer(2);
        s3 = new Rational(2,3);
        s4 = new Integer(2);
    }

    @org.junit.jupiter.api.Test
    void add1() {
        Assertions.assertEquals(new Integer(3), s1.add(new Integer(2)));
    }

    @org.junit.jupiter.api.Test
    void add2() {
        Assertions.assertEquals(new Integer(3), s1.add(s2));
    }

    @org.junit.jupiter.api.Test
    void add3() {
        Assertions.assertEquals(new Rational(5, 3), s1.add(s3));
    }

    @org.junit.jupiter.api.Test
    void mul1() {
        Assertions.assertEquals(new Integer(6), s4.mul(new Integer(3)));
    }

    @org.junit.jupiter.api.Test
    void mul2() {
        Assertions.assertEquals(new Integer(4), s4.mul(s2));
    }

    @org.junit.jupiter.api.Test
    void mul3() {
        Assertions.assertEquals(new Rational(4, 3), s4.mul(s3));
    }

    @org.junit.jupiter.api.Test
    void neg() {
        Assertions.assertEquals(new Integer(-1), s1.neg());
    }

    @org.junit.jupiter.api.Test
    void power1() {
        Assertions.assertEquals(new Integer(1), s1.power(2));
    }

    @org.junit.jupiter.api.Test
    void power2() {
        Assertions.assertEquals(new Integer(8), s4.power(3));
    }

    @org.junit.jupiter.api.Test
    void sign1() {
        Assertions.assertEquals(1, s1.sign());
    }

    @org.junit.jupiter.api.Test
    void sign2() {
        Assertions.assertEquals(-1, s1.neg().sign());
    }

    @org.junit.jupiter.api.Test
    void sign3() {
        Assertions.assertEquals(0, s0.sign());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Assertions.assertEquals("1", s1.toString());
    }
}