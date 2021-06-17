package atividade;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class Lanchonete {
	public JFrame lanchoneteWindow; //variável do frame
	protected String nameCliente, listaingredientes=""; //armazena o nome do cliente da classe Cliente, e armazena todos os ingredientes escolhidos para exibir no cupomfiscal
	//variavel dos campos de texto
	private JTextField qtdPaoFrances, qtdPaoCarteira, qtdPaoHamburguer, qtdPaoArabe, qtdQueijoCoalho, qtdQueijoMinas, qtdQueijoMucarela, qtdQueijoCreamCheese, qtdQueijoGorgonzola, qtdVerduraCebola, qtdVerduraPimentao, qtdVerduraTomate, qtdCarneMortadela, qtdCarneApresuntado, qtdCarneBacon, qtdCarnePresunto, qtdCarnePepperoni, qtdCarneSalame, qtdMolhoMaionese, qtdMolhoKetchup, qtdMolhoMaioneseTemperada, qtdMolhoTartaro, qtdMolhoBarbecue, qtdOutrosOvo, qtdOutrosBatataPalha;
	protected double valorTotal = 0;  //variavel que armazena o valor total da compra
	//variaveis que armazenam o valor de cada ingrediente
	private double paofrances = 0.25, paocarteira = 0.30, paohamburguer = 0.70, paoarabe = 1.30, queijocoalho = 1.50, queijominas = 1.80, queijomucarela = 2.00, queijocreamcheese = 3.00, queijogorgonzola = 3.50, cebola = 0.30, pimentao = 0.45, tomate = 0.50, mortadela = 0.50, apresuntado = 1.00, bacon = 1.30, presunto = 1.60, pepperoni = 1.80, salame = 2.00, maionese = 0.50, ketchup = 0.50, maionesetemperada = 0.70, molhotartaro = 1.00, barbecue = 1.50, ovo = 1.00, batatapalha = 1.00;
	//variavel que armazena a quantidade de cada ingrediente
	private int totalPaoFrances, totalPaoCarteira, totalPaoHamburguer, totalPaoArabe, totalQueijoCoalho, totalQueijoMinas, totalQueijoMucarela, totalQueijoCreamCheese, totalQueijoGorgonzola, totalCebola, totalPimentao, totalTomate, totalMortadela, totalApresuntado, totalBacon, totalPresunto, totalPepperoni, totalSalame, totalMaionese, totalKetchup, totalMaioneseTemperada, totalMolhoTartaro, totalBarbecue, totalOvo, totalBatataPalha;
	private int confirmarPedido;  //variavel que salva a confirmação do pedido
	/**Launch the application.**/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanchonete window = new Lanchonete();
					window.lanchoneteWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**Create the application.**/
	public Lanchonete() {
		inicializarLanchonete();
		labelsLanchonete();
	}
	/**Initialize the contents of the frame.**/
	private void inicializarLanchonete() {
		lanchoneteWindow = new JFrame();  //criação do frame(janela)
		lanchoneteWindow.getContentPane().setBackground(new Color(102, 153, 255));
		lanchoneteWindow.getContentPane().setForeground(Color.WHITE);
		lanchoneteWindow.setTitle("Lanchonete - Monte seu Sanduiche");
		lanchoneteWindow.setResizable(false);
		lanchoneteWindow.setBounds(100, 100, 800, 600);
		lanchoneteWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lanchoneteWindow.getContentPane().setLayout(null);
		lanchoneteWindow.setLocationRelativeTo(null);
		
		ArrayList<String> ingredientes = new ArrayList<>();  //ArrayList para armazenar os ingredientes selecionados
	
		//Caixas de seleção e caixas de texto
		//PAES
		JCheckBox chkPaoFrances = new JCheckBox("R$ 0,25 - P\u00E3o Franc\u00EAs");
		chkPaoFrances.setForeground(Color.WHITE);
		chkPaoFrances.setBackground(new Color(102, 153, 255));
		chkPaoFrances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkPaoFrances.isSelected()) {
					qtdPaoFrances.setEditable(true);
					qtdPaoFrances.setText(Integer.toString(1));
				}else {
					qtdPaoFrances.setText("");
					totalPaoFrances = 0;
					qtdPaoFrances.setEditable(false);
				}
			}
		});
		chkPaoFrances.setBounds(74, 102, 169, 23);
		lanchoneteWindow.getContentPane().add(chkPaoFrances);
		
		qtdPaoFrances = new JTextField();
		qtdPaoFrances.setForeground(Color.BLACK);
		qtdPaoFrances.setColumns(10);
		qtdPaoFrances.setBounds(289, 103, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdPaoFrances);
		qtdPaoFrances.setEditable(false);
		
		JCheckBox chkPaoCarteira = new JCheckBox("R$ 0,30 - P\u00E3o Carteira");
		chkPaoCarteira.setForeground(Color.WHITE);
		chkPaoCarteira.setBackground(new Color(102, 153, 255));
		chkPaoCarteira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkPaoCarteira.isSelected()) {
					qtdPaoCarteira.setEditable(true);
					qtdPaoCarteira.setText(Integer.toString(1));
				}else {
					qtdPaoCarteira.setText("");
					totalPaoCarteira = 0;
					qtdPaoCarteira.setEditable(false);
				}
			}
		});
		chkPaoCarteira.setBounds(74, 126, 169, 23);
		lanchoneteWindow.getContentPane().add(chkPaoCarteira);
		
		qtdPaoCarteira = new JTextField();
		qtdPaoCarteira.setForeground(Color.BLACK);
		qtdPaoCarteira.setColumns(10);
		qtdPaoCarteira.setBounds(289, 127, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdPaoCarteira);
		qtdPaoCarteira.setEditable(false);
		
		JCheckBox chkPaoHamburguer = new JCheckBox("R$ 0,70 - P\u00E3o de Hamb\u00FArguer");
		chkPaoHamburguer.setForeground(Color.WHITE);
		chkPaoHamburguer.setBackground(new Color(102, 153, 255));
		chkPaoHamburguer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkPaoHamburguer.isSelected()) {
					qtdPaoHamburguer.setEditable(true);
					qtdPaoHamburguer.setText(Integer.toString(1));
				}else {
					qtdPaoHamburguer.setText("");
					totalPaoHamburguer = 0;
					qtdPaoHamburguer.setEditable(false);
				}
			}
		});
		chkPaoHamburguer.setBounds(74, 150, 191, 23);
		lanchoneteWindow.getContentPane().add(chkPaoHamburguer);
		
		qtdPaoHamburguer = new JTextField();
		qtdPaoHamburguer.setForeground(Color.BLACK);
		qtdPaoHamburguer.setColumns(10);
		qtdPaoHamburguer.setBounds(289, 151, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdPaoHamburguer);
		qtdPaoHamburguer.setEditable(false);
		
		JCheckBox chkPaoArabe = new JCheckBox("R$ 1,30 - P\u00E3o \u00C1rabe");
		chkPaoArabe.setForeground(Color.WHITE);
		chkPaoArabe.setBackground(new Color(102, 153, 255));
		chkPaoArabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkPaoArabe.isSelected()) {
					qtdPaoArabe.setEditable(true);
					qtdPaoArabe.setText(Integer.toString(1));
				}else {
					qtdPaoArabe.setText("");
					totalPaoArabe = 0;
					qtdPaoArabe.setEditable(false);
				}
			}
		});
		chkPaoArabe.setBounds(74, 174, 169, 23);
		lanchoneteWindow.getContentPane().add(chkPaoArabe);
		
		qtdPaoArabe = new JTextField();
		qtdPaoArabe.setForeground(Color.BLACK);
		qtdPaoArabe.setColumns(10);
		qtdPaoArabe.setBounds(289, 175, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdPaoArabe);
		qtdPaoArabe.setEditable(false);
		
		//QUEIJOS
		JCheckBox chkQueijoCoalho = new JCheckBox("R$ 1,50 - Coalho");
		chkQueijoCoalho.setForeground(Color.WHITE);
		chkQueijoCoalho.setBackground(new Color(102, 153, 255));
		chkQueijoCoalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkQueijoCoalho.isSelected()) {
					qtdQueijoCoalho.setEditable(true);	
					qtdQueijoCoalho.setText(Integer.toString(1));
				}else {
					qtdQueijoCoalho.setText("");
					totalQueijoCoalho = 0;
					qtdQueijoCoalho.setEditable(false);
				}
			}
		});
		chkQueijoCoalho.setBounds(74, 242, 169, 23);
		lanchoneteWindow.getContentPane().add(chkQueijoCoalho);
		
		qtdQueijoCoalho = new JTextField();
		qtdQueijoCoalho.setForeground(Color.BLACK);
		qtdQueijoCoalho.setColumns(10);
		qtdQueijoCoalho.setBounds(289, 243, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdQueijoCoalho);
		qtdQueijoCoalho.setEditable(false);
		
		JCheckBox chkQueijoMinas = new JCheckBox("R$ 1,80 - Minas");
		chkQueijoMinas.setForeground(Color.WHITE);
		chkQueijoMinas.setBackground(new Color(102, 153, 255));
		chkQueijoMinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkQueijoMinas.isSelected()) {
					qtdQueijoMinas.setEditable(true);
					qtdQueijoMinas.setText(Integer.toString(1));
				}else {
					qtdQueijoMinas.setText("");
					totalQueijoMinas = 0;
					qtdQueijoMinas.setEditable(false);
				}
			}
		});
		chkQueijoMinas.setBounds(74, 266, 169, 23);
		lanchoneteWindow.getContentPane().add(chkQueijoMinas);
		
		qtdQueijoMinas = new JTextField();
		qtdQueijoMinas.setForeground(Color.BLACK);
		qtdQueijoMinas.setColumns(10);
		qtdQueijoMinas.setBounds(289, 267, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdQueijoMinas);
		qtdQueijoMinas.setEditable(false);
		
		JCheckBox chkQueijoMucarela = new JCheckBox("R$ 2,00 - Mu\u00E7arela");
		chkQueijoMucarela.setForeground(Color.WHITE);
		chkQueijoMucarela.setBackground(new Color(102, 153, 255));
		chkQueijoMucarela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkQueijoMucarela.isSelected()) {
					qtdQueijoMucarela.setEditable(true);
					qtdQueijoMucarela.setText(Integer.toString(1));
				}else {
					qtdQueijoMucarela.setText("");
					totalQueijoMucarela = 0;
					qtdQueijoMucarela.setEditable(false);
				}
			}
		});
		chkQueijoMucarela.setBounds(74, 290, 169, 23);
		lanchoneteWindow.getContentPane().add(chkQueijoMucarela);
		
		qtdQueijoMucarela = new JTextField();
		qtdQueijoMucarela.setForeground(Color.BLACK);
		qtdQueijoMucarela.setColumns(10);
		qtdQueijoMucarela.setBounds(289, 291, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdQueijoMucarela);
		qtdQueijoMucarela.setEditable(false);
		
		JCheckBox chkQueijoCreamCheese = new JCheckBox("R$ 3,00 - Cream Cheese");
		chkQueijoCreamCheese.setForeground(Color.WHITE);
		chkQueijoCreamCheese.setBackground(new Color(102, 153, 255));
		chkQueijoCreamCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkQueijoCreamCheese.isSelected()) {
					qtdQueijoCreamCheese.setEditable(true);	
					qtdQueijoCreamCheese.setText(Integer.toString(1));
				}else {
					qtdQueijoCreamCheese.setText("");
					totalQueijoCreamCheese = 0;
					qtdQueijoCreamCheese.setEditable(false);
				}
			}
		});
		chkQueijoCreamCheese.setBounds(74, 314, 169, 23);
		lanchoneteWindow.getContentPane().add(chkQueijoCreamCheese);
		
		qtdQueijoCreamCheese = new JTextField();
		qtdQueijoCreamCheese.setForeground(Color.BLACK);
		qtdQueijoCreamCheese.setColumns(10);
		qtdQueijoCreamCheese.setBounds(289, 315, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdQueijoCreamCheese);
		qtdQueijoCreamCheese.setEditable(false);
		
		JCheckBox chkQueijoGorgonzola = new JCheckBox("R$ 3,50 - Gorgonzola");
		chkQueijoGorgonzola.setForeground(Color.WHITE);
		chkQueijoGorgonzola.setBackground(new Color(102, 153, 255));
		chkQueijoGorgonzola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkQueijoGorgonzola.isSelected()) {
					qtdQueijoGorgonzola.setEditable(true);
					qtdQueijoGorgonzola.setText(Integer.toString(1));
				}else {
					qtdQueijoGorgonzola.setText("");
					totalQueijoGorgonzola = 0;
					qtdQueijoGorgonzola.setEditable(false);
				}
			}
		});
		chkQueijoGorgonzola.setBounds(74, 338, 169, 23);
		lanchoneteWindow.getContentPane().add(chkQueijoGorgonzola);
		
		qtdQueijoGorgonzola = new JTextField();
		qtdQueijoGorgonzola.setForeground(Color.BLACK);
		qtdQueijoGorgonzola.setColumns(10);
		qtdQueijoGorgonzola.setBounds(289, 339, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdQueijoGorgonzola);
		qtdQueijoGorgonzola.setEditable(false);
		
		//VERDURAS	
		JCheckBox chkVerduraCebola = new JCheckBox("R$ 0,30 - Cebola");
		chkVerduraCebola.setForeground(Color.WHITE);
		chkVerduraCebola.setBackground(new Color(102, 153, 255));
		chkVerduraCebola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkVerduraCebola.isSelected()) {
					qtdVerduraCebola.setEditable(true);	
					qtdVerduraCebola.setText(Integer.toString(1));
				}else {
					qtdVerduraCebola.setText("");
					totalCebola = 0;
					qtdVerduraCebola.setEditable(false);
				}
			}
		});
		chkVerduraCebola.setBounds(74, 406, 169, 23);
		lanchoneteWindow.getContentPane().add(chkVerduraCebola);
		
		qtdVerduraCebola = new JTextField();
		qtdVerduraCebola.setForeground(Color.BLACK);
		qtdVerduraCebola.setEditable(false);
		qtdVerduraCebola.setColumns(10);
		qtdVerduraCebola.setBounds(289, 407, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdVerduraCebola);
		
		JCheckBox chkVerduraPimentao = new JCheckBox("R$ 0,45 - Piment\u00E3o");
		chkVerduraPimentao.setForeground(Color.WHITE);
		chkVerduraPimentao.setBackground(new Color(102, 153, 255));
		chkVerduraPimentao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkVerduraPimentao.isSelected()) {
					qtdVerduraPimentao.setEditable(true);
					qtdVerduraPimentao.setText(Integer.toString(1));
				}else {
					qtdVerduraPimentao.setText("");
					totalPimentao = 0;
					qtdVerduraPimentao.setEditable(false);
				}
			}
		});
		chkVerduraPimentao.setBounds(74, 430, 169, 23);
		lanchoneteWindow.getContentPane().add(chkVerduraPimentao);
		
		qtdVerduraPimentao = new JTextField();
		qtdVerduraPimentao.setForeground(Color.BLACK);
		qtdVerduraPimentao.setEditable(false);
		qtdVerduraPimentao.setColumns(10);
		qtdVerduraPimentao.setBounds(289, 431, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdVerduraPimentao);
		
		JCheckBox chkVerduraTomate = new JCheckBox("R$ 0,50 - Tomate");
		chkVerduraTomate.setForeground(Color.WHITE);
		chkVerduraTomate.setBackground(new Color(102, 153, 255));
		chkVerduraTomate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkVerduraTomate.isSelected()) {
					qtdVerduraTomate.setEditable(true);	
					qtdVerduraTomate.setText(Integer.toString(1));
				}else {
					qtdVerduraTomate.setText("");
					totalTomate = 0;
					qtdVerduraTomate.setEditable(false);
				}
			}
		});
		chkVerduraTomate.setBounds(74, 454, 169, 23);
		lanchoneteWindow.getContentPane().add(chkVerduraTomate);
		
		qtdVerduraTomate = new JTextField();
		qtdVerduraTomate.setForeground(Color.BLACK);
		qtdVerduraTomate.setEditable(false);
		qtdVerduraTomate.setColumns(10);
		qtdVerduraTomate.setBounds(289, 455, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdVerduraTomate);
		
		//CARNES
		JCheckBox chkCarneMortadela = new JCheckBox("R$ 0,50 - Mortadela");
		chkCarneMortadela.setForeground(Color.WHITE);
		chkCarneMortadela.setBackground(new Color(102, 153, 255));
		chkCarneMortadela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkCarneMortadela.isSelected()) {
					qtdCarneMortadela.setEditable(true);	
					qtdCarneMortadela.setText(Integer.toString(1));
				}else {
					qtdCarneMortadela.setText("");
					totalMortadela = 0;
					qtdCarneMortadela.setEditable(false);
				}
			}
		});
		chkCarneMortadela.setBounds(470, 102, 169, 23);
		lanchoneteWindow.getContentPane().add(chkCarneMortadela);
		
		qtdCarneMortadela = new JTextField();
		qtdCarneMortadela.setForeground(Color.BLACK);
		qtdCarneMortadela.setEditable(false);
		qtdCarneMortadela.setColumns(10);
		qtdCarneMortadela.setBounds(685, 103, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdCarneMortadela);
		
		JCheckBox chkCarneApresuntado = new JCheckBox("R$ 1,00 - Apresuntado");
		chkCarneApresuntado.setForeground(Color.WHITE);
		chkCarneApresuntado.setBackground(new Color(102, 153, 255));
		chkCarneApresuntado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkCarneApresuntado.isSelected()) {
					qtdCarneApresuntado.setEditable(true);		
					qtdCarneApresuntado.setText(Integer.toString(1));
				}else {
					qtdCarneApresuntado.setText("");
					totalApresuntado = 0;
					qtdCarneApresuntado.setEditable(false);
				}
			}
		});
		chkCarneApresuntado.setBounds(470, 126, 169, 23);
		lanchoneteWindow.getContentPane().add(chkCarneApresuntado);
		
		qtdCarneApresuntado = new JTextField();
		qtdCarneApresuntado.setForeground(Color.BLACK);
		qtdCarneApresuntado.setEditable(false);
		qtdCarneApresuntado.setColumns(10);
		qtdCarneApresuntado.setBounds(685, 127, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdCarneApresuntado);
		
		JCheckBox chkCarneBacon = new JCheckBox("R$ 1,30 - Bacon");
		chkCarneBacon.setForeground(Color.WHITE);
		chkCarneBacon.setBackground(new Color(102, 153, 255));
		chkCarneBacon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkCarneBacon.isSelected()) {
					qtdCarneBacon.setEditable(true);		
					qtdCarneBacon.setText(Integer.toString(1));
				}else {
					qtdCarneBacon.setText("");
					totalBacon = 0;
					qtdCarneBacon.setEditable(false);
				}
			}
		});
		chkCarneBacon.setBounds(470, 150, 169, 23);
		lanchoneteWindow.getContentPane().add(chkCarneBacon);
		
		qtdCarneBacon = new JTextField();
		qtdCarneBacon.setForeground(Color.BLACK);
		qtdCarneBacon.setEditable(false);
		qtdCarneBacon.setColumns(10);
		qtdCarneBacon.setBounds(685, 151, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdCarneBacon);
		
		JCheckBox chkCarnePresunto = new JCheckBox("R$ 1,60 - Presunto");
		chkCarnePresunto.setForeground(Color.WHITE);
		chkCarnePresunto.setBackground(new Color(102, 153, 255));
		chkCarnePresunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkCarnePresunto.isSelected()) {
					qtdCarnePresunto.setEditable(true);		
					qtdCarnePresunto.setText(Integer.toString(1));
				}else {
					qtdCarnePresunto.setText("");
					totalPresunto = 0;
					qtdCarnePresunto.setEditable(false);
				}
			}
		});
		chkCarnePresunto.setBounds(470, 174, 169, 23);
		lanchoneteWindow.getContentPane().add(chkCarnePresunto);
		
		qtdCarnePresunto = new JTextField();
		qtdCarnePresunto.setForeground(Color.BLACK);
		qtdCarnePresunto.setEditable(false);
		qtdCarnePresunto.setColumns(10);
		qtdCarnePresunto.setBounds(685, 175, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdCarnePresunto);
		
		JCheckBox chkCarnePepperoni = new JCheckBox("R$ 1,80 - Pepperoni");
		chkCarnePepperoni.setForeground(Color.WHITE);
		chkCarnePepperoni.setBackground(new Color(102, 153, 255));
		chkCarnePepperoni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkCarnePepperoni.isSelected()) {
					qtdCarnePepperoni.setEditable(true);	
					qtdCarnePepperoni.setText(Integer.toString(1));
				}else {
					qtdCarnePepperoni.setText("");
					totalPepperoni = 0;
					qtdCarnePepperoni.setEditable(false);
				}
			}
		});
		chkCarnePepperoni.setBounds(470, 198, 169, 23);
		lanchoneteWindow.getContentPane().add(chkCarnePepperoni);
		
		qtdCarnePepperoni = new JTextField();
		qtdCarnePepperoni.setForeground(Color.BLACK);
		qtdCarnePepperoni.setEditable(false);
		qtdCarnePepperoni.setColumns(10);
		qtdCarnePepperoni.setBounds(685, 199, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdCarnePepperoni);
		
		JCheckBox chkCarneSalame = new JCheckBox("R$ 2,00 - Salame");
		chkCarneSalame.setForeground(Color.WHITE);
		chkCarneSalame.setBackground(new Color(102, 153, 255));
		chkCarneSalame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkCarneSalame.isSelected()) {
					qtdCarneSalame.setEditable(true);	
					qtdCarneSalame.setText(Integer.toString(1));
				}else {
					qtdCarneSalame.setText("");
					totalSalame = 0;
					qtdCarneSalame.setEditable(false);
				}
			}
		});
		chkCarneSalame.setBounds(470, 222, 169, 23);
		lanchoneteWindow.getContentPane().add(chkCarneSalame);
		
		qtdCarneSalame = new JTextField();
		qtdCarneSalame.setForeground(Color.BLACK);
		qtdCarneSalame.setEditable(false);
		qtdCarneSalame.setColumns(10);
		qtdCarneSalame.setBounds(685, 223, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdCarneSalame);
		
		//MOLHOS	
		JCheckBox chkMolhoMaionese = new JCheckBox("R$ 0,50 - Maionese");
		chkMolhoMaionese.setForeground(Color.WHITE);
		chkMolhoMaionese.setBackground(new Color(102, 153, 255));
		chkMolhoMaionese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkMolhoMaionese.isSelected()) {
					qtdMolhoMaionese.setEditable(true);	
					qtdMolhoMaionese.setText(Integer.toString(1));
				}else {
					qtdMolhoMaionese.setText("");
					totalMaionese = 0;
					qtdMolhoMaionese.setEditable(false);
				}
			}
		});
		chkMolhoMaionese.setBounds(470, 290, 169, 23);
		lanchoneteWindow.getContentPane().add(chkMolhoMaionese);
		
		qtdMolhoMaionese = new JTextField();
		qtdMolhoMaionese.setForeground(Color.BLACK);
		qtdMolhoMaionese.setEditable(false);
		qtdMolhoMaionese.setColumns(10);
		qtdMolhoMaionese.setBounds(685, 291, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdMolhoMaionese);
		
		JCheckBox chkMolhoKetchup = new JCheckBox("R$ 0,50 - Ketchup");
		chkMolhoKetchup.setForeground(Color.WHITE);
		chkMolhoKetchup.setBackground(new Color(102, 153, 255));
		chkMolhoKetchup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkMolhoKetchup.isSelected()) {
					qtdMolhoKetchup.setEditable(true);	
					qtdMolhoKetchup.setText(Integer.toString(1));
				}else {
					qtdMolhoKetchup.setText("");
					totalKetchup = 0;
					qtdMolhoKetchup.setEditable(false);
				}
			}
		});
		chkMolhoKetchup.setBounds(470, 314, 169, 23);
		lanchoneteWindow.getContentPane().add(chkMolhoKetchup);
		
		qtdMolhoKetchup = new JTextField();
		qtdMolhoKetchup.setForeground(Color.BLACK);
		qtdMolhoKetchup.setEditable(false);
		qtdMolhoKetchup.setColumns(10);
		qtdMolhoKetchup.setBounds(685, 315, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdMolhoKetchup);
		
		JCheckBox chkMolhoMaioneseTemperada = new JCheckBox("R$ 0,70 - Maionese Temperada");
		chkMolhoMaioneseTemperada.setForeground(Color.WHITE);
		chkMolhoMaioneseTemperada.setBackground(new Color(102, 153, 255));
		chkMolhoMaioneseTemperada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkMolhoMaioneseTemperada.isSelected()) {
					qtdMolhoMaioneseTemperada.setEditable(true);
					qtdMolhoMaioneseTemperada.setText(Integer.toString(1));
				}else {
					qtdMolhoMaioneseTemperada.setText("");
					totalMaioneseTemperada = 0;
					qtdMolhoMaioneseTemperada.setEditable(false);
				}
			}
		});
		chkMolhoMaioneseTemperada.setBounds(470, 338, 210, 23);
		lanchoneteWindow.getContentPane().add(chkMolhoMaioneseTemperada);
		
		qtdMolhoMaioneseTemperada = new JTextField();
		qtdMolhoMaioneseTemperada.setForeground(Color.BLACK);
		qtdMolhoMaioneseTemperada.setEditable(false);
		qtdMolhoMaioneseTemperada.setColumns(10);
		qtdMolhoMaioneseTemperada.setBounds(685, 339, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdMolhoMaioneseTemperada);
		
		JCheckBox chkMolhoTartaro = new JCheckBox("R$ 1,00 - Molho T\u00E1rtaro");
		chkMolhoTartaro.setForeground(Color.WHITE);
		chkMolhoTartaro.setBackground(new Color(102, 153, 255));
		chkMolhoTartaro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkMolhoTartaro.isSelected()) {
					qtdMolhoTartaro.setEditable(true);
					qtdMolhoTartaro.setText(Integer.toString(1));
				}else {
					qtdMolhoTartaro.setText("");
					totalMolhoTartaro = 0;
					qtdMolhoTartaro.setEditable(false);
				}
			}
		});
		chkMolhoTartaro.setBounds(470, 362, 169, 23);
		lanchoneteWindow.getContentPane().add(chkMolhoTartaro);
		
		qtdMolhoTartaro = new JTextField();
		qtdMolhoTartaro.setForeground(Color.BLACK);
		qtdMolhoTartaro.setEditable(false);
		qtdMolhoTartaro.setColumns(10);
		qtdMolhoTartaro.setBounds(685, 363, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdMolhoTartaro);
		
		JCheckBox chkMolhoBarbecue = new JCheckBox("R$ 1,50 - Barbecue");
		chkMolhoBarbecue.setForeground(Color.WHITE);
		chkMolhoBarbecue.setBackground(new Color(102, 153, 255));
		chkMolhoBarbecue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkMolhoBarbecue.isSelected()) {
					qtdMolhoBarbecue.setEditable(true);
					qtdMolhoBarbecue.setText(Integer.toString(1));
				}else {
					qtdMolhoBarbecue.setText("");
					totalBarbecue = 0;
					qtdMolhoBarbecue.setEditable(false);
				}
			}
		});
		chkMolhoBarbecue.setBounds(470, 386, 169, 23);
		lanchoneteWindow.getContentPane().add(chkMolhoBarbecue);
		
		qtdMolhoBarbecue = new JTextField();
		qtdMolhoBarbecue.setForeground(Color.BLACK);
		qtdMolhoBarbecue.setEditable(false);
		qtdMolhoBarbecue.setColumns(10);
		qtdMolhoBarbecue.setBounds(685, 387, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdMolhoBarbecue);
		
		//OUTROS
		JCheckBox chkOutrosOvo = new JCheckBox("R$ 1,00 - Ovo");
		chkOutrosOvo.setForeground(Color.WHITE);
		chkOutrosOvo.setBackground(new Color(102, 153, 255));
		chkOutrosOvo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkOutrosOvo.isSelected()) {
					qtdOutrosOvo.setEditable(true);
					qtdOutrosOvo.setText(Integer.toString(1));
				}else {
					qtdOutrosOvo.setText("");
					totalOvo = 0;
					qtdOutrosOvo.setEditable(false);
				}
			}		
		});
		chkOutrosOvo.setBounds(470, 454, 169, 23);
		lanchoneteWindow.getContentPane().add(chkOutrosOvo);
		
		qtdOutrosOvo = new JTextField();
		qtdOutrosOvo.setForeground(Color.BLACK);
		qtdOutrosOvo.setColumns(10);
		qtdOutrosOvo.setBounds(685, 455, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdOutrosOvo);
		qtdOutrosOvo.setEditable(false);
		
		JCheckBox chkBatataPalha = new JCheckBox("R$ 1,00 - Batata Palha");
		chkBatataPalha.setForeground(Color.WHITE);
		chkBatataPalha.setBackground(new Color(102, 153, 255));
		chkBatataPalha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkBatataPalha.isSelected()) {
					qtdOutrosBatataPalha.setEditable(true);
					qtdOutrosBatataPalha.setText(Integer.toString(1));
				}else {
					qtdOutrosBatataPalha.setText("");
					totalBatataPalha = 0;
					qtdOutrosBatataPalha.setEditable(false);
				}
			}
		});
		chkBatataPalha.setBounds(470, 478, 169, 23);
		lanchoneteWindow.getContentPane().add(chkBatataPalha);
		
		qtdOutrosBatataPalha = new JTextField();
		qtdOutrosBatataPalha.setForeground(Color.BLACK);
		qtdOutrosBatataPalha.setColumns(10);
		qtdOutrosBatataPalha.setBounds(685, 479, 27, 20);
		lanchoneteWindow.getContentPane().add(qtdOutrosBatataPalha);
		qtdOutrosBatataPalha.setEditable(false);	
		
		//Botão Encerrar Pedido
		JButton btEncerrarPedido = new JButton("Encerrar o Pedido");
		btEncerrarPedido.setForeground(Color.WHITE);
		btEncerrarPedido.setBackground(new Color(0, 102, 255));
		btEncerrarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //Este evento confere se as textbox  estão vazias, e se as checkbox estão selecionadas. 
				//Se a checkbox estiver selecionada e a textbox estiver vazia, aparece a mensagem de erro. Caso contrario, é captado o valor da textbox, adiciona o ingrediente na lista e soma o valorTotal
				//PÃES
				if (qtdPaoFrances.getText().isBlank()  && chkPaoFrances.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkPaoFrances.isSelected()) {
					totalPaoFrances = Integer.parseInt(qtdPaoFrances.getText());
					ingredientes.add("Pão Francês                        "+totalPaoFrances+" Und          R$ "+String.format("%.2f",(totalPaoFrances*paofrances))+"\n");
					valorTotal += totalPaoFrances*paofrances;	
				}
				if (qtdPaoCarteira.getText().isBlank()  && chkPaoCarteira.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkPaoCarteira.isSelected()) {
					totalPaoCarteira = Integer.parseInt(qtdPaoCarteira.getText());
					ingredientes.add("Pão Carteira                        "+totalPaoCarteira+" Und          R$ "+String.format("%.2f",(totalPaoCarteira*paocarteira))+"\n");
					valorTotal += totalPaoCarteira*paocarteira;
				}				
				if (qtdPaoHamburguer.getText().isBlank()  && chkPaoHamburguer.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkPaoHamburguer.isSelected()) {
					totalPaoHamburguer = Integer.parseInt(qtdPaoHamburguer.getText());
					ingredientes.add("Pão de Hamburguer             "+totalPaoHamburguer+" Und          R$ "+String.format("%.2f",(totalPaoHamburguer*paohamburguer))+"\n");
					valorTotal += totalPaoHamburguer*paohamburguer;
				}				
				if (qtdPaoArabe.getText().isBlank()  && chkPaoArabe.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkPaoArabe.isSelected()) {
					totalPaoArabe = Integer.parseInt(qtdPaoArabe.getText());
					ingredientes.add("Pão Arabe                          "+totalPaoArabe+" Und          R$ "+String.format("%.2f",(totalPaoArabe*paoarabe))+"\n");
					valorTotal += totalPaoArabe*paoarabe;
				}			
				
				//QUEIJOS
				if (qtdQueijoCoalho.getText().isBlank()  && chkQueijoCoalho.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkQueijoCoalho.isSelected()) {
					totalQueijoCoalho = Integer.parseInt(qtdQueijoCoalho.getText());
					ingredientes.add("Queijo Coalho                      "+totalQueijoCoalho+" Und          R$ "+String.format("%.2f",(totalQueijoCoalho*queijocoalho))+"\n");
					valorTotal += totalQueijoCoalho*queijocoalho;
				}				
				if (qtdQueijoMinas.getText().isBlank()  && chkQueijoMinas.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkQueijoMinas.isSelected()) {
					totalQueijoMinas = Integer.parseInt(qtdQueijoMinas.getText());
					ingredientes.add("Queijo Minas                       "+totalQueijoMinas+" Und          R$ "+String.format("%.2f",(totalQueijoMinas*queijominas))+"\n");
					valorTotal += totalQueijoMinas*queijominas;
				}					
				if (qtdQueijoMucarela.getText().isBlank()  && chkQueijoMucarela.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkQueijoMucarela.isSelected()) {
					totalQueijoMucarela = Integer.parseInt(qtdQueijoMucarela.getText());
					ingredientes.add("Queijo Muçarela                  "+totalQueijoMucarela+" Und          R$ "+String.format("%.2f",(totalQueijoMucarela*queijomucarela))+"\n");
					valorTotal += totalQueijoMucarela*queijomucarela;
				}				
				if (qtdQueijoCreamCheese.getText().isBlank()  && chkQueijoCreamCheese.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkQueijoCreamCheese.isSelected()) {
					totalQueijoCreamCheese = Integer.parseInt(qtdQueijoCreamCheese.getText());
					ingredientes.add("Queijo Cream Cheese           "+totalQueijoCreamCheese+" Und          R$ "+String.format("%.2f",(totalQueijoCreamCheese*queijocreamcheese))+"\n");
					valorTotal += totalQueijoCreamCheese*queijocreamcheese;
				}				
				if (qtdQueijoGorgonzola.getText().isBlank()  && chkQueijoGorgonzola.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkQueijoGorgonzola.isSelected()) {
					totalQueijoGorgonzola = Integer.parseInt(qtdQueijoGorgonzola.getText());
					ingredientes.add("Queijo Gorgonzola               "+totalQueijoGorgonzola+" Und          R$ "+String.format("%.2f",(totalQueijoGorgonzola*queijogorgonzola))+"\n");
					valorTotal += totalQueijoGorgonzola*queijogorgonzola;
				}
				
				//VERDURAS
				if (qtdVerduraCebola.getText().isBlank()  && chkVerduraCebola.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkVerduraCebola.isSelected()) {
					totalCebola = Integer.parseInt(qtdVerduraCebola.getText());
					ingredientes.add("Cebola                               "+totalCebola+" Und          R$ "+String.format("%.2f",(totalCebola*cebola))+"\n");
					valorTotal += totalCebola*cebola;
				}				
				if (qtdVerduraPimentao.getText().isBlank()  && chkVerduraPimentao.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkVerduraPimentao.isSelected()) {
					totalPimentao = Integer.parseInt(qtdVerduraPimentao.getText());
					ingredientes.add("Pimentão                           "+totalPimentao+" Und          R$ "+String.format("%.2f",(totalPimentao*pimentao))+"\n");
					valorTotal += totalPimentao*pimentao;
				}				
				if (qtdVerduraTomate.getText().isBlank()  && chkVerduraTomate.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkVerduraTomate.isSelected()) {
					totalTomate = Integer.parseInt(qtdVerduraTomate.getText());
					ingredientes.add("Tomate                             "+totalTomate+" Und          R$ "+String.format("%.2f",(totalTomate*tomate))+"\n");
					valorTotal += totalTomate*tomate;
				}				
				//CARNES
				if (qtdCarneMortadela.getText().isBlank()  && chkCarneMortadela.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkCarneMortadela.isSelected()) {
					totalMortadela = Integer.parseInt(qtdCarneMortadela.getText());
					ingredientes.add("Mortadela                           "+totalMortadela+" Und          R$ "+String.format("%.2f",(totalMortadela*mortadela))+"\n");
					valorTotal += totalMortadela*mortadela;
				}				
				if (qtdCarneApresuntado.getText().isBlank()  && chkCarneApresuntado.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkCarneApresuntado.isSelected()) {
					totalApresuntado = Integer.parseInt(qtdCarneApresuntado.getText());
					ingredientes.add("Apresuntado                       "+totalApresuntado+" Und          R$ "+String.format("%.2f",(totalApresuntado*apresuntado))+"\n");
					valorTotal += totalApresuntado*apresuntado;
				}				
				if (qtdCarneBacon.getText().isBlank()  && chkCarneBacon.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkCarneBacon.isSelected()) {
					totalBacon = Integer.parseInt(qtdCarneBacon.getText());
					ingredientes.add("Bacon                                "+totalBacon+" Und          R$ "+String.format("%.2f",(totalBacon*bacon))+"\n");
					valorTotal += totalBacon*bacon;
				}				
				if (qtdCarnePresunto.getText().isBlank()  && chkCarnePresunto.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkCarnePresunto.isSelected()) {
					totalPresunto = Integer.parseInt(qtdCarnePresunto.getText());
					ingredientes.add("Presunto                            "+totalPresunto+" Und          R$ "+String.format("%.2f",(totalPresunto*presunto))+"\n");
					valorTotal += totalPresunto*presunto;
				}				
				if (qtdCarnePepperoni.getText().isBlank()  && chkCarnePepperoni.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkCarnePepperoni.isSelected()) {
					totalPepperoni = Integer.parseInt(qtdCarnePepperoni.getText());
					ingredientes.add("Pepperoni                          "+totalPepperoni+" Und          R$ "+String.format("%.2f",(totalPepperoni*pepperoni))+"\n");
					valorTotal += totalPepperoni*pepperoni;
				}				
				if (qtdCarneSalame.getText().isBlank()  && chkCarneSalame.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkCarneSalame.isSelected()) {
					totalSalame = Integer.parseInt(qtdCarneSalame.getText());
					ingredientes.add("Salame                              "+totalSalame+" Und          R$ "+String.format("%.2f",(totalSalame*salame))+"\n");
					valorTotal += totalSalame*salame;
				}
				
				//MOLHOS
				if (qtdMolhoMaionese.getText().isBlank()  && chkMolhoMaionese.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkMolhoMaionese.isSelected()) {
					totalMaionese = Integer.parseInt(qtdMolhoMaionese.getText());
					ingredientes.add("Maionese                            "+totalMaionese+" Und          R$ "+String.format("%.2f",(totalMaionese*maionese))+"\n");
					valorTotal += totalMaionese*maionese;
				}				
				if (qtdMolhoKetchup.getText().isBlank()  && chkMolhoKetchup.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkMolhoKetchup.isSelected()) {
					totalKetchup = Integer.parseInt(qtdMolhoKetchup.getText());
					ingredientes.add("Ketchup                             "+totalKetchup+" Und          R$ "+String.format("%.2f",(totalKetchup*ketchup))+"\n");
					valorTotal += totalKetchup*ketchup;
				}				
				if (qtdMolhoMaioneseTemperada.getText().isBlank()  && chkMolhoMaioneseTemperada.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkMolhoMaioneseTemperada.isSelected()) {
					totalMaioneseTemperada = Integer.parseInt(qtdMolhoMaioneseTemperada.getText());
					ingredientes.add("Maionese Temperada           "+totalMaioneseTemperada+" Und          R$ "+String.format("%.2f",(totalMaioneseTemperada*maionesetemperada))+"\n");
					valorTotal += totalMaioneseTemperada*maionesetemperada;
				}				
				if (qtdMolhoTartaro.getText().isBlank()  && chkMolhoTartaro.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkMolhoTartaro.isSelected()) {
					totalMolhoTartaro = Integer.parseInt(qtdMolhoTartaro.getText());
					ingredientes.add("Molho Tartaro                     "+totalMolhoTartaro+" Und          R$ "+String.format("%.2f",(totalMolhoTartaro*molhotartaro))+"\n");
					valorTotal += totalMolhoTartaro*molhotartaro;
				}				
				if (qtdMolhoBarbecue.getText().isBlank()  && chkMolhoBarbecue.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkMolhoBarbecue.isSelected()) {
					totalBarbecue = Integer.parseInt(qtdMolhoBarbecue.getText());
					ingredientes.add("Molho Barbecue                  "+totalBarbecue+" Und          R$ "+String.format("%.2f",(totalBarbecue*barbecue))+"\n");
					valorTotal += totalBarbecue*barbecue;
				}
				
				//OUTROS
				if (qtdOutrosOvo.getText().isBlank()  && chkOutrosOvo.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkOutrosOvo.isSelected()) {
					totalOvo = Integer.parseInt(qtdOutrosOvo.getText());
					ingredientes.add("Ovo                                   "+totalOvo+" Und          R$ "+String.format("%.2f",(totalOvo*ovo))+"\n");
					valorTotal += totalOvo*ovo;
				}				
				if (qtdOutrosBatataPalha.getText().isBlank()  && chkBatataPalha.isSelected()){
					JOptionPane.showMessageDialog(lanchoneteWindow,"Não podem haver campos vazios!","Erro",JOptionPane.WARNING_MESSAGE);
				}else if (chkBatataPalha.isSelected()) {
					totalBatataPalha = Integer.parseInt(qtdOutrosBatataPalha.getText());
					ingredientes.add("Batata Palha                        "+totalBatataPalha+" Und          R$ "+String.format("%.2f",(totalBatataPalha*batatapalha))+"\n");
					valorTotal += totalBatataPalha*batatapalha;
				}
					
				if (valorTotal != 0) {
					Object[] opcoes = {"Sim","Não"};
					confirmarPedido = JOptionPane.showOptionDialog(lanchoneteWindow,"Confirma o pedido?",null, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcoes,opcoes[1]);
					if (confirmarPedido == 0) {
						lanchoneteWindow.dispose(); //fecha janela
						for(int i=0;i<ingredientes.size();i++) {
							listaingredientes += ingredientes.get(i);
						}
						Cupom cupom = new Cupom(listaingredientes,nameCliente,valorTotal);
						cupom.CupomWindow.setVisible(true);
					}else if (confirmarPedido == 1){
						valorTotal=0;
						ingredientes.clear();
					}
				}else {
					JOptionPane.showMessageDialog(lanchoneteWindow,"Escolha seus Ingredientes","Erro",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btEncerrarPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btEncerrarPedido.setBounds(316, 523, 162, 25);
		lanchoneteWindow.getContentPane().add(btEncerrarPedido);
}

public void labelsLanchonete() {  //DAQUI PRA BAIXO, LABELS E DETALHES VISUAIS POUCO RELEVANTES, NÃO MUDAM A FUNCIONALIDADE DO PROGRAMA
	JLabel labelMonteSeuSanduiche = new JLabel("MONTE SEU SANDU\u00CDCHE");  //Label Título MONTE SEU SANDUICHE
	labelMonteSeuSanduiche.setForeground(new Color(255, 255, 255));
	labelMonteSeuSanduiche.setHorizontalAlignment(SwingConstants.CENTER);
	labelMonteSeuSanduiche.setFont(new Font("Bookman Old Style", Font.BOLD, 32));
	labelMonteSeuSanduiche.setBounds(182, 7, 429, 50);
	lanchoneteWindow.getContentPane().add(labelMonteSeuSanduiche);
	
	JSeparator separator = new JSeparator();  //Linha separadora
	separator.setForeground(new Color(0, 51, 204));
	separator.setBounds(0, 57, 794, 11);
	lanchoneteWindow.getContentPane().add(separator);
	
	JLabel labelPao = new JLabel("Escolha o P\u00E3o:");  //Label Pao
	labelPao.setForeground(Color.BLACK);
	labelPao.setFont(new Font("Tahoma", Font.PLAIN, 20));
	labelPao.setBounds(70, 70, 146, 31);
	lanchoneteWindow.getContentPane().add(labelPao);
	
	JLabel labelQtdPao = new JLabel("Qtd:");  //Label Qtd Pao
	labelQtdPao.setForeground(Color.BLACK);
	labelQtdPao.setFont(new Font("Tahoma", Font.PLAIN, 20));
	labelQtdPao.setBounds(280, 70, 44, 31);
	lanchoneteWindow.getContentPane().add(labelQtdPao);
	
	JLabel labelQueijo = new JLabel("Escolha o Queijo:");  //Label Queijo
	labelQueijo.setForeground(Color.BLACK);
	labelQueijo.setFont(new Font("Tahoma", Font.PLAIN, 20));
	labelQueijo.setBounds(74, 210, 178, 31);
	lanchoneteWindow.getContentPane().add(labelQueijo);
	
	JLabel labelVerdura = new JLabel("Escolha a Verdura:");  //Label Verdura
	labelVerdura.setForeground(Color.BLACK);
	labelVerdura.setFont(new Font("Tahoma", Font.PLAIN, 20));
	labelVerdura.setBounds(74, 374, 178, 31);
	lanchoneteWindow.getContentPane().add(labelVerdura);
	
	JLabel labelCarne = new JLabel("Escolha a Carne:");  //Label Carne
	labelCarne.setForeground(Color.BLACK);
	labelCarne.setFont(new Font("Tahoma", Font.PLAIN, 20));
	labelCarne.setBounds(460, 70, 178, 31);
	lanchoneteWindow.getContentPane().add(labelCarne);
	
	JLabel labelQtdCarne = new JLabel("Qtd:");  //Label Qtd Carne
	labelQtdCarne.setForeground(Color.BLACK);
	labelQtdCarne.setFont(new Font("Tahoma", Font.PLAIN, 20));
	labelQtdCarne.setBounds(676, 70, 44, 31);
	lanchoneteWindow.getContentPane().add(labelQtdCarne);	
	
	JLabel labelMolho = new JLabel("Escolha o Molho:");  //Label Molho
	labelMolho.setForeground(Color.BLACK);
	labelMolho.setFont(new Font("Tahoma", Font.PLAIN, 20));
	labelMolho.setBounds(470, 258, 169, 31);
	lanchoneteWindow.getContentPane().add(labelMolho);
	
	JLabel labelOutros = new JLabel("Outros(adicionais):");  //Label Outros
	labelOutros.setForeground(Color.BLACK);
	labelOutros.setFont(new Font("Tahoma", Font.PLAIN, 20));
	labelOutros.setBounds(470, 422, 178, 31);
	lanchoneteWindow.getContentPane().add(labelOutros);
	}
}