import java.util.*;

public class BookDataBase{
    private ArrayList<Book> bookList;
    private int bookCounter;

    //コンストラクタ
    public BookDataBase(){
        bookList = new ArrayList<>();
        bookCounter = 1;
    }

    //本を登録するメソッド
    //本を登録して、bookCounterを1増やす
    public void register(String name){
        Book newBook = new Book(name,bookCounter);
        bookCounter += 1;
        bookList.add(newBook);
    }

    //名前から本情報を返すメソッド
    public Book bookInfomation(String name){
        for(Book b:bookList){
            if(b.getName().equals(name)){
                return b;
            }
        }
        System.out.println("This book don't exist");
        return null;
    }

    //idから本情報を返すメソッド
    public Book bookInfomation(int id){
        for(Book b:bookList){
            if(b.getId() == id){
                return b;
            }
        }
        System.out.println("This book don't exist");
        return null;
    }

    //本を廃棄するメソッド
    public void discard(int id){
        Book removeBook = this.bookInfomation(id);
        if(removeBook != null){
            bookList.remove(bookList.indexOf(removeBook));
        }
    }
    /*

    //本を貸し出すメソッド
    public void lend(){

    }

    //本を返却されるメソッド
    public void recieve(){

    }

    //ユーザーが本を検索するメソッド
    public void search(String name){
        //文字列が一部一致している本の名前・idをセットで出力する
        //拡張案：貸し出し状況の表示、貸し出し中の場合は返却予定日を表示
    }

    */

    //本の一覧を表示するメソッド
    public void viewAllBooks(){
        for(Book b:bookList){
            System.out.println("ID:" + b.getId() + " NAME:" + b.getName());
        }
    }

}