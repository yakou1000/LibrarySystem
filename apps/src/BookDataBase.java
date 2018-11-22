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

        //エラーチェック:IDが同じ本が存在していたら登録しない
        if(this.bookInformation(bookCounter).isEmpty()) {
            bookCounter += 1;
            bookList.add(newBook);
        }else{
            System.out.println("This ID is already used");
            return;
        }
    }

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

    //idから本情報を返すメソッド
    //扱いを一元化するためにリストで返す
    public ArrayList<Book> bookInformation(int id){
        ArrayList<Book> ret = new ArrayList<>();
        for(Book b:bookList){
            if(b.getId() == id){
                ret.add(b);
            }
        }
        return ret;
    }

    //idから本を廃棄するメソッド
    public void discard(int id){
        if(this.bookInformation(id).isEmpty()) {
            System.out.println("This book is not exist");
            return;
        }else{
            bookList.remove( bookList.indexOf(this.bookInformation(id).get(0)) );
        }
    }
    /*

    //本を貸し出すメソッド
    public void lend(){

    }

    //本を返却されるメソッド
    public void recieve(){

    }
    */

    //ユーザーが本を検索するメソッド
    public void search(String name){
        //文字列が一部一致している本の名前・idをセットで出力する
        //拡張案：貸し出し状況の表示、貸し出し中の場合は返却予定日を表示
        int num = 0;    //本の数
        for(Book b:bookList){
            if(b.getName().toLowerCase().contains(name.toLowerCase())){
                System.out.print("ID:" + b.getId() + ", NAME:" + b.getName() + ", 貸出状況:");
                if(b.getLent()){
                    System.out.println("貸出中");
                }else{
                    System.out.println("貸出可");
                }
                num +=1;
            }
        }
        System.out.println("検索した文字列を含む本は" + num + "冊ありました");
    }


    //本の一覧を表示するメソッド
    public void viewAllBooks(){
        for(Book b:bookList){
            System.out.print("ID:" + b.getId() + ", NAME:" + b.getName() + ", 貸出状況:");
            if(b.getLent()){
                System.out.println("貸出中");
            }else{
                System.out.println("貸出可");
            }
        }
        System.out.println(" ");
    }

}