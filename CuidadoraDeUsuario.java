import java.io.*;
import java.net.*;

public class CuidadoraDeUsuario extends Thread  // só vai cuidar de receber
{
	private Usuario usuario;
	private Salas salas = new Salas();
	private Socket conexao;
    //private Salas salas;
    private String username;
    private String sala;

	public CuidadoraDeUsuario (Socket conexao) throws Exception
	{
		if (conexao == null || salas == null)
			throw new Exception("Informacoes ausentes!");

		this.conexao = conexao;
        //this.salas = salas;
	}

	public void setSala(String sala)
	{
		this.sala = sala;
	}

	public void setUsername(String usrnm)
	{
		this.username = usrnm;
	}

	public void run()
	{
		ObjectOutputStream transmissor = new ObjectOutputStream(conexao.getOutputStream());
		ObjectInputStream receptor = new ObjectInputStream(conexao.getInputStream());

		this.nome = receptor.readObject();
		this.sala = receptor.readObject();
		Sala salaSala;
		salaSala = salas.getRoomsByName(sala);
		this.usuario = new Usuario(conexao, transmissor, receptor, nome, salaSala);
		salaSala.adicionarUsuario(usuario);

		// fazer varias vezes this.usuario.envia(new AvisoDeEntradaDaSala(i)), onde i é o nome de algum usuario que ja estava na sala
		// fazer varias vezes i.envia(new AvisoDeEntradaDaSala(usuario.getNome()), onde i é o nome de algum usuario que ja estava na sala
		// RECEBE PEDIDOS DE SAIR DA SALA OU MENSAGEM
		Enviavel recebido = null;
		do
		{
			// recebe o enviavel
			// enquanto não for pedido vai ser mensagem
			// recebe aviso de entrada e saida e mensagens
		}
		while (!(recebido instanceof PedidoParaSairDaSala));
		salaSala.remover(this.usuario);
		// remover this.usuario da sala
		// mandar new AvisoDeSaidaDaSala(this.usuario.getNome()) para todos da sala

		this.usuario.fechaTudo();
		//e fechar a conexão
	}
}