package TransferMerkezi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnaGirisFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaGirisFrame frame = new AnaGirisFrame();
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
	public AnaGirisFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                  TRANSFER MERKEZİNE HOŞGELDİNİZ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 402, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Teknik Ekip Girişi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TdGirisFrame tdgiris = new TdGirisFrame();
				tdgiris.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton.setBounds(10, 175, 165, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gözlemci Girişi");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GozlemciGirisFrame gozlemcigiris = new GozlemciGirisFrame();
				gozlemcigiris.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
		btnNewButton_1.setBounds(10, 90, 165, 55);
		contentPane.add(btnNewButton_1);
		
		
	}
}
