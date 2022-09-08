import java.util.ArrayList;

public class MaxIncontiguousSubArray {

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
      ArrayList<Integer> list=new ArrayList<>();

return list;
    }
    public static void main(String[] args) {
        int arr[]={8,5,10,9,4,15,12,90,13};
        int len=arr.length;
        int k=4;
        ArrayList<Integer> res=max_of_subarrays(arr,len,k);
        for(int r:res)
        System.out.print(r+" ");


    }
}
