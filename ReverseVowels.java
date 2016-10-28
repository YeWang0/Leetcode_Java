import java.util.HashSet;

/**
 * Created by yvan on 10/27/16.
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
//        char vowels[]={'a','e','i','o','u'};
        char[] chars = s.toCharArray();
        HashSet<Character> vowels=new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int left=0;
        int right=s.length()-1;
        while(left<right){
            while(left<right&&!vowels.contains(s.charAt(left)))left++;
            while(left<right&&!vowels.contains(s.charAt(right)))right--;
            if(left<right){
                char temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
