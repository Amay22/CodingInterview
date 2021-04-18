package hard;




public class Permute {

    public static void permutations(String input, int start, int length) {
        if (start == length - 1) {
            System.out.println(input);
            return;
        }
        for (int i = start; i < length; ++i) {
            input = swap(input, start, i);
            permutations(input, start + 1, length);
            input = swap(input, i, start);
        }
    }
    public static String swap(String input, int i , int j){
        int tmp = i;
        i = Math.min(i, j);
        j = Math.max(tmp, j);
        if(i == j){return input;}
        return input.substring(0,i) + input.charAt(j) + input.substring(i+1,j) + input.charAt(i)+ input.substring(j+1);
    }

    public static void main(String[] args) {
        String str = "123";
         permutations(str, 0, str.length() );
    }

}
