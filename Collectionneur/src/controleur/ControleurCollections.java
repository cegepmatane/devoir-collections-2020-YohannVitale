package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.CollectionDAO;
import donnee.OeuvreDAO;
import vue.Navigateur;
import vue.VueCollection;
import vue.VueCollections;

public class ControleurCollections extends Controleur{

	public ControleurCollections()
	{
		Logger.logMsg(Logger.INFO, "new ControleurCollections()");
	}

	// RECEPTION des EVENEMENTS
	public void actionOuvrirCollection(int numero)
	{
		CollectionDAO collectionDAO = new CollectionDAO();
		VueCollection.getInstance().afficherCollection(collectionDAO.detaillerCollection(numero));
		VueCollection.getInstance().afficherCollections(OeuvreDAO.listerOeuvreParCollections());
		Navigateur.getInstance().afficherVue(VueCollection.getInstance());
	}

}
