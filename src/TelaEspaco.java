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

public class TelaEspaco extends JFrame {

	private JPanel contentPane;
	private JTextField textAddID;
	private JTextField textAddNome;
	private JTextField textBuscaID;
	private JTextField textAtualizarID;
	private JTextField textNovoNome;
	private JTextField textDeletarID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEspaco frame = new TelaEspaco();
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
	public TelaEspaco() {
		
		setTitle("Gerenciador do Evento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Op\u00E7\u00F5es de gerenciamento dos espa\u00E7os de caf\u00E9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 600, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInformeONome = new JLabel("Cadastre novos espa\u00E7os de caf\u00E9 criando um ID e informando o nome nos campos abaixo:");
		lblInformeONome.setBounds(10, 40, 584, 15);
		panel.add(lblInformeONome);
		lblInformeONome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
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
		
		JButton btnCadastrarEspaco = new JButton("Cadastrar");
		btnCadastrarEspaco.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrarEspaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr0){
				String cadastroID = textAddID.getText();
				String cadastroNome = textAddNome.getText();
				if(cadastroID.equals("") || cadastroNome.equals("")){
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o espa\u00E7o de caf\u00E9", "Cadastro", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						BufferedWriter EscreverArquivo = new BufferedWriter(new FileWriter("TabelaEspaco.txt", true));
						EscreverArquivo.write("|ID:"+cadastroID+"| Espaço de Café: "+cadastroNome+" ");
						EscreverArquivo.flush();
						EscreverArquivo.newLine();
						EscreverArquivo.close();
						JOptionPane.showMessageDialog(null, "O espa\u00E7o de caf\u00E9 "+cadastroNome+" foi cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnCadastrarEspaco.setBounds(420, 60, 140, 22);
		panel.add(btnCadastrarEspaco);
		
		JLabel lblInsiraOID = new JLabel("Insira o ID do espa\u00E7o de caf\u00E9 no campo abaixo para visualizar suas informa\u00E7\u00F5es:");
		lblInsiraOID.setBounds(10, 100, 584, 15);
		panel.add(lblInsiraOID);
		lblInsiraOID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textBuscaID = new JTextField();
		textBuscaID.setText("ID");
		textBuscaID.setBounds(10, 120, 30, 20);
		panel.add(textBuscaID);
		textBuscaID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBuscaID.setColumns(10);
		
		JButton btnBuscarEspaco = new JButton("Buscar");
		btnBuscarEspaco.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscarEspaco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr1) {
				String ID = textBuscaID.getText();
				String linhaArquivo;
				try {
					BufferedReader LerArquivo = new BufferedReader(new FileReader("TabelaEspaco.txt"));
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
		btnBuscarEspaco.setBounds(420, 120, 140, 22);
		panel.add(btnBuscarEspaco);
		
		JLabel lblAlterar = new JLabel("Informe o ID do espa\u00E7o de caf\u00E9 cujo o nome deve ser alterado:");
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
		
		JButton btnAtualizarEspaco = new JButton("Atualizar");
		btnAtualizarEspaco.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizarEspaco.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent agr0){
				String atualizarID = textAtualizarID.getText();
				String novoNome = textNovoNome.getText();
				String linhaArquivo;
				if(atualizarID.equals("") || novoNome.equals("")) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar as informações do espa\u00E7o de caf\u00E9", "Atualizar", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						File TabelaEspaco = new File("TabelaEspaco.txt");
						File TabelaTemporaria = new File("TabelaTemporaria.txt");
						
						BufferedWriter EscreverArquivo = new BufferedWriter(new FileWriter(TabelaTemporaria));
						BufferedReader LerArquivo = new BufferedReader(new FileReader(TabelaEspaco));
						
						while((linhaArquivo = LerArquivo.readLine()) != null ) {
							if(linhaArquivo.contains("|ID:"+atualizarID+"|")) {
								EscreverArquivo.write("|ID:"+atualizarID+"| Espaço de Café: "+novoNome+" ");
							} else {
								EscreverArquivo.write(linhaArquivo);
							}
							EscreverArquivo.flush();
							EscreverArquivo.newLine();
						}
						EscreverArquivo.close();
						LerArquivo.close();
						TabelaEspaco.delete();
						TabelaTemporaria.renameTo(TabelaEspaco);
						JOptionPane.showMessageDialog(null, "As informações do espa\u00E7o de caf\u00E9 foram atualizadas com sucesso!", "Atualizar", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnAtualizarEspaco.setBounds(420, 180, 140, 22);
		panel.add(btnAtualizarEspaco);
		
		JLabel lblExcluir = new JLabel("Para excluir um espa\u00E7o de caf\u00E9 insira o ID no campo abaixo:");
		lblExcluir.setBounds(10, 220, 584, 15);
		panel.add(lblExcluir);
		lblExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDeletarID = new JTextField();
		textDeletarID.setText("ID");
		textDeletarID.setBounds(10, 240, 30, 20);
		panel.add(textDeletarID);
		textDeletarID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDeletarID.setColumns(10);
		
		JButton btnDeletarEspaco = new JButton("Deletar");
		btnDeletarEspaco.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletarEspaco.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent agr0){
				String deletarID = textDeletarID.getText();
				String linhaArquivo;
				if(deletarID.equals("")) {
					JOptionPane.showMessageDialog(null, "Não foi possível deletar o espa\u00E7o de caf\u00E9", "Deletar", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						File TabelaEspaco = new File("TabelaEspaco.txt");
						File TabelaTemporaria = new File("TabelaTemporaria.txt");
						
						BufferedWriter EscreverArquivo = new BufferedWriter(new FileWriter(TabelaTemporaria));
						BufferedReader LerArquivo = new BufferedReader(new FileReader(TabelaEspaco));
						
						while((linhaArquivo = LerArquivo.readLine()) != null ) {
							if(linhaArquivo.contains("|ID:"+deletarID+"|")) 
								continue;
							EscreverArquivo.write(linhaArquivo);
							EscreverArquivo.flush();
							EscreverArquivo.newLine();
						}
						LerArquivo.close();
						EscreverArquivo.close();
						TabelaEspaco.delete();
						TabelaTemporaria.renameTo(TabelaEspaco);
						JOptionPane.showMessageDialog(null, "O espa\u00E7o de caf\u00E9 foi deletado com sucesso!", "Deletar", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnDeletarEspaco.setBounds(420, 240, 140, 22);
		panel.add(btnDeletarEspaco);
	}
}