package linear;

/**
 * @Destription 环形队列
 * @author YFC
 * @create 2020-03-16 上午 11:54
 */
public class AnnularQueueDemo {

    public static void main(String[] args) {
        //AnnularQueue queue = new AnnularQueue(4);
        // 测试类  参考 ArrayQueueDemo.main();
    }


    // 数组模拟环形队列
    static class AnnularQueue{

        private int maxSize; // 队列最大数量
        private int front;// 队列头部，指向队列的第一个元素
        private int rear;// 队列尾部，指向队列有数据的最后一个元素后一个位置
        private int[] arr;// 模拟环形队列存放数据的数组

        public AnnularQueue(int queueMaxSize){
            this.maxSize = queueMaxSize;
            this.arr = new int[maxSize];
            // 队列头部和尾部默认都是0
        }

        // 队列对否已满
        public boolean isFull(){
            return  (rear+1) % maxSize == front;
        }

        // 队列是否为空
        public boolean isEmpty(){
            return front == rear;
        }

        // 队列的有效数据
        public int size(){
            return (rear+maxSize-front)%maxSize;
        }

       public void addQueue(int num){
            if(isFull()){
                System.out.println("队列已满，不能添加数据..");
                return;
            }
           // 因为rear 指向的是最后一个元素的后一个位置，所以直接在rear的下标赋值，将rear的下标往后移动
           // 因为考虑到环形列表，所以需要取模
            arr[rear] = num;
            rear = (rear+1)%maxSize;
        }

        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空，无法取出数据..");
            }
            /**
             * 取队列逻辑
             * 1. 将结果放到临时变量
             * 2. 设置front索引
             * 3. 将临时变量结果返回
             */
            int value = arr[front];
            front = (front+1)%maxSize;
            return value;
        }

        public void headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空，无法取出数据..");
            }
            System.out.println(arr[front]);
        }

        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列数据为空!!!");
                return;
            }
            // 遍历，肯定不能直接遍历数组，要考虑一下，最好画图。
            // 考虑到环形队列数组应该遍历有效个数， 从 front 开始， 到有效个数之间遍历。
            for (int i = front; i < front+size(); i++) {
                System.out.printf("arr[%d]=[%d]\n",i % maxSize, arr[i % maxSize]);
            }
            System.out.println();
        }





    }



}
