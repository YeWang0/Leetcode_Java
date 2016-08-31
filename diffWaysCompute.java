import java.util.LinkedList;
import java.util.List;

/**
 * Created by yvan on 8/29/16.
 */
public class diffWaysCompute {
    public static void main(String [] args){
        String input="2+3";
        diffWaysCompute Computer=new diffWaysCompute();

        for(Integer i : Computer.diffWaysToCompute(input)){
                System.out.println(i);
        }
    }
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result=new LinkedList<Integer>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*'){
                List<Integer> left=diffWaysToCompute(input.substring(0,i));
                List<Integer> right=diffWaysToCompute(input.substring(i+1));
                for (Integer i1:left){
                    for (Integer i2:right){
                        if(input.charAt(i)=='+'){
                            result.add(i1+i2);
                        }else if( input.charAt(i)=='-'){
                            result.add(i1-i2);
                        }else if( input.charAt(i)=='*'){
                            result.add((i1*i2));
                        }
                    }
                }
            }
        }
        if (result.isEmpty()){
            result.add( Integer.parseInt(input));
        }
        return result;
    }
}
