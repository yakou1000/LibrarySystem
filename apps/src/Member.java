import java.util.*;

public class Member{
    private int memberId;
    final String name;
    private boolean ooo;
    private ArrayList<Book> ownList;

    /*
     * コンストラクタ
     */
    public Member(String name,boolean ooo,int id){
        this.name = name;
        this.memberId = id;
        this.ooo = ooo;
        this.ownList = new ArrayList<>();
        //ID(登録番号)を生成する
    }

    /*
     * 借りている本の数を返す
     */
    public int numOwn(){
        return this.ownList.size();
    }
}