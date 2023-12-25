package banking;

import java.util.Scanner;
import menuBank.*;

public class Registration {
    private Bank bank;
    private Scanner sc;
    private Menu menuPassword;

    public Registration(Bank bank){
        this.bank = bank;
        sc = new Scanner(System.in);
        menuPassword = new Menu();
    }

    public void register(){
        System.out.print("Enter frist name: ");
        String fName = sc.next();

        System.out.print("Enter last name: ");
        String lName = sc.next();

        while(true){
            String password = getPasswordForUser();
            if(checkPassword(password)){
                Account newAccount = new Account(fName,lName,password);
                bank.addAccount(newAccount);
                Menu.createMessage("Successfully applied for ID");
                newAccount.displayAccountInfo();
                break;
            }
            else{
                Menu.createMessage("Invalid password. Please try again.");
                //System.out.println("Invalid password. Please try again.");
            }
        }
    }

    private String getPasswordForUser(){
        menuPassword.menuPassword();
        System.out.print("Enter password: ");
        return sc.next();
    }

    // ตรวจสอบความถูกต้องของรหัสผ่าน
    private boolean checkPassword(String password){
        boolean validLingth = password.length() >= 8;
        boolean validUpperCase = checkUpperCase(password);
        boolean validLowerCase = checkLowerCase(password);
        System.out.println();
        // เช็คว่ารหัสที่ผู้ใช้ตั้งผิดพลาดตรงไหน
        if(!validLingth){
            //Menu.createMessage("!Password must be at least 8 characters long.");
            System.out.println("!Password must be at least 8 characters long.");
        }
        if(!validUpperCase){
            //Menu.createMessage("!Password must contain at least one uppercase letter.");
            System.out.println("!Password must contain at least one uppercase letter.");
        }
        if(!validLowerCase){
            //Menu.createMessage("!Password must contain at least one lowercase letter.");
            System.out.println("!Password must contain at least one lowercase letter.");
        }

        return validLingth && validUpperCase && validLowerCase;
    }

    // ตรวจว่ารหัสผ่านมีพิมพ์ใหญ่ **ทำให้ code สั้นกว่านี้ได้
    private boolean checkUpperCase(String password){
        boolean checkUpperCase = false;

        for(char ch : password.toCharArray()){
            if(Character.isUpperCase(ch)){
                checkUpperCase = true;
                break;
            }
        }
        return checkUpperCase;
    }

    //ตรวจว่ารหัสผ่านมีพิมพ์เล็ก **ทำให้ code สั้นกว่านี้ได้
    private boolean checkLowerCase(String password){
        boolean checkLowerCase = false;

        for(char ch : password.toCharArray()){
            if(Character.isLowerCase(ch)){
                checkLowerCase = true;
                break;
            }
        }
        return checkLowerCase;
    }

    //Method repassword
    public void rePassword(long numberAccount){
        Account rePassword = bank.getAccount(numberAccount);
        String newPassword = "";

        while(true){
            if(rePassword != null){
                System.out.print("Enter your new password : ");
                newPassword = sc.next();

                if(checkPassword(newPassword)){
                    System.out.print("Enter your new password again : ");
                    String aginPassword = sc.next();

                    if(aginPassword.equals(newPassword)){
                        rePassword.setPassWord(newPassword);
                        Menu.createMessage("Successfully set a new password.");
                        break;
                    }
                    else{
                        Menu.createMessage("The password is incorrect.");
                    } // if aginPassword
                } // if checkPassword
                else{
                    Menu.createMessage("Invalid password. Please try again.");
                }
            } // if check null
            else{
                Menu.createMessage("This account was not found.");
                return;
            }
        }
    } 
} // class Registration
