package stack;

/**
 * 使用栈来实现计算一串数字
 *
 * @author YFC
 * @create 2020-05-10 下午 3:45
 */
public class CalculateStackDemo {


    public static void main(String[] args) {
        /*
        需求：传入一串字符串，计算其结果 ，例如： 5*6-2+3*5-6 = ?
        思路分析：
        1. 设计两个栈，一个存数据numStack, 一个存符号operatorStack;设计一个 index 指针来指向字符串中的每个字符
        2. 判断第一个字符是数字还是运算符，是数字，就入数据栈。如果是字符，判断字符栈是否为空，为空则入字符栈。
            不为空，判断当前字符的优先级是否小宇或等于栈中字符的优先级。
                - 是：  则pop 出数据栈两个数据、pop出字符栈中一个字符进行计算，结果入到数据栈中。
                - 否： 则字符入对应的栈
        3. 最后两个栈中的结果进行计算。数据栈的栈顶元素即为最终计算的结果。
         */

        //ArrayStack stack = new ArrayStack(3);
        //
        //stack.push(3);
        //stack.push(1);
        //stack.push(2);
        //
        //stack.list();
        //
        //stack.pop();
        //stack.pop();
        //
        //System.out.println("取出数据后...");
        //
        //stack.list();

        //stack.push(2);



        String operation = "3+7-6*1+1-2"; // 这个例子就计算的有问题。 - - 得正
        operation = "29+3-4*2";

        ArrayStack numStack = new ArrayStack(15);
        ArrayStack operStack = new ArrayStack(15);
        clean(numStack, operStack);

        int index = 0;
        int num1,num2,oper,result;
        String keepNum = "";

        char ch = ' ';
        while (true){
            // 取出每个字符
            ch = operation.substring(index, index+1).charAt(0);

            // 判断字符是数字或运算符
            if(numStack.isOper(ch)){
                // 是运算符，判断运算符栈是否有数据
                if(operStack.isEmpty()){
                    // 是空，加数据直接添
                    operStack.push(ch);
                }else {
                    // 不是空，判断运算符的优先级是否大于运算符栈顶优先级
                    if(operStack.priority(ch) > operStack.priority(operStack.peek())){
                        // 如果当前运算符大于运算符栈-栈顶元素的优先级，则直接入栈
                        operStack.push(ch);
                    }else {
                        // 如果当前运算符小于等于运算符栈-栈顶元素的优先级，
                        // ① pop 出数据栈的2个数据并计算，并push 数据栈。
                        // ② push 运算符到运算符栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        result = numStack.calculator(num1, num2, oper);
                        numStack.push(result);
                        operStack.push(ch);
                    }
                }
            }else{ // 如果是数据，直接入栈  参考 ASCII码对照表
                //numStack.push(ch - 48);
                /*
                 如果是最后一个字符，就直接入栈
                 假如数字遇到的是多位数，我们就需要继续扫描
                 */
                keepNum += ch;

                if(index == operation.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if(numStack.isOper(operation.substring(index + 1, index + 2).charAt(0))){
                        // 判断下一个字符是否是数字，是数字就拼接
                        numStack.push(Integer.parseInt(keepNum));
                        // 将keepNum 置为空
                        keepNum = "";
                    }
                }
            }
            index++;
            if(index >= operation.length()){
                break;
            }
        }


        // 最后将数据栈中数据和运算符栈中数据pop 出进行计算
        while (true){

            // 如何停止- 运算符栈空
            if(operStack.isEmpty()){
                break;
            }

            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();

            result = numStack.calculator(num1, num2, oper);
            numStack.push(result);
        }
        System.out.printf("%s = %d",operation,numStack.pop());
        System.out.println();
   }

    private static void clean(ArrayStack numStack, ArrayStack operStack) {
        while (true){
            if (numStack.isEmpty() && operStack.isEmpty()) {
                break;
            }
            if(!operStack.isEmpty()){
            operStack.pop();
            }
            if(!numStack.isEmpty()){
                numStack.pop();
            }
        }
    }


    /*
     总结：
     1.自己的逻辑有待加强
     2.从复用方面考虑
     */

    static class ArrayStack {


        public static void main(String[] args) {
            String operation = "3+2*5-6";
            System.out.println(operation.substring(1,2).charAt(0));
        }




        // 栈最大数量
        private int maxSize;

        // 数组模拟栈
        private int[] stack;

        // 栈顶元素
        private int top = -1;


        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            // 初始化栈
            this.stack = new int[this.maxSize];
        }

        // 显示栈顶元素数据
        public int peek(){
            return stack[top];
        }


        // 判断栈是否已满
        public boolean isFull() {
            return maxSize - 1 == top;
        }


        // 判断栈是否为空
        public boolean isEmpty() {
            return top == -1;
        }

        // 入栈
        public void push(int num) {
            /*
            1. 判断栈是否已满
                - 不满，则添加到栈,top 上移
                - 满，不处理
             */

            if (isFull()) {
                System.out.println("栈已满，无法添加数据!!!");
                return;
            }
            stack[++top] = num;
        }

        // 出栈
        public int pop() {
            /*
            1. 判断栈是否为空
                - 是 返回不处理
                - 否 出栈，top 下移
             */

            if (isEmpty()) {
                throw new RuntimeException("栈数据为空，无法取数据!!!");
            }

            return stack[top--];
        }

        // 打印栈元素
        public void list(){
            /*
            1. 判断栈是否为空
                - 是 不处理
                - 否 打印栈所有有效元素
             */
            if(isEmpty()){
                System.out.println("栈数据为空,无法打印数据!!!");
                return;
            }

            for (int i = top; i >=0; i--) {
                System.out.printf("stack[%d] = %d",i,stack[i]);
                System.out.println();
            }
        }


        /*
        获取运算符的优先级
        定义： * 、/ 优先级 1 , + 、- 优先级 0 , 其它为 -1
         */
        public int priority(int ch){
            int priority;
            if(ch == '*' || ch == '/'){
                priority = 1;
            }else if (ch == '+' || ch == '-'){
                priority = 0;
            }else {
                priority = -1;
            }
            return priority;
        }


        // 判断当前字符是否为运算符
        public boolean isOper(char ch){
            return ch == '+' ||  ch == '-' ||  ch == '*' || ch == '/';
        }

        // 计算两个数的结果
        public int calculator(int num1,int num2, int oper){
            int result = 0;
            switch (oper){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num2-num1;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num2/num1;
                    break;
                default:
                    break;
            }
            return result;
        }
    }


}
