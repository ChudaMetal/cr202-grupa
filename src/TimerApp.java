import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerApp extends JFrame implements ActionListener {

    private JTextField timeField;
    private JButton startButton;
    private JLabel messageLabel;
    private Timer timer;

    public TimerApp() {
        super("Timer App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeField = new JTextField(10);
        add(new JLabel("Enter time (HH:MM PM/AM): "));
        add(timeField);

        startButton = new JButton("Start Timer");
        startButton.addActionListener(this);
        add(startButton);

        messageLabel = new JLabel("Click the Start button to start the timer.");
        add(messageLabel);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startTimer();
        }
    }

    private void startTimer() {
        Calendar calendar = Calendar.getInstance();
        String timeString = timeField.getText();
        String[] timeParts = timeString.split(" ");

        // Split the time string into hours, minutes, and AM/PM
        String[] time = timeParts[0].split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        boolean isPM = timeParts[1].equalsIgnoreCase("PM");

        // Adjust the hours for PM times
        if (isPM && hours != 12) {
            hours += 12;
        }

        // Set the calendar object to the specified time
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, 0);

        Date timeToStart = calendar.getTime();

        timer = new Timer();

        TimerTask task = new TimerTask() {
            public void run() {
                showMessage("Time's up!");
            }
        };

        // Schedule the task to run at the specified time
        timer.schedule(task, timeToStart);
    }

    private void showMessage(String message) {
        messageLabel.setText(message);
        timer.cancel();
    }

    public static void main(String[] args) {
        new TimerApp();
    }
}
