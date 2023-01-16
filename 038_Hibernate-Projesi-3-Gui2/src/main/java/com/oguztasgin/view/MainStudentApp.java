package com.oguztasgin.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.oguztasgin.entity.ContactPerson;
import com.oguztasgin.entity.Student;
import com.oguztasgin.service.StudentService;
import com.oguztasgin.utils.Images;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class MainStudentApp {
	private StudentService studentService;
	private JFrame ogrenciBilgileri;
	private JTextField textFieldID;
	private JTextField textFieldEmail;
	private JTextField textFieldFirstname;
	private JTextField textFieldLastname;
	private JTextField textFieldPhone1;
	private JTextField textFieldAddress1;
	private JTextField textFieldPhone2;
	private JTextField textFieldAddress2;
	private JTable table;
	private JComboBox comboBoxGender;
	private JButton btnQueryEmail;
	private JButton btnQueryName;
	private JLabel lblCon1;
	private JButton btnQueryLastName;
	private JLabel lblCon2;
	private JLabel lblPhone;
	private JLabel lblAddress;
	private JButton btnGetAll;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JComboBox comboBox_1;
	private JLabel lblGender;
	private JLabel lblEmail;
	private JLabel lblName;
	private JLabel lblLastName;
	private JLabel lblId;
	private ResourceBundle resourceBundle;
	private  JLabel lblPhoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainStudentApp window = new MainStudentApp();
					window.ogrenciBilgileri.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainStudentApp() {
		initialize();
		Locale.setDefault(new Locale("en", "EN"));
		i18n();
		studentService = new StudentService();
	}
	
	public void i18n() {
		resourceBundle = ResourceBundle.getBundle("com.oguztasgin/config/resource_bundle");
		btnGetAll.setText(resourceBundle.getString("wordGetAll"));
		btnSave.setText(resourceBundle.getString("wordSave"));
		btnUpdate.setText(resourceBundle.getString("wordUpdate"));
		btnDelete.setText(resourceBundle.getString("wordDelete"));
		lblAddress.setText(resourceBundle.getString("wordAddress"));
		lblCon1.setText(resourceBundle.getString("wordCon1"));
		lblCon2.setText(resourceBundle.getString("wordCon2"));
		lblPhone.setText(resourceBundle.getString("wordPhoneNumber"));
		lblEmail.setText(resourceBundle.getString("wordEmail"));
		lblName.setText(resourceBundle.getString("wordName"));
		lblLastName.setText(resourceBundle.getString("wordLastName"));
		lblGender.setText(resourceBundle.getString("wordGender"));
		btnQueryEmail.setText(resourceBundle.getString("wordQuery"));
		btnQueryName.setText(resourceBundle.getString("wordQuery"));
		btnQueryLastName.setText(resourceBundle.getString("wordQuery"));
		
		
		comboBoxGender.removeAllItems();
		comboBoxGender.addItem(resourceBundle.getString("wordMale"));
		comboBoxGender.addItem(resourceBundle.getString("wordFemale"));
		

//		table.getColumnModel().getColumn(1).setHeaderValue(resourceBundle.getString("tableEmail"));
//		table.getColumnModel().getColumn(2).setHeaderValue(resourceBundle.getString("tableName"));
//		table.getColumnModel().getColumn(3).setHeaderValue(resourceBundle.getString("tableLastName"));
		
		table.getColumnModel().getColumn(1).setHeaderValue(resourceBundle.getString("tableEmail"));
		table.getColumnModel().getColumn(2).setHeaderValue(resourceBundle.getString("tableName"));
		table.getColumnModel().getColumn(3).setHeaderValue(resourceBundle.getString("tableLastName"));
		table.updateUI();
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ogrenciBilgileri = new JFrame();
		ogrenciBilgileri.setTitle("Öğrenci Bilgileri");
		ogrenciBilgileri.setBounds(100, 100, 848, 481);
		ogrenciBilgileri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ogrenciBilgileri.getContentPane().setLayout(null);
		
		lblId = new JLabel("ID");
		lblId.setBounds(123, 48, 46, 14);
		ogrenciBilgileri.getContentPane().add(lblId);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(123, 73, 46, 14);
		ogrenciBilgileri.getContentPane().add(lblEmail);
		
		lblName = new JLabel("First name");
		lblName.setBounds(123, 98, 46, 14);
		ogrenciBilgileri.getContentPane().add(lblName);
		
		lblLastName = new JLabel("Last name");
		lblLastName.setBounds(123, 123, 46, 14);
		ogrenciBilgileri.getContentPane().add(lblLastName);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(123, 157, 46, 14);
		ogrenciBilgileri.getContentPane().add(lblGender);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(192, 45, 86, 20);
		ogrenciBilgileri.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(192, 70, 86, 20);
		ogrenciBilgileri.getContentPane().add(textFieldEmail);
		
		textFieldFirstname = new JTextField();
		textFieldFirstname.setColumns(10);
		textFieldFirstname.setBounds(192, 95, 86, 20);
		ogrenciBilgileri.getContentPane().add(textFieldFirstname);
		
		textFieldLastname = new JTextField();
		textFieldLastname.setColumns(10);
		textFieldLastname.setBounds(192, 120, 86, 20);
		ogrenciBilgileri.getContentPane().add(textFieldLastname);
		
		comboBoxGender = new JComboBox();
		comboBoxGender.setBounds(192, 153, 61, 22);
		ogrenciBilgileri.getContentPane().add(comboBoxGender);
		
		btnQueryEmail = new JButton("Query");
		btnQueryEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Student> list = studentService.getByEmail(textFieldEmail.getText());
				tabloyuDoldur(list);
			}
		});
		btnQueryEmail.setBounds(290, 69, 89, 23);
		ogrenciBilgileri.getContentPane().add(btnQueryEmail);
		
		btnQueryName = new JButton("Query");
		btnQueryName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Student> list = studentService.getByName(textFieldFirstname.getText());
				tabloyuDoldur(list);
			}
		});
		btnQueryName.setBounds(290, 94, 89, 23);
		ogrenciBilgileri.getContentPane().add(btnQueryName);
		
		btnQueryLastName = new JButton("Query");
		btnQueryLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Student> list = studentService.getByLastName(textFieldLastname.getText());
				tabloyuDoldur(list);
			}
		});
		btnQueryLastName.setBounds(290, 119, 89, 23);
		ogrenciBilgileri.getContentPane().add(btnQueryLastName);
		
		lblCon1 = new JLabel("Contact Information-1");
		lblCon1.setBounds(468, 45, 78, 14);
		ogrenciBilgileri.getContentPane().add(lblCon1);
		
		lblCon2 = new JLabel("Contact Information-2");
		lblCon2.setBounds(575, 45, 78, 14);
		ogrenciBilgileri.getContentPane().add(lblCon2);
		
		lblPhone = new JLabel("Phone number");
		lblPhone.setBounds(406, 70, 46, 14);
		ogrenciBilgileri.getContentPane().add(lblPhone);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(406, 98, 46, 14);
		ogrenciBilgileri.getContentPane().add(lblAddress);
		
		textFieldPhone1 = new JTextField();
		textFieldPhone1.setBounds(460, 67, 86, 20);
		ogrenciBilgileri.getContentPane().add(textFieldPhone1);
		textFieldPhone1.setColumns(10);
		
		textFieldAddress1 = new JTextField();
		textFieldAddress1.setColumns(10);
		textFieldAddress1.setBounds(460, 95, 86, 20);
		ogrenciBilgileri.getContentPane().add(textFieldAddress1);
		
		textFieldPhone2 = new JTextField();
		textFieldPhone2.setColumns(10);
		textFieldPhone2.setBounds(567, 67, 86, 20);
		ogrenciBilgileri.getContentPane().add(textFieldPhone2);
		
		textFieldAddress2 = new JTextField();
		textFieldAddress2.setColumns(10);
		textFieldAddress2.setBounds(567, 95, 86, 20);
		ogrenciBilgileri.getContentPane().add(textFieldAddress2);
		
		lblPhoto = new JLabel("");
		//lblPhoto.setIcon(new ImageIcon("C:\\Users\\Irem\\Downloads\\MicrosoftTeams-imageX.png"));
		lblPhoto.setBounds(725, 24, 70, 65);
		ogrenciBilgileri.getContentPane().add(lblPhoto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 218, 582, 199);
		ogrenciBilgileri.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int satir = table.getSelectedRow(); 
				TableModel model = table.getModel();
				textFieldID.setText(model.getValueAt(satir, 0).toString());
				textFieldEmail.setText(model.getValueAt(satir, 1).toString());
				textFieldFirstname.setText(model.getValueAt(satir, 2).toString());
				textFieldLastname.setText(model.getValueAt(satir, 3).toString());
				String adres1 = studentService.getById(model.getValueAt(satir, 0).toString()).getContactPerson().getAddress1();
				String adres2 = studentService.getById(model.getValueAt(satir, 0).toString()).getContactPerson().getAddress2();
				String tel1 = studentService.getById(model.getValueAt(satir, 0).toString()).getContactPerson().getPhoneNumber1();
				String tel2 = studentService.getById(model.getValueAt(satir, 0).toString()).getContactPerson().getPhoneNumber1();
				Student student = null;
				student = studentService.getById(model.getValueAt(satir, 0).toString());
				textFieldAddress1.setText(adres1);
				textFieldAddress2.setText(adres2);
				textFieldPhone1.setText(tel1);
				textFieldPhone2.setText(tel2);
				//# To get images
				Images images = new Images();
				images.getPhoto(student.getId());
				String imageAddress = images.getPhoto(student.getId());
				lblPhoto.setIcon(new ImageIcon(imageAddress));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Email", "First name", "Last name"
			}
		));
		scrollPane.setViewportView(table);
		
		btnGetAll = new JButton("GetAll");
		btnGetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Student> list = studentService.getAll();
				tabloyuDoldur(list);
			}
		});
		btnGetAll.setBounds(253, 181, 89, 23);
		ogrenciBilgileri.getContentPane().add(btnGetAll);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactPerson contactPerson = new ContactPerson(textFieldPhone1.getText(),
						textFieldAddress1.getText(), textFieldPhone2.getText(), textFieldAddress2.getText());
				Student student = new Student(textFieldFirstname.getText(),
						textFieldLastname.getText(), textFieldEmail.getText(),
						comboBoxGender.getSelectedItem().toString(), contactPerson);
				studentService.save(student);
				
				List<Student> list = studentService.getAll();
				tabloyuDoldur(list);
			}
		});
		btnSave.setBounds(352, 181, 89, 23);
		ogrenciBilgileri.getContentPane().add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactPerson contactPerson = new ContactPerson(textFieldPhone1.getText(),
						textFieldAddress1.getText(), textFieldPhone2.getText(), textFieldAddress2.getText());
				studentService.update(textFieldID.getText(), textFieldFirstname.getText(),
						textFieldLastname.getText(), textFieldEmail.getText(),
						comboBoxGender.getSelectedItem().toString(), contactPerson);
				
				List<Student> list = studentService.getAll();
				tabloyuDoldur(list);
			}
		});
		btnUpdate.setBounds(460, 181, 89, 23);
		ogrenciBilgileri.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentService.delete(textFieldID.getText());
				
				List<Student> list = studentService.getAll();
				tabloyuDoldur(list);
				
				textFieldlariBosalt();
			}
		});
		btnDelete.setBounds(559, 181, 89, 23);
		ogrenciBilgileri.getContentPane().add(btnDelete);
		
		JLabel lblLan = new JLabel("Language");
		lblLan.setBounds(725, 355, 70, 14);
		ogrenciBilgileri.getContentPane().add(lblLan);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1.getSelectedItem().toString().equalsIgnoreCase("English")) {
					Locale.setDefault(new Locale("en", "EN"));
					i18n();
				}else if(comboBox_1.getSelectedItem().toString().equalsIgnoreCase("French")) {
					Locale.setDefault(new Locale("fr", "FR"));
					i18n();
				}else if(comboBox_1.getSelectedItem().toString().equalsIgnoreCase("Turkish")) {
					Locale.setDefault(new Locale("tr", "TR"));
					i18n();
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"English", "French", "Turkish"}));
		comboBox_1.setBounds(725, 385, 70, 22);
		ogrenciBilgileri.getContentPane().add(comboBox_1);
	}
	
	protected void textFieldlariBosalt() {
		textFieldID.setText("");
		textFieldFirstname.setText("");
		textFieldLastname.setText("");
		textFieldEmail.setText("");
		textFieldAddress1.setText("");
		textFieldAddress2.setText("");
		textFieldPhone1.setText("");
		textFieldPhone2.setText("");
		
	}

	protected void tabloyuDoldur(List<Student> list) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		Object [] columns = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			columns[0] = list.get(i).getId();
			columns[1] = list.get(i).getEmail();
			columns[2] = list.get(i).getFirstName();
			columns[3] = list.get(i).getLastName();
			
			model.addRow(columns);
		}	
	}
}
