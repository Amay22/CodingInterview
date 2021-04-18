package strings;


public class StringCompression {
    public static String compress(String plain){
    StringBuilder compressed = new StringBuilder();
    int count = 0;
    for(int i = 1; i < plain.length() ; i++){
        if(plain.charAt(i) == plain.charAt(i-1)){
            count++;
        }else{
            compressed.append(plain.charAt(i-1));
            compressed.append(count+1);
            count=0;
        }
    }
    return (compressed.length() > plain.length() ? plain : compressed.toString());
}
    public static void main(String[] args) {
        String str = "aaaaabbbbccd";
        System.out.println("'"+str+ "' becomes '"+compress(str)+"'");
        str = "abc";
        System.out.println("'"+str+ "' becomes '"+compress(str)+"'");
    }
}
