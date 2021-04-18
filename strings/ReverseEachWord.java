package strings;

public class ReverseEachWord {
    public static String reverseEachWord(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s += " ";
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                if(sb.length()>0){
                    sb.reverse();
                }
                ans.append(sb).append(s.charAt(i));
                sb = new StringBuilder();
            }else{
                sb.append(s.charAt(i));
            }
        }
        return ans.deleteCharAt(ans.length()-1).toString();
    }

    public static void main(String[] args) {
        String sentence = "a lazy brown fox";
        System.out.println(reverseEachWord(sentence));
    }
}
