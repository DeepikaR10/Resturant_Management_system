package com.rest.CLI;
import com.rest.models.Table;
import com.rest.services.TableService;
import java.util.List;
import java.util.Scanner;

public class TableCLI {
    private final TableService services;
    private final Scanner scanner;

    public TableCLI(TableService services){
        this(services, new Scanner(System.in));
    }

    public TableCLI(TableService services, Scanner scanner){
        this.services=services;
        this.scanner=scanner;
    }
    public void start(){
        System.out.println("=== RESTAURANT TABLE MANAGEMENT===");
        System.out.println("1.View All Tables");
        System.out.println("0.Back to Main Menu");

        System.out.print("Enter Choice: ");
        int choice =Integer.parseInt(scanner.nextLine());
        if(choice==1){
            List<Table> tables =services.getAllTables();
            System.out.println("\n== ALL TABLES ===");
            for(Table table:tables){
                System.out.println(table);
            }
        }
        else if(choice == 0){
            System.out.println("Returning to main menu.");
        }
        else{
            System.out.println("Invalid choice. Please try again.");
        }
    }
}
