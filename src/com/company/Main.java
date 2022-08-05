package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        String[] result = Auth.main();
       if("marketing".equals(result[0])){
            Marketing.main(result[1],result[0]);
       }
        if("manager".equals(result[0])){
            Manager.main(result[1],result[0]);
        }
        if("director".equals(result[0])){
            Director.main(result[1],result[0]);
        }
        if("worker".equals(result[0])){
            Worker.main(result[1],result[0]);
        }
    }
    public static void end(){
        System.out.println("Goodbye!");
    }
    public static void exit() throws IOException {
        System.out.println("""
        Log in to another account or register again for another account  - 1
        Exit - 2
                    """);
        while (true){
        int choice = input.nextInt();
        String[] arr = new String[]{};
        if (choice == 1){
            main(arr);
        }
        else
        {
            end();
            break;
        }}
    }
}
