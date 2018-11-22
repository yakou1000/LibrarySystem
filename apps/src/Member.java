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

    //getter群
    public int getId(){ return memberId; }

    public String getName(){ return name; }

    public boolean getOoo(){return ooo;}

    public ArrayList<Book> getOwnList(){return ownList;}

    //setter群
    public void setId(int id){ this.memberId = id;}

    public void setOoo(boolean ooo){ this.ooo = ooo;}

    //OwnListに対する操作
    //add,remove,numOwn,isMax

    //借りている本の数を返す
    public int numOwn(){
        return this.ownList.size();
    }

    //本を所有リストに入れる
    public void add(Book book){
        ownList.add(book);
    }

    //指定した順番の本を所有リストから削除
    public void remove(int index){
        ownList.remove(index);
    }

    //指定したbookオブジェクトを所有リストから削除
    public void remove(Book book){
        if(ownList.indexOf(book)>-1){
            ownList.remove(ownList.indexOf(book));
        }else{
            System.out.println("This book is not exist in the ownList");
        }

    }

    //所有リストを全削除
    public void clear(){
        ownList.clear();
    }

    //借りられる最大数借りているかどうかを返す
    public boolean isMax(){
        if(ooo){
            if(this.numOwn() < 5){
                return false;
            }else{
                return true;
            }
        }else{
            if(this.numOwn() < 3){
                return false;
            }else{
                return true;
            }
        }
    }
}