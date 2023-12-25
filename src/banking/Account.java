package banking;

import menuBank.Menu;

public class Account {
    private String fName, lName, password;
    private long accountNumber;
    private double balance;
    private static long nextAccountNumber = 1000000001;

    public Account(String fName, String lName, String password){
        this.fName = fName;
        this.lName = lName;
        this.password = password;

        accountNumber = nextAccountNumber;
        nextAccountNumber++;
        balance = 0;
    } 

    //ฝากเงินโดยรับ Account ที่จะฝากเงินเข้าไปกับจำนวนเงินที่ฝาก
    public void deposit(Account account, double amount){
        account.balance += amount;
    }

    //ถอนเงินโดยรับ Account ที่จะถอนเงินเข้าไปกับจำนวนเงินที่ถอน
    public void withdraw(Account account, double amount){
        if(amount <= account.balance){
            account.balance -= amount;
        }
        else{
            Menu.createMessage("The amount is not enough");
        }
    }

    //โอนเงินไปยังบัญชีที่ต้องการโดย รับเลขบัญชีปลายทางกับจำนวนเงินและ(Bankเพื่อหาบัญชีปลายทาง)
    public void transfer(long accountNumber, double amount, Bank bank){
        if(accountNumber == getAccountNumber()){
            Menu.createMessage("Unable to transfer money to your own account");
            return;
        }
        if(amount > 0 && amount <= getBalance()){
            //หาบัญชีปลายทางแล้วให้ตัวแปล targetAccount ชี้ไปที่ตัวแปลนั้นแล้วเปลี่ยนแปลค่าเงิน
            //ถ้าไม่เจอบัญชีปลายทางจะได้ null
            Account targeAccount = bank.getAccount(accountNumber);
            if(targeAccount != null){
                withdraw(this, amount);
                deposit(targeAccount, amount);
                Menu.createMessage("Transfer successful.");
            }
            else{
                Menu.createMessage("Target account not found.");
            }
        }
        else{
            Menu.createMessage("Invalid transfer amount.");
        }
    }

    public String getFName(){
        return fName;
    }

    public String getLName(){
        return lName;
    }

    public void setPassWord(String password){
        this.password = password;
    }

    public String getPassWord(){
        return password;
    }

    // ดึงยอดเงินในบัญชี
    public double getBalance(){
        return balance;
    }

    public long getAccountNumber(){
        return accountNumber;
    }

    //แสดงข้อมูลบัญชี
    public void displayAccountInfo(){
        System.out.println("\n====================== User ======================");
        System.out.println("Account Number : "+accountNumber);
        System.out.println("Account Holder name : "+fName+" "+lName);
        System.out.printf("Balance : %.2f",balance);
        System.out.println("\n==================================================");
    }

    @Override
    public String toString(){
        return "Account Number: "+accountNumber+"\nAccount Holder name: "+fName+" "+lName+"\nPassword your account: "+password+"\nBalance: "+balance;
    }
}
