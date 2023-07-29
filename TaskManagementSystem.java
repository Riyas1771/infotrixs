import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TaskManagementSystem {
    private Map<String, User> users;
    private List<Task> tasks;
    private User loggedInUser;

    private static final String USERS_FILE_PATH = "users.txt";
    private static final String TASKS_FILE_PATH = "tasks.txt";
    public TaskManagementSystem() {
        this.users = new HashMap<>();
        this.tasks = new ArrayList<>();
        readUsersFromFile();
        readTasksFromFile();
    }
    public void registerUser(String username, String password, UserRole role) {
        User newUser = new User(username, password, role);
        users.put(username, newUser);
        System.out.println("User registered successfully.");
    }

    public void login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Login successful. Welcome, " + user.getUsername() + "!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("Logged out successfully.");
    }

    public void createTask(String title, String description) {
        if (loggedInUser == null) {
            System.out.println("You need to log in to create a task.");
            return;
        }

        Task newTask = new Task(generateTaskId(), title, description, null, TaskStatus.NEW);
        tasks.add(newTask);
        System.out.println("Task created successfully.");
    }

    public void assignTask(Task task, User assignee) {
        if (loggedInUser == null) {
            System.out.println("You need to log in to assign a task.");
            return;
        }

        if (loggedInUser.getRole() != UserRole.ADMIN && loggedInUser.getRole() != UserRole.TEAM_LEADER) {
            System.out.println("You don't have the permission to assign tasks.");
            return;
        }

        task.setAssignee(assignee);
        task.setStatus(TaskStatus.IN_PROGRESS);
        System.out.println("Task assigned successfully to " + assignee.getUsername() + ".");
    }

    public void updateTaskStatus(Task task, TaskStatus newStatus) {
        if (loggedInUser == null) {
            System.out.println("You need to log in to update the task status.");
            return;
        }

        if (task.getAssignee() == null || !task.getAssignee().equals(loggedInUser)) {
            System.out.println("You can only update the status of tasks assigned to you.");
            return;
        }

        task.setStatus(newStatus);
        System.out.println("Task status updated successfully.");
    }

    // Other utility methods

    private String generateTaskId() {
		return null;
     
    }

    public void saveUsersToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE_PATH))) {
            outputStream.writeObject(users);
        } catch (IOException e) {
            System.out.println("Error saving user data to file: " + e.getMessage());
        }
    }

    public void readUsersFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(USERS_FILE_PATH))) {
            Object obj = inputStream.readObject();
            if (obj instanceof Map) {
                users = (Map<String, User>) obj;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Users file not found. A new file will be created when users are added.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading user data from file: " + e.getMessage());
        }
    }

    public void saveTasksToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TASKS_FILE_PATH))) {
            outputStream.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Error saving task data to file: " + e.getMessage());
        }
    }

    public void readTasksFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(TASKS_FILE_PATH))) {
            Object obj = inputStream.readObject();
            if (obj instanceof List) {
                tasks = (List<Task>) obj;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Tasks file not found. A new file will be created when tasks are added.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading task data from file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        TaskManagementSystem taskManagementSystem = new TaskManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Example usage of the task management system
        taskManagementSystem.registerUser("admin", "adminpass", UserRole.ADMIN);
        taskManagementSystem.registerUser("leader", "leaderpass", UserRole.TEAM_LEADER);
        taskManagementSystem.registerUser("user1", "userpass", UserRole.TEAM_MEMBER);
        taskManagementSystem.registerUser("user2", "userpass", UserRole.TEAM_MEMBER);

        taskManagementSystem.login("admin", "adminpass");
        taskManagementSystem.createTask("Implement feature A", "Implement a new feature in the project.");

        taskManagementSystem.login("leader", "leaderpass");
        Task task = taskManagementSystem.tasks.get(0); // Assuming task index 0 is the newly created task
        taskManagementSystem.assignTask(task, taskManagementSystem.users.get("user1"));

        taskManagementSystem.login("user1", "userpass");
        taskManagementSystem.updateTaskStatus(task, TaskStatus.COMPLETED);

        scanner.close();

        // Save user and task data to files before exiting the program
        taskManagementSystem.saveUsersToFile();
    }}



