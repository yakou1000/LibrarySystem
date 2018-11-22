import java.util.*;

public class MemberDataBase{
    private ArrayList<Member> memberList;
    private int memberCounter;

    //コンストラクタ
    public MemberDataBase() {
        this.memberList = new ArrayList<>();
        this.memberCounter = 1;
    }


    //会員登録するメソッド
    public void register(String name){
        Member newMember = new Member(name,false,memberCounter);


        //エラーチェック:IDが同じ会員が存在していたら登録しない
        if(this.memberInformation(memberCounter).isEmpty()) {
            memberCounter += 1;
            memberList.add(newMember);
        }else{
            System.out.println("This ID is already used");
            return;
        }
    }

    //会員を退会するメソッド
    public void leave(int id){
        if(memberInformation(id).isEmpty()){
            System.out.println("This member is not exist");
        }else{
            memberList.remove(memberList.indexOf(this.memberInformation(id).get(0)));
        }
    }

    //会員情報を変更するメソッド
    public void changeOoo(int id,boolean newOoo){
        memberInformation(id).get(0).setOoo(newOoo);
    }

    public void changeName(int id,String name){
        memberInformation(id).get(0).setName(name);
    }


    //名前から会員情報を返すメソッド
    //同じ名前の会員をまとめてリストにして返す
    public ArrayList<Member> memberInformation(String name){
        ArrayList<Member> ret = new ArrayList<>();
        for(Member m:memberList){
            if(m.getName().toLowerCase().contains(name.toLowerCase())){
                ret.add(m);
            }
        }
        return ret;
    }

    //idから会員情報を返すメソッド
    //扱いを一元化するためにリストで返す
    public ArrayList<Member> memberInformation(int id){
        ArrayList<Member> ret = new ArrayList<>();
        for(Member m:memberList){
            if(m.getId() == id){
                ret.add(m);
            }
        }
        return ret;
    }

    //全会員を表示するメソッド
    public void viewAllMembers(){
        for(Member m:memberList){
            System.out.print("ID:" + m.getId() + ", NAME:" + m.getName() + ", numOwn:" + m.numOwn() + ", ");
            if(m.getOoo()){
                System.out.println("大岡山住み");
            }else{
                System.out.println("大岡山以外住み");
            }
        }
        System.out.println(" ");
    }

}

