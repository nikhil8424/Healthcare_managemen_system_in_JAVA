import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.border.TitledBorder;

public class HomePageGui {
    //googlemapthingd
    private static void openGoogleMapsWindow() {
    try {
        Desktop.getDesktop().browse(new URI("https://www.google.com/maps?q=19.033205,72.838605"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Hospital GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        // Set background color of the entire frame
        Color backgroundColor = new Color(228, 241, 238);
        frame.getContentPane().setBackground(backgroundColor);

        // Top panel
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        String[] topLabels = {
            "BOOK AN APPOINTMENT", "FIND DOCTORS", "ONLINE SERVICES",   
            "HEALTHFIRST", "ANYTHING MORE", "ANYTHING MORE"
        };

        for (int i = 0; i < topLabels.length; i++) {
            gbc.gridx = i;
            gbc.gridy = 0;
            RoundedButton button = new RoundedButton(topLabels[i]);
            button.setPreferredSize(new Dimension(200, 50));
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(0, 51, 153));
            button.setFont(new Font("Arial", Font.BOLD, 14));
            topPanel.add(button, gbc);
        }

        frame.add(topPanel, BorderLayout.NORTH);

        // Main content panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1;
        gbc.weighty = 1;

        // For Patients panel
        JPanel forPatientsPanel = new JPanel(new GridBagLayout());
        TitledBorder border = BorderFactory.createTitledBorder("For Patients");
        border.setTitleFont(new Font("Arial", Font.BOLD, 24)); 
        forPatientsPanel.setBorder(border);
        forPatientsPanel.setBackground(backgroundColor);
        String[] services = {
            "Consultation", "Admission Process", "Insurance & TPA", "Hospital Tour",
            "24*7 Emergency", "E-Brochure", "Short Stay Service"
        };

        GridBagConstraints patientsGbc = new GridBagConstraints();
        patientsGbc.insets = new Insets(10, 10, 10, 10);
        patientsGbc.weightx = 1;
        patientsGbc.weighty = 1;
        patientsGbc.fill = GridBagConstraints.HORIZONTAL; // Ensure buttons fill the horizontal space

        for (int i = 0; i < services.length; i++) {
            patientsGbc.gridx = i % 4;
            patientsGbc.gridy = i / 4;
            JButton button = new JButton(services[i]);
            button.setPreferredSize(new Dimension(200, 50));
            button.setBackground(new Color(0, 51, 153));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            if (services[i].equals("E-Brochure")) {
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URI("https://hinduja-prod-assets.s3.ap-south-1.amazonaws.com/s3fs-public/2024-04/All%203%20booklet.pdf?VersionId=ADIij3yhcrDz4QsK_lfjvqpON55r16yT"));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            } else if (services[i].equals("Hospital Tour")) {
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        openGoogleMapsWindow();
                    }
                });
            }
            forPatientsPanel.add(button, patientsGbc);
        }
        

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(forPatientsPanel, gbc);

        // Doctor search panel
        JPanel doctorSearchPanel = new JPanel(new GridBagLayout());
        TitledBorder doctorSearchBorder = BorderFactory.createTitledBorder("Know about our Specialities, Doctors & Clinics");
        doctorSearchBorder.setTitleFont(new Font("Arial", Font.BOLD, 24));
        doctorSearchPanel.setBorder(doctorSearchBorder);
        doctorSearchPanel.setBackground(backgroundColor);

        GridBagConstraints doctorGbc = new GridBagConstraints();
        doctorGbc.insets = new Insets(5, 5, 5, 5);
        doctorGbc.weightx = 1;
        doctorGbc.weighty = 1;

        JLabel searchLabel = new JLabel("Find the right doctor for your needs:");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 20));
        doctorGbc.gridx = 0;
        doctorGbc.gridy = 0;
        doctorGbc.gridwidth = 2;
        doctorSearchPanel.add(searchLabel, doctorGbc);

        // Create the speciality combo box
         JComboBox<String> specialityBox = new JComboBox<>(new String[]{
            "Cardiology",
            "Neurology",
            "Orthopedics",
            "Pediatrics",
            "Dermatology",
            "Gastroenterology",
            "Oncology",
            "Endocrinology",
            "Ophthalmology",
            "Psychiatry",
            "Pulmonology",
            "Nephrology",
            "Hematology",
            "Rheumatology",
            "Urology",
            "Obstetrics and Gynecology",
            "Anesthesiology",
            "Radiology",
            "Pathology",
            "Otolaryngology",
            "Emergency Medicine",
            "General Surgery",
            "Plastic Surgery",
            "Geriatrics",
            "Family Medicine",
            "Sports Medicine",
            "Infectious Disease"
        });
        specialityBox.setFont(new Font("Arial", Font.PLAIN, 20));
        specialityBox.setPreferredSize(new Dimension(200, specialityBox.getPreferredSize().height));
        doctorGbc.gridx = 0;
        doctorGbc.gridy = 1;
        doctorGbc.gridwidth = 1;
        doctorSearchPanel.add(specialityBox, doctorGbc);

        // Create the sub category combo box
        JComboBox<String> subCategoryBox = new JComboBox<>(new String[]{
            "Interventional Cardiology",
            "Pediatric Cardiology",
            "Clinical Neurophysiology",
            "Neuromuscular Medicine",
            "Spine Surgery",
            "Pediatric Orthopedics",
            "Neonatology",
            "Pediatric Emergency Medicine",
            "Cosmetic Dermatology",
            "Dermatopathology",
            "Hepatology",
            "Colorectal Surgery",
            "Medical Oncology",
            "Radiation Oncology",
            "Diabetes",
            "Thyroid Disorders",
            "Cataract Surgery",
            "Retina/Vitreous Surgery",
            "Child Psychiatry",
            "Geriatric Psychiatry",
            "Critical Care Medicine",
            "Sleep Medicine",
            "Kidney Transplantation",
            "Dialysis",
            "Hematologic Malignancies",
            "Coagulation Disorders",
            "Pediatric Rheumatology",
            "Adult Rheumatology",
            "Pediatric Urology",
            "Urologic Oncology",
            "Maternal-Fetal Medicine",
            "Reproductive Endocrinology",
            "Pain Medicine",
            "Critical Care Anesthesiology",
            "Diagnostic Radiology",
            "Interventional Radiology",
            "Forensic Pathology",
            "Clinical Pathology",
            "Pediatric Otolaryngology",
            "Rhinology",
            "Pediatric Emergency Medicine",
            "Trauma Surgery",
            "Breast Surgery",
            "Reconstructive Surgery",
            "Cosmetic Surgery",
            "Geriatric Psychiatry",
            "Geriatric Neurology",
            "Adolescent Medicine",
            "Preventive Medicine",
            "Sports Medicine",
            "Orthopedic Sports Medicine",
            "HIV/AIDS",
            "Tropical Medicine"
        });

        subCategoryBox.setFont(new Font("Arial", Font.PLAIN, 20));
        subCategoryBox.setPreferredSize(new Dimension(200, subCategoryBox.getPreferredSize().height));
        doctorGbc.gridx = 1;
        doctorGbc.gridy = 1;
        doctorSearchPanel.add(subCategoryBox, doctorGbc);

        // Create the SEARCH button
        JButton searchButton = new JButton("SEARCH");
        searchButton.setFont(new Font("Arial", Font.BOLD, 20));
        searchButton.setBackground(new Color(0, 51, 153));
        searchButton.setForeground(Color.WHITE);
        searchButton.setPreferredSize(new Dimension(200, 50));
        doctorGbc.gridx = 0;
        doctorGbc.gridy = 2;
        doctorGbc.gridwidth = 2;
        doctorSearchPanel.add(searchButton, doctorGbc);

        // Add the doctor search panel to the main panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(doctorSearchPanel, gbc);

        // About panel
        JPanel aboutPanel = new JPanel(new BorderLayout());
        TitledBorder aboutBorder = BorderFactory.createTitledBorder("About MunnaBhai Multispeciality Hopsital");
        aboutBorder.setTitleFont(new Font("Arial", Font.BOLD, 24));
        aboutPanel.setBorder(aboutBorder);
        aboutPanel.setBackground(backgroundColor);

        JLabel aboutLabel = new JLabel("<html><body>"
    + "<h2>About MunnaBhai MBBS hospital</h2>"
    + "<p>“Our healthcare journey commenced in 2009 by the Shri Murli prashad sharma, "
    + "with a vision to provide quality healthcare for all. Over the last seven decades, "
    + "we have passionately followed this philosophy and today the hospital is regarded "
    + "as one of the top hospitals in Mumbai and one of the best hospitals in India. "
    + "We commit to move forward with greater zeal and determination to set new benchmarks "
    + "in medical excellence and patient care.”<br><br>"
    + "Health and Education are the birth right of every citizen"
    + "</p></body></html>");

        aboutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        aboutLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        aboutPanel.add(aboutLabel, BorderLayout.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;  // This makes the about panel take remaining vertical space
        mainPanel.add(aboutPanel, gbc);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Bottom panel for "Know More" button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(backgroundColor);

        JButton knowMoreButton = new JButton("KNOW MORE");
        knowMoreButton.setFont(new Font("Arial", Font.BOLD, 16));
        knowMoreButton.setBackground(new Color(0, 51, 153));
        knowMoreButton.setForeground(Color.WHITE);
        knowMoreButton.setPreferredSize(new Dimension(150, 50));
        bottomPanel.add(knowMoreButton);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Set frame visibility
        frame.setVisible(true);
    }
}