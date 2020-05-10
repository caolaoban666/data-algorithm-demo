package queue;

import java.util.Scanner;

/**
 * 自己先试着写的代码（不过这个也是之前看过视频所以才能写出来的代码）
 *
 * @author YFC
 * @create 2020-04-11 上午 10:01
 */
public class MyQueue {

    // 队列存储最大个数
    private Integer maxSize;
    private int front;
    private int rear;

    private Integer[] arr;

    public MyQueue(){

    }

    public MyQueue(int maxSize){
        arr = new Integer[maxSize];
        this.front = -1;
        this.rear = -1;
        this.maxSize = maxSize;
    }

    // 判断队列是否满
    public boolean full(){
        return rear == maxSize-1;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }


    // 添加元素到队列
    public void addQueue(Integer num){
        if(full()){
            System.out.println("队列已满，无法添加元素!!!");
            return;
        }
        arr[++rear] = num;
    }

    // 取出队列元素
    public void get(){
        if(isEmpty()){
            System.out.println("队列为空，无法取出元素!!!");
            return;
        }
       int num =  arr[++front];
        System.out.println("取出的元素为 "+num);
    }

    // 打印队列有效元素
    public void show(){
        if(isEmpty()){
            System.out.println("队列元素为空，请添加元素!!!");
            return;
        }

        for (int i = front+1; i <= rear; i++) {
            System.out.printf("arr[%d] = %d \t",i,arr[i]);
        }
        System.out.println();

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //MyQueue queue = new MyQueue(3);

        ArrayQueue queue = new ArrayQueue(3);

        char c = ' ';
        boolean flag = true;
        while (flag){

            char o = scanner.next().charAt(0);

            switch (o){
                case 's':
                    queue.show();
                break;
                case 'a':
                    System.out.println("请输入一个添加元素!!!");
                    int num = scanner.nextInt();
                    queue.addQueue(num);
                    break;
                case 'g':
                    queue.getQueue();
                    break;
                case 'h':
                    int n = queue.headQueue();
                    System.out.println("头元素为 = "+n);
                    break;
                case 'e':
                    flag = false;
                    break;

            }


        }


    }



}
