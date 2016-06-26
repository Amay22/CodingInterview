package Hard;

public class CountAndSayNums {

    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < sb.length(); i++) {            
            if(sb.charAt(i-1)==sb.charAt(i)){
                count++;
            }else{                
                result.append(count);
                result.append(sb.charAt(i));
                count = 1;
            }
        }
        if(sb.charAt(sb.length()-2)==sb.charAt(sb.length()-1)){
                result.append(count);
                result.append(sb.charAt(sb.length()-1));
            }else{                
                result.append(1);
                result.append(sb.charAt(sb.length()-1));
                
            }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(1223));
    }
}
