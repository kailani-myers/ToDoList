package toDoList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ToDoList {
	public static void main(String[] args) {
		
	//this is the main menu
		
		LinkedList<String> toDoList = new LinkedList<>();
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to your To-Do List! ");
		System.out.println("[0] Enter the task: Walk the dog");
		System.out.println("[1] Add new task");
		System.out.println("[2] View To-Do List");
		System.out.println("[3] Delete Task");
		System.out.println("[4] Save to file");
		System.out.println("[5] Exit Program ");
		System.out.println("Enter a number to select an option: ");
		
// this is to continually ask the user for an option input until their press 5 to exit the program
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("my list.txt"))) {
			while(true){
				String option = userInput.nextLine();
				if(option.equals("0") ) {
	//this adds the preset task : walk the dog
					
					System.out.println("Adding task 'Walk the Dog'...");
					toDoList.add("Walk the dog");
					System.out.println("Enter a number to select an option: ");
	// this allows the user to enter a task		
					
				}else if (option.equals("1")) {
					System.out.println("Please enter a task: ");
					String newTask = userInput.nextLine();
					toDoList.add(newTask);
					System.out.println("Task entered.");
					System.out.println("Enter a number to select an option: ");
				
	//this displays the current to do list to the user
				}else if (option.equals("2") ) {
					System.out.println("Here is your current To-Do List.");
					System.out.println(toDoList);
					System.out.println("Enter a number to select an option: ");
					
	// this allows the user to delete a task
				}else if(option.equals("3")) {
					System.out.println("Which task do you want to delete?");
					System.out.println(toDoList);
					String deleteTask = userInput.nextLine();
					for(String item:toDoList) {
						if (item.equals(deleteTask)) {
							toDoList.remove(deleteTask);
						}
						System.out.println(toDoList);
					}
					System.out.println("Task deleted.");
					
	//this saves the to do list to a file
				}else if(option.equals("4")) {
					for (String item: toDoList) {
						writer.write("\n" + item);
					}
					System.out.println("File created.");
					writer.close();
				}else if (option.equals("5")) {
					System.out.println("Exiting program... ");
					break;
				}else {
					
	//if the user does not enter a number this prints
					System.out.println("That is not a valid input! ");
					System.out.println("Enter a number to select an option: ");
				}
				
			}
			
		} catch (IOException e) {
	//closes user input
			e.printStackTrace();
			userInput.close();	
		}
	}
}