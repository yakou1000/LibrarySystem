import java.util.*;

public class LibrarySystem {
    private BookDataBase bookdb;
    private MemberDataBase memberdb;

    //コンストラクタ
    public LibrarySystem(){
        bookdb = new BookDataBase();
        memberdb = new MemberDataBase();
    }

    //getter
    public BookDataBase getBookDB(){
        return bookdb;
    }

    public MemberDataBase getMemberDB(){
        return memberdb;
    }

    //本を登録
    public void regBook(String name){
        bookdb.register(name);
    }

    //本を貸し出す
    public void lendBook(int memberID,int bookID){
        //memberIDが正しいものチェック
        if(memberdb.memberInformation(memberID).size()==0){
            System.out.println("This member is not exist");
            return;
        }
        Member m = memberdb.memberInformation(memberID).get(0);
        //その会員が貸出可能かをチェック
        if(m.isMax()){
            System.out.println("You cannot lend more books");
            return;
        }
        //bookIDが正しいものかをチェック
        if(bookdb.bookInformation(bookID).size()==0){
            System.out.println("This book is not exist");
            return;
        }
        Book b = bookdb.bookInformation(bookID).get(0);
        //その本が貸出可能かをチェック
        if(b.getLent()){
            System.out.println("This book is borrowed");
            return;
        }
        //本の貸出状況を変更する
        b.setLent(true);
        //返却予定日を算出
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //大岡山住みの人は3週間、そのほかの人は2週間先の日にちを算出
        if(m.getOoo()){
            cal.add(Calendar.DATE,21);
        }else{
            cal.add(Calendar.DATE,14);
        }
        //ReturnDateの値を更新
        b.setReturnDate(cal.getTime());
        //会員の所有リストに本を追加
        m.add(b);
        //printfデバッグ
        System.out.println("Finish process");
    }

    //本を検索
    public void searchBook(String name){
        bookdb.search(name);
    }

    //本の一覧を表示
    public void viewAllBooks(){
        bookdb.viewAllBooks();
    }

    //本を返却
    public void returnBook(int memberID,int bookID){
        //memberIDが正しいものチェック
        if(memberdb.memberInformation(memberID).size()==0){
            System.out.println("This member is not exist");
            return;
        }
        Member m = memberdb.memberInformation(memberID).get(0);
        //bookIDが正しいものかをチェック
        if(bookdb.bookInformation(bookID).size()==0){
            System.out.println("This book is not exist");
            return;
        }
        Book b = bookdb.bookInformation(bookID).get(0);
        //その本が借りられているかをチェック
        if(!(b.getLent())){
            System.out.println("This book didn't be borrowed");
            return;
        }
        //その会員がその本を借りているかをチェックし、借りていたら所有リストから削除する
        for(Book book:m.getOwnList()){
            if(book.getId() == bookID){
                m.remove(book);
                book.setLent(false);
                System.out.println("Finish return process");
                return;
            }
        }
        System.out.println("You didn't borrow this book");
    }

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

    //ある会員の借りている本の一覧を表示
    public void viewOwnList(int memberID){
        //memberIDが正しいものチェック
        if(memberdb.memberInformation(memberID).size()==0){
            System.out.println("This member is not exist");
            return;
        }
        Member m = memberdb.memberInformation(memberID).get(0);
        System.out.println("NAME: " + m.getName() + " は" + m.getOwnList().size() + "冊借りています");
        if(m.getOwnList().size()!=0){
            for(Book b:m.getOwnList()){
                System.out.println("ID:" + b.getId() + ", NAME:" + b.getName() + ", 返却予定日:" + b.RetDateString());
            }
        }
        System.out.println(" ");
    }
}
