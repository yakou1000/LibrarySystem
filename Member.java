import java.util.*;

public class Member{
    private int memberId;
    final String name;
    private boolean ooo;
    private Arraylist<Book> ownList;

    /*
     * コンストラクタ
     */
    public Member(String name,boolean ooo){
        this.name = name;
        this.ooo = ooo;
        this.ownlist = new Arraylist<>();
        //ID(登録番号)を生成する
    }

    /*
     * 借りている本の数を返す
     */
    public int numOwn(){
        return this.ownList.size();
    }
}