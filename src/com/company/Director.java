package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Director {
    static Scanner input = new Scanner(System.in);
    public static void main(String name, String acc_type) throws IOException{
        System.out.println("Greetings, dear Director " + name +
                " Please dial the menu number to work with the programme, if you are finished, dial 9:\n");
        String[] to_do = {"Show list of all coverage areas ",
                "Show list of budget categories ",
                "Show allocated budget for a particular category of marketing locations",
                "Show current funds for marketing",
                "Show the total budget needed for salaries",
                "Increase an employee's salary:",
                "Reduce an employee's salary:",
                "Show list of equipment for building projects ",
                "Exit"};
        while (true) {
            int count = 1;
            for (String work : to_do) {
                System.out.println(count + ":" + work);
                count++;
            }
            int command = input.nextInt();
            if (command == 2){
                show_budget_category();
            }
            if(command == 4){
                show_market_budget();
            }
            if(command == 3){
                show_market_category();
            }
            if(command == 1){
                show_areas();
            }
            if (command == 5){
                show_salary_category();
            }
            if(command == 6){
            raise_salary("+");
            }
            if(command == 7){
                lower_salary();
            }
            if (command == 8){
                list_of_equipment();
            }
            if (command == 9){
                Main.exit();
            }
        }

    }
    private static void show_budget_category() throws IOException{
        String[] categories = new String[]{"A budget for salaries","Budget for marketing"};
        String[] filenames = new String[]{"salary_budget","marketing_budget"};
            while (true) {
                int count = 1;
                for (String line : categories){
                    System.out.println(count + ") "+ line);
                    count++;
                }
                System.out.println("Choose a category for the budget 0 - exit");
                int choice = input.nextInt();
                if (choice == 1 || choice == 2) {
                    while (true) {
                        String[] arr = Context.get_lines(filenames[choice -1]);
                        for (String line : arr) {
                            System.out.println(line);
                        }
                        System.out.println("Want to change your budget? 1 - yes / 2 - no");
                        String type = "add";
                        int ch = input.nextInt();
                        if (ch == 1) {
                            System.out.println("Enter a new budget");
                            String salary2 = input.nextLine();
                            int salary = input.nextInt();
                            System.out.println("Done!");
                            Context.update_budget(arr[0], salary, filenames[choice-1]);
                        } else {
                            break;
                        }
                    }
                }
                else if (choice > 2 || choice < 0){
                    continue;
                }
                else break;
            }
    }
    private static void show_market_category(){
        String[] areas = Context.get_lines("media");
        int count = 1;
        for (String line : areas){
            System.out.println(count + ") "+ line);
            count++;
        }
    }
    private static void show_salary_category(){
        String[] areas = Context.get_lines("salary_budget");
        for (String line : areas){
            System.out.println( line);
        }
        String[] areas2 = Context.get_lines("salary");
        int count2 = 1;
        for (String line : areas2){
            System.out.println(count2 + ") "+ line);
            count2++;
        }
    }
    private static void show_areas(){
        String[] areas = Context.get_lines("areas");
        int count = 1;
        for (String line : areas){
            System.out.println(count + ") "+ line);
            count++;
        }
    }
    private static void show_market_budget(){
        String[] areas = Context.get_lines("marketing_budget");
        System.out.println(areas[0]);
    }
    private static void raise_salary(String type_of ) throws IOException {
        String[] arr = Context.get_lines("salary");
        int count = 1;
        for (String worker : arr){
            System.out.println(count+") "+worker);
            count++;
        }
        while (true){
            if (type_of.equals("+"))
            System.out.println("Do you want a pay rise? 1 - yes / 2 - no");
            else System.out.println("Do you want to take a pay cut? 1 - yes / 2 - no");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Choose to whom");
                int line = input.nextInt()-1;
                System.out.println(arr[line]);
                if (type_of.equals("+"))
                System.out.println("Enter how much of a salary increase");
                else System.out.println("Enter how much of a salary reduction");
                String salary2 = input.nextLine();
                int salary = input.nextInt();
                System.out.println("Done!");
                Context.change_budget("salary_budget","salary",arr[line],salary,"salary",type_of,arr);
            }else
                break;
        }
    }
    private static void list_of_equipment() throws IOException{
        String[] arr = Context.get_lines("equipment");
        int count = 1;
        for (String worker : arr){
            System.out.println(count+") "+worker);
            count++;
        }
        while (true){
            System.out.println("Want to add equipment? 1 - yes / 2 - no");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("What would you like to add?");
                String equip1 = input.nextLine();
                String equip = input.nextLine();
                Context.write("equipment",equip);
            }
            else {
                break;
            }
        }
        String[] arr2 = Context.get_lines("equipment");
        System.out.println("New list of equipment");
        int count2 = 1;
        for (String worker : arr2){
            System.out.println(count2+") "+worker);
            count2++;
        }
    }
    private static void lower_salary() throws IOException {
        raise_salary("-");
    }
}
