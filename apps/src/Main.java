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
        //本を検索する
        Book book1 = bdb.bookInfomation("2ndBook");
        Book book2 = bdb.bookInfomation("SecondBook");
        //本を廃棄する(idが一致したりしなかったりする)
        bdb.discard(book1.getId());
        bdb.viewAllBooks();
        bdb.discard(book2.getId());
        bdb.viewAllBooks();
        //再び登録する
        bdb.register("4thBook");
        bdb.register("5thBook");
        bdb.viewAllBooks();
    }
}