package donnee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Collection;

public class OeuvreDAO {

	public static List<Collection> listerOeuvreParCollections()
	{
		Connection connection = BaseDeDonnees.getInstance().getConnection();

		List<Collection> listeCollection =  new ArrayList<Collection>();
		Statement requeteListeCollection;
		try {
			requeteListeCollection = connection.createStatement();
			ResultSet curseurListeCollections = requeteListeCollection.executeQuery("SELECT * from Collection");
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
	}

}
