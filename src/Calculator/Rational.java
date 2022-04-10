package Calculator;

public class Rational implements Scalar{
    private int numerator;
    private int denominator;

    @Override
    public Scalar add(Scalar s) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public Scalar mul(Scalar s) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public Scalar neg() {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public Scalar power(int exponent) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public Scalar sign() {
        throw new RuntimeException("not implemented yet");
    }

    public Rational reduce() {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
