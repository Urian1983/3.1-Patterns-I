package level1.view;

import level1.model.Undo;
import java.util.Scanner;

public class Terminal {
    Undo terminal = Undo.getInstance();

    public void run(Scanner scanner){

        boolean running = true;
        System.out.println("Welcome to the mini-terminal, please enter a command and please enter");
        System.out.println("Options:" +
                "type history to print the list of commands that you already typed." +
                "type undo to remove the last command of the list" +
                "type exit for getting out");

        while(running){
            System.out.println("<Terminal>");
            String newCommand = scanner.nextLine();
            if(newCommand.equalsIgnoreCase("exit")){
                running = false;
            }
            else if (newCommand.equalsIgnoreCase("undo")){
                if(!terminal.undoCommand()){
                    System.out.println("Command list is empty");
                }

            }

            else if(newCommand.equalsIgnoreCase("history")){
                terminal.getCommandList().descendingIterator().forEachRemaining(System.out::println);

            }

            else{
                terminal.newCommand(newCommand);
            }


        }
    }

}
