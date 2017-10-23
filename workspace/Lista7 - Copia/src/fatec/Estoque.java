package fatec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
	private double saldo;
	private List<Object> fluxo;
	private Scanner scan;

	public Estoque() {
		saldo = 0;
		fluxo = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	public void imprimir() {
		int i = 0, tEntrada = 0, tSaida = 0;
		for (Object fluxos : fluxo) {
			System.out.printf("Id: " + i + "\t");
			if (fluxos instanceof Entrada) {
				((Entrada) fluxos).imprime();
				tEntrada += ((Entrada) fluxos).getValor();
			} else if (fluxos instanceof Saida) {
				((Saida) fluxos).imprime();
				tSaida += ((Saida) fluxos).getValor();
			}
			i++;
		}
		System.out.println("Total de Entrada: R$" + tEntrada);
		System.out.println("Total de Saida: R$" + tSaida);
	}

	public void printEntradas() {
		int i = 0;
		for (Object fluxos : fluxo) {
			if (fluxos instanceof Entrada) {
				System.out.printf("Id: " + i + "\t");
				((Entrada) fluxos).imprime();
			}
			i++;
		}
		System.out.println();
	}

	public void printSaidas() {
		int i = 0;
		for (Object fluxos : fluxo) {
			if (fluxos instanceof Saida) {
				System.out.printf("Id: " + i + "\t");
				((Saida) fluxos).imprime();
			}
			i++;
		}
		System.out.println();
	}

	public void opcoes() {
		System.out.printf("* Opções*****************************************************************\n"
				+ "* 1-Adicionar Entrada\t" + "2-Adicionar Saida\t" + "3-Editar Entrada\t*\n" + "* 4-Editar Saida\t"
				+ "5-Excluir Entrada\t" + "6-Excluir Saida\t\t*\n" + "* 7-Usuarios\t\t" + "8-Sair\t\t\t\t\t\t*\n");
		System.out.println("*************************************************************************");
	}

	public void cadEntrada() {
		System.out.println("Tipo de entrada: ");
		String n = scan.next();
		System.out.println("Valor: ");
		double d = scan.nextDouble();
		fluxo.add(new Entrada(n, d));

	}

	public void editEntrada() {
		System.out.println("Id: ");
		int id = scan.nextInt();
		System.out.printf("Tipo de entrada: ");
		String n = scan.next();
		System.out.println("Valor: ");
		double d = scan.nextDouble();
		try {
			((Entrada) fluxo.get(id)).setNome(n);
			((Entrada) fluxo.get(id)).setValor(d);
			System.out.println("Alterado!!!");
		} catch (Exception e) {
			System.out.println("Erro ao editar");
		}

	}

	public void excEntrada() {
		System.out.println("Id: ");
		int id = scan.nextInt();
		fluxo.remove(id);
		System.out.println("Deletado!!!");
	}

	public void cadSaida() {
		System.out.println("Tipo de entrada: ");
		String n = scan.next();
		System.out.println("Valor: ");
		double d = scan.nextDouble();
		fluxo.add(new Saida(n, d));

	}

	public void editSaida() {
		System.out.println("Id: ");
		int id = scan.nextInt();
		System.out.printf("Tipo de entrada: ");
		String n = scan.next();
		System.out.println("Valor: ");
		double d = scan.nextDouble();
		((Saida) fluxo.get(id)).setNome(n);
		((Saida) fluxo.get(id)).setValor(d);
		System.out.println("Alterado!!!");
	}

	public void excSaida() {
		System.out.println("Id: ");
		int id = scan.nextInt();
		fluxo.remove(id);
		System.out.println("Deletado!!!");
	}

	public void salvaCaixa() {
		try {
			FileOutputStream fos = new FileOutputStream("caixa.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(fluxo);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Object> loadCaixa() {
		ArrayList<Object> fluxoo = new ArrayList<Object>();
		try {
			FileInputStream fis = new FileInputStream("caixa.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			fluxoo = (ArrayList<Object>) ois.readObject();
			ois.close();

		} catch (Exception e) {
			System.out.println("Nenhum banco carregado.");
		}
		return fluxoo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Object> getFluxo() {
		return fluxo;
	}

	public void setFluxo(List<Object> fluxo) {
		this.fluxo = fluxo;
	}

}
