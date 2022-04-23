package tests;

import Calculator.Polynomial;
import Calculator.Monomial;
import Calculator.Scalar;
import Calculator.Rational;
import org.junit.jupiter.api.*;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    public Polynomial p1;
    public Polynomial p2;
    public Polynomial p3;
    public Polynomial p4;
    public Polynomial p5;
    public Polynomial p6;

    @BeforeEach
    void setUp() {
        p2 = new Polynomial();
        TreeMap<java.lang.Integer, Monomial> map1 = new TreeMap<>();
        map1.put(0, new Monomial(0, new Calculator.Integer(1)));
        map1.put(1, new Monomial(1, new Calculator.Integer(2)));
        map1.put(2, new Monomial(2, new Calculator.Integer(3)));
        p2.setMonomials(map1);

        p3 = new Polynomial();
        TreeMap<java.lang.Integer, Monomial> map2 = new TreeMap<>();
        map2.put(1, new Monomial(1, new Calculator.Integer(-1)));
        map2.put(2, new Monomial(2, new Calculator.Integer(2)));
        map2.put(3, new Monomial(3, new Calculator.Integer(3)));
        p3.setMonomials(map2);

        p4 = new Polynomial();
        TreeMap<java.lang.Integer, Monomial> map3 = new TreeMap<>();
        map3.put(6, new Monomial(6, new Calculator.Integer(7)));
        p4.setMonomials(map3);

        p5 = new Polynomial();
        TreeMap<java.lang.Integer, Monomial> map4 = new TreeMap<>();
        map4.put(0, new Monomial(0, new Calculator.Integer(5)));
        p5.setMonomials(map4);

        p6 = new Polynomial();
        TreeMap<java.lang.Integer, Monomial> map5 = new TreeMap<>();
        map5.put(2, new Monomial(2, new Rational(2,3)));
        p6.setMonomials(map5);
    }

    @Test
    void build1() {
        Assertions.assertEquals(p2,p1.build("1 2 3"));
    }

    @Test
    void build2() {
        Assertions.assertEquals(p3,p1.build("0 -1 2 3"));
    }

    @Test
    void build3() {
        Assertions.assertEquals(p4,p1.build("0 0 0    0 0      0 7"));
    }

    @Test
    void build4() {
        Assertions.assertEquals(p5,p1.build("5 "));
    }

    @Test
    void build5() {
        Assertions.assertEquals(p6,p1.build("0 0 2/3"));
    }

    @Test
    void add1() {
        Assertions.assertEquals(p1.build("1 1 5 3"),p2.add(p3));
    }

    @Test
    void add2() {
        Assertions.assertEquals(p1.build("5 0 0 0 0 0 7"),p4.add(p5));
    }

    @Test
    void mul1() {
        Assertions.assertEquals(p1.build("0 -1 0 4 12 9"),p2.mul(p3));
    }

    @Test
    void mul2() {
        Assertions.assertEquals(p1.build("0 0 0 0 0 0 35"),p4.mul(p5));
    }

    @Test
    void evaluate1() {
        Assertions.assertEquals(new Calculator.Integer(1),p2.evaluate(new Calculator.Integer(0)));
    }

    @Test
    void evaluate2() {
        Assertions.assertEquals(new Rational(3, 8),p3.evaluate(new Rational(1, 2)));
    }

    @Test
    void evaluate3() {
        Assertions.assertEquals(new Calculator.Integer(2),p2.evaluate(new Calculator.Integer(-1)));
    }

    @Test
    void derivative1() {
        Assertions.assertEquals(p1.build("2 6"), p2.derivative());
    }

    @Test
    void derivative2() {
        Assertions.assertEquals(p1.build("-1 4 9"), p3.derivative());
    }

    @Test
    void derivative3() {
        Assertions.assertEquals(p1.build("0 4/3"), p6.derivative());
    }

    @Test
    void testToString1() {
        Assertions.assertEquals("1+2x+3x^2", p2.toString());
    }

    @Test
    void testToString2() {
        Assertions.assertEquals("-x+2x^2+3x^3", p3.toString());
    }

    @Test
    void testToString3() {
        Assertions.assertEquals("7x^6", p4.toString());
    }

    @Test
    void testToString4() {
        Assertions.assertEquals("2/3x^2", p6.toString());
    }
}