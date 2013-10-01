package br.unioeste;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ControleJuridicoVIEW extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldProcessoNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleJuridicoVIEW frame = new ControleJuridicoVIEW();
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
	public ControleJuridicoVIEW() {

		super("ESW1 - 3ºBimestre");

		try {	/**Pegar variaveis de ambiente*/
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
		} catch (Exception e) {
			
		}


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 70, 985, 613);
		contentPane.add(tabbedPane);

		/* PROCESSOS */
		
		JPanel panelProcessos = new JPanel();
		tabbedPane.addTab("Processos", null, panelProcessos, null);
		panelProcessos.setLayout(null);
		
		JLabel lblNumeroDoProcesso = new JLabel("Numero do Processo");
		lblNumeroDoProcesso.setBounds(37, 30, 174, 24);
		panelProcessos.add(lblNumeroDoProcesso);
	    
	    JTextField txtNumeroprocesso = new JTextField();
	    txtNumeroprocesso.setBounds(229, 26, 247, 33);
	    txtNumeroprocesso.setColumns(10);
	    panelProcessos.add(txtNumeroprocesso);	    
	    
	    JLabel lblDescrio = new JLabel("Descrição");
	    lblDescrio.setBounds(85, 117, 70, 15);
	    panelProcessos.add(lblDescrio);
	    
	    JTextArea txtrDescrio = new JTextArea();
	    txtrDescrio.setBounds(229, 97, 249, 140);
	    panelProcessos.add(txtrDescrio);
	    
	    JLabel lblTipoDeProcesso = new JLabel("Tipo de processo");
	    lblTipoDeProcesso.setBounds(566, 53, 146, 24);
	    panelProcessos.add(lblTipoDeProcesso);

	    String tipos[] = {"Administrativo", "Civíl", "Penal", "Trabalhista", "Tributário", "Execução Fiscal"};
	    JComboBox cBTipoProcesso = new JComboBox(tipos);
	    cBTipoProcesso.setBounds(697, 50, 205, 24);
	    panelProcessos.add(cBTipoProcesso);
	    
	    JLabel lblForm = new JLabel("Forúm");
	    lblForm.setBounds(85, 275, 70, 15);
	    panelProcessos.add(lblForm);
	    
	    String foruns[] = {"Justiça Federal"};
	    JComboBox cBForum = new JComboBox(foruns);
	    cBForum.setBounds(272, 270, 252, 24);
	    panelProcessos.add(cBForum);
	    
	    JLabel lblSituao = new JLabel("Situação");
	    lblSituao.setBounds(566, 117, 123, 15);
	    panelProcessos.add(lblSituao);
	    
	    String sits[] = {"Aberto", "Parado", "Julgamento", "julgado", "Execução"};
	    JComboBox cBSituacao = new JComboBox(sits);
	    cBSituacao.setBounds(697, 112, 205, 24);
	    panelProcessos.add(cBSituacao);
	    
	    JLabel lblAdvogado = new JLabel("Advogado");
	    lblAdvogado.setBounds(85, 326, 123, 15);
	    panelProcessos.add(lblAdvogado);
	    
	    String advs[] = {"AN Bernardes Kliemann"};
	    JComboBox cBAdvogados = new JComboBox(advs);
	    cBAdvogados.setBounds(272, 321, 252, 24);
	    panelProcessos.add(cBAdvogados);
	    
	    JButton btnSalvar = new JButton("Salvar");
	    btnSalvar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		/* POGs */
	    		
	    	}
	    });
	    btnSalvar.setBounds(193, 468, 117, 25);
	    panelProcessos.add(btnSalvar);
	    
	    JButton btnBuscar = new JButton("Buscar");
	    btnBuscar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		/* POGs */
	    		
	    	}
	    });
	    btnBuscar.setBounds(333, 468, 117, 25);
	    panelProcessos.add(btnBuscar);
	    
	    JButton btnExcluit = new JButton("Excluir");
	    btnExcluit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		
	    		/* POGs */
				
			}
		});
	    btnExcluit.setBounds(481, 468, 117, 25);
	    panelProcessos.add(btnExcluit);
	    
	    JLabel lblTramites = new JLabel("Tramites");
	    lblTramites.setBounds(566, 173, 70, 15);
	    panelProcessos.add(lblTramites);
	    
	    JTextArea textArea_tramites = new JTextArea();
	    textArea_tramites.setEditable(false);
	    textArea_tramites.setBounds(566, 200, 389, 240);
	    panelProcessos.add(textArea_tramites);

	    /* FIM pannel processos */
	    
		JPanel panelTramits= new JPanel();
		tabbedPane.addTab("Tramits", null, panelTramits, null);
		panelTramits.setLayout(null);
		
		JLabel lblProcesso = new JLabel("Processo Numero");
		lblProcesso.setBounds(54, 66, 178, 15);
		panelTramits.add(lblProcesso);
		
		textFieldProcessoNum = new JTextField();
		textFieldProcessoNum.setBounds(211, 50, 202, 33);
		panelTramits.add(textFieldProcessoNum);
		textFieldProcessoNum.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setBounds(458, 61, 117, 25);
		panelTramits.add(btnBuscar_1);
		
		JLabel lblTramite = new JLabel("Tramite");
		lblTramite.setBounds(65, 188, 124, 15);
		panelTramits.add(lblTramite);
		
		String tramites[] = {"Petição", "Contestação"};
		
		JComboBox comboBox = new JComboBox(tramites);
		comboBox.setBounds(211, 174, 202, 33);
		panelTramits.add(comboBox);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.setBounds(211, 490, 117, 25);
		panelTramits.add(btnSalvar_1);
		
		JLabel lblObservaes = new JLabel("Observações");
		lblObservaes.setBounds(54, 279, 124, 15);
		panelTramits.add(lblObservaes);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(188, 279, 352, 161);
		panelTramits.add(textArea);
	}
	
	
}
