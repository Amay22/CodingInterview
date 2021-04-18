package hard;

/*
Simplest ever combination technique ever. Can be mugged up.
*/
public class Combination {
    public static void combination(String active, String comb){
        if(comb.length() == 0){
            System.out.println(active);
        }else{
            combination(active + comb.charAt(0), comb.substring(1, comb.length()));
            combination(active, comb.substring(1, comb.length()));
        }
    }

    public static void main(String[] args) {
        combination("", "123");
    }

}
