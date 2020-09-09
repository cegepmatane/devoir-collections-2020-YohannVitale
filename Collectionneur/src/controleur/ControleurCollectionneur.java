package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.CollectionDAO;
import donnee.OeuvreDAO;
import vue.Navigateur;
import vue.VueCollection;
import vue.VueCollections;

public class ControleurCollectionneur extends Controleur{

	public ControleurCollectionneur()
	{
		Logger.logMsg(Logger.INFO, "new ControleurCollections()");
	}

	// RECEPTION des EVENEMENTS
	public void actionOuvrirCollection(int id)
	{
		CollectionDAO collectionDAO = new CollectionDAO();
		VueCollection.getInstance().afficherCollection(collectionDAO.detaillerCollection(id));
		VueCollection.getInstance().afficherOeuvre(OeuvreDAO.listerOeuvreParCollections(id));
		Navigateur.getInstance().afficherVue(VueCollection.getInstance());
	}

}
