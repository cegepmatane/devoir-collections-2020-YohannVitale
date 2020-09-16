package controleur;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import donnee.CollectionDAO;
import donnee.OeuvreDAO;
import modele.Collection;
import modele.Oeuvre;
import vue.Navigateur;
import vue.VueAjouterOeuvre;
import vue.VueCollection;

public class ControleurCollection extends Controleur
{
	protected CollectionDAO collectionDAO = new CollectionDAO();
	protected OeuvreDAO oeuvreDAO = new OeuvreDAO();

	protected Collection collection = null;
	protected List<Oeuvre> oeuvres = null;

	public ControleurCollection()
	{
		Logger.logMsg(Logger.INFO, "new ControleurCollection()");
	}


	public void actionOuvrirCollection(int id)
	{
		CollectionDAO collectionDAO = new CollectionDAO();
		this.collection = collectionDAO.detaillerCollection(id);
		VueCollection.getInstance().afficherCollection(this.collection);
		this.oeuvres = oeuvreDAO.listerOeuvreParCollections(id);
		VueCollection.getInstance().afficherOeuvre(this.oeuvres);
		//VueCollection.getInstance().afficherCollection(collectionDAO.detaillerCollection(id));
		//VueCollection.getInstance().afficherOeuvre(OeuvreDAO.listerOeuvreParCollections(id));
		Navigateur.getInstance().afficherVue(VueCollection.getInstance());
	}

	public void notifierClicAjouterOeuvre()
	{
		Navigateur.getInstance().afficherVue(VueAjouterOeuvre.getInstance());
	}

	public void notifierClicEnregistrerAjoutOeuvre()
	{
		Oeuvre oeuvre = VueAjouterOeuvre.getInstance().lireOeuvre();
		oeuvre.setIdCollection(collection.getId());
		OeuvreDAO oeuvreDAO = new OeuvreDAO();
		oeuvreDAO.ajouterOeuvre(oeuvre);
		//TODO gerer la situation d'afficher la nouvelle oeuvre
		//VueCollection.getInstance().afficherOeuvre(oeuvreDAO.listerOeuvreParCollections(1);
		this.oeuvres.add(oeuvre);
		VueCollection.getInstance().afficherOeuvre(oeuvres); //TODO optimiser
		Navigateur.getInstance().afficherVue(VueCollection.getInstance());
	}

	public void notifierClicEditerOeuvre(int ind)
	{
		Logger.logMsg(Logger.INFO, "ControleurCollectionClicEditerOeuvre");
	}

}
