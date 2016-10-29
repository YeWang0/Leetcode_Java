/**
 * Created by yvan on 10/28/16.
 */
public class AddBinary {
    public static void main(String [] arg){
        AddBinary ab=new AddBinary();
        System.out.println(ab.addBinary("101","111"));
    }
    public String addBinary(String a, String b) {
        if(a.length()<b.length()){
            String temp=a;
            a=b;
            b=temp;
        }
        int na=a.length();
        int nb=b.length();

        char[] result=new char[na];
        boolean carry=false;
        int i=1;
        while(i<=na){
            char x=a.charAt(na-i);
            char y=nb-i>=0?b.charAt(nb-i):'0';
            char z=carry?(char)(x+y-47):(char)(x+y-48);
            System.out.println(z);
            System.out.println(na-i);
            if(z=='3'){carry=true;result[na-i]='1';}
            if(z=='2'){carry=true;result[na-i]='0';}
            if(z=='1'){carry=false;result[na-i]='1';}
            if(z=='0'){carry=false;result[na-i]='0';}
            i++;
        }
//        carry?'1';

        return carry?'1'+new String(result):new String(result);
    }
}
