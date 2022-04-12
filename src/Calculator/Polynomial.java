package Calculator;

import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<java.lang.Integer, Monomial> monomials;

    public Polynomial() {
        this.monomials = new TreeMap<>();
    }

    protected Polynomial clone(){
        Polynomial p=new Polynomial();
        p.monomials.putAll(this.monomials);
        return p;
    }

    public static Polynomial build(String input){
        Polynomial p=new Polynomial();
        String trim=input.replaceAll(" +"," ");
        String[] s= trim.split(" ");
        for(int i=0;i< s.length;i++){
            Monomial m=Monomial.build(s[i],i);
            if(m.sign()!=0)
                p.monomials.put(i,m);
        }
        return p;
    }

    public Polynomial add(Polynomial p){
        Polynomial result=clone();
        for(Map.Entry<java.lang.Integer,Monomial> entry : p.monomials.entrySet()) {
            java.lang.Integer key=entry.getKey();
            if(result.monomials.containsKey(key))
                result.monomials.put(key,entry.getValue().add(result.monomials.get(key)));
            else
                result.monomials.put(key,entry.getValue());
        }
        return result;
    }

    public Polynomial mul(Polynomial p){
        return null;
    }

    public Scalar evaluate(Scalar s){
        return null;
    }

    public Polynomial derivative(){
        return null;
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                "monomials=" + monomials +
                '}';
    }
}
