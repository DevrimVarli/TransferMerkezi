package TransferMerkezi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TransferMerkezi.AnaGirisFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class TdGirisFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_kadi;
	static String ad;
	static String sifre;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TdGirisFrame frame = new TdGirisFrame();
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
	public TdGirisFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_kullanıcıadi = new JLabel("Kullanıcı Adı:");
		lbl_kullanıcıadi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lbl_kullanıcıadi.setBounds(67, 54, 104, 27);
		contentPane.add(lbl_kullanıcıadi);
		
		text_kadi = new JTextField();
		text_kadi.setBounds(211, 60, 104, 20);
		contentPane.add(text_kadi);
		text_kadi.setColumns(10);
		
		JLabel lbl_sifre = new JLabel("Şifre:");
		lbl_sifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lbl_sifre.setBounds(67, 91, 104, 27);
		contentPane.add(lbl_sifre);
		
		JButton btnkgiris = new JButton("Giriş");
		btnkgiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad=text_kadi.getText();
				String sifre=new String(passwordField.getPassword());
				String sql_sorgu="SELECT count(Tc) as giris FROM teknik_ekip1 where ad='"+ad+"' and sifre='"+sifre+"'";
				ResultSet myRs=baglanti.yap();
				myRs =baglanti.sorgula(sql_sorgu);
				try {
					while(myRs.next()) {
						if(myRs.getInt("giris")==1) {
							TdFrame frm=new TdFrame();
							frm.setVisible(true);
							setVisible(false);
						}else {
							btnkgiris.setText("Hatalı Giris");
						}
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnkgiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnkgiris.setBounds(211, 146, 104, 27);
		contentPane.add(btnkgiris);
		
		JButton btnNewButton = new JButton("Geri Dön");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaGirisFrame anaGirisframe = new AnaGirisFrame();
				anaGirisframe.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnNewButton.setBounds(337, 229, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(208, 97, 107, 20);
		contentPane.add(passwordField);
		
		JButton btnKaytOl = new JButton("Kayıt Ol");
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TdKayıtFrame frame=new TdKayıtFrame();
				frame.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnKaytOl.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnKaytOl.setBounds(97, 146, 104, 27);
		contentPane.add(btnKaytOl);
	}
}