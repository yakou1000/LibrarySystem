import java.util.*;

public class LibrarySystemDemo(){
    private BookDataBase bdb;
    private MemberDataBase mdb;

    public static void main(String args[]){
            bdb = new BookDataBase();
            mdb = new MemberDataBase();

            //本を登録する
            bdb.register("FirstBook");
            bdb.register("SecondBook");
            bdb.register("ThirdBook");
            bdb.viewAllBooks();
            //本を廃棄する(名前が一致したりしなかったりする)
            bdb.discard("2ndBook");
            bdb.viewAllBooks();
            bdb.discard("SecondBook");
            bdb.viewAllBooks();
            //再び登録する
            bdb.register("4thBook");
            bdb.register("5thBook");
            bdb.viewAllBooks();
        }
}