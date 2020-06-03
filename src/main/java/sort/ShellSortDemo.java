package sort;

import java.util.Random;

/**
 * 希尔排序
 *
 * @author YFC
 * @create 2020-06-03 9:36
 */
public class ShellSortDemo {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 5, 4, 6, 9, 8, 7, 0};


        // 希尔排序
        int[] randomArr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = new Random().nextInt(80000);
        }
        //System.out.println(Arrays.toString(randomArr));

        long startTime = System.currentTimeMillis();
        //shellSort(randomArr);// 交换式
        shellSort2(randomArr);// 移位式
        System.out.println("shellSort 排序耗时 "+(System.currentTimeMillis()-startTime)+"ms"); //shellSort 排序耗时 7673ms
        System.out.println("shellSort 排序耗时 "+(System.currentTimeMillis()-startTime)+"ms"); //shellSort 排序耗时 67ms

        //System.out.println(Arrays.toString(arr));


    }

    private static void shellSort2(int[] arr) {
        // 优化 交换改为移位
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];

                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }

            }
        }
    }

    private static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                for (int j = i - gap; j >= 0; j -= gap) {
                    //交换效率慢
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("第" + (++count) + "轮后排序结果为");
            //System.out.println(Arrays.toString(arr));


        }


    }

}
