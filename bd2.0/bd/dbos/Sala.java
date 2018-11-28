package bd.dbos;

public class Sala implements Cloneable
{
	private int codigo;
	private String nome;
	private int qtdeUsuarios;

	public void setCodigo (int codigo) throws Exception
	{
		if (codigo <= 0)
			throw new Exception ("Codigo invalido");

		this.codigo = codigo;
	}

	public void setNome (String nome) throws Exception
	{
		if (nome==null || nome.equals(""))
			throw new Exception ("Nome nao fornecido");

		this.nome = nome;
	}

	public void setQtdeUsuarios (int qtdeUsuarios) throws Exception
	{
		if (qtdeUsuarios <= 0)
			throw new Exception ("Qauantidade invalida");

		this.qtdeUsuarios = qtdeUsuarios;
	}

	public int getCodigo ()
	{
		return this.codigo;
	}

	public String getNome ()
	{
		return this.nome;
	}

	public int getQtdeUsuarios ()
	{
		return this.qtdeUsuarios;
    }

    public Sala (int codigo, String nome, int qtdeUsuarios) throws Exception
	{
		this.setCodigo (codigo);
		this.setNome   (nome);
		this.setQtdeUsuarios  (qtdeUsuarios);
    }

    public String toString ()
	    {
	        String ret="";

	        ret+="Codigo: "+this.codigo+"\n";
	        ret+="Nome..: "+this.nome  +"\n";
	        ret+="Quantidade de Usuarios.: "+this.qtdeUsuarios;

	        return ret;
	    }

	    public boolean equals (Object obj)
	    {
	        if (this==obj)
	            return true;

	        if (obj==null)
	            return false;

	        if (!(obj instanceof Sala))
	            return false;

	        Sala sal = (Sala)obj;

	        if (this.codigo!=sal.codigo)
	            return false;

	        if (this.nome.equals(sal.nome))
	            return false;

	        if (this.qtdeUsuarios!=sal.qtdeUsuarios)
	            return false;

	        return true;
	    }

	    public int hashCode ()
	    {
	        int ret=666;

	        ret = 7*ret + new Integer(this.codigo).hashCode();
	        ret = 7*ret + this.nome.hashCode();
	        ret = 7*ret + new Integer(this.qtdeUsuarios).hashCode();

	        return ret;
	    }


	    public Sala (Sala modelo) throws Exception
	    {
	        this.codigo = modelo.codigo; // nao clono, pq nao eh objeto
	        this.nome   = modelo.nome;   // nao clono, pq nao eh clonavel
	        this.qtdeUsuarios  = modelo.qtdeUsuarios;  // nao clono, pq nao eh objeto
	    }

	    public Object clone ()
	    {
	        Sala ret=null;

	        try
	        {
	            ret = new Sala (this);
	        }
	        catch (Exception erro)
	        {} // nao trato, pq this nunca é null e construtor de
	           // copia da excecao qdo seu parametro for null

	        return ret;
    }
}