package menjacnica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import util.URLConnectionUtil;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Prozor extends JFrame {

	private JPanel contentPane;
	private JLabel lblIzValuteZemlje;
	private JComboBox domacaZ;
	private JLabel lblUValutuZemlje;
	private JComboBox stranaZ;
	private JLabel lblIznos;
	private JTextField domacaIz;
	private JTextField stranaIz;
	private JLabel label;
	private JButton btnKonvertuj;
	private LinkedList<Country> countries=new LinkedList<Country>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prozor frame = new Prozor();
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
	public Prozor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIzValuteZemlje());
		contentPane.add(getDomacaZ());
		contentPane.add(getLblUValutuZemlje());
		contentPane.add(getStranaZ());
		contentPane.add(getLblIznos());
		contentPane.add(getDomacaIz());
		contentPane.add(getStranaIz());
		contentPane.add(getLabel());
		contentPane.add(getBtnKonvertuj());
		try {
			String zemljeJ=URLConnectionUtil.getContent("http://free.currencyconverterapi.com/api/v3/countries");
			JsonParser par=new JsonParser();
			Gson g=new GsonBuilder().create();
			JsonObject obj=par.parse(zemljeJ).getAsJsonObject().getAsJsonObject("results");
			for(Map.Entry<String, JsonElement> entry:obj.entrySet()) {
				Country c=g.fromJson(entry.getValue(), Country.class);
				countries.add(c);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		dodajCB(domacaZ);
		dodajCB(stranaZ);
		
		
	}
	private JLabel getLblIzValuteZemlje() {
		if (lblIzValuteZemlje == null) {
			lblIzValuteZemlje = new JLabel("Iz valute zemlje");
			lblIzValuteZemlje.setBounds(70, 68, 106, 16);
		}
		return lblIzValuteZemlje;
	}
	private JComboBox getDomacaZ() {
		if (domacaZ == null) {
			domacaZ = new JComboBox();
			domacaZ.setBounds(70, 97, 122, 22);
			
		}
		return domacaZ;
	}
	private JLabel getLblUValutuZemlje() {
		if (lblUValutuZemlje == null) {
			lblUValutuZemlje = new JLabel("U valutu zemlje");
			lblUValutuZemlje.setBounds(300, 68, 122, 16);
		}
		return lblUValutuZemlje;
	}
	private JComboBox getStranaZ() {
		if (stranaZ == null) {
			stranaZ = new JComboBox();
			stranaZ.setBounds(300, 97, 122, 22);
			
		}
		return stranaZ;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos:");
			lblIznos.setBounds(70, 175, 56, 16);
		}
		return lblIznos;
	}
	private JTextField getDomacaIz() {
		if (domacaIz == null) {
			domacaIz = new JTextField();
			domacaIz.setText("");
			domacaIz.setBounds(70, 204, 122, 22);
			domacaIz.setColumns(10);
		}
		return domacaIz;
	}
	private JTextField getStranaIz() {
		if (stranaIz == null) {
			stranaIz = new JTextField();
			stranaIz.setText("");
			stranaIz.setBounds(300, 204, 122, 22);
			stranaIz.setColumns(10);
		}
		return stranaIz;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Iznos:");
			label.setBounds(300, 175, 56, 16);
		}
		return label;
	}
	private JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			btnKonvertuj.setBounds(192, 292, 97, 25);
		}
		return btnKonvertuj;
	}
	private void dodajCB(JComboBox domacaZ ) {
		for(Country i:countries)
			domacaZ.addItem(i);
		
		
	}
}
