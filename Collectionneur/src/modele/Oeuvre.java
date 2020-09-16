package modele;

public class Oeuvre {

	protected int id;
	protected String nom;
	protected String description;
	protected int idCollection;

	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		// TODO Auto-generated method stub
		this.id = id;

	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}


	/*public void add(Oeuvre oeuvre)
	{
		// TODO Auto-generated method stub
		this.idCollection = idCollection;
	}*/

	public int getIdCollection()
	{
		return idCollection;
	}

	public void setIdCollection(int idCollection)
	{
		this.idCollection = idCollection;
	}



}
