

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class AuthService {
    private User user;

    public void login(Scanner scanner) {
        System.out.print("Enter username :");
        String username = scanner.nextLine();
        if (username.isEmpty()) {
            System.out.println("Please enter username....");
            return;
        }
        System.out.print("Enter password :");
        String password = scanner.nextLine();
        if (password.isEmpty()) {
            System.out.println("Please enter password.....");
            return;
        }
        user = new User(username, password);
        System.out.println("Login successful.....");
		System.out.println("");
    }

    public void logout() {
        user = null;
        System.out.println("Logged out...");
		System.out.println("Visit Again...");
        System.out.println("");
    }

    public User getUser() {
        return user;
    }
}

class ProfileService {
    private User user;

    public ProfileService(User user) {
        this.user = user;
    }

    public void updateProfile(Scanner scanner) {
        System.out.print("Enter new username:");
        String newUsername = scanner.nextLine();
        if (newUsername.isEmpty()) {
            System.out.println("Please enter username.");
            return;
        }
        System.out.print("Enter new password:");
        String newPassword = scanner.nextLine();
        if (newPassword.isEmpty()) {
            System.out.println("Please enter password.");
            return;
        }
        user.setUsername(newUsername);
        user.setPassword(newPassword);
        System.out.println("Profile updated.");
        System.out.println("");
    }
}

class QuizService {
    private int score;

    public void startQuiz(Scanner scanner) {
        score = 0;

        System.out.println("Question 1: What is the size of int in Java?");
        System.out.println("1. 2 bytes\n2. 4 bytes\n3. 8 bytes\n4. 16 bytes");
        int answer1 = scanner.nextInt();
        if (answer1 == 2) score++;

        System.out.println("Question 2: Which keyword is used to define a class in Java?");
        System.out.println("1. class\n2. Class\n3. define\n4. new");
        int answer2 = scanner.nextInt();
        if (answer2 == 1) score++;

        System.out.println("Question 3: Which method is used to print something in Java?");
        System.out.println("1. print\n2. write\n3. printf\n4. println");
        int answer3 = scanner.nextInt();
        if (answer3 == 4) score++;
		
		System.out.println("Question 4: Who invented Java Programming? ");
        System.out.println("1. Guido van Rossum\n2. James Gosling\n3. Dennis Ritchie\n4. Bjarne Stroustrup ");
        int answer4 = scanner.nextInt();
        if (answer4 == 2) score++;
		
		System.out.println("Question 5:  Which component is used to compile, debug and execute the java programs?");
        System.out.println("1.JRE\n2.JIT\n3.JDK\n4.JVM");
        int answer5 = scanner.nextInt();
        if (answer5 == 3) score++;
		
		System.out.println("Question 6:Which one of the following is not a Java feature? ");
        System.out.println(" 1.Object-oriented\n 2.Use of pointers\n 3.Portable\n 4.Dynamic and Extensible ");
        int answer6 = scanner.nextInt();
        if (answer6 == 2) score++;
		
		System.out.println("Question 7: What is the extension of java code files? ");
        System.out.println("1. .js\n2. .txt\n3. .class\n4. .java");
        int answer7 = scanner.nextInt();
        if (answer7 == 4) score++;
		
		System.out.println("Question 8:  Which of the following is not an OOPS concept in Java? ");
        System.out.println("1.Polymorphism\n 2.Inheritance\n 3.Compilation\n 4.Encapsulation ");
        int answer8 = scanner.nextInt();
        if (answer8 == 3) score++;
		
		System.out.println("Question 9: What is the extension of compiled java classes? ");
        System.out.println("1. .txt\n2. .js\n3. .class\n4. .java");
        int answer9 = scanner.nextInt();
        if (answer9 == 3) score++;
		
		System.out.println("Question 10: Which exception is thrown when java is out of memory?");
        System.out.println("1.MemoryError\n 2.OutOfMemoryError\n 3.MemoryOutOfBoundsException\n 4.MemoryFullException ");
        int answer10 = scanner.nextInt();
        if (answer10 == 2) score++;
		
		//all answers=== 

        System.out.println("Quiz completed. Your score is: " + score + "/10");
        System.out.println("");
    }

    public int getScore() {
        return score;
    }
}

class TimerService {
    private JLabel timerLabel;
    private Timer timer;

    public TimerService(JLabel timerLabel) {
        this.timerLabel = timerLabel;
        this.timer = new Timer();
    }

    public void startTimer(QuizService quizService, Scanner scanner) {
        TimerTask task = new TimerTask() {
            int timeRemaining = 180; // 3 minutes in seconds

            @Override
            public void run() {
                if (timeRemaining > 0) {
                    timerLabel.setText("Time remaining: " + timeRemaining + " seconds");
                    timeRemaining--;
                } else {
                    System.out.println("Time is up! Auto-submitting answers.");
                    System.out.println("Your score is: " + quizService.getScore() + "/3");
                    System.exit(0);
                    System.out.println("");
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // Update every second
    }

    public void stopTimer() {
        timer.cancel();
    }
}

public class OnlineTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        User user = new User("", "");
        ProfileService profileService = new ProfileService(user);
        QuizService quizService = new QuizService();

        JFrame frame = new JFrame("Quiz Timer");
        JLabel timerLabel = new JLabel("Time remaining: 300 seconds", SwingConstants.CENTER);
        frame.add(timerLabel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false); // Hide the frame initially

        TimerService timerService = new TimerService(timerLabel);

        while (true) {
			System.out.println(">>>  WEl-COME To Online Examination  <<<");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Start Quiz");
            System.out.println("4. Logout");
			System.out.println("______________________________________");
            System.out.println("");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    authService.login(scanner);
                    break;
                case 2:
                    profileService.updateProfile(scanner);
                    break;
                case 3:
                    frame.setVisible(true); // Show the frame when starting the quiz
                    timerService.startTimer(quizService, scanner);
                    quizService.startQuiz(scanner); // Display the quiz questions
                    timerService.stopTimer(); // Stop the timer after quiz completion
                    frame.setVisible(false); // Hide the frame after quiz completion
                    break;
                case 4:
                    authService.logout();
                    frame.setVisible(false); // Hide the frame when logging out
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
