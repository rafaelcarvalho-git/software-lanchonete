package atividade;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cliente {
	public JFrame clienteWindow;  //variavel do frame(janela)
	private JTextField nome;  //variavel da caixa de texto nome
	protected String nomeCliente; //variavel que armazena o nome do cliente
	/** Launch the application.**/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();  //Cria��o do objeto window
					window.clienteWindow.setVisible(true);  //Faz a janela ficar vis�vel
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//
	/**Create the application.**/
	public Cliente() {
		inicializarCliente();
		labelsCliente();
	}

	/**Initialize the contents of the frame.*/
	private void inicializarCliente() {
		clienteWindow = new JFrame();  //cria��o do frame(janela)
		clienteWindow.getContentPane().setBackground(new Color(153, 204, 255));
		clienteWindow.setBackground(Color.WHITE);
		clienteWindow.setTitle("Lanchonete - Novo Pedido");
		clienteWindow.setResizable(false);
		clienteWindow.setBounds(100, 100, 350, 180);
		clienteWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clienteWindow.getContentPane().setLayout(null);
		clienteWindow.setLocationRelativeTo(null); 
		clienteWindow.setVisible(true);
		
		nome = new JTextField();  //Caixa de texto para inserir o nome
		nome.setBackground(Color.WHITE);
		nome.setForeground(Color.BLACK);
		nome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nome.setBounds(33, 71, 268, 20);
		clienteWindow.getContentPane().add(nome);
		nome.setColumns(10);
		
		JButton botaoIniciarPedido = new JButton("Iniciar Pedido");  //Bot�o que inicia pedido e abre a janela Monte seu Sanduiche, chamando a classe Lanchonete
		botaoIniciarPedido.setForeground(Color.BLACK);
		botaoIniciarPedido.setBackground(Color.WHITE);
		botaoIniciarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeCliente = nome.getText();  //Recebe a string inserida na caixa de texto
				if (nomeCliente.isEmpty()==true) {  //Confere se a caixa de texto esta vazia. Caso esteja, aparece uma mensagem de erro
					JOptionPane.showMessageDialog(clienteWindow,"          Insira seu Nome!","Erro",JOptionPane.WARNING_MESSAGE);
				}else {  //Caso a caixa de texto n�o esteja vazia
				Lanchonete lanchonete = new Lanchonete();  //� criado o objeto lanchonete
				lanchonete.nameCliente = nomeCliente;  //A vari�vel do nome do cliente � passado entre as janelas
				lanchonete.lanchoneteWindow.setVisible(true);  //E a janela Monte seu Sanduiche fica vis�vel
				clienteWindow.dispose();  //E fecha a tela do cliente
				}
			}
		});
		botaoIniciarPedido.setBounds(114, 102, 115, 23);
		clienteWindow.getContentPane().add(botaoIniciarPedido);		
}

public void labelsCliente() {  //DAQUI PRA BAIXO, LABELS E DETALHES VISUAIS POUCO RELEVANTES, N�O MUDAM A FUNCIONALIDADE DO PROGRAMA
	JLabel labelLanchonete = new JLabel("Lanchonete");  //label t�tulo Lanchonete
	labelLanchonete.setForeground(new Color(255, 255, 255));
	labelLanchonete.setFont(new Font("Bookman Old Style", Font.BOLD, 26));
	labelLanchonete.setHorizontalAlignment(SwingConstants.CENTER);
	labelLanchonete.setBounds(70, 0, 194, 45);
	clienteWindow.getContentPane().add(labelLanchonete);
	
	JSeparator separator = new JSeparator(); //linha separadora
	separator.setBounds(0, 35, 334, 20);
	clienteWindow.getContentPane().add(separator);
	
	JLabel labelNome = new JLabel("Nome:");  //label Nome:
	labelNome.setForeground(new Color(255, 255, 255));
	labelNome.setHorizontalAlignment(SwingConstants.LEFT);
	labelNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
	labelNome.setBounds(33, 45, 105, 20);
	clienteWindow.getContentPane().add(labelNome);
	}
}