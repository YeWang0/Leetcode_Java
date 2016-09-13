import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by yvan on 9/13/16.
 */
public class fractionToDecimal {
    public  static void main(String[] args){
        fractionToDecimal f2d=new fractionToDecimal();
        f2d.convert(-1,-2147483648);

    }
    public String convert(int numerator, int denominator){
        String result="";
        Long num= Math.abs((long)numerator);
        Long den= Math.abs((long)denominator);
        System.out.println(num+" "+den);
        if(numerator<0&&denominator>0||numerator>0&&denominator<0){
            result+='-';
        }
//        System.out.println(denominator);
        Long temp=(num/den);
        Long remainder=(num%den);
        result+=String.valueOf(temp);
        if(remainder==0){
            return result;
        }
        result+='.';
        remainder*=10;
        HashMap<Long,Integer> map=new HashMap<Long, Integer>();
        while(!map.containsKey(remainder)){

            map.put(remainder,result.length());
            temp=(remainder/den);
            remainder=(remainder)%den;

            System.out.println(temp+" "+remainder);
            result+= String.valueOf(temp);
            if(remainder==0){
                return result;
            }
            remainder*=10;
        }
//        System.out.println(map.get(remainder));
        int index=map.get(remainder);
        System.out.println(result.substring(0,index)+'('+result.substring(index)+')');
        return result.substring(0,index)+'('+result.substring(index)+')';
    }
}
