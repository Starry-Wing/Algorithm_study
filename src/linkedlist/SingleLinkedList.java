package linkedlist;

import data.MyData;

public class SingleLinkedList {

    MyData data=new MyData(0);
    //先初始化一个头节点，头节点不要动
    private Node head=new Node(data);

    public void add(Node node){
        Node temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }

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

}
