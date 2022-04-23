package tests;

import Calculator.Monomial;
import Calculator.Scalar;
import Calculator.Integer;
import Calculator.Rational;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    public Monomial m1;
    public Monomial m2;
    public Monomial m3;
    public Scalar s1;
    public Scalar s2;

    @BeforeEach
    void setUp() {
        s1 = new Integer(1);
        s2 = new Rational(2, 3);
        m1 = new Monomial(2, s1);
        m2 = new Monomial(2, s2);
        m3 = new Monomial(3, s1);
    }

    @Test
    void add1() {
        Assertions.assertEquals(null, m1.add(m3));
    }

    @Test
    void add2() {
        Assertions.assertEquals(new Monomial(2, new Rational(5, 3)), m1.add(m2));
    }

    @Test
    void mul1() {
        Assertions.assertEquals(new Monomial(4, s2), m1.mul(m2));
    }

    @Test
    void mul2() {
        Assertions.assertEquals(new Monomial(5, s1), m1.mul(m3));
    }

    @Test
    void evaluate1() {
        Assertions.assertEquals(new Integer(9), m1.evaluate(new Integer(3)));
    }

    @Test
    void evaluate2() {
        Assertions.assertEquals(new Integer(6), m2.evaluate(new Integer(3)));
    }

    @Test
    void derivative1() {
        Assertions.assertEquals(new Monomial(1, new Integer(2)), m1.derivative());
    }

    @Test
    void derivative2() {
        Assertions.assertEquals(new Monomial(1, new Rational(4, 3)), m2.derivative());
    }

    @Test
    void derivative3() {
        Assertions.assertEquals(new Monomial(2, new Integer(3)), m3.derivative());
    }

    @Test
    void sign() {
        Assertions.assertEquals(1, m1.sign());
    }

    @Test
    void testToString1() {
        Assertions.assertEquals("x^2", m1.toString());
    }

    @Test
    void testToString2() {
        Assertions.assertEquals("2/3x^2", m2.toString());
    }

    @Test
    void testToString3() {
        Assertions.assertEquals("x^3", m3.toString());
    }
}