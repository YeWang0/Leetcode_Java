
import java.util.*;

/**
 * Created by yvan on 11/13/16.
 */
public class Boomerangs {
    public int numberOfBoomerangs(int[][] points) {

        int distance=0;
        List<Integer> temp=new ArrayList<>();
//        List<Integer> ps=new ArrayList<>();
        int ps=0;
        int sum=0;
        for(int i=0;i<points.length;i++) {
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(j==i)continue;
                distance = getDistance(points[i], points[j]);
                if (map.containsKey(distance)) {
                    map.put(distance,(map.get(distance))+1);
                } else {
                    map.put(distance, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sum += getCount(entry.getValue());
            }
        }
        return sum;
    }

    public int numberOfBoomerangs2(int[][] points) {
        HashMap<List<Integer>,Integer> map=new HashMap<>();
        int distance=0;
        List<Integer> temp=new ArrayList<>();
//        List<Integer> ps=new ArrayList<>();
        int ps=0;
        for(int i=0;i<points.length;i++) {
            for (int j = i + 1; j < points.length; j++) {
                distance = getDistance(points[i], points[j]);
                temp = new ArrayList<>();
                temp.add(i);
                temp.add(distance);
                List t = Arrays.asList(temp);
                if (map.containsKey(t)) {
                    ps = map.get(t);
                    ps++;
                    map.put(t, ps);
                } else {
                    ps = 1;
                    map.put(t, ps);
                }

                temp = new ArrayList<>();
                temp.add(j);
                temp.add(distance);
                List t2 = Arrays.asList(temp);
                if (map.containsKey(t2)) {
                    ps = map.get(t2);
                    ps++;
                    map.put(t2, ps);
                } else {
                    ps = 1;
                    map.put(t2, ps);
                }
            }
        }
        int sum=0;
        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet())
        {
            sum+=getCount(entry.getValue());
            System.out.println(getCount(entry.getValue()));
        }
        return sum;
    }
    public int getCount(int i){
        return i*(i-1);
    }
    public int getDistance(int[] x,int[] y){
        return (int)(Math.pow(x[0]-y[0],2)+Math.pow(x[1]-y[1],2));
    }

}
