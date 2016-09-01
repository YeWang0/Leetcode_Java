import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yvan on 9/1/16.
 */
public class ValidSerialization {
    public static void main(String [] args){
        ValidSerialization vs=new ValidSerialization();
        String preorder="9,3,4,#,#,1,#,#,2,#,6,#,#";
        vs.isValidSerialization(preorder);
    }
    public boolean isValidSerialization(String preorder) {
        if(preorder==null){
            return true;
        }
        String[] parts=preorder.split(",");
        int n=parts.length;
        List<String> nodes=new ArrayList<String>(Arrays.asList(parts));
        boolean flag=true;
        for(String s:nodes)
            System.out.println(s);
        System.out.println("-*-");
        while(flag) {
            flag=false;
            for (int i = 0; i < nodes.size() - 2; i++) {

                if (!nodes.get(i).equals("#") &&
                    nodes.get(i + 1).equals("#") &&
                    nodes.get(i + 2).equals("#"))
                {
                    nodes.remove(i);
                    nodes.remove(i + 1);
                    flag=true;
                    for(String s:nodes)
                        System.out.println(s);
                    System.out.println("---");
                }
            }
        }
        for(String s:nodes)
            System.out.println(s);
        return nodes.size()==1 && nodes.get(0).equals("#");
    }
}
