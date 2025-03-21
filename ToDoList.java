import java.io.*;
import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks.txt";

    public ToDoList() {
        loadTasks();
    }
    public void addTask(String name){
        tasks.add(new Task (name));
        saveTasks();
    }
    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()){
            tasks.get(index).markCompleted();
            saveTasks();
        }
    }
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()){
            tasks.remove(index);
            saveTasks();
        }
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    private void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){
            for (Task task : tasks){
                writer.println((task.isCompleted() ? "1" : "0") + "," + task.getName());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
    private void loadTasks() {
        tasks.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",", 2);
                if (parts.length == 2){
                    Task task = new Task(parts[1]);
                    if (parts[0].equals("1")){
                        task.markCompleted();
                    }
                    tasks.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous tasks found, starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}
