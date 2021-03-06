import gui.menus.MainMenu;
import gui.popups.ClosePopup;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	// Constants

	// State variables
	Stage window;

	// Components

	public static void main( String[] args ) {
		// write your code here
		launch(args);
	}

	@Override
	public void start( Stage primaryStage ) throws Exception {

		primaryStage.setTitle( "Monopoly Sicilia" );
		primaryStage.getIcons().add(new Image("file:src/vendor/image/logo.png"));
		window = primaryStage;
		window.setResizable(false);
		new MainMenu().display(window);
		window.setOnCloseRequest( e -> {
			e.consume();
			closeProgram();
		} );
		window.show();
	}

	private void closeProgram() {
		new ClosePopup().display(window);
	}
}