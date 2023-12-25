package menuBank;

public class Menu {
   
    public static void menuStart(){
        System.out.println("\n==== Menu Bank ====");
        System.out.println("| 1.Registration  |");
        System.out.println("| 2.Login         |");
        System.out.println("| 3.Repassword    |");
        System.out.println("| 4.Exit          |");
        System.out.println("===================");
    }

    public void menuPassword(){
        System.out.println("\n====================== Rules ======================");
        System.out.println("| 1.Password greater than or equal to 8           |");
        System.out.println("| 2.Password must contain uppercase letters [A-Z] |");
        System.out.println("| 3.Password must contain lowercase letters [a-z] |");
        System.out.println("===================================================");
    }

    public static void menuAccountWork(){
        System.out.println("\n========== Bank Account ==========");
        System.out.println("| 1.Deposit money                |");
        System.out.println("| 2.Withdraw money               |");
        System.out.println("| 3.Transfer money               |");
        System.out.println("| 4.Show my account              |");
        System.out.println("| 5.Return to the Menu Bank page |");
        System.out.println("==================================");
        System.out.print("Enter choice [1-5] : ");
    }

    public static void createMessage(String message){
        String newMessage = "";
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= message.length()+4; j++){
                if(i == 1 || i == 3){
                   newMessage+="="; 
                }
                if(i == 2 && j == 1){
                    newMessage+="| "+message;
                }
                if(i == 2 && j == 1){
                    newMessage+=" |";
                }
            }
            newMessage+="\n";
        }
        System.out.print(newMessage);
    }

}
