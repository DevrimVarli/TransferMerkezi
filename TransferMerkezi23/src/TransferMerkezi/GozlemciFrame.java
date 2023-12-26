package TransferMerkezi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GozlemciFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelim =new DefaultTableModel();
	Object[] kolonlar= {"id","ad","soyad","mevki","piyasa_degeri"} ;
	Object[] satirlar= new Object [5];
	private JButton btnListele;
	private JTextField text_id;
	private JTextField text_ad;
	private JTextField text_soyad;
	private JTextField text_mevki;
	private JTextField text_piyasadegeri;
	private JTextField text_sorguad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GozlemciFrame frame = new GozlemciFrame();
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
	public GozlemciFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 33, 286, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(53, 158, 283, 94);
		scrollPane.setViewportView(table);
		
		btnListele = new JButton("Listele");
		btnListele.setBackground(new Color(255, 128, 255));
		btnListele.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setRowCount(0);
				
				ResultSet myRs=baglanti.yap();
				modelim.addRow(satirlar);
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getInt("id");
						satirlar[1]=myRs.getString("ad");
						satirlar[2]=myRs.getString("soyad");
						satirlar[3]=myRs.getString("mevki");
						satirlar[4]=myRs.getInt("piyasa_degeri");
						modelim.addRow(satirlar);
						
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				table.setModel(modelim);
				
			}
		});
		btnListele.setBounds(371, 11, 139, 31);
		contentPane.add(btnListele);
		
		text_id = new JTextField();
		text_id.setBounds(436, 53, 96, 20);
		contentPane.add(text_id);
		text_id.setColumns(10);
		
		text_ad = new JTextField();
		text_ad.setBounds(436, 84, 96, 20);
		contentPane.add(text_ad);
		text_ad.setColumns(10);
		
		text_soyad = new JTextField();
		text_soyad.setBounds(436, 115, 96, 20);
		contentPane.add(text_soyad);
		text_soyad.setColumns(10);
		
		text_mevki = new JTextField();
		text_mevki.setBounds(436, 145, 96, 20);
		contentPane.add(text_mevki);
		text_mevki.setColumns(10);
		
		JButton btnkayıt = new JButton("Kaydet");
		btnkayıt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,ad,soyad,mevki,piyasa_degeri,sql_sorgu;
				id=text_id.getText();
				ad=text_ad.getText();
				soyad=text_soyad.getText();
				mevki=text_mevki.getText();
				piyasa_degeri=text_piyasadegeri.getText();
				sql_sorgu="INSERT INTO new_table(id,ad,soyad,mevki,piyasa_degeri) VALUES ("+id+",'"+ ad +"',"+"'"+ soyad +"',"+"'"+ mevki +"',"+""+ piyasa_degeri +")";
				
				baglanti.ekle(sql_sorgu);
			}
		});
		btnkayıt.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnkayıt.setBounds(471, 224, 84, 31);
		contentPane.add(btnkayıt);
		
		text_piyasadegeri = new JTextField();
		text_piyasadegeri.setBounds(436, 176, 96, 20);
		contentPane.add(text_piyasadegeri);
		text_piyasadegeri.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(371, 43, 109, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblAd = new JLabel("ad");
		lblAd.setForeground(Color.WHITE);
		lblAd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblAd.setBounds(371, 70, 109, 38);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("soyad");
		lblSoyad.setForeground(Color.WHITE);
		lblSoyad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblSoyad.setBounds(351, 101, 109, 38);
		contentPane.add(lblSoyad);
		
		JLabel lblMevki = new JLabel("mevki");
		lblMevki.setForeground(Color.WHITE);
		lblMevki.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblMevki.setBounds(351, 135, 109, 31);
		contentPane.add(lblMevki);
		
		JLabel lblPiyasaDegeri = new JLabel("piyasa degeri");
		lblPiyasaDegeri.setForeground(Color.WHITE);
		lblPiyasaDegeri.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblPiyasaDegeri.setBounds(306, 166, 150, 31);
		contentPane.add(lblPiyasaDegeri);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,ad,soyad,mevki,piyasa_degeri,sql_sorgu;
				 
				id=text_id.getText();
				ad=text_ad.getText();
				soyad=text_soyad.getText();
				mevki=text_mevki.getText();
				piyasa_degeri=text_piyasadegeri.getText();
				sql_sorgu= "UPDATE new_table SET id="+id+",ad='"+ad+"',soyad='"+soyad+"',mevki='"+mevki+"',piyasa_degeri="+piyasa_degeri+" WHERE id="+id;
				//System.out.println(sql_sorgu);
				baglanti.update(sql_sorgu);
			}
		});
		btnUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnUpdate.setBounds(471, 270, 84, 31);
		contentPane.add(btnUpdate);
		
		JButton btnsil = new JButton("Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sql_sorgu;
				 
				id=text_id.getText();
				sql_sorgu="DELETE FROM new_table WHERE id="+id;
				baglanti.sil(sql_sorgu);
				
			}
		});
		btnsil.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnsil.setBounds(471, 312, 84, 30);
		contentPane.add(btnsil);
		
		JLabel lblNewLabel_1 = new JLabel("Alan:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 235, 65, 20);
		contentPane.add(lblNewLabel_1);
		
		text_sorguad = new JTextField();
		text_sorguad.setColumns(10);
		text_sorguad.setBounds(10, 265, 96, 20);
		contentPane.add(text_sorguad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ad", "Soyad", "Mevki", "PiyasaDegeri", "id"}));
		comboBox.setBounds(58, 233, 84, 22);
		contentPane.add(comboBox);
		
		JButton btnSorgula = new JButton("Sorgula");
		btnSorgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				String sql_sorgu=null;
				String alan=text_sorguad.getText();
				ResultSet myRs=null;
				int secilen=comboBox.getSelectedIndex();
				
				if(secilen == 0) {
					 sql_sorgu = "SELECT * FROM new_table WHERE ad like'"+alan+"%'";
					
				}
				else if(secilen == 1) {
					 sql_sorgu = "SELECT * FROM new_table WHERE soyad like'"+alan+"%'";
				}
				else if(secilen == 2) {
					 sql_sorgu = "SELECT * FROM new_table WHERE mevki like'"+alan+"%'";
				}
				else if(secilen == 3) {
					 sql_sorgu = "SELECT * FROM new_table WHERE piyasa_degeri ="+Integer.parseInt(alan);
				}
				else if(secilen == 4) {
					 sql_sorgu = "SELECT * FROM new_table WHERE id ="+Integer.parseInt(alan);
				}
				
				
				
				
				
				//System.out.println(sql_sorgu);
				myRs=baglanti.sorgula(sql_sorgu);
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getInt("id");
						satirlar[1]=myRs.getString("ad");
						satirlar[2]=myRs.getString("soyad");
						satirlar[3]=myRs.getString("mevki");
						satirlar[4]=myRs.getInt("piyasa_degeri");
						modelim.addRow(satirlar);
						
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnSorgula.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnSorgula.setBounds(10, 296, 96, 20);
		contentPane.add(btnSorgula);
		
		JButton btnNewButton = new JButton("geridön");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GozlemciGirisFrame frame =new GozlemciGirisFrame();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnNewButton.setBounds(335, 312, 109, 31);
		contentPane.add(btnNewButton);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text_id.setText( modelim.getValueAt(table.getSelectedRow(),0).toString());
				text_ad.setText( modelim.getValueAt(table.getSelectedRow(),1).toString());
				text_soyad.setText( modelim.getValueAt(table.getSelectedRow(),2).toString());
				text_mevki.setText( modelim.getValueAt(table.getSelectedRow(),3).toString());
				text_piyasadegeri.setText( modelim.getValueAt(table.getSelectedRow(),4).toString());
			}
		});
		
		//contentPane.add(table);
	}
}
