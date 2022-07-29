import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumdistinctelementsafterremovingKelements {


    static int maxDistinctNum(int a[], int n, int k)
    {
     int count=0;
     Map<Integer,Integer> map=new HashMap<>();
     PriorityQueue<Integer> queue=new PriorityQueue<>();
     for(int i:a)
         map.put(i, map.getOrDefault(i, 0) + 1);
     /*Below if else is same as above one line code*/
        /* if (map.containsKey(i))
             map.put(i,map.get(i)+1);
          else
              map.put(i,1);*/
        for(Map.Entry<Integer,
                Integer> p : map.entrySet())
        {
            if(p.getValue() == 1)
                ++count;
            else
                queue.add(p.getValue());
        }
        if(queue.isEmpty()){
           return count-k;
        }
        while(k>=0 && !queue.isEmpty()){
            int val=queue.poll();
            if(val==1)
                ++count;
            else{
                --val;
                --k;
                queue.add(val);
            }

        }
        if(k>0)
            count=count-k;
        if(!queue.isEmpty())
            count=count+queue.size();
     return count;
    }

    public static void main(String[] args) {
      //  int arr[]={5, 7, 5, 5, 1, 2, 2};
       // int n=arr.length;
       // int k=3;
        /*int arr[]={6,15,19};
        int n=arr.length;
        int k=1;*/
        /*int arr[]={ 2 ,12, 14, 1, 2, 11, 1, 1, 19, 18, 2, 8, 4, 9, 3, 3, 14, 17, 16, 13};
        int n=arr.length;
        int k=19;*/
        int arr[]={ 18,15,14,20,1,10,14,12,13,17,17,2,14,3,5,7,17,3};
        int n=arr.length;
        int k=1;
        System.out.println(maxDistinctNum(arr,n,k));

        }

}
