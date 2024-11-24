package cpf;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class Cpf {

	GerarDados gerarDados = new GerarDados();

	JTextArea textAreaDV;

	JTextArea textAreaOrigem;

	private JFrame frmGerador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cpf window = new Cpf();
					window.frmGerador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cpf() {
		initialize();
		URL caminhoIcone = getClass().getResource("logo.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.frmGerador.setIconImage(iconeTitulo);
	}

	private void initialize() {
		this.frmGerador = new JFrame();
		this.frmGerador.setTitle("Gerador de CPF");
		this.frmGerador.setBounds(100, 100, 527, 383);
		this.frmGerador.setDefaultCloseOperation(3);
		this.frmGerador.setResizable(false);
		this.frmGerador.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		this.frmGerador.getContentPane().add(panel, "Center");
		JLabel lblNewLabel = new JLabel("Padrão");
		lblNewLabel.setFont(new Font("Arial Black", 0, 18));
		final JComboBox comboBoxPadraoDV = new JComboBox();
		comboBoxPadraoDV.setFont(new Font("Arial Black", 0, 16));
		comboBoxPadraoDV.setModel(new DefaultComboBoxModel<>(new String[] { "XXX.XXX.XXX-XX", "XXXXXXXXX" }));
		JLabel lblDv = new JLabel("DV");
		lblDv.setFont(new Font("Arial Black", 0, 18));
		final JComboBox comboBoxDV = new JComboBox();
		comboBoxDV.setFont(new Font("Arial Black", 0, 16));
		comboBoxDV.setModel(new DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41",
				"42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58",
				"59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75",
				"76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92",
				"93", "94", "95", "96", "97", "98", "99" }));
		JLabel lblNewLabel_1 = new JLabel("Padrão");
		lblNewLabel_1.setFont(new Font("Arial Black", 0, 18));
		JLabel lblDv_1 = new JLabel("Origem");
		lblDv_1.setFont(new Font("Arial Black", 0, 18));
		final JComboBox comboBoxPadraoOrigem = new JComboBox();
		comboBoxPadraoOrigem.setFont(new Font("Arial Black", 0, 16));
		comboBoxPadraoOrigem.setModel(new DefaultComboBoxModel<>(new String[] { "XXX.XXX.XXX-XX", "XXXXXXXXXXX" }));
		final JComboBox comboBoxOrigem = new JComboBox();
		comboBoxOrigem.setFont(new Font("Arial Black", 0, 16));
		comboBoxOrigem.setModel(new DefaultComboBoxModel<>(
				new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB",
						"PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
		this.textAreaDV = new JTextArea("");
		this.textAreaDV.setEditable(false);
		this.textAreaDV.setBackground(new Color(192, 192, 192));
		this.textAreaDV.setFont(new Font("Arial Black", 0, 16));
		this.textAreaOrigem = new JTextArea("");
		this.textAreaOrigem.setEditable(false);
		this.textAreaOrigem.setBackground(new Color(192, 192, 192));
		this.textAreaOrigem.setFont(new Font("Arial Black", 0, 16));
		JButton btnGerarCpfDV = new JButton("Gerar CPF");
		btnGerarCpfDV.setFont(new Font("Arial Black", 0, 16));
		btnGerarCpfDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemComboBoxPadraoDV = comboBoxPadraoDV.getSelectedItem().toString();
				String itemComboBoxDV = comboBoxDV.getSelectedItem().toString();
				Cpf.this.textAreaDV.setText(Cpf.this.gerarDados.gerarCpfDigito(itemComboBoxPadraoDV, itemComboBoxDV));
			}
		});
		JButton btnGerarCpfOrigem = new JButton("Gerar CPF");
		btnGerarCpfOrigem.setFont(new Font("Arial Black", 0, 16));
		btnGerarCpfOrigem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemComboBoxPadraoOrigem = comboBoxPadraoOrigem.getSelectedItem().toString();
				String itemComboBoxOrigem = comboBoxOrigem.getSelectedItem().toString();
				Cpf.this.textAreaOrigem
						.setText(Cpf.this.gerarDados.gerarCpfOrigem(itemComboBoxPadraoOrigem, itemComboBoxOrigem));
			}
		});
		JButton btnCopiarDV = new JButton("Copiar");
		btnCopiarDV.setFont(new Font("Arial Black", 0, 16));
		btnCopiarDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
				ClipboardOwner selection = new StringSelection(Cpf.this.textAreaDV.getText());
				board.setContents((Transferable) selection, selection);
			}
		});
		JButton btnCopiarOrigem = new JButton("Copiar");
		btnCopiarOrigem.setFont(new Font("Arial Black", 0, 16));
		btnCopiarOrigem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
				ClipboardOwner selection = new StringSelection(Cpf.this.textAreaOrigem.getText());
				board.setContents((Transferable) selection, selection);
			}
		});
		JSeparator separator = new JSeparator();
		JSeparator separator_1 = new JSeparator();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(55)
						.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(lblNewLabel, GroupLayout.Alignment.LEADING, -2, 77, -2)
								.addComponent(lblNewLabel_1, GroupLayout.Alignment.LEADING, -2, 77, -2)
								.addComponent(comboBoxPadraoOrigem, GroupLayout.Alignment.LEADING, 0, -1, 32767)
								.addComponent(comboBoxPadraoDV, GroupLayout.Alignment.LEADING, 0, -1, 32767)
								.addComponent(this.textAreaDV,
										GroupLayout.Alignment.LEADING)
								.addComponent(this.textAreaOrigem, GroupLayout.Alignment.LEADING))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblDv_1, -2, 79, -2).addComponent(lblDv, -2, 66, -2)
										.addGroup(gl_panel.createSequentialGroup().addComponent(comboBoxDV, -2, 86, -2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(gl_panel
														.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
														.addComponent(btnCopiarDV, GroupLayout.Alignment.LEADING, -1,
																-1, 32767)
														.addComponent(btnGerarCpfDV, GroupLayout.Alignment.LEADING, -1,
																-1, 32767)))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(comboBoxOrigem, -2, 87, -2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(gl_panel
														.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														.addComponent(btnCopiarOrigem, -1, -1, 32767)
														.addComponent(btnGerarCpfOrigem, -1, -1, 32767))))
						.addContainerGap(44, 32767))
				.addComponent(separator, -1, 523, 32767)
				.addGroup(gl_panel.createSequentialGroup().addComponent(separator_1, -2, 513, -2).addContainerGap()));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap(11, 32767)
								.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblNewLabel, -2, 27, -2).addComponent(lblDv))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(comboBoxPadraoDV, -2, 33, -2).addComponent(comboBoxDV, -2, 31, -2)
										.addComponent(btnGerarCpfDV))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(this.textAreaDV, -2, -1, -2).addComponent(btnCopiarDV))
								.addGap(18).addComponent(separator, -2, 11, -2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblNewLabel_1, -2, 34, -2).addComponent(lblDv_1, -2, 34, -2))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										gl_panel.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(comboBoxPadraoOrigem, -2, 29, -2)
												.addComponent(comboBoxOrigem, -2, -1, -2)
												.addComponent(btnGerarCpfOrigem))
								.addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(btnCopiarOrigem))
										.addGroup(gl_panel.createSequentialGroup().addGap(18)
												.addComponent(this.textAreaOrigem, -2, -1, -2)))
								.addGap(60).addComponent(separator_1, -2, 11, -2).addGap(110)));
		panel.setLayout(gl_panel);
		JMenuBar menuBar = new JMenuBar();
		this.frmGerador.setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("Ajuda");
		mnNewMenu.setFont(new Font("Arial", 0, 17));
		menuBar.add(mnNewMenu);
		JMenuItem mntmNewMenuItem = new JMenuItem("Sobre o Gerador de CPF");
		mntmNewMenuItem.setFont(new Font("Arial", 0, 16));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Desenvolvido por Iris Guedes / 2023", "Sobre o Gerador de CPF",
						-1);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}

}
