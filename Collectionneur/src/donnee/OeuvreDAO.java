package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Collection;
import modele.Oeuvre;

public class OeuvreDAO
{

	/*public static List<Collection> listerOeuvreParCollections()
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();

		List<Collection> listeCollection =  new ArrayList<Collection>();
		Statement requeteListeCollection;
		try {
			requeteListeCollection = connection.createStatement();
			ResultSet curseurListeCollections = requeteListeCollection.executeQuery("SELECT * FROM oeuvre WHERE id_collection = ?");
			while(curseurListeCollections.next())
			{
				int id = curseurListeCollections.getInt("id");
				String nom = curseurListeCollections.getString("nom");
				Collection Collection = new Collection();
				Collection.setId(id);
				Collection.setNom(nom);
				listeCollection.add(Collection);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}

		return listeCollection;
	}*/

	public static List<Oeuvre> listerOeuvreParCollections(int idCollection)
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();

		List<Oeuvre> listeOeuvres = new ArrayList<Oeuvre>();

		try {
			PreparedStatement requete = connection.prepareStatement("SELECT * FROM oeuvre WHERE id_collection = ?");
			//PreparedStatement requete = connection.prepareStatement("SELECT * FROM oeuvre WHERE id_collection = 1");
			requete.setInt(1, idCollection);
			ResultSet curseur = requete.executeQuery();
			while(curseur.next())
			{
				int id = curseur.getInt("id");
				String nom = curseur.getString("nom");
				String description = curseur.getString("description");
				System.out.println("je suis dans List<Oeuvre> while de OeuvreDAO");
				System.out.println(id + nom);
				Oeuvre oeuvre = new Oeuvre();
				oeuvre.setId(id);
				oeuvre.setNom(nom);
				oeuvre.setDescription(description);
				listeOeuvres.add(oeuvre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("La liste des oeuvres : " + listeOeuvres);
		return listeOeuvres;
	}

	public void ajouterOeuvre(Oeuvre oeuvre)
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();
		try
		{
			PreparedStatement requete = connection.prepareStatement("INSERT into oeuvre(nom, description) VALUES(?, ?)");
			requete.setString(1, oeuvre.getNom());
			requete.setString(2, oeuvre.getDescription());
			requete.execute();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
