package linkedlist;

public class CircularLinkedList {

    private DoubleLinkedList linkedList=new DoubleLinkedList();

    public CircularLinkedList(DoubleLinkedList linkedList){
        this.linkedList=linkedList;
        endToEnd();
    }

    private void endToEnd(){
        int len=linkedList.getLength();
        Node nodeEnd=linkedList.getNodeFromPosition(len);
        Node nodeBegin=linkedList.getNodeFromPosition(1);
        nodeEnd.next=nodeBegin;
        nodeBegin.pre=nodeEnd;
    }

    public void test(){
        Node temp=linkedList.getNodeFromPosition(1);
        for (int i=0;i<100;i++){
            System.out.println(temp.toString());
            temp=temp.next;
        }
    }

}
