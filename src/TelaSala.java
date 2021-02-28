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

public class TelaSala extends JFrame {

	private JPanel contentPane;
	private JTextField textAddID;
	private JTextField textAddNome;
	private JTextField textAddLotacao;
	private JTextField textBuscaID;
	private JTextField textAtualizarID;
	private JTextField textNovoNome;
	private JTextField textNovaLotacao;
	private JTextField textDeletarID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSala frame = new TelaSala();
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
	public TelaSala() {
		
		setTitle("Gerenciador do Evento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Op\u00E7\u00F5es de gerenciamento das salas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 600, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastre = new JLabel("Cadastre novas salas criando um ID e informando o nome e a lota\u00E7\u00E3o nos campos abaixo:");
		lblCadastre.setBounds(10, 40, 550, 15);
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
		
		textAddLotacao = new JTextField();
		textAddLotacao.setText("Lota\u00E7\u00E3o");
		textAddLotacao.setBounds(185, 60, 125, 20);
		panel.add(textAddLotacao);
		textAddLotacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAddLotacao.setColumns(10);
		
		JButton btnCadastrarSala = new JButton("Cadastrar");
		btnCadastrarSala.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr0){
				String cadastroID = textAddID.getText();
				String cadastroNome = textAddNome.getText();
				String cadastroLotacao = textAddLotacao.getText();
				if(cadastroID.equals("") || cadastroNome.equals("") || cadastroLotacao.equals("")){
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a sala", "Cadastro", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						BufferedWriter EscreverArquivo = new BufferedWriter(new FileWriter("TabelaSala.txt", true));
						EscreverArquivo.write("|ID:"+cadastroID+"| Sala: "+cadastroNome+" - Lotação: "+cadastroLotacao+" ");
						EscreverArquivo.flush();
						EscreverArquivo.newLine();
						EscreverArquivo.close();
						JOptionPane.showMessageDialog(null, "A sala "+cadastroNome+" - "+cadastroLotacao+"  foi cadastrada com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnCadastrarSala.setBounds(420, 60, 140, 22);
		panel.add(btnCadastrarSala);
		
		JLabel lblInsiraOID = new JLabel("Insira o ID da sala no campo abaixo para visualizar suas informações:");
		lblInsiraOID.setBounds(10, 100, 550, 15);
		panel.add(lblInsiraOID);
		lblInsiraOID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textBuscaID = new JTextField();
		textBuscaID.setText("ID");
		textBuscaID.setBounds(10, 120, 30, 20);
		panel.add(textBuscaID);
		textBuscaID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBuscaID.setColumns(10);
		
		JButton btnBuscarSala = new JButton("Buscar");
		btnBuscarSala.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr1) {
				String ID = textBuscaID.getText();
				String linhaArquivo;
				try {
					BufferedReader LerArquivo = new BufferedReader(new FileReader("TabelaSala.txt"));
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
		btnBuscarSala.setBounds(420, 120, 140, 22);
		panel.add(btnBuscarSala);
		
		JLabel lblAlterar = new JLabel("Informe o ID da sala cujo o nome e a lota\u00E7\u00E3o deve ser alterados:");
		lblAlterar.setBounds(10, 160, 550, 15);
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
		
		textNovaLotacao = new JTextField();
		textNovaLotacao.setText("Lota\u00E7\u00E3o Nova");
		textNovaLotacao.setBounds(185, 180, 125, 20);
		panel.add(textNovaLotacao);
		textNovaLotacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNovaLotacao.setColumns(10);
		
		JButton btnAtualizarSala = new JButton("Atualizar");
		btnAtualizarSala.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizarSala.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent agr0){
				String atualizarID = textAtualizarID.getText();
				String novoNome = textNovoNome.getText();
				String novaLotacao = textNovaLotacao.getText();
				String linhaArquivo;
				if(atualizarID.equals("") || novoNome.equals("") || novaLotacao.equals("")) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar as informações da sala", "Atualizar", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						File TabelaSala = new File("TabelaSala.txt");
						File TabelaTemporaria = new File("TabelaTemporaria.txt");
						
						BufferedWriter EscreverArquivo = new BufferedWriter(new FileWriter(TabelaTemporaria));
						BufferedReader LerArquivo = new BufferedReader(new FileReader(TabelaSala));
						
						while((linhaArquivo = LerArquivo.readLine()) != null ) {
							if(linhaArquivo.contains("|ID:"+atualizarID+"|")) {
								EscreverArquivo.write("|ID:"+atualizarID+"| Sala: "+novoNome+" - Lotação: "+novaLotacao+" ");
							} else {
								EscreverArquivo.write(linhaArquivo);
							}
							EscreverArquivo.flush();
							EscreverArquivo.newLine();
						}
						EscreverArquivo.close();
						LerArquivo.close();
						TabelaSala.delete();
						TabelaTemporaria.renameTo(TabelaSala);
						JOptionPane.showMessageDialog(null, "As informações da sala foram atualizadas com sucesso!", "Atualizar", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnAtualizarSala.setBounds(420, 180, 140, 22);
		panel.add(btnAtualizarSala);
		
		JLabel lblExcluir = new JLabel("Para excluir uma sala, insira o ID no campo abaixo:");
		lblExcluir.setBounds(10, 220, 550, 15);
		panel.add(lblExcluir);
		lblExcluir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textDeletarID = new JTextField();
		textDeletarID.setText("ID");
		textDeletarID.setBounds(10, 240, 30, 20);
		panel.add(textDeletarID);
		textDeletarID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDeletarID.setColumns(10);
		
		JButton btnDeletarSala = new JButton("Deletar");
		btnDeletarSala.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletarSala.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent agr0){
				String deletarID = textDeletarID.getText();
				String linhaArquivo;
				if(deletarID.equals("")) {
					JOptionPane.showMessageDialog(null, "Não foi possível deletar a sala", "Deletar", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						File TabelaSala = new File("TabelaSala.txt");
						File TabelaTemporaria = new File("TabelaTemporaria.txt");
						
						BufferedWriter EscreverArquivo = new BufferedWriter(new FileWriter(TabelaTemporaria));
						BufferedReader LerArquivo = new BufferedReader(new FileReader(TabelaSala));
						
						while((linhaArquivo = LerArquivo.readLine()) != null ) {
							if(linhaArquivo.contains("|ID:"+deletarID+"|")) 
								continue;
							EscreverArquivo.write(linhaArquivo);
							EscreverArquivo.flush();
							EscreverArquivo.newLine();
						}
						LerArquivo.close();
						EscreverArquivo.close();
						TabelaSala.delete();
						TabelaTemporaria.renameTo(TabelaSala);
						JOptionPane.showMessageDialog(null, "A sala foi deletada com sucesso!", "Deletar", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnDeletarSala.setBounds(420, 240, 140, 22);
		panel.add(btnDeletarSala);
	}
}