package Calculator;

public class Main {

    public static void main(String[] args) {

//        System.out.println(Polynomial.build("1      2 3"));
//        System.out.println(Polynomial.build("0 1 2   3"));
//        System.out.println(Polynomial.build("0 0 0    0 0      0 7"));
//        System.out.println(Polynomial.build("5 "));
//        System.out.println(Polynomial.build("1 -2 3"));
//        System.out.println(Polynomial.build("0 1/2 3     -5/3"));
//        System.out.println("test update");

//        String input="1      2 3";
//        String str=input.replaceAll(" +"," ");
//        String[] s=str.split(" ");
//        for(String sub:s)
//            System.out.println(sub);

        Polynomial p1=Polynomial.build("1 2 3");
        Polynomial p2=Polynomial.build("0 1 2 3");
        Polynomial p3=Polynomial.build("0 0 0    0 0      0 7");
        Polynomial p4=Polynomial.build("5 ");
        Polynomial sum=p1.add(p2);
        Polynomial sum2=p3.add(p4);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(sum);
        System.out.println(sum2);
        Polynomial mul1=p1.mul(p2);
        Polynomial mul2=p3.mul(p4);
        System.out.println(mul1);
        System.out.println(mul2);
        System.out.println("Version2");
        System.out.println("check for class files");
    }
}
