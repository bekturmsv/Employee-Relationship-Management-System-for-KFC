package com.company;
import java.util.*;
import java.io.*;

public class Auth {
    public static String[] main(){
        Scanner input = new Scanner(System.in);
        String[] account_types = {"marketing","manager","director","worker"};
        int enter = 0;
        System.out.println("1. Login | 2. Registration :");
        enter = input.nextInt();

        if (enter == 2){
            register();
        }

        System.out.println("Enter to acc");
        System.out.println("Choose type of acc");
        while (true){
            int count = 1;
            for(String type : account_types){
                System.out.println(count + " : " + type);
                count++;
            }
            int account_type = input.nextInt();
            String acc_type = "";
            if(account_type ==1){
                acc_type = "marketing";
            }
            else if(account_type == 2){
                acc_type = "manager";
            }else if(account_type == 3){
                acc_type = "director";
            }else if(account_type == 4){
                acc_type = "worker";
            }else {
                System.out.println("Sorry, but we did not find this type of account, please repeat");
                continue;
            }
            System.out.println("Enter your login: ");
            String password2 = input.nextLine();
            String login = input.nextLine();
            System.out.println("Enter your password: ");
            String password = input.nextLine();


            boolean result = auth(login,password,acc_type);


            if(result){
                return new String[]{acc_type,login};
            }else{
                System.out.println("Invalid username or password, please try again");
            }
        }

    }

    public static void register(){
        Scanner input = new Scanner(System.in);
        String[] account_types = {"marketing","manager","director","worker"};
        int count =1;
        for( String type : account_types){
            System.out.println(count+" : "+type);
            count++;
        }
        System.out.print("Enter Account Type - ");
        int account_type = input.nextInt();
        String acc_type = "";

        if(account_type ==1){
            acc_type = "marketing";
        }else if(account_type == 2){
            acc_type = "manager";
        }else if(account_type == 3){
            acc_type = "director";
        }else if(account_type == 4){
            acc_type = "worker";
        }else {
            System.out.println("Sorry, but we did not find this type of account, please repeat");
            return;
        }
        System.out.println("Enter your login: ");
        String password2 = input.nextLine();
        String login = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        File myFile =new File("users.txt");
        File salaryFile = new File("salary");
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile,true));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter(salaryFile,true));
            writer.write(login + " ");
            writer.write(password+ " ");
            writer.write(acc_type + " " +"\n");
            if(!acc_type.equals("director")){
                writer2.write(login+ " ");
                writer2.write(acc_type + " ");
                writer2.write(0 + "\n");
                writer2.close();
            }
            writer.close();
            System.out.println("Register success");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static boolean auth(String login,String password,String acc_type){
        boolean res = false;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("users.txt"));
            String line;
            while((line = br.readLine())!=null){
                String[] arr = line.split(" ");
                if(login.equals(arr[0]) && password.equals(arr[1]) && acc_type.equals(arr[2])){
                    System.out.println(arr[1]);
                    System.out.println("Auth success");
                     res = true;
                     br.close();
                     break;
                }else{
                    res = false;
                }
            }
        }catch (IOException ex){
            System.out.println("error");
        }
return res;
    }
}
