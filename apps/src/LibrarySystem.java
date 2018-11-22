import java.util.*;

public class LibrarySystem {
    BookDataBase bookdb;
    MemberDataBase memberdb;

    //コンストラクタ
    public LibrarySystem(){
        bookdb = new BookDataBase();
        memberdb = new MemberDataBase();
    }

    //本を登録
    public void regBook(String name){
        bookdb.register(name);
    }

    //本を貸し出す

    //本を検索
    public void searchBook(String name){
        bookdb.search(name);
    }

    //本の一覧を表示
    public void viewAllBooks(){
        bookdb.viewAllBooks();
    }

    //本を返却

    //本を廃棄する
    public void discardBook(int id){
        bookdb.discard(id);
    }

    //会員登録
    public void regMember(String name){
        memberdb.register(name);
    }

    //会員退会
    public void discardMember(int id){
        memberdb.leave(id);
    }

    //会員情報変更

    //会員の一覧表示
    public void viewAllMembers(){
        memberdb.viewAllMembers();
    }
}
