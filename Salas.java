import java.io.*;
import javax.swing.*;
import java.net.*;
import java.util.*;

public class Salas
{
	private ArrayList<Sala> salas;
	private int quantidade;

	public Salas(){
		salas = new ArrayList<Sala>();
	}

	public Sala[] getSalas() {
		return this.salas.toArray();
	}

	public boolean existe(String sala)
	{
		return this.salas.contains(sala);
	}

	public Sala getRoomsByName(String nome) throws Exception
	{
		for (int i = 0; i < this.salas.size(); i++)
		{
			if (this.salas[i].getNome() == nome )
				return this.salas[i];
	    }

	   	throw new Exception("Sala inexistente!");
	   	//return null;
	}

	public Sala getSalaByName (String nome)
	{
		return this.salas;
	}


}