package Calculator;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar add(Integer s);
    Scalar add(Rational s);
    Scalar mul(Scalar s);
    Scalar mul(Integer s);
    Scalar mul(Rational s);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
}
