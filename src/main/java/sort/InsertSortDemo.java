package sort;

import java.util.Random;

/**
 * @author YFC
 * @create 2020-06-01 18:55
 */
public class InsertSortDemo {

    public static void main(String[] args) {
        //int[] arr = {5,1,2,0,2};

        int[] randomArr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            randomArr[i] = new Random().nextInt(80000);
        }
        //System.out.println(Arrays.toString(randomArr));

        long startTime = System.currentTimeMillis();
        insertSort(randomArr);
        System.out.println("insertSort 排序耗时 "+(System.currentTimeMillis()-startTime)+"ms");//insertSort 排序耗时 734ms


        //int insertValue = arr[1];
        //int insertIndex = 1-1 ;
        //
        //while (
        //        // 防止越界
        //        insertIndex >= 0
        //                // 如果当前插入数据小于 比较数据，需要处理，否则不需要处理
        //        && insertValue < arr[insertIndex]){
        //    // 将符合条件数据后移
        //    arr[insertIndex+1] = arr[insertIndex];
        //    insertIndex --;
        //}
        //
        //arr[insertIndex+1] = insertValue;
        //
        //System.out.println("第"+1+"次排序结果为");
        //System.out.println(Arrays.toString(arr));
        //
        //
        //
        //insertValue = arr[2];
        //insertIndex = 2-1 ;
        //
        //while (
        //    // 防止越界
        //        insertIndex >= 0
        //                // 如果当前插入数据小于 比较数据，需要处理，否则不需要处理
        //                && insertValue < arr[insertIndex]){
        //    // 将符合条件数据后移
        //    arr[insertIndex+1] = arr[insertIndex];
        //    insertIndex --;
        //}
        //
        //arr[insertIndex+1] = insertValue;
        //
        //System.out.println("第"+2+"次排序结果为");
        //System.out.println(Arrays.toString(arr));

    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int insertValue = arr[i];
            int insertIndex = i-1 ;

            while (
                    // 防止越界
                    insertIndex >= 0
                            // 如果当前插入数据小于 比较数据，需要处理，否则不需要处理
                    && insertValue < arr[insertIndex]){
                // 将符合条件数据后移
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex --;
            }

            arr[insertIndex+1] = insertValue;

            //System.out.println("第"+i+"次排序结果为");
            //System.out.println(Arrays.toString(arr));

        }
    }


}
