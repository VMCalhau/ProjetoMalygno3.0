public class AvisoDeSaidaDaSala implements Enviavel
{
	private String nome;

	public String getNome()
	{
		return this.nome;
	}

	public String setNome(String nome)
	{
		this.nome = nome;
	}

	public AvisoDeSaidaDaSala (String nome)
	{
		this.nome = nome;
	}
}