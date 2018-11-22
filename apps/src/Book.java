import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Book{
    final int id;               //本ID
    final String name;          //本の名前
    private boolean lent;       //貸し出し状況
    private Calendar returnDate;    //返却予定日
    final Calendar registerDate;  //本の登録日
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    //コンストラクタ
    public Book(String name,int id){
        this.id = id;                       //本DBのメソッドから生成
        this.name = name;                   //本の名前
        this.lent = false;                  //貸し出し中かどうか
        this.registerDate = Calendar.getInstance();     //本を登録した日付
    }

    //getter
    public int getId(){
        return this.id;
    }

    //getter
    public String getName(){
        return this.name;
    }

    //setter
    public void setLent(boolean b){
       this.lent = b;
    }

    //getter
    public boolean getLent(){
        return this.lent;
    }

    //setter
    public void setReturnDate(Date d){
        this.returnDate = d;
    }

    //getter
    public Calendar getReturnDate(){
        return this.returnDate;
    }

    //getter
    public Calendar getRegisterDate(){
        return this.registerDate;
    }


}