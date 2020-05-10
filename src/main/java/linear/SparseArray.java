package linear;

/**
 * 稀疏数组
 *
 * @author YFC
 * @create 2020-03-14 上午 10:08
 */
public class SparseArray {

    public static void main(String[] args) {


        /**
         * 二维数组转稀疏数组
         *
         *
         *
         */

        // 棋盘定义数据为 ： 0-无数据 1-黑子 2-白子



        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][4] = 2;

        System.out.println("原始二维数组数据为~~~~");

        // 遍历一下二维数组
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1.length; j++) {
                System.out.printf("%d\t",chessArray1[i][j]);
            }
            System.out.println();
        }

        // 先遍历二维数组，获取数组的有效个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArray1[i][j]!=0){
                    sum++;
                }
            }
        }

        // 转为稀疏数组，
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        // 再次遍历二维数组
        int count =  0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArray1[i][j]!=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        System.out.println("转为稀疏数组后~~~~");

        // 遍历一下二维数组
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray.length; j++) {
                System.out.printf("%d\t",sparseArray[i][j]);
            }
            System.out.println();
        }



        // 稀疏数组转为二维数组

        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("稀疏数组转为二维数组后的结果为 = ");
        // 遍历一下二维数组
        for (int i = 0; i < chessArray2.length; i++) {
            for (int j = 0; j < chessArray2.length; j++) {
                System.out.printf("%d\t",chessArray2[i][j]);
            }
            System.out.println();
        }




    }

}
