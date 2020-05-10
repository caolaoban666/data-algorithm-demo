package queue;

/**
 * 听数据结构与算法后写的代码
 *
 * @author YFC
 * @create 2020-04-11 上午 10:58
 */
public class ArrayQueue {

    // 队列最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 用数组模拟队列
    private int[] arr;

    public ArrayQueue(){

    }

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        // 头元素，默认指向有效元素的前一个位置
        this.front = -1;
        // 尾元素，默认指向有当前有效元素的当前位置
        this.rear = -1;
    }


    // 判断队列是否已满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }


    // 添加元素到队列
    public void addQueue(int num){
        // 判断队列是否满
        if(isFull()){
            System.out.println("队列已满，无法添加元素!!!");
            return;
        }

        rear++;
        arr[rear] = num;
    }


    // 取出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！！！无法取数据!!!");
        }
        front++;
       return arr[front];
    }


    // 打印队列所有元素
    public void show(){
        if(isEmpty()){
            System.out.println("队列元素为空，请先添加元素!!!");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d \n",i,arr[i]);
        }
        System.out.println();
    }

    // 取出队列头元素
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！！！无法取数据!!!");
        }
        return arr[front+1];
    }

    // 测试参考MyQueue.main();

}
