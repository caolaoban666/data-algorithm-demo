package sort;

import java.util.Random;

/**
 * 冒泡排序算法
 *
 * @author YFC
 * @create 2020-05-28 下午 8:29
 */
public class BubbleSortDemo {


    public static void main(String[] args) {

        /**
         *
         * 冒泡排序
         */
        int arr[] = {3,1,5,2,6,4};

        int[] randomArr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = new Random().nextInt(80000);
        }
        //System.out.println(Arrays.toString(randomArr));

        long startTime = System.currentTimeMillis();
        bubbleSort(randomArr);
        System.out.println("bubbleSort 排序耗时 "+(System.currentTimeMillis()-startTime)+"ms");//bubbleSort 排序耗时 12361ms

    }

    private static void bubbleSort(int[] arr) {
        // 排序标识，为了减少无用排序次数
        boolean flag = false;
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length -1 -i; j++) {
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if(!flag){
                break;
            }else {
                flag = false;
            }
            //System.out.println("第"+(i+1)+"次排序");
            //System.out.println(Arrays.toString(arr));
        }
    }


}
