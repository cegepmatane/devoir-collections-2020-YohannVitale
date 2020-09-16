package controleur;

import donnee.CollectionDAO;
import vue.Vue;
import vue.VueAjouterOeuvre;
import vue.VueCollectionneur;

//import vue.Navigateur;
//import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale()
	{
		//return VueAjouterOeuvre.getInstance();

		CollectionDAO collectionDAO = new CollectionDAO();
		VueCollectionneur.getInstance().afficherCollections(collectionDAO.listerCollections());
		return VueCollectionneur.getInstance();

	}


}
