
package strings;

public class RemoveArbitrarySpace {
    public static String removeArbitrarySpaces(String str){
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '){
                word.append(str.charAt(i));
            }else if (word.length() > 0){
                word.append(' ');
                sb.append(word);
                word = new StringBuilder();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeArbitrarySpaces("    the   sky                 is    blue   "));
    }
}
