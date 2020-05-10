package queue;

/**
 * 环形队列
 *
 * @author YFC
 * @create 2020-04-12 下午 6:30
 */
public class CircleQueue {


    // 数组最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 用数组模拟队列
    private int[] arr;


    public CircleQueue(){

    }


    public CircleQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        // 队列头，指向第一个元素的前一个位置
        this.front = -1;
        // 队列尾，指向当前元素的位置
        this.rear = -1;
    }

    // 队列是否已满
    public boolean isFull(){
        return (front+rear)%maxSize == maxSize-1;
    }

    // 队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 添加元素到队列
    public void addQueue(int num){
        if(isFull()){
            System.out.println("队列已满，无法添加元素到队列!!!");
            return;
        }
    }



}
