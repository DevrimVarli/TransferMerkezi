package TransferMerkezi;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TransferMerkezi.baglanti;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GozlemciKayıtFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_tc;
	private JTextField text_kadi;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GozlemciKayıtFrame frame = new GozlemciKayıtFrame();
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
	public GozlemciKayıtFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(64, 128, 128));
		contentPane_1.setBounds(0, 0, 436, 263);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("Kullanici Adi:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(70, 82, 142, 27);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T.C NO:");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(70, 44, 142, 27);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Şifre:");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(70, 118, 142, 27);
		contentPane_1.add(lblNewLabel_1_2);
		
		text_tc = new JTextField();
		text_tc.setColumns(10);
		text_tc.setBounds(209, 47, 96, 20);
		contentPane_1.add(text_tc);
		
		text_kadi = new JTextField();
		text_kadi.setColumns(10);
		text_kadi.setBounds(209, 85, 96, 20);
		contentPane_1.add(text_kadi);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(209, 121, 96, 20);
		contentPane_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Kayıt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet myRs= baglanti.yap();
				String Tc=text_tc.getText();
				String ad=text_kadi.getText();
				String sifre=new String(passwordField.getPassword());
				String sql1="INSERT INTO kullanıcı1 (Tc,ad,sifre) VALUES ("+Tc+",'"+ad+"','"+sifre+"')";
				baglanti.ekle(sql1);
				//System.out.println("KAyıt basarili");
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnNewButton.setBounds(141, 171, 139, 20);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("geridön");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GozlemciGirisFrame frame=new GozlemciGirisFrame();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(282, 215, 119, 27);
		contentPane_1.add(btnNewButton_1);
	}
}
