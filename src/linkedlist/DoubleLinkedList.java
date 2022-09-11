package linkedlist;

import data.MyData;

public class DoubleLinkedList {

    private MyData data=new MyData(0);
    private Node head=new Node(data);

    //自动整理排序
    private void sort(){
        Node temp=head;
        for (int i=0;temp!=null;temp=temp.next,i++){
            temp.data.no=i;
        }
    }

    //在末尾添加节点
    public void add(Node node){
        Node temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }

        temp.next=node;
        node.pre=temp;
        node.data.no=temp.data.no+1;

    }

    //遍历双链表
    public void ergodic(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node temp=head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp.toString());
            temp=temp.next;
        }
    }

    //判断节点是否存在
    public boolean isExist(Node node){
        if (head.next==null){
            return false;
        }

        for (Node temp=head.next;temp!=null;temp=temp.next){
            if (temp.data.no==node.data.no){
                return true;
            }
        }

        return false;
    }

    //根据位置获取节点
    public Node getNodeFromPosition(int i){
        for (Node temp=head.next;temp!=null;temp=temp.next){
            if (temp.data.no==i){
                return temp;
            }
        }
        return null;
    }

    //在指定位置插入节点,i>=1,不能插在头节点前，也不能插在尾节点后
    public void insertNode(int i,Node node){
        Node temp=getNodeFromPosition(i);
        node.pre=temp.pre;
        node.next=temp;
        temp.pre.next=node;
        temp.pre=node;
        sort();
    }

    //获取链表存储节点的个数
    public int getLength(){
        sort();
        Node temp;
        for (temp=head;temp.next!=null;temp=temp.next){

        }
        return temp.data.no;
    }

    //删除指定位置的节点（不能删除头节点）
    public void deleteNode(int i){
        Node temp=getNodeFromPosition(i);
        temp.pre.next=temp.next;
        if (temp.next!=null){
            temp.next.pre=temp.pre;
        }
        sort();

    }


}
