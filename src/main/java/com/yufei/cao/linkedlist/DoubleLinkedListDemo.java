package com.yufei.cao.linkedlist;

/**
 * 双向链表
 *
 * @author YFC
 * @create 2020-05-06 下午 9:05
 */
public class DoubleLinkedListDemo {


    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();

        linkedList.addNode(new DoubleLinked("1","宋江","及时雨"));
        linkedList.addNode(new DoubleLinked("2","卢俊义","玉麒麟"));
        linkedList.addNode(new DoubleLinked("3","吴用","智多星"));
        //linkedList.addNode(new DoubleLinked("4","林冲","豹子头"));
        //linkedList.addNode(new DoubleLinked("5","武松","行者"));
        //linkedList.addNode(new DoubleLinked("6","鲁智深","花和尚"));

        System.out.println("初始列表为：");
        linkedList.list();

        System.out.println("添加节点，列表为：");
        linkedList.addNode(new DoubleLinked("6","鲁智深","花和尚"));
        linkedList.list();

        System.out.println("删除节点，列表为：");
        linkedList.removeNode(new DoubleLinked("3","吴用","智多星"));
        linkedList.list();

        System.out.println("更新节点，列表为：");
        linkedList.updateNode(new DoubleLinked("6","鲁提辖","小花"));
        linkedList.list();

    }


   static class DoubleLinkedList{


        public DoubleLinkedList(){

        }

        private DoubleLinked head = new DoubleLinked();


        // 遍历链表
        public void list(){
            // 判断链表是否为空
            if(head.next == null){
                System.out.println("链表为空!!!");
                return;
            }

            DoubleLinked temp = head;

            // 不为空，遍历链表
            while (true){
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
                System.out.println(temp);
            }
        }


        // 添加节点
        public void addNode(DoubleLinked node){
            /*
              暂时只考虑追加到最后一个节点的下一个节点位置
             思路：1. 遍历找到最后一个节点 2.设置最后一个节点的next节点为当前要添加的节点
             */
            if(head.next == null){
                head.next = node;
                node.prev = head;
                return;
            }

            DoubleLinked temp = head.next;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }

        // 删除链表的节点
        public void removeNode(DoubleLinked node){

            /*
            思路：之前单链表删除是先找到要删除节点的上一个节点，再删除。
            双向链表不用，因为有prev 属性，所以可以直接找要删除的节点
            1. 声明一个temp 节点，找到要删除的节点用temp 指向
            2. 当前节点的上一个节点的下一个节点 指向 当前节点的下一个节点;即: temp.prev.next = temp.next;
               当前节点的下一个节点的上一个节点 指向 当前节点的上一个节点;即：temp.next.prev = temp.prev;
             */

            if(head.next == null){
                System.out.println("当前链表为空!!!");
                return;
            }

            DoubleLinked temp = head.next;
            while (true){
                if(temp.next == null){
                    System.out.println("找到最后一个节点了...");
                    break;
                }
                if(temp.getNo().equalsIgnoreCase(node.getNo())){
                    // 已找到此节点
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    break;
                }
                temp = temp.next;
            }
        }

        // 修改链表数据
        public void updateNode(DoubleLinked node){

            if(head.next == null){
                System.out.println("当前链表为空!!!");
                return;
            }

            DoubleLinked temp = head;
            while (true){
                if(temp == null){
                    System.out.println("找到最后一个节点了...");
                    break;
                }
                if(temp.getNo().equalsIgnoreCase(node.getNo())){
                    // 已找到此节点
                    temp.name = node.name;
                    temp.nickName = node.nickName;
                    break;
                }
                temp = temp.next;
            }
        }


    }



    static class DoubleLinked{
        private String no;
        private String name;
        private String nickName;

        private DoubleLinked next;
        private DoubleLinked prev;

        public DoubleLinked(){
            this("","","");
        }

        public DoubleLinked(String no, String name, String nickName) {
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

        public DoubleLinked getNext() {
            return next;
        }

        public void setNext(DoubleLinked next) {
            this.next = next;
        }

        public DoubleLinked getPrev() {
            return prev;
        }

        public void setPrev(DoubleLinked prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "DoubleLinked{" +
                    "no='" + no + '\'' +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }




}
