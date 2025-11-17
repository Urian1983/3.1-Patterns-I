package level1.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;

class UndoTest {

    @BeforeEach
    void setUp() throws Exception{
        Field instanceField = Undo.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null,null);
    }


    @Test
    void getInstance_ShouldReturnSameInstance() {
        Undo u1= Undo.getInstance();
        Undo u2 =Undo.getInstance();

        assertThat(u1).isSameAs(u2);
    }

    @Test
    void newCommandShouldAddCommandToStack() {
        Undo undo = Undo.getInstance();

        undo.newCommand("cmd1");
        undo.newCommand("cmd2");

        ArrayDeque<String> commands = undo.getCommandList();

        //The order is reverse since it is a LIFO
        assertThat(commands).containsExactly("cmd2","cmd1");
    }

    @Test
    void undoCommand_ShouldRemoveLastCommandAndReturnTrue() {
        Undo undo = Undo.getInstance();

        undo.newCommand("cmd1");
        undo.newCommand("cmd2");

        boolean result = undo.undoCommand();

        assertThat(result).isTrue();
        assertThat(undo.getCommandList()).containsExactly("cmd1");
    }

    @Test
    void undoCommand_ShouldReturnFalse_WhenStackIsEmpty() {
        Undo undo = Undo.getInstance();

        boolean result = undo.undoCommand();

        assertThat(result).isFalse();
        assertThat(undo.getCommandList()).isEmpty();
    }

    @Test
    void getCommandList_ShouldReturnACopyNotOriginalStack() {
        Undo undo = Undo.getInstance();
        undo.newCommand("cmd1");

        ArrayDeque<String> copy = undo.getCommandList();
        copy.push("cmd2"); // modificamos la copia

        assertThat(undo.getCommandList())
                .containsExactly("cmd1"); // el original no debe cambiar

        assertThat(copy)
                .containsExactly("cmd2", "cmd1"); // la copia sí refleja el cambio
    }
}