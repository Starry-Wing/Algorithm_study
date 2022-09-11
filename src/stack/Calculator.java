package stack;


import data.MyData;
import linkedlist.DoubleLinkedList;
import linkedlist.Node;

import java.util.Objects;
import java.util.Scanner;

//计算器
public class Calculator {

    public void test(){
        Scanner input=new Scanner(System.in);
        String expr=input.next();
        start(expr);
    }

    //开始运算
    public void start(String expr){
        DoubleLinkedList exprList=getList(expr);

        LinkedStack numStack=new LinkedStack();
        LinkedStack operStack=new LinkedStack();

        String str="";

        for (int i=1;i<=exprList.getLength();i++){
            str=exprList.getNodeFromPosition(i).data.str;
            if (isNum(str)){
                numStack.push(new MyData(str));
            }else if (isOper(str)){
                if (operStack.isEmpty()){
                    operStack.push(new MyData(str));
                }else {
                    if (priority(str)>priority(operStack.getTop().str)){
                        operStack.push(new MyData(str));
                    }else {
                        int numA=Integer.parseInt(numStack.pop().str);
                        int numB=Integer.parseInt(numStack.pop().str);
                        String op=operStack.pop().str;

                        int numC=getResult(numB,numA,op);
                        numStack.push(new MyData(String.valueOf(numC)));
                        operStack.push(new MyData(str));
                    }
                }
            }

        }

        while (numStack.getLenth()>1){
            int numA=Integer.parseInt(numStack.pop().str);
            int numB=Integer.parseInt(numStack.pop().str);
            String op=operStack.pop().str;

            int numC=getResult(numB,numA,op);
            numStack.push(new MyData(String.valueOf(numC)));
        }

        System.out.println(numStack.pop().str);


    }


    //判断是不是运算符
    private boolean isOper(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/';
    }

    private boolean isOper(String ch){
        return Objects.equals(ch, "+") || Objects.equals(ch, "-") || Objects.equals(ch, "*") || Objects.equals(ch, "/");
    }

    //判断是不是数字
    private boolean isNum(char ch){
        String str="";
        str=str+ch;
        return str.matches("\\d+");
    }

    private boolean isNum(String ch){
        return ch.matches("\\d+");
    }

    //获取运算符优先级
    private int priority(String ch){
        if (Objects.equals(ch, "*") || Objects.equals(ch, "/")){
            return 2;
        }else if (Objects.equals(ch, "+") || Objects.equals(ch, "-")){
            return 1;
        }
        return -1;
    }

    //运算操作
    private int getResult(int a,int b,String ch){
        switch (ch){
            case "+":return a+b;
            case "-":return a-b;
            case "*":return a*b;
            case "/":return a/b;
        }
        return -999;
    }

    //将表达式字符串拆解依次装入线性表
    private DoubleLinkedList getList(String expr){

        if (isOper(expr.charAt(expr.length()-1))){
            System.out.println("表达式格式错误!");
            return null;
        }

        DoubleLinkedList exprList=new DoubleLinkedList();
        //int index=0;
        char ch;
        String str="";
        for (int i=0;i<expr.length();i++){
            ch=expr.charAt(i);
            if (isOper(ch)){
                str=str+ch;
                exprList.add(new Node(new MyData(str)));
                str="";
            }
            else if (isNum(ch)){
                while (true){
                    str=str+ch;
                    i++;
                    if (i>=expr.length()){
                        exprList.add(new Node(new MyData(str)));
                        break;
                    }
                    ch=expr.charAt(i);
                    if (isNum(ch)){
                    }else {
                        exprList.add(new Node(new MyData(str)));
                        i--;
                        break;
                    }
                }
                str="";
            }else {
                System.out.println("表达式格式错误!");
                return null;
            }
        }

        return exprList;
    }


}
