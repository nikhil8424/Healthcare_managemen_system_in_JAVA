import javax.swing.*;
import java.awt.*;

public class HealthcareSystemGUI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Healthcare System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Create the main panel with GridLayout
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        
        // Left panel for doctor profiles
        JPanel doctorPanel = new JPanel();
        doctorPanel.setLayout(new BoxLayout(doctorPanel, BoxLayout.Y_AXIS));
        
        // Doctor 1 profile
        JPanel doctor1Panel = new JPanel();
        doctor1Panel.setLayout(new BorderLayout());
        JLabel doctor1Label = new JLabel("<html><b>Dr. Kishor Sathe</b><br>Consultant - Emergency Medicine<br>MBBS, MRCEM, UK</html>");
        JButton doctor1ProfileButton = new JButton("View Profile");
        doctor1Panel.add(doctor1Label, BorderLayout.CENTER);
        doctor1Panel.add(doctor1ProfileButton, BorderLayout.SOUTH);
        doctorPanel.add(doctor1Panel);

        // Doctor 2 profile
        JPanel doctor2Panel = new JPanel();
        doctor2Panel.setLayout(new BorderLayout());
        JLabel doctor2Label = new JLabel("<html><b>Dr. Khusrav Bajan</b><br>Section Head - Accident & Emergency,<br>Consultant - General Medicine and Critical Care Medicine<br>M.D, European Diploma In Intensive Care (EDIC)</html>");
        JButton doctor2ProfileButton = new JButton("View Profile");
        doctor2Panel.add(doctor2Label, BorderLayout.CENTER);
        doctor2Panel.add(doctor2ProfileButton, BorderLayout.SOUTH);
        doctorPanel.add(doctor2Panel);

        // Book appointment button
        JButton bookAppointmentButton = new JButton("Book Appointment");
        doctorPanel.add(bookAppointmentButton);

        // Right panel for emergency details
        JPanel emergencyPanel = new JPanel();
        emergencyPanel.setLayout(new BoxLayout(emergencyPanel, BoxLayout.Y_AXIS));
        
        // Emergency Sections
        JPanel emergencySectionsPanel = new JPanel(new GridLayout(2, 1));
        JButton overviewButton = new JButton("Overview");
        JButton infrastructureButton = new JButton("Infrastructure");
        emergencySectionsPanel.add(overviewButton);
        emergencySectionsPanel.add(infrastructureButton);
        emergencyPanel.add(emergencySectionsPanel);
        
        // Important Numbers
        JLabel importantNumbersLabel = new JLabel("<html><h3>Important Numbers</h3></html>");
        emergencyPanel.add(importantNumbersLabel);
        
        JPanel numbersPanel = new JPanel(new GridLayout(2, 1));
        JLabel assistanceLabel = new JLabel("<html><img src='https://img.icons8.com/material-outlined/24/000000/phone.png'> 24x7 Assistance<br>022 24447523</html>");
        JLabel ambulanceLabel = new JLabel("<html><img src='https://img.icons8.com/material-outlined/24/000000/ambulance.png'> Ambulance & Emergency<br>09820885000</html>");
        numbersPanel.add(assistanceLabel);
        numbersPanel.add(ambulanceLabel);
        emergencyPanel.add(numbersPanel);

        // Add panels to the main panel
        mainPanel.add(doctorPanel);
        mainPanel.add(emergencyPanel);

        // Add the main panel to the frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }
}
