package stack;

import data.MyData;
import linkedlist.DoubleLinkedList;
import linkedlist.Node;

import java.util.Date;

public class LinkedStack {

    private DoubleLinkedList linkedList=new DoubleLinkedList();

    public LinkedStack(){

    }

    public LinkedStack(DoubleLinkedList linkedList){
        this.linkedList=linkedList;
    }

    public MyData getTop(){
        int i=linkedList.getLength();
        return linkedList.getNodeFromPosition(i).data;
    }

    public MyData pop(){
        int i=linkedList.getLength();
        MyData data=linkedList.getNodeFromPosition(i).data;
        linkedList.deleteNode(i);
        return data;
    }

    public void push(MyData data){
        linkedList.add(new Node(data));
    }

    public int getLenth(){
        return linkedList.getLength();
    }

    public boolean isEmpty(){
        if (getLenth()==0){
            return true;
        }
        return false;
    }

    public void ergodic(){
        linkedList.ergodic();
    }

}
