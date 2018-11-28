package bd;

import core.*;
import daos.*;

public class Conexao
{
	public static final MeuPreparedStatement COMANDO;

	static
	{
		MeuPreparedStatement comando = null;

		try
		{
			comando =
			new MeuPreparedStatement (
			"com.microsoft.sqlserver.jdbc.SQLServerDriver",
			"jdbc:sqlserver:regulus:1433;databasename=PR118044",
			"PR118044", "PR118044");
		}
		catch (Exception erro)
		{
			System.err.println ("Problemas de conexao com o BD");
			System.exit(0); // aborta o programa
		}

		COMANDO = comando;
	}
}