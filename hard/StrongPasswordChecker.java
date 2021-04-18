package hard;

class StrongPasswordChecker {
    public static int strongPasswordChecker(String s) {
        if (s == null) {
            return 6;
        }
        if (s.length() < 6) {
            return 6 - s.length();
        }
        int charactersToChange = 0;
        int repeatingCharacters = 0;
        if (s.length() > 20) {
            charactersToChange += s.length() - 20;
            repeatingCharacters = -charactersToChange;
        }
        boolean foundLowerCase = false;
        boolean foundUpperCase = false;
        boolean foundDigit = false;

        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                foundLowerCase = true;
            }
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                foundUpperCase = true;
            }

            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                foundDigit = true;
            }
            if (i < s.length()-2 && s.charAt(i) == s.charAt(i+1) && s.charAt(i) == s.charAt(i+2)) {
                System.out.println(s.charAt(i));
                repeatingCharacters++;
            }
        }
//        if(repeatingCharacters > 3){
//            repeatingCharacters = repeatingCharacters/3;
//        }
        if (!foundLowerCase){
            charactersToChange++;
//            repeatingCharacters--;
        }
        if (!foundUpperCase){
            charactersToChange++;
//            repeatingCharacters--;
        }
        if(!foundDigit){
            charactersToChange++;
//            repeatingCharacters--;
        }
        if (repeatingCharacters > 0) {
            charactersToChange +=  repeatingCharacters;
        }
        // else if (repeatingCharacters > 0) {
        // charactersToChange += repeatingCharacters - 1;
        // }

        return charactersToChange;
    }

    public static void main(String[] args)
    {
        String input = "aaa111";
        System.out.println(strongPasswordChecker(input));

    }
}
