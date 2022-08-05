package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Worker {
    static Scanner input = new Scanner(System.in);
    public static void main(String name, String acc_type) throws IOException {
        System.out.println("Greetings, dear Worker " +
                "Please dial the menu number to work with the programme, if you are finished, dial 5:\n");
        String[] to_do = {"Show a list of the cases I have been entrusted with",
                "Show list of completed instructions",
                "Show list of cases I am working on",
                "Show wages",
                "Exit"};
        while (true) {
            int count = 1;
            for (String work : to_do) {
                System.out.println(count + ":" + work);
                count++;
            }
            int command = input.nextInt();
            if(command == 1){
                show_work("need_to_do");
            }
            if(command == 2){
                show_finished_work();
            }
            if(command == 3){
                active_work();
            }
            if (command == 4){
                show_salary(name,acc_type);
            }
            if(command>6 || command < 1 ){
                System.out.println("Error, there is no such command here, please try again :-(");
                continue;
            }else if (command == 5){
                Main.exit();
                break;
            }
        }
    }

    private static void show_work(String file) throws IOException {
   String[] arr = Context.get_lines(file);
    int count = 1;
    for (int i = 0; i <= arr.length-1; i++){
        System.out.println(count+") "+arr[i]);
        count++;
    }
    }

    private static void active_work() throws IOException{
        String[] arr = Context.get_lines("active_work");
        int count = 1;
        for (int i = 0; i <= arr.length-1; i++){
            System.out.println(count+") "+arr[i]);
            count++;
        }
        while (true){
            System.out.println("Wanna take order? 1 - yes / 2 - no");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Choose one");
                int line = input.nextInt();
                Context.from_to("active_work","finished_work",arr[line-1]);
            }else

                break;
        }
        System.out.println("Remains to be done");
        show_work("active_work");
        }


    private static void show_finished_work() throws IOException{
        show_work("finished_work");
    }
    private static void show_salary(String name, String acc_type) throws IOException{
        String[] arr = Context.show_salary_for_user("salary",name,acc_type);
            if (arr.length == 0){
                System.out.println("We didn't find you");
            }else {
                System.out.println("Employee " + arr[0] + " receives - " + arr[2] + " $");
            }
    }
}
