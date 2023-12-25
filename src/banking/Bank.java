package banking;

import java.util.ArrayList;

public class Bank {
    //เก็บทุกบัญชีที่สมัครสำเร็จไว้ที่ accounts
    private ArrayList<Account> accounts = new ArrayList<>();

    //เพิ่มบัญชีใหม่
    public void addAccount(Account account){
        accounts.add(account);
    }

    //ลบบัญชีตามหมายเลขบัญชี
    public void removeAccount(long accountNumber){
        
    }

    //ดึงข้อมูลบัญชีตามหมายเลขบัญชี
    public Account getAccount(long accountNumber){
        for(Account account : accounts){
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }

    //แสดงข้อมูลทุกบัญชีในระบบ
    public void displayAllAcounts(){
        for(Account account : accounts){
            account.displayAccountInfo();
        }
    }
}
