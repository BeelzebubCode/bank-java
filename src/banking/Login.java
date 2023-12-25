package banking;

import menuBank.Menu;

public class Login extends Account{ // แก้โดยไม่ต้องสืบทอดแต่สร้างตัวแปร Account ไว้ในคลาสได้

    public Login(String fName, String lName, String password) {
        super(fName, lName, password);
    }

    // ตรวจสอบว่ารหัสผ่านที่ป้อนนั้นตรงกับรหัสผ่านของ Account
    public boolean loginPassword(Account account, String password){
        if(password.equals(account.getPassWord())){
            Menu.createMessage("Login successful.");
            //System.out.println("Login successful.");
            return true;
        }
        else{
            Menu.createMessage("Login failed. Incorrect password.");
            //System.out.println("Login failed. Incorrect password.");
            return false;
        }
    }
}
