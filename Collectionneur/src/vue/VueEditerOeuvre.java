package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurCollection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Oeuvre;

public class VueEditerOeuvre extends Vue
{
	protected ControleurCollection controleur;

	protected static VueEditerOeuvre instance;
	public static VueEditerOeuvre getInstance()
	{
		if(null == instance)
			instance = new VueEditerOeuvre();
		return instance;
	}

	public VueEditerOeuvre()
	{
		super("editer-oeuvre.fxml");
	}

	public void activerControles()
	{
		super.activerControles();

		Button actionEnregistrer = (Button) lookup("#actionEnregistrer");

		actionEnregistrer.setOnAction(new EventHandler<ActionEvent>()
				{
					public void handle(ActionEvent arg0)
					{
						Logger.logMsg(Logger.INFO, "clic sur enregistrer Oeuvre");
						controleur.notifierClicEnregistrerEditerOeuvre();
					}
				});



	}

	public Oeuvre lireOeuvre()
	{
		Oeuvre oeuvre = new Oeuvre();
		TextField champNom = (TextField)lookup("#nomOeuvre");
		oeuvre.setNom(champNom.getText());
		TextField champDescription = (TextField) lookup("#descriptionOeuvre");
		oeuvre.setDescription(champDescription.getText());
		return oeuvre;
	}

	public void afficherOeuvre(Oeuvre oeuvre)
	{
		TextField champNom = (TextField)lookup("#nomOeuvre");
		champNom.setText(oeuvre.getNom());
		/*TextField champOeuvre = (TextField)lookup("descriptionOeuvre");
		champOeuvre.setText(oeuvre.getDescription());*/
	}



}
