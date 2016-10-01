import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yvan on 9/28/16.
 */
public class Partition {
    List<List<String >> result;
    List<String> temp;
    public List<List<String>> partition(String s) {
        result=new ArrayList<List<String>>();
        temp=new ArrayList<String>();

        get_partition(s,0);
        return result;
    }
    public void get_partition(String s,int index){
        if(index>=s.length()&&temp.size()>0){
            List<String> t=new ArrayList<String>();
            for(int i=0;i<temp.size();i++){
                t.add(temp.get(i));
            }
            result.add(t);
        }
        for(int i=index;i<s.length();i++){
            if(check_palindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                get_partition(s,i+1);
                if(temp.size()>0)
                    temp.remove(temp.size()-1);
            }
        }
    }
    public boolean check_palindrome(String s,int l,int r){
        if(l==r){
            return true;
        }
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
