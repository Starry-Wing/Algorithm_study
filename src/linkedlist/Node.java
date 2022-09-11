package linkedlist;

import data.MyData;

public class Node {

    public MyData data;
    public Node next;
    public Node pre;

    public Node(MyData data){
        this.data=data;
    }

    public String toString(){
        return "[no="+data.no+","+"str="+data.str+"]";
    }

}
