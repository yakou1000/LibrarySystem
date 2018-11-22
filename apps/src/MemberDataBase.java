import java.util.*;

public class MemberDataBase{
    private ArrayList<Member> memberList;
    private int memberCounter;

    //コンストラクタ
    public MemberDataBase() {
        this.memberList = new ArrayList<>();
        this.memberCounter = 1;
    }


    //会員登録するメソッド
    public void register(String name){
        Member newMember = new Member(name,false,memberCounter);

        /*
        //エラーチェック:IDが同じ会員が存在していたら登録しない
        if(this.bookInformation(bookCounter).isEmpty()) {
            bookCounter += 1;
            bookList.add(newBook);
        }else{
            System.out.println("This ID is already used");
            return;
        }
        */
    }

    //会員を退会するメソッド
    public void leave(){

    }

    //会員情報を変更するメソッド
    public void change(){

    }

    //todo:以下を変更
    //名前から本情報を返すメソッド
    //同じ名前の本をまとめてリストにして返す
    public ArrayList<Book> bookInformation(String name){
        ArrayList<Book> ret = new ArrayList<>();
        for(Book b:bookList){
            if(b.getName().equals(name)){
                ret.add(b);
            }
        }
        return ret;
    }

    //idから会員情報を返すメソッド
    //扱いを一元化するためにリストで返す
    public ArrayList<Member> memberInformation(int id){
        ArrayList<Member> ret = new ArrayList<>();
        for(Member b:memberList){
            if(b.getId() == id){
                ret.add(b);
            }
        }
        return ret;
    }

}

