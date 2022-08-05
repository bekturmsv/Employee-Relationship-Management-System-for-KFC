package com.company;
import java.io.*;
import java.util.*;

public class Context {
    Scanner input = new Scanner(System.in);
    public static String[] get_lines(String file){
        BufferedReader br = null;
        ArrayList<String> array = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()){
                array.add(sc.nextLine());
            }
        }catch (IOException ex){
            System.out.println("error");
        }
        return array.toArray(new String[0]);
    }
    public static void delete_line(String file,String line){
        ArrayList<String> array = new ArrayList<String>();
        try{
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()){
                array.add(sc.nextLine());
            }
        }
        catch (IOException ex){
            System.out.println(ex);
        }
        String[] arr = array.toArray(new String[0]);
                try{
                   BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    for (String row : arr){
                    if (!row.strip().equals(line.strip())){
                        writer.write(row);
                        writer.newLine();
                    }}
                    writer.close();
                }
                catch (IOException ex){
                    System.out.println(ex);
                }
    }
    public static void write(String file_name,String param_list) throws IOException{
    BufferedWriter br = new BufferedWriter(new FileWriter(file_name,true));
    br.write( param_list + "\n");
    br.close();
    }
    public static void from_to(String file_need,String file_end, String line) throws IOException{
        delete_line(file_need,line);
        write(file_end,line);
    }
    public static String[] show_salary_for_user(String file, String name, String acc_type) throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(file));
        ArrayList<String> array = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(" ");
            if (name.equals(arr[0]) && acc_type.equals(arr[1])) {
                array.add(arr[0] + " ");
                array.add(arr[1] + " ");
                array.add(arr[2] + " ");
                br.close();
                break;
            }
        }
        return array.toArray(new String[0]);
    }
    public static void change_salary(String filename, String line ,int salary, String type) throws IOException {
        String[] array_line =  line.split(" ");
        String[] sal_budg = get_lines("salary_budget");
        String[] arr2 = sal_budg[0].split(" ");
        int b2 = Integer.parseInt(array_line[2]);
        if (type.equals("+")) {
            b2 += salary;

        }else {
            b2 -= salary;
        }
        array_line[2] = String.valueOf(b2);
        String new_str = String
                .join(" ",array_line)
                .replace("[","")
                .replace("]","");
        ArrayList<String> array = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                array.add(sc.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        String[] arr = array.toArray(new String[0]);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (String row : arr) {
                if (!row.strip().equals(line.strip())) {
                    writer.write(row);
                    writer.newLine();
                }
            }
            writer.write(new_str);
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
            System.out.println("Now "+array_line[0]+" (" +array_line[1]+") "+" receives "+array_line[2]+" $");
    }
    public static void change_budget(String file,String filename, String line ,int sum, String type,String t, String[] array) throws IOException{
        String[] budg = get_lines(file);
        String[] arr = budg[0].split(" ");
        int sum_of_budg = 0;
        if (type.equals("marketing")){
        for(String li : array){
            String[] hh = li.split(" ");
            int f = Integer.parseInt(hh[5]);
            sum_of_budg +=f;
        }}
        else{
            for(String li : array){
                String[] hh = li.split(" ");
                int f = Integer.parseInt(hh[2]);
                sum_of_budg +=f;
            }
        }
        int b = Integer.parseInt(arr[9]);
        int a = Integer.parseInt(arr[6]);
        int new_b = sum_of_budg;
        if (t.equals("+")){
         new_b+=sum;}
        else {
            new_b-=sum;
        }
        if (new_b > a ){
            System.out.println("The budget is tight");
        }else
        {
            arr[9] = String.valueOf(new_b);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(arr[0]+" ");bw.write(arr[1]+" ");bw.write(arr[2]+" ");bw.write(arr[3]+" ");
            bw.write(arr[4]+" ");bw.write(arr[5]+" ");bw.write(arr[6]+" ");bw.write(arr[7]+" ");bw.write(arr[8]+" ");
            bw.write(arr[9]+" ");bw.write(arr[10]+" ");
            bw.close();
            if (type.equals("marketing")){
            update_clients_value(filename,line,sum,5);}
            else if (type.equals("salary")){
                change_salary(filename,line,sum,t);
            }
        }
        System.out.println("Budget used: "+new_b);
    }

    public static void update_budget(String line, int budget_sum, String file) throws IOException{
        String[] arr = line.split(" ");
        arr[6] = String.valueOf(budget_sum);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(arr[0]+" ");bw.write(arr[1]+" ");bw.write(arr[2]+" ");bw.write(arr[3]+" ");
        bw.write(arr[4]+" ");bw.write(arr[5]+" ");bw.write(arr[6]+" ");bw.write(arr[7]+" ");bw.write(arr[8]+" ");
        bw.write(arr[9]+" ");bw.write(arr[10]+" ");
        bw.close();
    }
    public static void update_clients_value(String filename, String line, int clients,int index){
        String[] array_line =  line.split(" ");
        array_line[index] = String.valueOf(clients);
        String new_str = String
                .join(" ",array_line)
                .replace("[","")
                .replace("]","");
        ArrayList<String> array = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                array.add(sc.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        String[] arr = array.toArray(new String[0]);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (String row : arr) {
                if (!row.strip().equals(line.strip())) {
                    writer.write(row);
                    writer.newLine();
                }
            }
            writer.write(new_str);
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    public static String[] find_workers(String filename){
        String[] arr = get_lines(filename);
        ArrayList<String> arr_workers = new ArrayList<String>();
        for (String line : arr){
            String[] array = line.split(" ");
            if (array[2].equals("worker")){
                arr_workers.add(line);
            }
        }
        return arr_workers.toArray(new String[0]);
    }

}
