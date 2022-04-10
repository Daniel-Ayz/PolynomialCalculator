package Calculator;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar neg();
    Scalar power(int exponent);
    Scalar sign();
}
