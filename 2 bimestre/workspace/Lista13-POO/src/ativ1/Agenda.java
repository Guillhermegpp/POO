package ativ1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Agenda {
	private Collection<Pessoa> agenda;
	boolean add = false;
	public boolean f;

	public Agenda() {
		agenda = new TreeSet<Pessoa>();
	}

	public Collection<Pessoa> getAgenda() {
		return agenda;
	}

	public void setAgenda(Collection<Pessoa> agenda) {
		this.agenda = agenda;
	}

	public void inserir() {
		String nome = JOptionPane.showInputDialog("Nome Completo: ");
		if (nome != null) {
			String email = JOptionPane.showInputDialog("Email: ");
			String telefone = JOptionPane.showInputDialog("Telefone: ");
			String rua = JOptionPane.showInputDialog("Rua: ");
			String num = JOptionPane.showInputDialog("N: ");
			String cidade = JOptionPane.showInputDialog("Cidade: ");
			String estado = JOptionPane.showInputDialog("UF: ");
			try {
				cadastrar(nome, email, telefone, rua, cidade, estado, Integer.parseInt(num));
				JOptionPane.showMessageDialog(null, "Contato adicionado");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Algo deu errado");
			}
		}
	}

	public void salvar(Collection<Pessoa> agenda2) throws Exception {
		FileOutputStream saida = new FileOutputStream("lista13.db");
		ObjectOutputStream saidaO = new ObjectOutputStream(saida);
		saidaO.writeObject(agenda2);
		saidaO.close();
	}

	@SuppressWarnings({ "resource", "unchecked" })
	public void receber() throws Exception {
		FileInputStream entrada = new FileInputStream("lista13.db");
		ObjectInputStream entradaO = new ObjectInputStream(entrada);
		Set<Pessoa> p = (Set<Pessoa>) entradaO.readObject();
		agenda = p;
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

	public void cadastrar(String n, String e, String t, String rua, String cidade, String estado, int numero) {
		new Thread() {

			@Override
			public void run() {
				agenda.add(new Pessoa(n, e, t, rua, cidade, estado, numero));

				try {
					salvar(agenda);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error");
				}

			}
		}.start();

	}

	public void excluir() throws InterruptedException {
		if (agenda.size() != 0) {
			f = false;
			String nome = JOptionPane.showInputDialog("Digite o nome que deseja excluir: ");
			
			if (nome != null) {
			Iterator<Pessoa> it = agenda.iterator();
			while (it.hasNext()) {
				if (it.next().getNome().equalsIgnoreCase(nome)) {
					String r = JOptionPane.showInputDialog("Deseja realmente excluir " + nome + " da agenda?? (S/N)");
					if (r.equalsIgnoreCase("S")) {
						JOptionPane.showMessageDialog(null, "Excluido");
						Excluir(nome);
					}
					f = true;
				}
			}
			if (!f)
				JOptionPane.showMessageDialog(null, "Nada encontrado", "Agenda", JOptionPane.WARNING_MESSAGE);
		}
		}
		

	}

	public void Excluir(String nome) {
		new Thread() {

			@Override
			public void run() {
				Iterator<Pessoa> it = agenda.iterator();
				while (it.hasNext()) {
					if (it.next().getNome().equalsIgnoreCase(nome)) {
						it.remove();
						try {
							salvar(agenda);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Error");
						}
					}
				}

			}
		}.start();

	}

	StringBuilder sb = new StringBuilder();

	public void imprimir() {
		if (agenda.size() != 0) {
			for (Pessoa p : agenda) {
				sb.append("Nome: " + p.getNome() + "\n" + "Email: " + p.getEmail() + "\n" + "Telefone: "
						+ p.getTelefone() + "\nEndereço: " + p.getRua() + ", " + p.getNumero() + ", " + p.getCidade()
						+ " - " + p.getEstado()

						+ "\n_______________________________\n");
			}
			JOptionPane.showMessageDialog(null, sb);
			sb = new StringBuilder();
		}
		else 
			JOptionPane.showMessageDialog(null, "Nada encontrado", "Agenda", JOptionPane.WARNING_MESSAGE);

	}

}
