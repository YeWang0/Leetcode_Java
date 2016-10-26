import java.util.HashSet;

/**
 * Created by yvan on 10/25/16.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        set.add(n);
        while(true) {

            String num = Integer.toString(n);
            int sum = 0;
            for (int i = 0; i < num.length(); i++) {
                sum += (num.charAt(i) - '0') * (num.charAt(i) - '0');
            }
            if (sum == 1) {
                return true;
            } else {
                if (set.contains(sum)) {
                    return false;
                } else {
                    set.add(sum);
                }
            }
        }
    }
}
