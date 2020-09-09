package controleur;

import donnee.CollectionDAO;
import vue.Vue;
import vue.VueCollections;

//import vue.Navigateur;
//import vue.*;

public class Controleur {

	public static Vue selectionnerVuePrincipale()
	{
		CollectionDAO collectionDAO = new CollectionDAO();
		VueCollections.getInstance().afficherCollections(collectionDAO.listerCollections());
		return VueCollections.getInstance();
	}
		
}
