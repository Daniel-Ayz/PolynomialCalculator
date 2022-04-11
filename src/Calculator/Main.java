package Calculator;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Monomial(0,new Integer(1)));

        System.out.println(Polynomial.build("1 2 3"));
        System.out.println(Polynomial.build("0 1 2 3"));
        System.out.println(Polynomial.build("”0 0 0 0 0 0 7"));
        System.out.println(Polynomial.build("5"));
        System.out.println(Polynomial.build("1 -2 3"));
        System.out.println(Polynomial.build("”0 1/2 3 -5/3"));

    }
}
