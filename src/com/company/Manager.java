package com.company;
import java.nio.charset.Charset;
import java.util.*;
import java.io.*;

import java.util.Scanner;

public class Manager {
    static Scanner input = new Scanner(System.in);
    public static void main(String name, String acc_type) throws IOException{
        System.out.println("Greetings, dear Manager " +
                "Please dial the menu number to work with the programme, if you are finished, dial 5:\n");
        String[] to_do = {"Show employee list ",
                "Show to-do list",
                "Show list of employee instructions ",
                "Show list of all coverage areas ",
                "Exit"};
        while (true) {
            int count = 1;
            for (String work : to_do) {
                System.out.println(count + ":" + work);
                count++;
            }
            int command = input.nextInt();
            if(command == 1){
                show_workers();
            }
            if(command == 2){
                show_to_do_list();
            }
            if (command == 3){
                workers_instructions();
            }
            if (command == 4){
                areas_kg();
            }
            if (command == 5){
                Main.exit();
                break;
            }
        }
    }
    private static void show_workers(){
        String[] arr = Context.find_workers("users.txt");
        int count = 1;
        for (String line : arr){
            String[] array = line.split(" ");
            System.out.println(count + ") "+array[0] +" "+ array[2]);
            count++;
        }
    }
    private static void show_to_do_list() throws IOException {
        String[] arr = Context.get_lines("todo_list_manager");
        if (arr.length == 0){
            System.out.println("You have nothing.");
        }else{
            int count = 1;
        for (int i = 0; i <= arr.length-1; i++){
            System.out.println(count+") "+arr[i]);
            count++;
        }}
        while (true){
            System.out.println("Would you like to add? 1 - yes / 2 - no");
            int ch = input.nextInt();
            if (ch == 1){
                System.out.println("What would you like to add?");
                String addTask2 = input.nextLine();
                String addTask = input.nextLine();
                Context.write("todo_list_manager",addTask);
            }else{
                break;
            }
        }
    }
    private static void workers_instructions() throws IOException{
        String[] arr = Context.get_lines("need_to_do");
        int count = 1;
        for (String line : arr){
            System.out.println(count+") "+line);
            count++;
        }
        while (true){
            System.out.println("Do you want to add tasks? 1 - yes / 2 - no");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("What would you like to add?");
                String line2 = input.nextLine();
                String line = input.nextLine();

                Context.write("need_to_do",line);
            }else {
                break;
            }}
        String[] arr2 = Context.get_lines("need_to_do");
        System.out.println("New instructions for workers");
        int count2 = 1;
        for (String line : arr2){
            System.out.println(count2+") "+line);
            count2++;
        }
    }


    private static void areas_kg() throws IOException{
        String[] areas = Context.get_lines("areas");
        int count = 1;
        for (String line : areas){
            System.out.println(count + ") "+ line);
            count++;
        }
        while (true){
            System.out.println("Want to update values? 1 - yes / 2 - no");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Select an area");
                int line = input.nextInt()-1;
                System.out.println("Update the number of clients");
                int client_count = input.nextInt();
                Context.update_clients_value("areas",areas[line],client_count,2);
            }else {
                break;
            }
        }
    }

}
