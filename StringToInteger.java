/**
 * Created by yvan on 10/31/16.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        int result=0;
        int flag=1;
        int index=0;
        if(str.charAt(0)=='-'){
            flag=-1;
            index++;
        }
        for(;index<str.length();index++){
            if(str.charAt(index)>=30&&str.charAt(index)<=39){
                result=result*10+(str.charAt(index)-30);
            }else{
                return 0;
            }
        }
        return result*flag;

    }
}
