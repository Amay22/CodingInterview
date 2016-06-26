package Strings;

public class HistogramEachCharacter {

    public static void printHistogram(String str) {

        int chars[] = new int[128];

        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i)]++;
        }

        for (int i = 0; i < 128; ++i) {
            if (chars[i] > 0) {
                System.out.print((char)i + " ");

                for (int j = 0; j < chars[i]; ++j) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }
    
    public static void main(String[] args) {
        printHistogram("howwwhas");
    }
}
