package RevisaoClasse;

public class Professor extends Pessoa{
	public int numeroMatricula;
	public String[] turmas;
	
	public Professor(String nome,int numeroMatricula){
		super(nome);
		this.numeroMatricula = numeroMatricula;
	}
	
	public void setDisciplinas(String[] turmas){
		this.turmas = turmas;
	}
}
