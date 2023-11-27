import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void simpleTaskTitleNo() {
        SimpleTask simpleTask = new SimpleTask(5, "Увидеть рассвет");
        //simpleTask.matches("Увидеть закат");


        boolean expected = false;
        boolean actual = simpleTask.matches("Увидеть закат");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void simpleTaskTitleYes() {
        SimpleTask simpleTask = new SimpleTask(5, "Увидеть рассвет");


        boolean expected = true;
        boolean actual = simpleTask.matches("Увидеть рассвет");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void epicSubtasksNo() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Масло");
    }

    @Test
    public void epicSubtasksYesOne() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");
    }

    @Test
    public void epicSubtasksYesTwo() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");
    }

    @Test
    public void epicSubtasksYesThree() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(5, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");
    }

    @Test
    public void meetingNowObjects() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Хлебушка купить");
    }

    @Test
    public void meetingTopicObjectYes() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
    }

    @Test
    public void meetingProjectObjectYes() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
    }

    @Test
    public void meetingStartObjectYes() {
        Meeting meeting = new Meeting(
                5,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Во вторник после обеда");
    }

}