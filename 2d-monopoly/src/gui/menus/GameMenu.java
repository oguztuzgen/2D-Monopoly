package gui.menus;

import gui.menus.controller.GameMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import management.GameManager;


public class GameMenu {
	public void display(Stage context, String name0,
						String name1, boolean isBot1,
						String name2, boolean isBot2,
						String name3, boolean isBot3) throws Exception {
		FXMLLoader loader
				= new FXMLLoader(getClass().getResource("../../GameMenu.fxml"));
		Parent root = loader.load();
		GameMenuController gameMenuController = loader.getController();
		gameMenuController.setStage(context);
		GameManager gameManager = GameManager
				.getInstance(name0, name1, isBot1, name2, isBot2, name3, isBot3);
		context.setScene(new Scene(root, 1280, 720));
		context.show();
	}
}