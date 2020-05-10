package stack;

/**
 * @author YFC
 * @create 2020-05-08 下午 10:52
 */
public class ArrayStackDemo {


    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(5);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(6);
        //stack.push(9);

        stack.list();

        System.out.println("--------------------");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        //stack.pop();
        //stack.pop();

        stack.list();

    }


    static class ArrayStack {

        // 栈最大数量
        private int maxSize;
        // 栈顶下标
        private int top = -1;
        // 数组模拟栈，存放数据
        private int[] stack;

        // 声明构造器
        public ArrayStack(int maxSize){
            this.maxSize = maxSize;
            stack = new int[this.maxSize];
        }

        // 判断栈是否已满
        public boolean isFull(){
            // 思路： 如何判断栈已满，判断栈的最大数量-1 是否和 栈顶 top 相等
            return maxSize-1 == top;
        }

        // 判断栈是否为空
        public boolean isEmpty(){
            return top == -1;
        }

        // 入栈 用push ，所以方法命名为 push
        public void push(int num){
            /*
            1. 判断栈是否已满
            2. 未满，入栈，已满，不处理
             */
            if(isFull()){
                System.out.println("栈已满，无法添加数据!!!");
                return;
            }
            stack[++top] = num;
        }

        // 出栈 用pop ，所以方法命名为 pop
        public int pop(){
            /*
            1. 判断栈是否为空
            2. 为空，抛异常； 不为空，出栈（直接返回 stack[top], top--）
             */
            if(isEmpty()){
                throw new RuntimeException("栈为空，无法取出栈顶数据!!!");
            }
            return stack[top--];
        }

        // 打印栈数据，因为是栈结构，需要从栈顶开始打印数据
        public void list(){
            if(isEmpty()){
                System.out.println("栈数据为空!!!");
                return;
            }
            for (int i = top; i >=0; i--) {
                System.out.printf("stack[%d]=%d\n",i,stack[i]);
            }
        }


    }


}
