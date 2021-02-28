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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Sistema extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
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
	public Sistema() {
		
		setTitle("Gerenciador do Evento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGerenciarParticipante = new JButton("Gerenciar Participantes");
		btnGerenciarParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGerenciarParticipante.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent agr0) {
				// TODO Auto-generated method stub
				TelaParticipante frame = new TelaParticipante();
				frame.setVisible(true);
			}
		});
		btnGerenciarParticipante.setBounds(55, 85, 220, 25);
		contentPane.add(btnGerenciarParticipante);
		
		JButton btnGerenciarSala = new JButton("Gerenciar Salas do Evento");
		btnGerenciarSala.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGerenciarSala.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent agr1) {
				// TODO Auto-generated method stub
				TelaSala frame = new TelaSala();
				frame.setVisible(true);
			}
		});
		btnGerenciarSala.setBounds(55, 121, 220, 25);
		contentPane.add(btnGerenciarSala);
		
		JButton btnGerenciarEspaco = new JButton("Gerenciar Espa\u00E7os de Caf\u00E9");
		btnGerenciarEspaco.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGerenciarEspaco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent agr2) {
				// TODO Auto-generated method stub
				TelaEspaco frame = new TelaEspaco();
				frame.setVisible(true);
			}
		});
		btnGerenciarEspaco.setBounds(55, 157, 220, 25);
		contentPane.add(btnGerenciarEspaco);
		
		JButton btnProcessaDados = new JButton("Processar Dados");
		btnProcessaDados.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProcessaDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent agr2) {
				// TODO Auto-generated method stub
				
				int contaPessoa = 0;
				int i = 0;
				String contador1;
				String linhaParticipante, linhaSala, linhaEspaco, linhaSala2, linhaEspaco2, linhaSala4, linhaEspaco4;
				
				try {
					
					BufferedReader contaArquivo1 = new BufferedReader(new FileReader("TabelaParticipante.txt"));
					while((contador1 = contaArquivo1.readLine()) != null ) {
						contaPessoa += 1;
					}
					contaArquivo1.close();
					
					File TabelaParticipante = new File("TabelaParticipante.txt");
					File TemporariaParticipante = new File("TemporariaParticipante.txt");
					
					BufferedWriter EscreverParticipante = new BufferedWriter(new FileWriter(TemporariaParticipante));
					BufferedReader LerParticipante = new BufferedReader(new FileReader(TabelaParticipante));
					
					File TabelaSala = new File("TabelaSala.txt");
					File TemporariaSala = new File("TemporariaSala.txt");
					
					BufferedWriter EscreverSala = new BufferedWriter(new FileWriter(TemporariaSala));
					BufferedReader LerSala = new BufferedReader(new FileReader(TabelaSala));
					
					File TabelaEspaco = new File("TabelaEspaco.txt");
					File TemporariaEspaco = new File("TemporariaEspaco.txt");
					
					BufferedWriter EscreverEspaco = new BufferedWriter(new FileWriter(TemporariaEspaco));
					BufferedReader LerEspaco = new BufferedReader(new FileReader(TabelaEspaco));
					
					linhaSala = LerSala.readLine();
					linhaEspaco = LerEspaco.readLine();
					
					BufferedReader LerSala2 = new BufferedReader(new FileReader("TabelaSala.txt"));
					BufferedReader LerEspaco2 = new BufferedReader(new FileReader("TabelaEspaco.txt"));
					
					linhaSala2 = LerSala2.readLine();
					linhaEspaco2 = LerEspaco2.readLine();
					
					linhaSala2 = LerSala2.readLine();
					linhaEspaco2 = LerEspaco2.readLine();
					
					File TemporariaSala4 = new File("TemporariaSala4.txt");
					
					BufferedWriter EscreverSala4 = new BufferedWriter(new FileWriter(TemporariaSala4));
					BufferedReader LerSala4 = new BufferedReader(new FileReader("TemporariaSala4.txt"));
					
					File TemporariaEspaco4 = new File("TemporariaEspaco4.txt");
					
					BufferedWriter EscreverEspaco4 = new BufferedWriter(new FileWriter(TemporariaEspaco4));
					BufferedReader LerEspaco4 = new BufferedReader(new FileReader(TemporariaEspaco4));
					
					while((linhaParticipante = LerParticipante.readLine()) != null ) {
						if(i < contaPessoa/4) {
							EscreverParticipante.write(linhaParticipante + " " + "[ Etapa 1: " + linhaSala + linhaEspaco + " ][ Etapa 2: " + linhaSala + linhaEspaco + " ]");
							EscreverParticipante.flush();
							EscreverParticipante.newLine();
							if(i == 0) {
								EscreverSala.write(linhaSala + " " + linhaParticipante + "[ Etapa 1 ][ Etapa 2 ]");
								EscreverSala.flush();
								EscreverEspaco.write(linhaEspaco + " " + linhaParticipante + "[ Etapa 1 ][ Etapa 2 ]");
								EscreverEspaco.flush();
								
								EscreverSala4.write(linhaSala2);
								EscreverSala4.flush();
								EscreverEspaco4.write(linhaEspaco2);
								EscreverEspaco4.flush();
							} else {
								EscreverSala.write(" " + linhaParticipante + "[ Etapa 1 ][ Etapa 2 ]");
								EscreverSala.flush();
								EscreverEspaco.write(" " + linhaParticipante + "[ Etapa 1 ][ Etapa 2 ]");
								EscreverEspaco.flush();
							}
							i++;
						} else if(i <= contaPessoa/2) {
							EscreverParticipante.write(linhaParticipante + " " + "[ Etapa 1: " + linhaSala + linhaEspaco + " ][ Etapa 2: " + linhaSala2 + linhaEspaco2 + " ]");
							EscreverParticipante.flush();
							EscreverParticipante.newLine();
							
							EscreverSala.write(" " + linhaParticipante + "[ Etapa 1 ]");
							EscreverSala.flush();
							EscreverEspaco.write(" " + linhaParticipante + "[ Etapa 1 ]");
							EscreverEspaco.flush();
							
							EscreverSala4.write(" " + linhaParticipante + "[ Etapa 2 ]");
							EscreverSala4.flush();
							EscreverEspaco4.write(" " + linhaParticipante + "[ Etapa 2 ]");
							EscreverEspaco4.flush();
							i++;
						} else if(i <= contaPessoa*0.75) {
							EscreverParticipante.write(linhaParticipante + " " + "[ Etapa 1: " + linhaSala2 + linhaEspaco2 + " ][ Etapa 2: " + linhaSala + linhaEspaco + " ]");
							EscreverParticipante.flush();
							EscreverParticipante.newLine();
							
							EscreverSala.write(" " + linhaParticipante + "[ Etapa 2 ]");
							EscreverSala.flush();
							EscreverEspaco.write(" " + linhaParticipante + "[ Etapa 2 ]");
							EscreverEspaco.flush();
							
							EscreverSala4.write(" " + linhaParticipante + "[ Etapa 1 ]");
							EscreverSala4.flush();
							EscreverEspaco4.write(" " + linhaParticipante + "[ Etapa 1 ]");
							EscreverEspaco4.flush();
							i++;
						} else {
							EscreverParticipante.write(linhaParticipante + " " + "[ Etapa 1: " + linhaSala2 + linhaEspaco2 + " ][ Etapa 2: " + linhaSala2 + linhaEspaco2 + " ]");
							EscreverParticipante.flush();
							EscreverParticipante.newLine();
							
							EscreverSala4.write(" " + linhaParticipante + "[ Etapa 1 ][ Etapa 2 ]");
							EscreverSala4.flush();
							EscreverEspaco4.write(" " + linhaParticipante + "[ Etapa 1 ][ Etapa 2 ]");
							EscreverEspaco4.flush();
							i++;
						}
					}
					EscreverParticipante.close();
					LerParticipante.close();
					TabelaParticipante.delete();
					TemporariaParticipante.renameTo(TabelaParticipante);
					
					linhaSala4 = LerSala4.readLine();
					EscreverSala.newLine();
					EscreverSala.write(linhaSala4);
					linhaEspaco4 = LerEspaco4.readLine();
					EscreverEspaco.newLine();
					EscreverEspaco.write(linhaEspaco4);
					
					LerSala4.close();
					EscreverSala.close();
					EscreverSala4.close();
					LerSala.close();
					LerSala2.close();
					TabelaSala.delete();
					TemporariaSala4.delete();
					TemporariaSala.renameTo(TabelaSala);
					
					LerEspaco4.close();
					EscreverEspaco.close();
					EscreverEspaco4.close();
					LerEspaco.close();
					LerEspaco2.close();
					TabelaEspaco.delete();
					TemporariaEspaco4.delete();
					TemporariaEspaco.renameTo(TabelaEspaco);
					
					JOptionPane.showMessageDialog(null, "Dados processados com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnProcessaDados.setBounds(55, 212, 220, 25);
		contentPane.add(btnProcessaDados);
		
		JLabel txtBemVindo = new JLabel("Bem-Vindo ao Sistema de Gerenciamento do Evento!");
		txtBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBemVindo.setBounds(10, 10, 330, 22);
		contentPane.add(txtBemVindo);
		
		JLabel txtSelecione = new JLabel("Selecione a op\u00E7\u00E3o de acordo com sua necessidade:");
		txtSelecione.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSelecione.setBounds(10, 60, 330, 14);
		contentPane.add(txtSelecione);
		
		JLabel txtDistribua = new JLabel("Distribua os participantes entre as salas e espa\u00E7os de caf\u00E9:");
		txtDistribua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDistribua.setBounds(10, 193, 330, 14);
		contentPane.add(txtDistribua);
	}
}