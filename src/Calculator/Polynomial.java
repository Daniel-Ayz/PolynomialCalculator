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
        Polynomial result=new Polynomial();
        for(Map.Entry<java.lang.Integer,Monomial> entry : p.monomials.entrySet()) {
            Polynomial sub = new Polynomial();
            Monomial m = entry.getValue();
            for(Map.Entry<java.lang.Integer,Monomial> subEntry : this.monomials.entrySet()) {
                sub.monomials.put(subEntry.getKey()+entry.getKey(), subEntry.getValue().mul(m));
            }
            result=result.add(sub);
        }
        return result;
    }

    public Scalar evaluate(Scalar s){
        Scalar result=new Rational(0,1);
        for(Map.Entry<java.lang.Integer,Monomial> entry : this.monomials.entrySet()) {
            result=result.add(entry.getValue().evaluate(s));
        }
        return result;
    }

    public Polynomial derivative(){
        Polynomial result=new Polynomial();
        for(Map.Entry<java.lang.Integer,Monomial> entry : this.monomials.entrySet()) {
            if(entry.getKey()!=0){
                result.monomials.put(entry.getKey()-1, entry.getValue().derivative());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String str="";
        for(Map.Entry<java.lang.Integer,Monomial> entry : this.monomials.entrySet()) {
            if(!str.equals("") && entry.getValue().sign()>0)
                str=str+"+"+entry.getValue().toString();
            else
                str=str+entry.getValue().toString();
        }
        return str;
    }

}
