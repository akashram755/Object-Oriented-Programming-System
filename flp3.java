import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Task {
    private String title;
    private int duration;
    public Task(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
    public String getTitle() { return title; }
    public int getDuration() { return duration; }
}

class TaskService {
    private List<Task> tasks = new ArrayList<>();
    public void addTask(String title, int duration) throws Exception {
        if (title.isEmpty()) {
            throw new Exception("Task title cannot be empty");
        }
        if (duration <= 0) {
            throw new Exception("Invalid duration");
        }
        tasks.add(new Task(title, duration));
    }
    public List<Task> getTasks() {
        return tasks;
    }
}

class TimerThread extends Thread {
    private int time;
    private JLabel label;
    public TimerThread(int time, JLabel label) {
        this.time = time;
        this.label = label;
    }
    public void run() {
        try {
            while (time > 0) {
                int t = time;
                SwingUtilities.invokeLater(() -> label.setText("Time: " + t));
                Thread.sleep(1000);
                time--;
            }
            SwingUtilities.invokeLater(() -> label.setText("Task Completed"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TaskUI {
    private JFrame frame;
    private JTextField taskField, timeField;
    private JTextArea displayArea;
    private JLabel timerLabel;
    private TaskService service;
    public TaskUI() {
        service = new TaskService();
        frame = new JFrame("Task Manager");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        taskField = new JTextField(15);
        timeField = new JTextField(5);
        JButton addBtn = new JButton("Add Task");
        JButton startBtn = new JButton("Start Timer");
        displayArea = new JTextArea(10, 30);
        timerLabel = new JLabel("Time: 0");
        addBtn.addActionListener(e -> addTask());
        startBtn.addActionListener(e -> startTask());
        frame.add(new JLabel("Task:"));
        frame.add(taskField);
        frame.add(new JLabel("Time:"));
        frame.add(timeField);
        frame.add(addBtn);
        frame.add(startBtn);
        frame.add(timerLabel);
        frame.add(new JScrollPane(displayArea));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void addTask() {
        try {
            String title = taskField.getText();
            int time = Integer.parseInt(timeField.getText());
            service.addTask(title, time);
            displayArea.append("Added: " + title + "\n");
            taskField.setText("");
            timeField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }
    }
    private void startTask() {
        try {
            List<Task> tasks = service.getTasks();
            if (tasks.isEmpty()) {
                throw new Exception("No tasks available");
            }
            Task t = tasks.get(tasks.size() - 1);
            TimerThread timer = new TimerThread(t.getDuration(), timerLabel);
            timer.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }
    }
}

public class flp3 {
    public static void main(String[] args) {
        new TaskUI();
    }
}