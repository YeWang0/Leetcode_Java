import java.util.ArrayList;
import java.util.List;

/**
 * Created by yvan on 10/31/16.
 */
public class GenerateParentheses {
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generater(new String(),n,n);
        return result;
    }
    public void generater(String prefix,int leftb,int rightb){
        if(leftb==0&&rightb==0)result.add(prefix);
        if(leftb<rightb){
            generater(new String(prefix+')'),leftb,rightb-1);
        }
        if(leftb>0)
            generater(new String(prefix+'('),leftb-1,rightb);
    }
}
