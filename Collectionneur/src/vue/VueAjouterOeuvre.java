package vue;

import com.sun.media.jfxmedia.logging.Logger;

import controleur.ControleurCollection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Oeuvre;

public class VueAjouterOeuvre extends Vue
{
	protected ControleurCollection controleur;

	protected static VueAjouterOeuvre instance;
	public static VueAjouterOeuvre getInstance()
	{
		if(null == instance)
			instance = new VueAjouterOeuvre();
		return instance;
	}

	public VueAjouterOeuvre()
	{
		super("ajouter-oeuvre.fxml");
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
						controleur.notifierClicEnregistrerAjoutOeuvre();
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



}
