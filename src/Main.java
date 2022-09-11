import data.MyData;
import linkedlist.CircularLinkedList;
import linkedlist.DoubleLinkedList;
import linkedlist.Node;
import linkedlist.SingleLinkedList;
import stack.Calculator;
import stack.LinkedStack;

public class Main {
    public static void main(String[] args) {

        Calculator cal=new Calculator();
        cal.test();
    }

    static void test1(){
        Node luxian=new Node(new MyData("卢锡安","圣枪游侠"));
        Node yizeruier=new Node(new MyData("伊泽瑞尔","探险家"));
        Node gewen=new Node(new MyData("格温","灵罗娃娃"));

        DoubleLinkedList heros=new DoubleLinkedList();
        heros.add(luxian);
        heros.add(yizeruier);
        heros.add(gewen);
        heros.ergodic();
        System.out.println();

        heros.insertNode(3,new Node(new MyData("卡密尔","青钢影")));
        heros.ergodic();
        System.out.println(heros.getLength());
        System.out.println();

        heros.deleteNode(3);
        heros.ergodic();
    }

    static void test2(){
        Node luxian=new Node(new MyData("卢锡安","圣枪游侠"));
        Node yizeruier=new Node(new MyData("伊泽瑞尔","探险家"));
        Node gewen=new Node(new MyData("格温","灵罗娃娃"));

        DoubleLinkedList heros=new DoubleLinkedList();
        heros.add(luxian);
        heros.add(yizeruier);
        heros.add(gewen);

        LinkedStack heroStack=new LinkedStack(heros);
        System.out.println(heroStack.pop().name);
        System.out.println(heroStack.getTop().name);
        heroStack.push(new MyData("瑞文","放逐之刃"));
        System.out.println(heroStack.getTop().name);

    }


}
