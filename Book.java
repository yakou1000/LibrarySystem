import java.util.*;

public class Book{
    private int id;             //本ID
    final String name;        //本の名前
    private boolean lent;       //貸し出し状況
    private int returnDate[];  //返却予定日
    private int registDate[];  //本の登録日

    //コンストラクタ
    public Book(String name){
        this.name = name;
        lent = false;
        returnDate = {0,0,0};
    }
}