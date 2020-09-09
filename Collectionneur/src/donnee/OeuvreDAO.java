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

	public List<Oeuvre> listerOeuvreParCollections(int idCollection)
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();

		List<Oeuvre> oeuvres = new ArrayList<Oeuvre>();

		try {
			PreparedStatement requete = connection.prepareStatement("SELECT * FROM oeuvre WHERE id_collection = ?");
			requete.setInt(1, idCollection);
			ResultSet curseur = requete.executeQuery();
			while(curseur.next())
			{
				int id = curseur.getInt("id");
				String nom = curseur.getString("nom");
				String description = curseur.getString("description");

				Oeuvre oeuvre = new Oeuvre();
				oeuvre.setId(id);
				oeuvre.setNom(nom);
				oeuvre.setDescription(description);
				oeuvre.add(oeuvre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oeuvres;
	}

}
