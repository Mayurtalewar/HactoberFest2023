import java.util.*;
 public class inversion_count
{
    public static int mergeArrays(int[] left, int [] right)
    {
        int[] merge=new int[left.length+right.length];
        int i = 0, j = 0, k = 0,count=0,n=left.length;
        while (i < left.length && j < right.length)
        {
            if (left[i] < right[j]) {
                merge[k] = left[i];
                i++;
            }
            else
            {
                merge[k] = right[j];
                j++;
                count+=n-i;
            }
        }
        while (i < left.length) {
            merge[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            merge[k] = right[j];
            j++;
            k++;
        }
        return count;
    }
    public static int mergeSort(int[] arr)
    {
        int count=0;
        if(arr.length<=1)
        {
            return count;
        }
        else{
            int mid=arr.length/2;
            int[] left=Arrays.copyOfRange(arr,0,mid);
            int[] right=Arrays.copyOfRange(arr,mid,arr.length);
            count+=mergeSort(left);
            count+=mergeSort(right);
            count+= mergeArrays(left, right);
        }
        return count;
    }


    public static void main(String[] args)
    {
        int[] arr = { 9,8,3,2,5};
        int count=mergeSort(arr);
        System.out.println("Inversion counts:"+count);
    }
}
