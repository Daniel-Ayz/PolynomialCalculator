package Calculator;

import java.util.Objects;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m){
        if (m.exponent != this.exponent)
            return null;
        return new Monomial(this.exponent,this.coefficient.add(m.coefficient));
    }

    public Monomial mul(Monomial m){
        return new Monomial(this.exponent+m.exponent,this.coefficient.mul(m.coefficient));
    }

    public Scalar evaluate(Scalar s){
        return ((s.power(this.exponent)).mul(this.coefficient));
    }

    public Monomial derivative(){
        return new Monomial(this.exponent-1,this.coefficient.mul(new Integer(this.exponent)));
    }

    public int sign(){
        return this.coefficient.sign();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return exponent == monomial.exponent && coefficient.equals(monomial.coefficient);
    }

    public String toString(){
        String ans="";
        if(this.exponent==1)
            ans=ans+"x";
        else if(this.exponent>1)
            ans=ans+"x^"+this.exponent;
        if((this.coefficient.add(new Integer(-1))).sign()==0) {
            if (ans.equals(""))
                return "1";
            return ans;
        }
        else if((this.coefficient.add(new Integer(1))).sign()==0) {
            if (ans.equals(""))
                return "-1";
            return "-"+ans;
        }
        return this.coefficient.toString()+ans;
    }

    //static functions

    protected static Monomial build(String coef,int exponent){
        int number=0;
        int divisor=0;
        boolean minus=false;
        boolean rational=false;
        int c=0;
        while(c<coef.length()){
            char ch=coef.charAt(c);
            if(ch=='-')
                minus=!minus;
            else if(ch=='/')
                rational=true;
            else if(!rational)
                number=number*10+charToInt(ch);
            else
                divisor=divisor*10+charToInt(ch);
            c++;
        }
        Scalar s=createScalar(minus,number,divisor);
        return new Monomial(exponent,s);
    }

    private static int charToInt(char c){
        return "0123456789".indexOf(c);
    }

    private static Scalar createScalar(boolean minus,int number,int divider){
        if(divider==0){
            if(minus)
                return new Integer(-1*number);
            else
                return new Integer(number);
        }
        else{
            if(minus)
                return new Rational(-1*number,divider);
            else
                return new Rational(number,divider);
        }
    }
}
