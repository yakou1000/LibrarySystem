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
        bdb.viewAllBooks();
    }
}