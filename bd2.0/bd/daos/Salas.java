package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;
import javax.swing.*;

public class Salas
{
	public static Sala getSala (JComboBox cbx) throws Exception
	{
		Sala sala = null;

		try
		{
			String sql;
			sql = "SELECT * FROM SALAS WHERE CodSala = ?";
			Conexao.COMANDO.prepareStatement (sql);

			List<String> strList = new ArrayList<String>();
			String query = "SELECT * FROM Salas WHERE CodSala = ?";
			PreparedStatement ps = Conexao.COMANDO.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next)
			{
			   strList.add(rs.getString("Nome"));
		    }
 			ps.close();

 			DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(strList.toArray());
 			cbx.setModel(defaultComboBoxModel);
		}
		catch (Exception erro)
		{
			throw new Exception("Erro ao conseguir sala");
		}
		return sala;
	}
}