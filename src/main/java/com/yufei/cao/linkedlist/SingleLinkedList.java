package com.yufei.cao.linkedlist;

/**
 * 我爱java
 *
 * @author YFC
 * @create 2020-04-28 下午 11:10
 */
public class SingleLinkedList {

    /**
     * 单链表，我爱java，别人休息，我不休息，别人睡觉，我不睡觉，我就不信追不上。
     */

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.addNode(new HeroNode("1","宋江","及时雨"));
        linkedList.addNode(new HeroNode("2","卢俊义","玉麒麟"));
        linkedList.addNode(new HeroNode("3","吴用","智多星"));
        linkedList.addNode(new HeroNode("4","林冲","豹子头"));
        linkedList.addNode(new HeroNode("5","武松","行者"));
        linkedList.addNode(new HeroNode("6","鲁智深","花和尚"));

        System.out.println("修改之前: ---------- ");
        linkedList.list();

        linkedList.updateNode(new HeroNode("12","时迁","鼓上蚤"));

        System.out.println("修改之后: ---------- ");
        linkedList.list();


        System.out.println("删除编号后-------- ");
        //linkedList.deleteNode("3");
        //linkedList.deleteNode("2");
        //linkedList.deleteNode("1");
        //linkedList.deleteNode("4");
        //linkedList.deleteNode("5");
        linkedList.deleteNode("1");

        linkedList.list();


        int count = linkedList.count(linkedList.head);
        System.out.println("单链表的个数: "+ count);


        System.out.println("------------- 查找");

        //linkedList.search(3);
        linkedList.search(1);


    }


    /*
    单链表：是链式存储，结构不是连续的。
     */

   static class LinkedList {

        private HeroNode head = new HeroNode("", "", "");

        // 添加英雄节点
        // 思路： 添加节点，是要追加到最后一个节点的后一个位置
        public void addNode(HeroNode node) {
            HeroNode temp = head;

            while (true){
                if(temp.next == null){
                    // 找到最后一个节点了
                    break;
                }
                temp = temp.next;
            }

            temp.next = node;
        }

        // 修改节点数据 根据编号no 修改，但是编号 no 不能改变
       public void updateNode(HeroNode newNode){
            if(head.next == null){
                System.out.println("链表数据为空!!!");
                return;
            }

            HeroNode temp = head.next;
            boolean flag = false;
            while (true){
                if(temp == null){
                    break;
                }
                if(temp.no.equalsIgnoreCase(newNode.no)){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if(flag){
                temp.setName(newNode.name);
                temp.setNickName(newNode.nickName);
            }else{
                System.out.println("没有找到数据!!!");
            }
       }

       // 删除节点
       public void deleteNode(String no){
            // 根据no 删除
           if(head.next == null){
               System.out.println("链表为空!!!!");
               return;
           }

           HeroNode temp = head;
           boolean flag = false;
           while (true){
                if(temp.next == null){
                    break;
                }
                if(temp.next.no.equalsIgnoreCase(no)){
                   flag = true;
                    break;
                }
                temp = temp.next;
           }
           if(flag){
               temp.next = temp.next.next;
           }else{
               System.out.println("没有找到数据!!!");
           }


       }


       // 查找单链表的个数
       public int count(HeroNode head){
            if(head.next == null){
                return 0;
            }

            int length = 0;
            HeroNode cur = head.next;
            while (cur !=null){
                length++;
                cur = cur.next;
            }
            return length;
       }

       // 查找单链表的倒数第k 个节点
       /*
        思路分析：
        1.倒数第k 就是正数第 (单链表总数 - k)
        2.返回结果
        */

       public void search(int k){
          // int total = count();
          //
          // if(head.next == null || total<k){
          //     System.out.println("单链表节点为空!!!");
          //     return;
          // }
          //
          // HeroNode temp = head;
          //
          //int size =  count()-k+1;
          //
          // int count = 0;
          // while (true){
          //     if(temp.next == null){
          //         break;
          //     }
          //     if(count == size){
          //         // 找到这节点了
          //         System.out.println("当前倒数第 "+k+" 个节点是 "+temp);
          //         break;
          //     }
          //     temp = temp.next;
          //     count++;
          //
          // }


       }




        // 显示单链表
        public void list(){
            // 判断链表是否为空，为空就不要打印了
            // 要设置一个 辅助变量temp, 为什么要设置一个辅助变量，因为head 节点是不能动的
            if(head.next == null){
                // 节点是空，判断head 节点是否为空
                return;
            }

            HeroNode temp = head;
            while (true){
                if(temp.next == null){
                    // 节点为空，直接返回就行，不用打印了
                    return;
                }
                temp = temp.next;
                System.out.println(temp);
            }
        }

    }


    static class HeroNode {
        private String no;
        private String name;
        private String nickName;
        // 指向下一个节点
        private HeroNode next;


        public HeroNode(String no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public HeroNode getNext() {
            return next;
        }

        public void setNext(HeroNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no='" + no + '\'' +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }


}
