public class AvisoDeEntradaNaSala implements Enviavel
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

	public AvisoDeEntradaNaSala (String nome)
	{
		this.nome = nome;
	}
}