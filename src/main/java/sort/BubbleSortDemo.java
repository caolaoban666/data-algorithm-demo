package sort;

/**
 * @author YFC
 * @create 2020-05-28 下午 8:29
 */
public class BubbleSortDemo {


    public static void main(String[] args) {


        /**
         *  冒泡排序
         */

        int[] arr = new int[]{1,3,5,3,6,-2};

        System.out.println("排序前....");
        System.out.println(arr);

        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("排序后.....");
        System.out.println(arr);






    }



}
