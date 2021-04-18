package strings;

public class Roman2Int {

    public static int romanToInt(String s) {
        if (s == null) {
            return 0;
        }

        int prev = romanTable(s.charAt(s.length() - 1));
        int curr = 0;
        int result = prev;
        for (int i = s.length() - 2; i >= 0; i--) {
            curr = romanTable(s.charAt(i));
            if (curr < prev) {
                result -= curr;
                prev = 0;
            } else {
                result += curr;
                prev = curr;
            }
        }
        return result;
    }

    public static int romanTable(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XIV"));
    }
}
