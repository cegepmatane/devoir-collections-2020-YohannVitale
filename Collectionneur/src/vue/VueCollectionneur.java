package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurCollectionneur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class VueCollectionneur extends Vue {

	protected ControleurCollectionneur controleur;
	protected static VueCollectionneur instance = null;
	public static VueCollectionneur getInstance() {if(null==instance)instance = new VueCollectionneur();return VueCollectionneur.instance;};

	private VueCollectionneur()
	{
		super("collections.fxml");
		super.controleur = this.controleur = new ControleurCollectionneur();
		Logger.logMsg(Logger.INFO, "new VueCollections()");
	}

	public void activerControles()
	{
		super.activerControles();
	}

	public void afficherCollections(List<modele.Collection> collections)
	{

		int position = 1;
		System.out.println("Je suis dans AfficherCollections");
		Logger.logMsg(Logger.INFO, "VueCollection.afficherCollections");
		for(modele.Collection collection : collections)
		{
			Button libelle = (Button)lookup("#categorie-" + position);
			System.out.println(collection.getNom());
			libelle.setText(collection.getNom());
			libelle.setId(collection.getId()+""); // l'id est changé mais on n'a plus besoin de recuperer l'objet

			libelle.setOnAction(new EventHandler<ActionEvent>()
			{
	            public void handle(ActionEvent e)
	            {
	            	Logger.logMsg(Logger.INFO, "Bouton Collection active");
	            	Button bouton = (Button)e.getSource();
	            	controleur.actionOuvrirCollection(Integer.parseInt(bouton.getId()));
	            }
	        });

			position++;
			if(position > 8) break;
		}


	}


}
