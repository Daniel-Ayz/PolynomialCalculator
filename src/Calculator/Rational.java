package Calculator;

public class Rational implements Scalar{
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.add(this);
    }

    private Scalar add(Integer s) {
        return new Rational((s.getNumber()*this.denominator)+this.numerator,this.denominator);
    }

    private Scalar add(Rational s) {
        return new Rational((this.numerator*s.denominator)+(s.numerator*this.denominator),this.denominator*s.denominator);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mul(this);
    }

    private Scalar mul(Integer s) {
        return new Rational(s.getNumber()*this.numerator,this.denominator);
    }

    private Scalar mul(Rational s) {
        return new Rational(this.numerator*s.numerator,this.denominator*s.denominator);
    }

    @Override
    public Scalar neg() {
        return new Rational(-1*this.numerator,this.denominator);
    }

    @Override
    public Scalar power(int exponent) {
        return new Rational((int)Math.pow(this.numerator,exponent),(int)Math.pow(this.denominator,exponent));
    }

    @Override
    public int sign() {
        if(this.numerator==0)
            return 0;
        else if((this.numerator>0 && this.denominator>0)||(this.numerator<0 && this.denominator<0))
            return 1;
        else return -1;
    }

    public Rational reduce() {
        int sign=sign();
        int numeratorABS=Math.abs(this.numerator);
        int denominatorABS=Math.abs(this.denominator);
        int gcd=gcd(numeratorABS,denominatorABS);
        if(sign==0)
            return new Rational(0,1);
        else if(sign==1)
            return new Rational(numeratorABS/gcd,denominatorABS/gcd);
        else
            return new Rational(-1*(numeratorABS/gcd),denominatorABS/gcd);
    }

    private int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

    @Override
    public String toString() {
        String ans="";
        Rational reduced=reduce();
        if(denominator==1)
            return ans+reduced.numerator;
        else
            return ans+reduced.numerator+"/"+reduced.denominator;
    }
}
