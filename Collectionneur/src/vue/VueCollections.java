package vue;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class VueCollections extends Vue {

	protected ControleurCollections controleur;
	protected static VueCollections instance = null;
	public static VueCollections getInstance() {if(null==instance)instance = new VueCollections();return VueCollections.instance;};

	private VueCollections()
	{
		super("collections.fxml");
		super.controleur = this.controleur = new ControleurCollections();
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
