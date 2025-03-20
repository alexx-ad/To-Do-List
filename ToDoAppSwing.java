import javax.swing.*;
import java.awt.*;

public class ToDoAppSwing {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private ToDoList toDoList;

    public ToDoAppSwing() {
        toDoList = new ToDoList();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskInput = new JTextField(20);

        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.setLocationRelativeTo(null);

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton completeButton = new JButton("Mark Completed");

        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
        completeButton.addActionListener(e -> markTaskCompleted());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Task: "));
        panel.add(taskInput);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(completeButton);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        frame.setVisible(true);
    }
    private void addTask() {
        String taskName = taskInput.getText().trim();
        if (!taskName.isEmpty()){
            toDoList.addTask(taskName);
            updateTaskList();
            taskInput.setText("");
        }
    }
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1){
            toDoList.deleteTask(selectedIndex);
            updateTaskList();
        }
    }
    private void markTaskCompleted() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1){
            toDoList.markTaskCompleted(selectedIndex);
            updateTaskList();
        }
    }
    private void updateTaskList() {
        listModel.clear();
        for (Task task : toDoList.getTasks()){
            listModel.addElement(task.toString());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoAppSwing::new);
    }
}
