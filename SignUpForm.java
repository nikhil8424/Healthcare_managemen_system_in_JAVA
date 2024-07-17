import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpForm {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Signup Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Left panel for the form
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("Hospital Staff Login");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(title, gbc);

        // Name field
        JLabel nameLabel = new JLabel("ADMIN ID");
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(nameLabel, gbc);

        JTextField nameField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Email field
        JLabel emailLabel = new JLabel("Email address");
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(emailLabel, gbc);

        JTextField emailField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        // Password field
        JLabel passwordLabel = new JLabel("Password");
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        // Terms and policy checkbox
        JCheckBox termsCheckbox = new JCheckBox("I agree to the terms & policy");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        formPanel.add(termsCheckbox, gbc);

        // Signup button
        JButton signupButton = new JButton("Signup");
        signupButton.setBackground(new Color(85, 107, 47));
        signupButton.setForeground(Color.WHITE);
        gbc.gridy++;
        formPanel.add(signupButton, gbc);

        // Divider
        JLabel dividerLabel = new JLabel("Are you a Patient?");
        dividerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridy++;
        formPanel.add(dividerLabel, gbc);

        // Google and Apple sign-in buttons
        JButton googleButton = new JButton("Go to the Website");
        gbc.gridy++;
        formPanel.add(googleButton, gbc);

        // Add ActionListener to the "Go to the Website" button
        googleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @SuppressWarnings("static-access")
                    public void run() {
                        new HomePageGui().main(null);
                    }
                });
            }
        });

        //moving forward to homepage'
        // Signup button ActionListener
signupButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if ADMIN ID and password match the expected values
        String adminId = nameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (adminId.equals("12345") && password.equals("12345")) {
            // Open HomePageGui
            SwingUtilities.invokeLater(new Runnable() {
                @SuppressWarnings("static-access")
                public void run() {
                    new HomePageGui().main(null);
                }
            });
        } else {
            // Show an error message or handle invalid login
            JOptionPane.showMessageDialog(frame,
                    "Invalid ADMIN ID or password. Please try again.",
                    "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});


        

        // Right panel for the image
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("loginimage.jpg");
                Image image = imageIcon.getImage();
                int width = getWidth();
                int height = getHeight();
                g.drawImage(image, 0, 0, width, height, this);
            }
        };

        // Split pane to divide the frame into two equal vertical parts
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, formPanel, imagePanel);
        splitPane.setDividerLocation(400); // Set the divider to the middle
        splitPane.setResizeWeight(0.5); // Set equal resizing weight

        // Add the split pane to the frame
        frame.add(splitPane);

        // Make the frame visible
        frame.setVisible(true);
    }
}
