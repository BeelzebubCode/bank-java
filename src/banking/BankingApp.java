package banking;

import java.util.InputMismatchException;
import java.util.Scanner;

import menuBank.*;

public class BankingApp {
    private static Bank bank = new Bank();
    private static Scanner sc = new Scanner(System.in);

    // Main
    public static void main(String[] args) {
        long numberAccount;
        while(true){
            try{
                Menu.menuStart();
                System.out.print("Enter choice [1-4] : ");
                int choice = sc.nextInt();

                switch(choice){
                    case 1:
                        Registration newUser = new Registration(bank);
                        newUser.register();
                        break;
                    case 2:
                        System.out.print("Enter account number : ");
                        numberAccount = sc.nextLong();

                        // นำหมายเลข Account ไปหา Account ที่ตรงและนำมาเก็บที่ loginAccount
                        // ถ้าไม่เจอจะได้ค่า null 
                        Account loginAccount = bank.getAccount(numberAccount);
                        if(loginAccount != null){
                            Login login = new Login(loginAccount.getFName(),loginAccount.getLName(),loginAccount.getPassWord());
                            System.out.print("Enter password: ");
                            String password = sc.next();
                            // ตรวจสอบรหัสผ่านที่ป้อนว่าถูกต้องตาม Account นั้นไหม
                            if(login.loginPassword(loginAccount,password)){
                                // เปิดหน้า Menu login และส่งข้อมูล (Account)loginAccount เข้าไป
                                loginMenu(loginAccount, sc);
                            }
                            else{

                            } 
                        }
                        else{
                            Menu.createMessage("Account not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter account number : ");
                        numberAccount = sc.nextLong();

                        Registration reg = new Registration(bank);
                        reg.rePassword(numberAccount);
                        
                        break;
                    default :
                        Menu.createMessage("End Of Work");
                        bank.displayAllAcounts();
                        sc.close();
                        return;
                }
            }catch(InputMismatchException e){
                Menu.createMessage("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    public static void loginMenu(Account loginAccount, Scanner sc){
        while(true){
            try{
                Menu.menuAccountWork();
                int choice = sc.nextInt();
                long targetAccountNumber = 0;
                double amount = 0;
            
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit number: ");
                        amount = sc.nextDouble();
                        loginAccount.deposit(loginAccount, amount);
                        Menu.createMessage("Deposit Succeed");
                        break;
                    case 2:
                        System.out.print("Enter withdraw amount: ");
                        amount = sc.nextDouble();
                        loginAccount.withdraw(loginAccount, amount);
                        break;
                    case 3:
                        System.out.print("Enter target account number: ");
                        targetAccountNumber = sc.nextLong();
                        System.out.print("Enter transfer amount: ");
                        amount = sc.nextDouble();
                        loginAccount.transfer(targetAccountNumber, amount, bank);
                        break;
                    case 4:
                        loginAccount.displayAccountInfo();
                        break;
                    case 5:
                        System.out.println("Return to the Menu Bank page.");
                        return;
                    default:
                        System.out.println("\nThe selected choice was not found.");
                        break;
                }
            }catch(InputMismatchException e){
                Menu.createMessage("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
    }
}
