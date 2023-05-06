package jepm.proyect.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jepm.proyect.controller.EstudianteController;
import jepm.proyect.model.Estudiante;

import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField jtf_id;
	private JTextField jtf_name;
	private JTextField jtf_lastname1;
	private JTextField jtf_lastname2;
	private JTextField jtf_DNI;
	private JTextField jtf_address;
	private JTextField jtf_email;
	private JTextField jtf_phoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Gestion Estudiantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		contentPane.add(splitPane, gbc_splitPane);
		
		JPanel jp_TablePanel = new JPanel();
		splitPane.setLeftComponent(jp_TablePanel);
		GridBagLayout gbl_JP_TablePanel = new GridBagLayout();
		gbl_JP_TablePanel.columnWidths = new int[]{467, 0};
		gbl_JP_TablePanel.rowHeights = new int[]{73, 0};
		gbl_JP_TablePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_JP_TablePanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		jp_TablePanel.setLayout(gbl_JP_TablePanel);
		
		JTable studentTable = new JTable(EstudianteController.getTableData(), 
				EstudianteController.getColumnTittle());
		JScrollPane jsp_StudentTableScrollPane = new JScrollPane(studentTable);
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex2 = studentTable.getSelectedRow();
				int studentId = (int) EstudianteController.getTableData()[rowIndex2][0];
				super.mouseClicked(e);
				setValuesToUpdatePanel(studentId);
			}
		});
		GridBagConstraints gbc_JSP_StudentTableScrollPane = new GridBagConstraints();
		gbc_JSP_StudentTableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_JSP_StudentTableScrollPane.gridx = 0;
		gbc_JSP_StudentTableScrollPane.gridy = 0;
		jp_TablePanel.add(jsp_StudentTableScrollPane, gbc_JSP_StudentTableScrollPane);
		
		JPanel jp_UpdatePanel = new JPanel();
		splitPane.setRightComponent(jp_UpdatePanel);
		GridBagLayout gbl_JP_UpdatePanel = new GridBagLayout();
		gbl_JP_UpdatePanel.columnWidths = new int[]{0, 254};
		gbl_JP_UpdatePanel.columnWeights = new double[]{0.0, 0.0};
//		gbl_JP_UpdatePanel.columnWidths = new int[]{0, 0, 0};
//		gbl_JP_UpdatePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gbl_JP_UpdatePanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gbl_JP_UpdatePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		jp_UpdatePanel.setLayout(gbl_JP_UpdatePanel);
		
		JLabel lblNewLabel = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		jp_UpdatePanel.add(lblNewLabel, gbc_lblNewLabel);
		
		jtf_id = new JTextField();
		GridBagConstraints gbc_jtf_id = new GridBagConstraints();
		gbc_jtf_id.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_id.gridx = 1;
		gbc_jtf_id.gridy = 0;
		jp_UpdatePanel.add(jtf_id, gbc_jtf_id);
		jtf_id.setColumns(10);
		jtf_id.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		jp_UpdatePanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtf_name = new JTextField();
		GridBagConstraints gbc_jtf_name = new GridBagConstraints();
		gbc_jtf_name.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_name.gridx = 1;
		gbc_jtf_name.gridy = 1;
		jp_UpdatePanel.add(jtf_name, gbc_jtf_name);
		jtf_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 1: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		jp_UpdatePanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtf_lastname1 = new JTextField();
		jtf_lastname1.setColumns(10);
		GridBagConstraints gbc_jtf_lastname1 = new GridBagConstraints();
		gbc_jtf_lastname1.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_lastname1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_lastname1.gridx = 1;
		gbc_jtf_lastname1.gridy = 2;
		jp_UpdatePanel.add(jtf_lastname1, gbc_jtf_lastname1);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 2: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		jp_UpdatePanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtf_lastname2 = new JTextField();
		jtf_lastname2.setColumns(10);
		GridBagConstraints gbc_jtf_lastname2 = new GridBagConstraints();
		gbc_jtf_lastname2.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_lastname2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_lastname2.gridx = 1;
		gbc_jtf_lastname2.gridy = 3;
		jp_UpdatePanel.add(jtf_lastname2, gbc_jtf_lastname2);
		
		JLabel lblNewLabel_4 = new JLabel("DNI: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		jp_UpdatePanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtf_DNI = new JTextField();
		jtf_DNI.setColumns(10);
		GridBagConstraints gbc_jtf_DNI = new GridBagConstraints();
		gbc_jtf_DNI.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_DNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_DNI.gridx = 1;
		gbc_jtf_DNI.gridy = 4;
		jp_UpdatePanel.add(jtf_DNI, gbc_jtf_DNI);
		
		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		jp_UpdatePanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtf_address = new JTextField();
		jtf_address.setColumns(10);
		GridBagConstraints gbc_jtf_address = new GridBagConstraints();
		gbc_jtf_address.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_address.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_address.gridx = 1;
		gbc_jtf_address.gridy = 5;
		jp_UpdatePanel.add(jtf_address, gbc_jtf_address);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		jp_UpdatePanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtf_email = new JTextField();
		jtf_email.setColumns(10);
		GridBagConstraints gbc_jtf_email = new GridBagConstraints();
		gbc_jtf_email.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_email.gridx = 1;
		gbc_jtf_email.gridy = 6;
		jp_UpdatePanel.add(jtf_email, gbc_jtf_email);
		
		JLabel lblNewLabel_7 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		jp_UpdatePanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtf_phoneNumber = new JTextField();
		jtf_phoneNumber.setColumns(10);
		GridBagConstraints gbc_jtf_phoneNumber = new GridBagConstraints();
		gbc_jtf_phoneNumber.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_phoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_phoneNumber.gridx = 1;
		gbc_jtf_phoneNumber.gridy = 7;
		jp_UpdatePanel.add(jtf_phoneNumber, gbc_jtf_phoneNumber);
		
		JLabel lblNewLabel_8 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		jp_UpdatePanel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JComboBox jcb_gender = new JComboBox();
		GridBagConstraints gbc_jcb_gender = new GridBagConstraints();
		gbc_jcb_gender.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_gender.gridx = 1;
		gbc_jcb_gender.gridy = 8;
		jp_UpdatePanel.add(jcb_gender, gbc_jcb_gender);
	}
	
	
	/**
	 * Set values to the updatePanel's fiels.
	 * @param id
	 */
	private void setValuesToUpdatePanel(int id) {
		Estudiante e = EstudianteController.findbyId(id);
		jtf_id.setText(e.getId() + "");
		jtf_name.setText(e.getNombre());
		jtf_lastname1.setText(e.getApellido1());
		jtf_lastname2.setText(e.getApellido2());
		jtf_DNI.setText(e.getDni());
		jtf_address.setText(e.getDireccion());
		jtf_email.setText(e.getEmail());
		jtf_phoneNumber.setText(e.getTelefono()+"");
		
	}
	
	

}
