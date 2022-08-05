package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Marketing {
    static Scanner input  = new Scanner(System.in);
    public static void main(String name, String acc_type) throws IOException {
        System.out.println("Greetings, dear Marketer " +name+
                " Please dial the menu number to work with the programme, if you are finished, dial 6:\n");
        String[] to_do = {"Show a list of all customer zones by region ",
                "Show list of categories for marketing ",
                "Show allocated budget for a particular category of marketing locations",
                "Show total budget for marketing ",
                "Spending a budget on promotion",
                "Exit "};
        while (true) {
            int count = 1;
            for (String work : to_do) {
                System.out.println(count + ":" + work);
                count++;
            }
            int command = input.nextInt();
            if(command == 1){
                show_coverage_areas();
            }
            if(command == 2){
                show_media();
            }
            if(command == 3){
                allocated_budget();
            }
            if (command == 4){
                entire_budget();
            }
            if (command == 5){
                promotion();
            }
            if (command == 6){
                Main.exit();
                break;
            }
            if(command>6 || command < 1 ){
                System.out.println("Error, there is no such command here, please try again :-(");
                continue;
            }else if (command == 5){
                Main.end();
                break;
            }
        }
    }

    private static void show_coverage_areas() throws IOException{
            String[] areas = Context.get_lines("areas");
        for (String line : areas){
            System.out.println(line);
        }
    }
    private static void show_media()throws IOException{
        String[] areas = Context.get_lines("media");
        int count = 1;
        for (String line : areas){
            String[] arr = line.split(" ");
            System.out.println(count +" : "+arr[0]+" " + arr[1]+" " + arr[2]+" " + arr[3]);
            count++;
        }
        while (true){
            System.out.println("Do you want to update values? 1 - yes / 2 - no");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Select Social network");
                int line = input.nextInt()-1;
                System.out.println("Update the number of subscribers");
                int client_count = input.nextInt();
                Context.update_clients_value("media",areas[line],client_count,2);
            }else {
                break;
            }}
    }
    private static void allocated_budget(){
        String[] arr = Context.get_lines("media");
        int count = 1;
        for (String line : arr){
            System.out.println(count+" : "+ line);
            count++;
        }
    }
    private static void entire_budget(){
        String[] arr = Context.get_lines("marketing_budget");
        for (String line : arr){
            System.out.println( line);
        }
    }
    private static void promotion() throws IOException{
        String[] arr = Context.get_lines("media");
        int count = 1;
        for (String line : arr){
            System.out.println(count+" : "+ line);
            count++;
        }
        while (true){
            System.out.println("Do you want to promote a social network? 1 - yes / 2 - no");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Select Social network");
                int line = input.nextInt()-1;
                System.out.println("Enter the amount ");
                int sum = input.nextInt();
                Context.change_budget("marketing_budget","media",arr[line],sum,"marketing","+",arr);
            }else {
                break;
            }}
    }
}
