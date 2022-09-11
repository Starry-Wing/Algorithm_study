package data;

public class MyData {
    public int no;
    public int num;
    public String str;
    public String name;

    public MyData(){

    }

    public MyData(int no,String name,String str){
        this.no=no;
        this.name=name;
        this.str=str;
    }

    public MyData(int num){
        this.num=num;
    }

    public MyData(String name,String str){
        this.name=name;
        this.str=str;
    }

    public MyData(String str){
        this.str=str;
    }

}
