package sort;

import java.util.Arrays;

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
        shellSort(arr);

    }

    private static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                for (int j = i - gap; j >= 0; j -= gap) {
                    // 交换效率慢
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第" + (++count) + "轮后排序结果为");
            System.out.println(Arrays.toString(arr));


        }


    }

}
