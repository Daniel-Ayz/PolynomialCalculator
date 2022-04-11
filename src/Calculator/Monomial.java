package Calculator;

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
            return ans;
        }
        return this.coefficient.toString()+ans;
    }
}
