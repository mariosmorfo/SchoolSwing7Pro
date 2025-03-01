package gr.aueb.cf.schoolapp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import gr.aueb.cf.schoolapp.model.City;

public class UpdateTeacherPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstnameText;
	private JTextField lastnameText;
	private JTextField vatText;
	private JTextField fathernameText;
	private JTextField phoneNumberText;
	private JTextField emailText;
	private JTextField streetText;
	private JTextField streetNumberText;
	private JTextField zipcodeText;
	private JLabel errorFirstname;
	private JLabel errorLastname;
	private JTextField cityText;
	//private JComboBox<City> cityComboBox;
	//private List<City> cities = new ArrayList<>();

	public UpdateTeacherPage() {
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Ποιότητα στην Εκπαίδευση");
		setBounds(100, 100, 857, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeacherInfo = new JLabel("Στοιχεία Εκπαιδευτή");
		lblTeacherInfo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTeacherInfo.setBounds(267, 63, 341, 44);
		contentPane.add(lblTeacherInfo);
		
		firstnameText = new JTextField();
		firstnameText.setBounds(91, 131, 263, 37);
		contentPane.add(firstnameText);
		firstnameText.setColumns(10);
		
		
		
		lastnameText = new JTextField();
		lastnameText.setColumns(10);
		lastnameText.setBounds(512, 131, 263, 37);
		contentPane.add(lastnameText);
		
		
		
		JLabel lblFirstname = new JLabel("Όνομα*");
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstname.setBounds(29, 135, 62, 29);
		contentPane.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Επώνυμο*");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastname.setBounds(432, 135, 84, 29);
		contentPane.add(lblLastname);
		
		JLabel lblVat = new JLabel("ΑΦΜ*");
		lblVat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVat.setBounds(41, 202, 50, 29);
		contentPane.add(lblVat);
		
		vatText = new JTextField();
		vatText.setColumns(10);
		vatText.setBounds(91, 198, 263, 37);
		contentPane.add(vatText);
		
		JLabel lblFathername = new JLabel("Πατρώνυμο*");
		lblFathername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFathername.setBounds(421, 202, 95, 29);
		contentPane.add(lblFathername);
		
		fathernameText = new JTextField();
		fathernameText.setColumns(10);
		fathernameText.setBounds(512, 198, 263, 37);
		contentPane.add(fathernameText);
		
		JLabel lblPhoneNumber = new JLabel("Τηλέφωνο*");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhoneNumber.setBounds(10, 275, 81, 29);
		contentPane.add(lblPhoneNumber);
		
		phoneNumberText = new JTextField();
		phoneNumberText.setColumns(10);
		phoneNumberText.setBounds(91, 271, 263, 37);
		contentPane.add(phoneNumberText);
		
		JLabel lblEmail = new JLabel("e-mail*");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(460, 275, 56, 29);
		contentPane.add(lblEmail);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(512, 271, 263, 37);
		contentPane.add(emailText);
		
		JLabel lblStreet = new JLabel("Διεύθυνση*");
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStreet.setBounds(10, 342, 81, 29);
		contentPane.add(lblStreet);
		
		streetText = new JTextField();
		streetText.setColumns(10);
		streetText.setBounds(91, 338, 263, 37);
		contentPane.add(streetText);
		
		JLabel lblStreetNumber = new JLabel("Αριθμός*");
		lblStreetNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStreetNumber.setBounds(446, 342, 70, 29);
		contentPane.add(lblStreetNumber);
		
		streetNumberText = new JTextField();
		streetNumberText.setColumns(10);
		streetNumberText.setBounds(512, 338, 263, 37);
		contentPane.add(streetNumberText);
		
		JLabel lblCity = new JLabel("Πόλη*");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(41, 411, 50, 29);
		contentPane.add(lblCity);
		
		JLabel lblZipCode = new JLabel("ΤΚ*");
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblZipCode.setBounds(481, 411, 35, 29);
		contentPane.add(lblZipCode);
		
		zipcodeText = new JTextField();
		zipcodeText.setColumns(10);
		zipcodeText.setBounds(512, 407, 263, 37);
		contentPane.add(zipcodeText);
		
		errorFirstname = new JLabel("");
		errorFirstname.setForeground(new Color(255, 0, 0));
		errorFirstname.setBounds(92, 167, 260, 29);
		contentPane.add(errorFirstname);
		
		errorLastname = new JLabel("");
		errorLastname.setForeground(new Color(255, 0, 0));
		errorLastname.setBounds(514, 167, 260, 29);
		contentPane.add(errorLastname);
		
		//cityComboBox = new JComboBox<>();
//		cityComboBox.setBounds(89, 407, 263, 37);
//		contentPane.add(cityComboBox);
        
		
		JButton updateBtn = new JButton("Ενημέρωση");
		
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updateBtn.setForeground(new Color(255, 255, 255));
		updateBtn.setBackground(new Color(64, 128, 128));
		updateBtn.setBounds(512, 485, 263, 54);
		contentPane.add(updateBtn);
		
		JButton closeBtn = new JButton("Κλείσιμο");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getViewTeachersPage().setEnabled(true);
				Main.getUpdateTeacherPage().setVisible(false);
			}
		});
		
		closeBtn.setForeground(new Color(0, 0, 0));
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		closeBtn.setBackground(new Color(192, 192, 192));
		closeBtn.setBounds(91, 485, 263, 54);
		contentPane.add(closeBtn);	
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(new Color(0, 52, 117));
		header.setBounds(0, 0, 842, 56);
		contentPane.add(header);
		
		JLabel govImage = new JLabel("");
		govImage.setIcon(new ImageIcon(UpdateTeacherPage.class.getResource("/images/gov_logo_small.png")));
		govImage.setBounds(10, 0, 154, 56);
		header.add(govImage);
		
		JLabel firstLastName = new JLabel("Μάριος Μορφονίδης");
		firstLastName.setForeground(Color.WHITE);
		firstLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		firstLastName.setBounds(683, 11, 123, 34);
		header.add(firstLastName);
		
		JPanel footer = new JPanel();
		footer.setLayout(null);
		footer.setBounds(0, 558, 842, 104);
		contentPane.add(footer);
		
		JLabel lblManual = new JLabel("Εγχειρίδιο Χρήσης");
		lblManual.setForeground(Color.BLUE);
		lblManual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblManual.setBounds(126, 32, 112, 34);
		footer.add(lblManual);
		
		JLabel lblQuestions = new JLabel("Συχνές Ερωτήσεις");
		lblQuestions.setForeground(Color.BLUE);
		lblQuestions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuestions.setBounds(364, 32, 112, 34);
		footer.add(lblQuestions);
		
		JLabel lblSupport = new JLabel("Υποστήριξη Πολιτών");
		lblSupport.setForeground(Color.BLUE);
		lblSupport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSupport.setBounds(602, 32, 112, 34);
		footer.add(lblSupport);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 128, 255));
		separator.setBounds(0, 2, 746, 1);
		footer.add(separator);
		
		cityText = new JTextField();
		cityText.setColumns(10);
		cityText.setBounds(91, 407, 263, 37);
		contentPane.add(cityText);
	}
}


