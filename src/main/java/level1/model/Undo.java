package level1.model;

import java.util.ArrayDeque;

public class Undo {

    private static Undo instance;
    private final ArrayDeque<String> commandStack = new ArrayDeque<>();

    private Undo(){

    }

    public static Undo getInstance(){
        if(instance == null){
            instance = new Undo();
        }
        return instance;
    }

    public void newCommand(String command){
        commandStack.push(command);
    }

    public boolean undoCommand(){
        if(commandStack.isEmpty()){
            return false;
        }

        commandStack.pop();
        return true;
    }

    public ArrayDeque<String> getCommandList(){
        ArrayDeque<String> copy = new ArrayDeque<String>(commandStack);
        return copy;
    }

}
