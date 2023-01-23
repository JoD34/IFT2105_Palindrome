public class Palindrome {
    public static boolean checker(String input){
        String lookUp = "";
        for(int i = input.length()-1; i>=0;i--) {
            lookUp += input.charAt(i);
        }
        return input.equals(lookUp);
    }

    public static boolean checker_recursive(String input){
        int len = input.length()-1;
        if (len<=0) return true;

        boolean isSame = input.charAt(0) == input.charAt(len);
        return isSame && checker_recursive(getSubString(input, 1, len));
    }

    public static String reverse(String input){
        String reverseWord = "";
        for(int i = input.length()-1; i>=0; i--) {
            reverseWord += (char)input.charAt(i);
        }
        return reverseWord;
    }
    public static String transforme_palindrome(String input){
        if(checker(input))return input;
        String rev = reverse(input);
        return input.concat(rev);
    }
    public static String transforme_palindrome_compacte(String input) {
        int len = input.length(), n=0;
        for (int i = 0; i <= len - 1; i++) {
            String potentialPalin = getSubString(input, i, len);
            if (!checker(potentialPalin)) continue;
            n = i;
            break;
        }
        return input += reverse(getSubString(input, 0, n));
    }
        /*
        if(checker(input)) return input;

        int n = 0, l = input.length()-1;
        boolean foundIt = false;

        for (int i = 0; i<=l; i++){
            if(input.charAt(i) == input.charAt(l)){
                n = i;

                for (int j = l; j>=i ; j--){
                    if(input.charAt(i) != input.charAt(j)){
                        i = n + 1;
                        break;
                    }
                    if(j - i <= 1){
                        foundIt = true;
                        break;
                    }
                    i++;
                }
            }
            if (foundIt) break;
        }

        if(n!=0) {input += reverse(getSubString(input,0,n));}
        else{input+=reverse(input);}
        return input;
        }
         */

    public static String getSubString(String s, int beg, int end) {
        String res = "";
        for (int i = beg; i < end; i++){
            res += s.charAt(i);
        }
        return res;
    }
}
