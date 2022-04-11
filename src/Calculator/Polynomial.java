package Calculator;

import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Monomial> monomials;

    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    public Polynomial(){
        monomials=new ArrayList<Monomial>();
    }

    public static Polynomial build(String input){
        Polynomial p=new Polynomial();

        int index=0;
        boolean pastChar=false;
        int exponent=0;
        int number=0;
        int divider=0;
        boolean mone=true;
        boolean minus=false;
        while(index<input.length()){
            char c=input.charAt(index);
            if((mone) && ('0'<=c) && (c<='9')){
                number=number*10+charToInt(c);
                pastChar=true;
            }
            else if(!(mone) && ('0'<=c) && (c<='9'))
                divider=divider*10+charToInt(c);
            else if(c=='-')
                minus=true;
            else if(c=='/')
                mone=false;
            else if(pastChar){
                Scalar s=createScalar(minus,number,divider);
                if(s.sign()!=0)
                    p.getMonomials().add(new Monomial(exponent,s));
                pastChar=false;
                exponent++;
                number=0;
                divider=0;
                mone=true;
                minus=false;
            }
            index++;
        }
        if(pastChar){
            Scalar s=createScalar(minus,number,divider);
            if(s.sign()!=0)
                p.getMonomials().add(new Monomial(exponent,s));
        }
        return p;
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

    @Override
    public String toString() {
        return "Polynomial{" +
                "monomials=" + monomials +
                '}';
    }
}
