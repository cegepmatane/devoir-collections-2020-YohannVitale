package vue;

import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurCollection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.Collection;
import modele.Oeuvre;

public class VueCollection extends Vue {


	protected static VueCollection instance = null;
	public static VueCollection getInstance()
	{
		if(null==instance)
			instance = new VueCollection();
		return VueCollection.instance;
	};

	protected ControleurCollection controleur = null;

	public ControleurCollection getControlleur()
	{
		return this.controleur;
	}

	private VueCollection()
	{
		super("collection.fxml");
		super.controleur = this.controleur = new ControleurCollection();
		Logger.logMsg(Logger.INFO, "new VueCollection()");
	}

	public void activerControles()
	{
		super.activerControles();

		Button actionAjouterOeuvre = (Button) lookup("#actionAjouterOeuvre");

		actionAjouterOeuvre.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent e)
			{
				controleur.notifierClicAjouterOeuvre();
			}

		} );

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
		System.out.println("vueCollection.afficherOeuvre()");
		System.out.println(list);
		VBox vueOeuvres = (VBox)lookup("#affichageCollection");
		//vueOeuvres.getChildren().clear();
		Button action;


		for(Oeuvre oeuvre:list)
		{
			action = new Button("Éditer");
			//action.setId(collection.getId() + "");
			action.setOnAction(new EventHandler<ActionEvent>()
			{
				public void handle(ActionEvent e)
				{
					Button source = (Button)e.getSource();
					System.out.println(" id de l'oeuvre : " + source.getId());
					Logger.logMsg(Logger.INFO, "Clic sur le oeuvre " + source.getId());
					//controleur.notifierClicEditerOeuvre(Integer.parseInt(source.getId()));
				}
			});


			Logger.logMsg(Logger.INFO, "oeuvre " + oeuvre.getNom());
			HBox vueOeuvre = new HBox();
			vueOeuvre.getStyleClass().add("oeuvre");
			vueOeuvre.getChildren().add(new Label(oeuvre.getNom()));
			vueOeuvre.getChildren().add(action);
			vueOeuvres.getChildren().add(vueOeuvre);

		}

		System.out.println("apres la boucle for Oeuvre oeuvre:list");

	}
}
