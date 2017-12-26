package ativ1;


import javax.swing.JOptionPane;

public class Main13 {
	public static void main(String[] args) throws Exception {
		Agenda agenda = new Agenda();
		agenda.GetDB();
		Evento evento = new Evento();
		evento.GetDB();
		int ag, ev;
		int menu;
		// Thread checando os eventos proximos e notificar na tela
		new Thread() {
			public void run() {
				evento.notifica();
			};
		}.start();

		do {
			Object[] options = { "Agenda", "Evento" };
			menu = JOptionPane.showOptionDialog(null, "Agenda Pessoal\nSelecione uma das opções", "Lista 13 - POO",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (menu != -1) {
				switch (menu) {
				case 0:
					do {
						Object[] optionsa = { "Cadastrar", "Listar", "Excluir" };
						ag = JOptionPane.showOptionDialog(null, "", "Lista 13 - POO", JOptionPane.DEFAULT_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, optionsa, optionsa[0]);
						if (ag != -1) {
							switch (ag) {
							case 0:
								agenda.inserir();
								break;
							case 1:
								agenda.imprimir();
								break;
							case 2:
								agenda.excluir();
								break;
							}
						}
					} while (ag != -1);
					break;
				// ========================================
				case 1:
					do {
						Object[] optionse = { "Adicionar Evento", "Listar", "Editar" ,"Excluir" };
						ev = JOptionPane.showOptionDialog(null, "", "Lista 13 - POO", JOptionPane.DEFAULT_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, optionse, optionse[0]);
						if (ev != -1) {
							switch (ev) {
							case 0:
								evento.inserir();
								break;
							case 1:
								evento.listar();
								break;
							case 2:
								evento.editar();
								break;
							case 3:
								evento.excluir();
								break;
							}
						}
					} while (ev != -1);
					break;
				}
			}
		} while (menu != -1);
		
	}
}
