import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String name){
        tasks.add(new Task (name));
    }
    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()){
            tasks.get(index).markCompleted();
        }
    }
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()){
            tasks.remove(index);
        }
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
