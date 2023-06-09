package videoZamanHesaplayici;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class videoZamanHesaplayici extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fld_dakika;
	private JTextField fld_saniye;
	private JTextField fld_sonuc;
	private JTextField fld_xSpeed;
	private JTextField fld_totalSure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					videoZamanHesaplayici frame = new videoZamanHesaplayici();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Hesapla() {		
		int dk = Integer.parseInt(fld_dakika.getText()); // String deðeri int e çevirir.
		int sn = Integer.parseInt(fld_saniye.getText());
		double hiz = Double.parseDouble(fld_xSpeed.getText());		
		int toplamSure = 60 * dk + sn;
		
		if (hiz == 1) {
			fld_sonuc.setText("Zaman tasarrufu yok !");
		} else if (hiz > 1) {
			double tasarruf = (toplamSure * (hiz - 1)) / hiz;
			fld_sonuc.setText("Toplam saniye kazancýnýz : " + tasarruf + "sn");
		} else if (hiz == 0) {
			fld_sonuc.setText("Videoyu izlemediniz !");
		} else {
			double hiz2 = hiz - 1; // hiz2 negatif çýkýyor
			double tasarruf = (toplamSure / hiz) * Math.abs(hiz2);
			fld_sonuc.setText("Toplam saniye kaybýnýz : " + tasarruf + "sn");
		}
	}
	
	public void TotalSureHesapla() {
		int dk = Integer.parseInt(fld_dakika.getText()); // String deðeri int e çevirir.
		int sn = Integer.parseInt(fld_saniye.getText());
		int toplamSure = 60 * dk + sn;		
		fld_totalSure.setText(toplamSure + " Saniye");
	}

	/**
	 * Create the frame.
	 */
	public videoZamanHesaplayici() {
		setTitle("Time Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 272);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Dakika = new JLabel("Dakika");
		lbl_Dakika.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lbl_Dakika.setBounds(10, 11, 86, 26);
		panel.add(lbl_Dakika);
		
		fld_dakika = new JTextField();
		fld_dakika.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		fld_dakika.setBounds(10, 34, 86, 20);
		panel.add(fld_dakika);
		fld_dakika.setColumns(10);
		
		JLabel lbl_Saniye = new JLabel("Saniye");
		lbl_Saniye.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lbl_Saniye.setBounds(137, 11, 86, 26);
		panel.add(lbl_Saniye);
		
		fld_saniye = new JTextField();
		fld_saniye.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		fld_saniye.setColumns(10);
		fld_saniye.setBounds(137, 34, 86, 20);
		panel.add(fld_saniye);
		
		JButton btn_Hesapla = new JButton("Hesapla");
		btn_Hesapla.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btn_Hesapla.setBounds(10, 157, 128, 36);
		panel.add(btn_Hesapla);
		
		btn_Hesapla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Hesapla();
				
			}
			
		});
		
		JButton btn_TotalSureHesapla = new JButton("TotalS\u00FCreHesapla");
		btn_TotalSureHesapla.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btn_TotalSureHesapla.setBounds(233, 72, 160, 36);
		panel.add(btn_TotalSureHesapla);
		
		btn_TotalSureHesapla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TotalSureHesapla();
				
			}
			
		});
		
		JLabel lbl_Sonuc = new JLabel("Sonuç");
		lbl_Sonuc.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lbl_Sonuc.setBounds(10, 204, 213, 26);
		panel.add(lbl_Sonuc);
		
		fld_sonuc = new JTextField();
		fld_sonuc.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		fld_sonuc.setBackground(Color.WHITE);
		fld_sonuc.setEditable(false);
		fld_sonuc.setColumns(10);
		fld_sonuc.setBounds(10, 241, 213, 20);
		panel.add(fld_sonuc);
		
		JLabel lbl_xSpeed = new JLabel("Video Hýzý (x)");
		lbl_xSpeed.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lbl_xSpeed.setBounds(10, 100, 213, 26);
		panel.add(lbl_xSpeed);
		
		fld_xSpeed = new JTextField();
		fld_xSpeed.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		fld_xSpeed.setBackground(Color.WHITE);
		fld_xSpeed.setColumns(10);
		fld_xSpeed.setBounds(10, 126, 213, 20);
		panel.add(fld_xSpeed);
		
		JLabel lbl_totalSure = new JLabel("Toplam S\u00FCre");
		lbl_totalSure.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		lbl_totalSure.setBounds(10, 65, 213, 14);
		panel.add(lbl_totalSure);
		
		fld_totalSure = new JTextField();
		fld_totalSure.setEditable(false);
		fld_totalSure.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		fld_totalSure.setBackground(Color.WHITE);
		fld_totalSure.setColumns(10);
		fld_totalSure.setBounds(10, 79, 213, 26);
		panel.add(fld_totalSure);
		
		JLabel lbl_bbostt = new JLabel("b.bostt");
		lbl_bbostt.setForeground(Color.BLUE);
		lbl_bbostt.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 12));
		lbl_bbostt.setBounds(370, 257, 46, 14);
		panel.add(lbl_bbostt);
		
		
	}
}
