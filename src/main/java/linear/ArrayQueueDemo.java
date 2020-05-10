package linear;

import java.util.Scanner;

/**
 * 数组模拟队列demo
 *
 * @author YFC
 * @create 2020-03-15 上午 9:16
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {


        //Queue queue = new Queue(3);
        AnnularQueueDemo.AnnularQueue queue = new AnnularQueueDemo.AnnularQueue(4);
        Scanner scanner = new Scanner(System.in);

        char c = ' ';// 用户输入信息

        System.out.println("s(show)：显示队列");
        System.out.println("a(add)：向队列添加数据");
        System.out.println("g(show)：从队列获取数据");
        System.out.println("h(show)：显示队列头部数据");
        System.out.println("e(exit)：退出程序");

        boolean flag = true;
        while (flag) {
            c = scanner.next().charAt(0);
            switch (c) {
                case 's':
                    queue.showQueue();
                    break;
                case 'h':
                    queue.headQueue();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数");
                    int num = scanner.nextInt();
                    queue.addQueue(num);
                    break;
                case 'g':
                    int n = queue.getQueue();
                    System.out.println(n);
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
            }
        }
        System.out.println("程序已退出!!!");
    }


    static class Queue {

        private int maxSize; // 队列最大数量
        private int front;// 队列头部
        private int rear;// 队列尾部
        private int[] arr;// 模拟队列存放数据的数组

        public Queue(int queueMaxSize) {
            maxSize = queueMaxSize;
            arr = new int[maxSize];
            front = -1;// 队列头部，默认表示的是队列的头部前一个位置的索引
            rear = -1;// 队列尾部，默认表示队列尾部
        }

        //队列是否已满
        public boolean isFull() {
            return rear == maxSize - 1;
        }

        // 判断队列是否为空
        public boolean isEmpty() {
            return rear == front;
        }

        public void addQueue(int num) {
            if (isFull()) {
                System.out.println("队列已满，不能添加数据..");
                return;
            }
            rear++;
            arr[rear] = num;
        }


        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，无法取出数据..");
            }
            front++;
            return arr[front];
        }

        public void headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，无法取出数据..");
            }
            System.out.println(arr[front + 1]);
        }

        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列数据为空!!!");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=[%d]\n", i, arr[i]);
            }
            System.out.println();
        }


    }


}
