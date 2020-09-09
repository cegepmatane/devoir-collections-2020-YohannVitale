package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurCollection;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Collection;
import modele.Oeuvre;

public class VueCollection extends Vue {

	protected ControleurCollection controleur;
	protected static VueCollection instance = null;
	public static VueCollection getInstance() {if(null==instance)instance = new VueCollection();return VueCollection.instance;};

	private VueCollection()
	{
		super("collection.fxml");
		super.controleur = this.controleur = new ControleurCollection();
		Logger.logMsg(Logger.INFO, "new VueCollection()");
	}

	public void activerControles()
	{
		super.activerControles();
	}

	public void afficherCollection(modele.Collection collection)
	{
		/*TextArea affichageDescription = (TextArea)lookup("#collection-description");
		affichageDescription.setText(collection.getDescription());

		Label affichageTitre = (Label)lookup("#titre-page");
		affichageTitre.setText("COLLECTION " + collection.getNom());*/
	}

	public void afficherOeuvre(List<Oeuvre> list)
	{
		Logger.logMsg(Logger.INFO, "VueCollection.afficherOeuvre()");
		VBox vueOeuvres = (VBox)lookup("#affichageCollection");
		//vueOeuvres.getChildren().clear();


		for(Oeuvre oeuvre:list)
		{
			Logger.logMsg(Logger.INFO, "oeuvre " + oeuvre.getNom());
			HBox vueOeuvre = new HBox();
			vueOeuvre.getStyleClass().add("oeuvre");
			vueOeuvre.getChildren().add(new Label(oeuvre.getNom()));
			vueOeuvres.getChildren().add(vueOeuvre);

		}

	}
}
