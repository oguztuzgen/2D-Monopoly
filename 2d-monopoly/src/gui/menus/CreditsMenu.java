package gui.menus;

import gui.misc.FPSCounter;
import gui.misc.Style;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreditsMenu {
	public void display(Stage context) {
		Button button_return = new Button("Go back");
		button_return.setStyle(Style.button_one);
		button_return.setOnAction( e -> {
			new MainMenu().display(context);
		});

		Text title = new Text("Contributors");
		title.setStyle(Style.text_two + "-fx-font-family: Forte;");
		title.setFill(new Color(1,0,0,1));

		Text name1 = new Text("Oğuz Orhun Tüzgen");
		name1.setStyle(Style.text_two);
		name1.setFill(Color.rgb(255,255,255));

		Text name2 = new Text("Ufuk Palpas");
		name2.setStyle(Style.text_two);
		name2.setFill(Color.rgb(255,255,255));

		Text name3 = new Text("Uğur Utku Seyfeli");
		name3.setStyle(Style.text_two);
		name3.setFill(Color.rgb(255,255,255));

		Text name4 = new Text("Yiğit Harun");
		name4.setStyle(Style.text_two);
		name4.setFill(Color.rgb(255,255,255));

		Text name5 = new Text("Asya Doğa Özer");
		name5.setStyle(Style.text_two);
		name5.setFill(Color.rgb(255,255,255));

		VBox layout_credits = new VBox(20);
		layout_credits.setBackground(new Background(new BackgroundFill(new Color(0,0,0,1), null, null)));
		layout_credits.setAlignment(Pos.CENTER);
		layout_credits.getChildren().addAll(
				title, name1, name2, name3, name4, name5, button_return
		);

		BorderPane layout = new BorderPane(layout_credits);

		Scene scene_credits = new Scene(layout, 1280, 720);

		HBox layout_FPS = new HBox(0);
		layout_FPS.setAlignment(Pos.TOP_RIGHT);
		layout_FPS.getChildren().add(new FPSCounter().display(scene_credits));

		layout.setTop(layout_FPS);
		context.setScene(scene_credits);
	}
}