package Calculator;

public class Integer implements Scalar{
    private int number;

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

    @Override
    public String toString() {
        return "Integer{" +
                "number=" + number +
                '}';
    }
}
