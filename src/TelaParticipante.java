import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TelaParticipante extends JFrame {

	private JPanel contentPane;
	private JTextField textAddID;
	private JTextField textAddNome;
	private JTextField textAddSobrenome;
	private JTextField textBuscaID;
	private JTextField textAtualizarID;
	private JTextField textNovoNome;
	private JTextField textNovoSobrenome;
	private JTextField textDeletarID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaParticipante frame = new TelaParticipante();
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
	public TelaParticipante() {
		
		setTitle("Gerenciador do Evento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Op\u00E7\u00F5es de gerenciamento dos participantes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 600, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastre = new JLabel("Cadastre novos participantes criando um ID e informando o nome e o sobrenome nos campos abaixo:");
		lblCadastre.setBounds(10, 40, 584, 15);
		panel.add(lblCadastre);
		lblCadastre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textAddID = new JTextField();
		textAddID.setText("ID");
		textAddID.setBounds(10, 60, 30, 20);
		panel.add(textAddID);
		textAddID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAddID.setColumns(10);
		
		textAddNome = new JTextField();
		textAddNome.setText("Nome");
		textAddNome.setBounds(50, 60, 125, 20);
		panel.add(textAddNome);
		textAddNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAddNome.setColumns(10);
		
		textAddSobrenome = new JTextField();
		textAddSobrenome.setText("Sobrenome");
		textAddSobrenome.setBounds(185, 60, 125, 20);
		panel.add(textAddSobrenome);
		textAddSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAddSobrenome.setColumns(10);
		
		JButton btnCadastrarParticipante = new JButton("Cadastrar");
		btnCadastrarParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr0){
				String cadastroID = textAddID.getText();
				String cadastroNome = textAddNome.getText();
				String cadastroSobrenome = textAddSobrenome.getText();
				if(cadastroID.equals("") || cadastroNome.equals("") || cadastroSobrenome.equals("")){
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o participante", "Cadastro", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						BufferedWriter EscreverArquivo = new BufferedWriter(new FileWriter("TabelaParticipante.txt", true));
						EscreverArquivo.write("|ID:"+cadastroID+"| Nome: "+cadastroNome+" "+cadastroSobrenome+" ");
						EscreverArquivo.flush();
						EscreverArquivo.newLine();
						EscreverArquivo.close();
						JOptionPane.showMessageDialog(null, "O(A) participante "+cadastroNome+" "+cadastroSobrenome+" foi cadastrado(a) com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnCadastrarParticipante.setBounds(420, 60, 140, 22);
		panel.add(btnCadastrarParticipante);
		
		JLabel lblInsiraOID = new JLabel("Insira o ID do participante no campo abaixo para visualizar suas informações:");
		lblInsiraOID.setBounds(10, 100, 584, 15);
		panel.add(lblInsiraOID);
		lblInsiraOID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textBuscaID = new JTextField();
		textBuscaID.setText("ID");
		textBuscaID.setBounds(10, 120, 30, 20);
		panel.add(textBuscaID);
		textBuscaID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBuscaID.setColumns(10);
		
		JButton btnBuscarParticipante = new JButton("Buscar");
		btnBuscarParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscarParticipante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr1) {
				String ID = textBuscaID.getText();
				String linhaArquivo;
				try {
					BufferedReader LerArquivo = new BufferedReader(new FileReader("TabelaParticipante.txt"));
					while((linhaArquivo = LerArquivo.readLine()) != null ) {
						if(linhaArquivo.contains("|ID:"+ID+"|")) {
							JOptionPane.showMessageDialog(null, linhaArquivo, "Buscar", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					LerArquivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnBuscarParticipante.setBounds(420, 120, 140, 22);
		panel.add(btnBuscarParticipante);
		
		JLabel lblAlterar = new JLabel("Informe o ID do participante cujo o nome deve ser alterado:");
		lblAlterar.setBounds(10, 160, 584, 15);
		panel.add(lblAlterar);
		lblAlterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textAtualizarID = new JTextField();
		textAtualizarID.setText("ID");
		textAtualizarID.setBounds(10, 180, 30, 20);
		panel.add(textAtualizarID);
		textAtualizarID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAtualizarID.setColumns(10);
		
		textNovoNome = new JTextField();
		textNovoNome.setText("Nome Novo");
		textNovoNome.setBounds(50, 180, 125, 20);
		panel.add(textNovoNome);
		textNovoNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNovoNome.setColumns(10);
		
		textNovoSobrenome = new JTextField();
		textNovoSobrenome.setText("Sobrenome Novo");
		textNovoSobrenome.setBounds(185, 180, 125, 20);
		panel.add(textNovoSobrenome);
		textNovoSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNovoSobrenome.setColumns(10);
		
		JButton btnAtualizarParticipante = new JButton("Atualizar");
		btnAtualizarParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizarParticipante.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent agr2){
				String atualizarID = textAtualizarID.getText();
				String novoNome = textNovoNome.getText();
				String novoSobrenome = textNovoSobrenome.getText();
				String linhaArquivo;
				if(atualizarID.equals("") || novoNome.equals("") || novoSobrenome.equals("")) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar as informações do participante", "Atualizar", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						File TabelaParticipante = new File("TabelaParticipante.txt");
						File TabelaTemporaria = new File("TabelaTemporaria.txt");
						
						BufferedWriter EscreverArquivo = new BufferedWriter(new FileWriter(TabelaTemporaria));
						BufferedReader LerArquivo = new BufferedReader(new FileReader(TabelaParticipante));
						
						while((linhaArquivo = LerArquivo.readLine()) != null ) {
							if(linhaArquivo.contains("ID:"+atualizarID+"|")) {
								EscreverArquivo.write("|ID:"+atualizarID+"| Nome: "+novoNome+" "+novoSobrenome+" ");
							} else {
								EscreverArquivo.write(linhaArquivo);
							}
							EscreverArquivo.flush();
							EscreverArquivo.newLine();
						}
						EscreverArquivo.close();
						LerArquivo.close();
						TabelaParticipante.delete();
						TabelaTemporaria.renameTo(TabelaParticipante);
						JOptionPane.showMessageDialog(null, "As informações do participante foram atualizadas com sucesso!", "Atualizar", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnAtualizarParticipante.setBounds(420, 180, 140, 22);
		panel.add(btnAtualizarParticipante);
		
		JLabel lblExcluir = new JLabel("Para excluir um participante, insira o ID no campo abaixo:");
		lblExcluir.setBounds(10, 220, 584, 15);
		panel.add(lblExcluir);
		lblExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDeletarID = new JTextField();
		textDeletarID.setText("ID");
		textDeletarID.setBounds(10, 240, 30, 20);
		panel.add(textDeletarID);
		textDeletarID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDeletarID.setColumns(10);
		
		JButton btnDeletarParticipante = new JButton("Deletar");
		btnDeletarParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletarParticipante.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent agr3){
				String deletarID = textDeletarID.getText();
				String linhaArquivo;
				if(deletarID.equals("")) {
					JOptionPane.showMessageDialog(null, "Não foi possível deletar o participante", "Deletar", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						File TabelaParticipante = new File("TabelaParticipante.txt");
						File TabelaTemporaria = new File("TabelaTemporaria.txt");
						
						BufferedWriter EscreverArquivo = new BufferedWriter(new FileWriter(TabelaTemporaria));
						BufferedReader LerArquivo = new BufferedReader(new FileReader(TabelaParticipante));
						
						while((linhaArquivo = LerArquivo.readLine()) != null ) {
							if(linhaArquivo.contains("|ID:"+deletarID+"|")) 
								continue;
							EscreverArquivo.write(linhaArquivo);
							EscreverArquivo.flush();
							EscreverArquivo.newLine();
						}
						LerArquivo.close();
						EscreverArquivo.close();
						TabelaParticipante.delete();
						TabelaTemporaria.renameTo(TabelaParticipante);
						JOptionPane.showMessageDialog(null, "O(A) participante foi deletado(a) com sucesso!", "Deletar", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnDeletarParticipante.setBounds(420, 240, 140, 22);
		panel.add(btnDeletarParticipante);
	}
}