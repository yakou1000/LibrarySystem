//import java.util.*;

public class Main{
    public static void main(String[] args){
        BookDataBase bdb = new BookDataBase();
        MemberDataBase mdb = new MemberDataBase();

        //本を登録する
        bdb.register("FirstBook");
        bdb.register("SecondBook");
        bdb.register("ThirdBook");
        bdb.viewAllBooks();
        //本を廃棄する(idが一致したりしなかったりする
        bdb.discard(4);
        bdb.viewAllBooks();
        bdb.discard(2);
        bdb.viewAllBooks();
        //再び登録する
        bdb.register("4thBook");
        bdb.register("5thBook");
        //同じ名前の本を登録する
        bdb.register("FirstBook");
        bdb.register("SecondBook");
        bdb.register("日本語の本です");
        bdb.register("日本語の本その一");
        bdb.viewAllBooks();
        //本を検索する
        bdb.search("cond");
        bdb.search("first");
        bdb.search("First");
        bdb.search("Book");
        bdb.search("一");
        //本の貸し出し状況を変更する
        bdb.bookInformation(3).get(0).setLent(true);
        bdb.viewAllBooks();
    }
}