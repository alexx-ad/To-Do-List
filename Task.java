public class Task{
    private String name;
    private boolean isCompleted;

    public Task(String name){
        this.name = name;
        this.isCompleted = false;
    }
    public String getName() {
        return name;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void markCompleted() {
        isCompleted = true;
    }
    public String toString() {
        return (isCompleted ? "[✔] " : "[ ]") + name;
    }
}