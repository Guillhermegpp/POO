package ativ1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Evento {
	final long TEMPO = (1000 * 60 * 60 * 24); // atualizaçao diaria
	private ArrayList<Dados> eventos;

	public Evento() {
		eventos = new ArrayList<Dados>();
	}

	/*
	 * Esse método é responsavel por avisar ao usuario se houver algum evento
	 * nos proximos 2 dias Caso tenha, ele imprime uma notificação na tela. Esse
	 * método esta ajustado para disparar uma vez por dia. Para isso a agenda
	 * não pode ser fechada. Caso queira que dispare em um intervalo menor é só
	 * alterar a variavel TEMPO (linha 16)
	 */
	public void notifica() {
		// Thread checando os eventos proximos e notificar na tela
		Timer timer = null;
		if (timer == null) {
			timer = new Timer();
			TimerTask tarefa = new TimerTask() {
				public void run() {
					try {
						for (Dados dados : eventos) {
							dados.dataDiff(dados.dataHoje(), dados.getData());
						}
						Dados.imprimeNotify();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
		}

	}

	public ArrayList<Dados> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Dados> eventos) {
		this.eventos = eventos;
	}

	public void salvar(ArrayList<Dados> event2) throws Exception {
		FileOutputStream saida = new FileOutputStream("EventoLista13.db");
		ObjectOutputStream saidaO = new ObjectOutputStream(saida);
		saidaO.writeObject(event2);
		saidaO.close();
	}

	@SuppressWarnings({ "resource", "unchecked" })
	public void receber() throws Exception {
		FileInputStream entrada = new FileInputStream("EventoLista13.db");
		ObjectInputStream entradaO = new ObjectInputStream(entrada);
		ArrayList<Dados> p = (ArrayList<Dados>) entradaO.readObject();
		eventos = p;
	}

	public void GetDB() {
		new Thread() {

			@Override
			public void run() {
				try {
					receber();
				} catch (Exception e) {

				}
			}
		}.start();

	}

	public void inserir() throws ParseException {
		String desc = JOptionPane.showInputDialog("Descricao");
		String dat = JOptionPane.showInputDialog("Data que ocorrerá o evento(dd/MM/yyyy)");

		new Thread() {

			@Override
			public void run() {
				eventos.add(new Dados(desc, dat));
				try {
					salvar(eventos); // A PORRA NAO TA SALVANDO
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}

		}.start();
	}

	public void editar() {
		if (eventos.size() != 0) {
			StringBuilder sb = new StringBuilder();
			String cod = JOptionPane.showInputDialog("Codigo do evento: ");
			try {
				int c = Integer.parseInt(cod);

				if (eventos.get(c) != null) {
					Object[] options = { "Descrição", "Data" };
					sb.append(eventos.get(c).getDescricao() + "  \nData: " + dataSimples(eventos.get(c).getData())
							+ "\nO que deseja alterar?");
					int n = JOptionPane.showOptionDialog(null, sb, "Informação", JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (n == 0) {
						String des = JOptionPane.showInputDialog("Nome: ");
						eventos.get(c).setDescricao(des);
					} else if (n == 1) {
						String data = JOptionPane.showInputDialog("Data: ");
						try {
							eventos.get(c).setData(data);
						} catch (ParseException e) {
						}

					}

				}
			} catch (Exception e) {
			}
		} else
			JOptionPane.showMessageDialog(null, "Nada encontrado", "Eventos", JOptionPane.WARNING_MESSAGE);

	}

	public String dataSimples(Date dataa) {
		String s = dataa.toString();
		System.out.println(s);
		String[] str = s.split(" ");
		String simples = (str[2] + "-" + str[1] + "-" + str[5]);
		return simples;
	}

	public void listar() {
		int i = 0;
		StringBuilder sr = new StringBuilder();
		for (Dados dados : eventos) {

			sr.append("Cód. " + i + "\n" + dados.getDescricao() + "  \nData: " + dataSimples(dados.getData())
					+ "\n_______________________________________________\n");
			i++;
		}
		if (sr.length() != 0)
			JOptionPane.showMessageDialog(null, sr, "Eventos", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Nada encontrado", "Eventos", JOptionPane.WARNING_MESSAGE);

		sr = new StringBuilder();
	}

	public void excluir() {
		if (eventos.size() != 0) {
			String cod = JOptionPane.showInputDialog("Cod. do Evento: ");
			try {
				int c = Integer.parseInt(cod);
				if (eventos.get(c) != null) {
					Object[] options = { "Sim", "Nao" };
					StringBuilder sh = new StringBuilder();
					sh.append(eventos.get(c).getDescricao() + "  \nData: " + dataSimples(eventos.get(c).getData())
							+ "\n");
					sh.append("Deseja Realmente excluir esse evento?");
					int n = JOptionPane.showOptionDialog(null, sh, "Informação", JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (n == 0) {
						JOptionPane.showMessageDialog(null, "Excluido", "Eventos", JOptionPane.INFORMATION_MESSAGE);
						new Thread() {

							@Override
							public void run() {
								eventos.remove(c);
								try {
									salvar(eventos);
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, "Erro no salvamento", "Eventos",
											JOptionPane.WARNING_MESSAGE);

								}
							}
						}.start();
					}
				}
			} catch (Exception e) {
			}
		} else
			JOptionPane.showMessageDialog(null, "Nada encontrado", "Eventos", JOptionPane.WARNING_MESSAGE);

	}

}
