package Calculator;

public class Integer implements Scalar{
    private int number;

    public Integer(int number){
        this.number=number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.add(this);
    }

    private Scalar add(Integer s){
        return new Integer(this.number+s.number);
    }

    private Scalar add(Rational s){
        return new Rational(s.getNumerator()+(this.number*s.getDenominator()),s.getDenominator());
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mul(this);
    }

    private Scalar mul(Integer s){
        return new Integer(this.number*s.number);
    }

    private Scalar mul(Rational s){
        return new Rational(s.getNumerator()*this.number,s.getDenominator());
    }

    @Override
    public Scalar neg() {
        return new Integer(-1*this.number);
    }

    @Override
    public Scalar power(int exponent) {
        return new Integer((int)Math.pow(this.number,exponent));
    }

    @Override
    public int sign() {
        if(this.number==0)
            return 0;
        else if(this.number>0)
            return 1;
        else return -1;
    }

    @Override
    public String toString() {
        String ans="";
        return ans+this.number;
    }
}
