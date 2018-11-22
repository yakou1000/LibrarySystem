//import java.util.*;

public class Main{
    public static void main(String[] args){
        LibrarySystem ls = new LibrarySystem();

        //本を登録する
        ls.regBook("FirstBook");
        ls.regBook("SecondBook");
        ls.regBook("ThirdBook");
        ls.viewAllBooks();
        //本を廃棄する(idが一致したりしなかったりする
        ls.discardBook(4);
        ls.viewAllBooks();
        ls.discardBook(2);
        ls.viewAllBooks();
        //再び登録する
        ls.regBook("4thBook");
        ls.regBook("5thBook");
        //同じ名前の本を登録する
        ls.regBook("FirstBook");
        ls.regBook("SecondBook");
        ls.regBook("日本語の本です");
        ls.regBook("日本語の本その一");
        ls.viewAllBooks();
        //本を検索する
        ls.searchBook("cond");
        ls.searchBook("first");
        ls.searchBook("First");
        ls.searchBook("Book");
        ls.searchBook("一");
        //本の貸し出し状況を変更する
        ls.getBookDB().bookInformation(3).get(0).setLent(true);
        ls.viewAllBooks();

        //会員登録
        ls.regMember("Man1");
        ls.regMember("Woman1");
        ls.regMember("Man2");
        //会員情報変更
        ls.getMemberDB().memberInformation(2).get(0).setOoo(true);
        ls.getMemberDB().memberInformation(1).get(0).add(ls.getBookDB().bookInformation(1).get(0));
        ls.viewAllMembers();

    }
}