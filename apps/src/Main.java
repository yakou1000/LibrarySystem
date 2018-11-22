//import java.util.*;

public class Main{

    //ユーザー対話型になるようにメソッドを定義
    //main内ではwhileループする
    //quitを忘れない


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

        //会員登録
        ls.regMember("Man1");
        ls.regMember("Woman1");
        ls.regMember("Man2");
        //会員情報変更
        ls.getMemberDB().memberInformation(2).get(0).setOoo(true);
        ls.viewAllMembers();
        //貸出手続き
        //正常な手続き
        ls.lendBook(1,1);
        ls.lendBook(2,6);
        //すでに借りられている手続き
        ls.lendBook(1,1);
        //メンバーIDが間違っている
        ls.lendBook(4,3);
        //BookIDが間違っている
        ls.lendBook(1,30);
        //これ以上借りられない
        ls.lendBook(1,3);
        ls.lendBook(1,4);
        ls.lendBook(1,5);

        ls.viewAllBooks();
        ls.viewAllMembers();

        //返却手続き
        //メンバーIDが間違っている
        ls.returnBook(4,5);
        //本IDが間違っている
        ls.returnBook(1,30);
        //借りていない本を返そうとする
        ls.returnBook(1,5);
        //正常な手続き
        ls.returnBook(1,1);
        ls.returnBook(1,3);
        ls.returnBook(1,4);
        ls.returnBook(2,6);

        ls.viewAllBooks();
        ls.viewAllMembers();

        //2回目以降の貸出手続き、返却予定日がどうなるか
        ls.lendBook(2,1);

        ls.viewAllBooks();
        ls.viewAllMembers();


    }
}