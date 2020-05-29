package sort;

import java.util.Arrays;

/**
 * 选择排序算法
 *
 * @author YFC
 * @create 2020-05-29 9:25
 */
public class SelectSortDemo {


    public static void main(String[] args) {


        int arr[] = {3,1,5,2,6,4};

        int temp = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(arr[i] != arr[minIndex]){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

            System.out.println("第"+(i+1)+"次排序结果为");
            System.out.println(Arrays.toString(arr));
        }


        





    }



}
