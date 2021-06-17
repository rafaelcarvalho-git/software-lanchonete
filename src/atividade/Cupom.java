package atividade;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Color;

public class Cupom extends Lanchonete {	
	public JFrame CupomWindow;  //variavel do frame(janela)
	public double valor;  //variavel que recebe o valorTotal da classe Lanchonete
	public String nome, valorFinal, listaCupomFiscal;  //variaveis que armazenam o nome do cliente, o valorTotal da compra em String, e a lista dos ingredientes	
	int novoPedido;  //variavel que armazena a escolha de fazer um novo pedido
	/**Launch the application.**/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cupom window = new Cupom("","",0);
					window.CupomWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**Create the application.**/
	public Cupom(String listaingredientes,String nameCliente,double valorTotal) { //recebe valores das variaveis da classe Lanchonete, para serem utilizados na classe Cupom
		this.valor = valorTotal;
		this.listaCupomFiscal = listaingredientes;
		this.nome = nameCliente;
		inicializarCupom();  //inicia a janela
		labelsCupom();  //exibe os labels
	}

	/**inicializarCupom the contents of the frame.**/
	private void inicializarCupom() {  //criação do frame(janela)
		CupomWindow = new JFrame(); 
		CupomWindow.getContentPane().setBackground(new Color(51, 153, 255));
		CupomWindow.setTitle("Cupom Fiscal - Lanchonete");
		CupomWindow.setResizable(false);
		CupomWindow.setBounds(100, 100, 390, 485);
		CupomWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CupomWindow.setLocationRelativeTo(null);
		CupomWindow.getContentPane().setLayout(null);
		
		//label que exibe o valor total da compra
		JLabel valorTotalCupom = new JLabel();  //exibe o valor total da compra, com a formatação de 2 casas decimais após a virgula(ponto)
		valorTotalCupom.setForeground(Color.BLACK);
		valorTotalCupom.setBounds(220, 356, 116, 43);
		valorTotalCupom.setHorizontalAlignment(SwingConstants.CENTER);
		valorTotalCupom.setFont(new Font("Tahoma", Font.BOLD, 22));
		CupomWindow.getContentPane().add(valorTotalCupom);
		String valorFinal = String.format("%.2f", valor);
		valorTotalCupom.setText(valorFinal);  //exibe o valor no label		
			
		JButton btConcluirPedido = new JButton("Concluir Pedido");  //botao que conclui o pedido e fecha a janela(encerra o programa)
		btConcluirPedido.setBackground(Color.WHITE);
		btConcluirPedido.setForeground(Color.BLACK);
		btConcluirPedido.setBounds(127, 410, 130, 23);
		btConcluirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //evento que fecha janela e dá opção de concluir o pedido ou fazer outro			
				Object[] opcoes = {"Sim","Não"};
				novoPedido = JOptionPane.showOptionDialog(lanchoneteWindow,"Deseja fazer um novo pedido?",null, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opcoes,opcoes[1]);
				if (novoPedido==0) {  //fecha a janela cupom, limpa as variaveis e abre a janela Cliente
					CupomWindow.dispose(); 
					nome="";
					nameCliente="";
					listaingredientes="";
					listaCupomFiscal="";
					valorTotal=0;
					Cliente cliente = new Cliente();  //É criado o objeto lanchonete
					cliente.clienteWindow.setVisible(true);
				}else {  //fecha a janela cupom e encerra o programa
					CupomWindow.dispose();
					JOptionPane.showMessageDialog(CupomWindow,"            Obrigado por fazer o Pedido :) \n Espero que tenha gostado do nosso projeto.");
				}
			
			}
		});
		btConcluirPedido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CupomWindow.getContentPane().add(btConcluirPedido);
		
		JScrollPane scrollPane = new JScrollPane();  //scroll para rolar a lista dos ingredientes
		scrollPane.setBounds(25, 93, 325, 230);
		CupomWindow.getContentPane().add(scrollPane);
		
		JTextPane listaIngredientes = new JTextPane();  //caixa de texto que exibe a lista dos ingredientes
		scrollPane.setViewportView(listaIngredientes);
		listaIngredientes.setForeground(new Color(0, 0, 0));
		listaIngredientes.setText(listaCupomFiscal);
		listaIngredientes.setEditable(false);
		listaIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
}

public void labelsCupom() {  //DAQUI PRA BAIXO, LABELS E DETALHES VISUAIS POUCO RELEVANTES, NÃO MUDAM A FUNCIONALIDADE DO PROGRAMA
	JLabel labelCupom = new JLabel("Cupom Fiscal");
	labelCupom.setForeground(new Color(255, 255, 255));
	labelCupom.setBounds(107, 11, 170, 37);
	labelCupom.setHorizontalAlignment(SwingConstants.CENTER);
	labelCupom.setFont(new Font("Bookman Old Style", Font.BOLD, 24));
	CupomWindow.getContentPane().add(labelCupom);
			
	JLabel labelNomeCliente = new JLabel();
	labelNomeCliente.setForeground(new Color(255, 255, 255));
	labelNomeCliente.setBounds(25, 331, 325, 23);
	labelNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
	labelNomeCliente.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
	CupomWindow.getContentPane().add(labelNomeCliente);
	labelNomeCliente.setText(nome);
	
	JLabel labelTotal = new JLabel("Total:");
	labelTotal.setForeground(Color.BLACK);
	labelTotal.setBounds(52, 359, 116, 37);
	labelTotal.setHorizontalAlignment(SwingConstants.CENTER);
	labelTotal.setFont(new Font("Tahoma", Font.BOLD, 22));
	CupomWindow.getContentPane().add(labelTotal);
	
	JLabel labelRs = new JLabel("R$");
	labelRs.setForeground(Color.BLACK);
	labelRs.setBounds(198, 365, 31, 24);
	labelRs.setFont(new Font("Tahoma", Font.BOLD, 22));
	CupomWindow.getContentPane().add(labelRs);
	
	JLabel labelProduto = new JLabel("Ingrediente");
	labelProduto.setForeground(Color.BLACK);
	labelProduto.setBounds(25, 68, 102, 14);
	labelProduto.setHorizontalAlignment(SwingConstants.LEFT);
	labelProduto.setFont(new Font("Tahoma", Font.BOLD, 16));
	CupomWindow.getContentPane().add(labelProduto);
	
	JLabel labelQtd = new JLabel("Quantidade");
	labelQtd.setForeground(Color.BLACK);
	labelQtd.setBounds(157, 68, 100, 14);
	labelQtd.setHorizontalAlignment(SwingConstants.CENTER);
	labelQtd.setFont(new Font("Tahoma", Font.BOLD, 16));
	CupomWindow.getContentPane().add(labelQtd);
	
	JLabel labelValor = new JLabel("Valor");
	labelValor.setForeground(Color.BLACK);
	labelValor.setBounds(304, 68, 46, 14);
	labelValor.setHorizontalAlignment(SwingConstants.RIGHT);
	labelValor.setFont(new Font("Tahoma", Font.BOLD, 16));
	CupomWindow.getContentPane().add(labelValor);	
	}
}
