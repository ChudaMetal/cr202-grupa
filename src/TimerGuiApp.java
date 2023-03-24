

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TimerGuiApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private Timer timer1;
    private Timer timer2;
    private Timer timer3;

    public TimerGuiApp() {
        super("Timer GUI App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Create buttons to start and stop timers
        JButton startButton = new JButton("Start Timers");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimers();
            }
        });
        JButton stopButton = new JButton("Stop Timers");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimers();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        // Add buttons to the GUI
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }

    private void startTimers() {

        // Task 1: React at a certain time interval
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task 1: Reacting at a certain time interval");
            }
        };
        timer1 = new Timer();
        timer1.schedule(task1, 0, 5000); // Start immediately, repeat every 5 seconds

        // Task 2: React at a certain time
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task 2: Reacting at a certain time");
            }
        };
        timer2 = new Timer();
        timer2.schedule(task2, 3000); // Start after 3 seconds

        // Task 3: React with an indicated period
        TimerTask task3 = new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                count++;
                System.out.println("Task 3: Reacting with an indicated period (count: " + count + ")");
            }
        };
        timer3 = new Timer();
        timer3.schedule(task3, 0, 1000); // Start immediately, repeat every 1 second
    }

    private void stopTimers() {
        if (timer1 != null) {
            timer1.cancel();
        }
        if (timer2 != null) {
            timer2.cancel();
        }
        if (timer3 != null) {
            timer3.cancel();
        }
        System.out.println("All timers stopped");
    }

    public static void main(String[] args) {
        TimerGuiApp app = new TimerGuiApp();
        app.setVisible(true);
    }
}
