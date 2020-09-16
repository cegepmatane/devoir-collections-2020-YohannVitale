package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.CollectionDAO;
import donnee.OeuvreDAO;
import vue.Navigateur;
import vue.VueCollection;
import vue.VueCollectionneur;

public class ControleurCollectionneur extends Controleur{

	public ControleurCollectionneur()
	{
		Logger.logMsg(Logger.INFO, "new ControleurCollections()");
	}

	// RECEPTION des EVENEMENTS
	public void actionOuvrirCollection(int id)
	{
		VueCollection.getInstance().getControlleur().actionOuvrirCollection(id);
	}

}
