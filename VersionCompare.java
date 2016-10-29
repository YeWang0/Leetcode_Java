/**
 * Created by yvan on 10/27/16.
 */
public class VersionCompare {
    public int compareVersion(String version1, String version2) {
        int a=0,b=0;
        int pa=0,pb=0;
        int t;
        while(a<version1.length()&&b<version2.length()){
            while(version1.charAt(a)!='.'&&a<version1.length())a++;
            while(version2.charAt(b)!='.'&&b<version2.length())b++;
            if(a>=version1.length()&&b>=version2.length())break;
            String s1=version1.substring(pa,a);
            String s2=version2.substring(pb,b);
            t=Integer.getInteger(s1)-Integer.getInteger(s2);
            if(t>0){
                return 1;
            }else if(t<0){
                return -1;
            }else{
                pa=++a;
                pb=++b;
            }
        }
        String s1=version1.substring(pa,a);
        String s2=version2.substring(pb,b);
        t=Integer.valueOf(s1)-Integer.valueOf(s2);
        if(t>0){
            return 1;
        }else if(t<0){
            return -1;
        }else{
            if(a>=version1.length()&&b>=version2.length()) return 0;
            else if(a>=version1.length()) {
                for(int i=b;b<version2.length();i++){
                    if(!(version2.charAt(i)=='.'||version2.charAt(i)=='0')){
                        return -1;
                    }
                }
                return 0;
            }
            else if(b>=version2.length()) {
                for(int i=a;a<version1.length();i++){
                    if(!(version1.charAt(i)=='.'||version1.charAt(i)=='0')){
                        return -1;
                    }
                }
                return 0;
            }
        }
        return 0;




//        boolean flag=false;
//        int n1=version1.length();
//        for(int i=0;i<n1;){
//            if(version1.charAt(i)=='.'&&flag==true){
//                version1=version1.substring(0,i)+version1.substring(i+1);
//                n1--;
//            }else if(version1.charAt(i)=='.'){
//                flag=true;
//                i++;
//            }else{
//                i++;
//            }
//        }
//        flag=false;
//        int n2=version2.length();
//        for(int i=0;i<n2;){
//            if(version2.charAt(i)=='.'&&flag==true){
//                version2=version2.substring(0,i)+version2.substring(i+1);
//                n2--;
//            }else if(version2.charAt(i)=='.'){
//                flag=true;
//                i++;
//            }else{
//                i++;
//            }
//        }
//        Float t=Float.parseFloat(version1)-Float.parseFloat(version2);
//        if(t>0){
//            return 1;
//        }else if(t<0){
//            return -1;
//        }else{
//            return 0;
//        }
    }
}
