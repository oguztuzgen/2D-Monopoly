package gui.menus.controller;

import entity.Bank;
import entity.Forex;
import entity.Trade;
import entity.card.Card;
import entity.card.CardDeck;
import entity.card.MovementByNumCardStrategy;
import entity.card.MovementToCardStrategy;
import entity.map.tile.*;
import entity.player.BotCharacter;
import entity.player.Player;
import entity.powerup.PowerUp;
import gui.menus.MainMenu;
import gui.misc.Style;
import gui.popups.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import management.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GameMenuController {
	private static GameMenuController instance;
	private DecimalFormat df = new DecimalFormat("####.##");

	public static GameMenuController getInstance() {
		if (instance == null)
			instance = new GameMenuController();
		return instance;
	}

	public static void deleteInstance() {
		instance = null;
	}

	@FXML
	private AnchorPane listItems = new AnchorPane();
	@FXML
	private Label currentPlayerName = new Label();
	@FXML
	private Label showDollarAmount = new Label();
	@FXML
	private Label showEuroAmount = new Label();
	@FXML
	private Label showFrancAmount = new Label();
	@FXML
	private Label infoPlayer1Name = new Label();
	@FXML
	private Text infoPlayer1Money = new Text();
	@FXML
	private Label infoPlayer2Name = new Label();
	@FXML
	private Text infoPlayer2Money = new Text();
	@FXML
	private Label infoPlayer3Name = new Label();
	@FXML
	private Text infoPlayer3Money = new Text();
	@FXML
	private Label infoPlayer4Name = new Label();
	@FXML
	private Text infoPlayer4Money = new Text();
	@FXML
	private Label textForexDollar = new Label();
	@FXML
	private Button buttonDollarBuy = new Button();
	@FXML
	private Button buttonDollarSell = new Button();
	@FXML
	private Label textForexEuro = new Label();
	@FXML
	private Button buttonEuroBuy = new Button();
	@FXML
	private Button buttonEuroSell = new Button();
	@FXML
	private Label textForexFrank = new Label();
	@FXML
	private Button buttonFrancBuy = new Button();
	@FXML
	private Button buttonFrancSell = new Button();
	@FXML
	private TextField textFieldDollar = new TextField();
	@FXML
	private TextField textFieldEuro = new TextField();
	@FXML
	private TextField textFieldFranc = new TextField();
	@FXML
	private Button buttonTile39 = new Button();
	@FXML
	private Button buttonTile38 = new Button();
	@FXML
	private Button buttonTile37 = new Button();
	@FXML
	private Button buttonTile36 = new Button();
	@FXML
	private Button buttonTile35 = new Button();
	@FXML
	private Button buttonTile34 = new Button();
	@FXML
	private Button buttonTile33 = new Button();
	@FXML
	private Button buttonTile32 = new Button();
	@FXML
	private Button buttonTile31 = new Button();
	@FXML
	private Button buttonTile30 = new Button();
	@FXML
	private Button buttonTile29 = new Button();
	@FXML
	private Button buttonTile28 = new Button();
	@FXML
	private Button buttonTile27 = new Button();
	@FXML
	private Button buttonTile26 = new Button();
	@FXML
	private Button buttonTile25 = new Button();
	@FXML
	private Button buttonTile24 = new Button();
	@FXML
	private Button buttonTile23 = new Button();
	@FXML
	private Button buttonTile22 = new Button();
	@FXML
	private Button buttonTile21 = new Button();
	@FXML
	private Button buttonTile20 = new Button();
	@FXML
	private Button buttonTile19 = new Button();
	@FXML
	private Button buttonTile18 = new Button();
	@FXML
	private Button buttonTile17 = new Button();
	@FXML
	private Button buttonTile16 = new Button();
	@FXML
	private Button buttonTile15 = new Button();
	@FXML
	private Button buttonTile14 = new Button();
	@FXML
	private Button buttonTile13 = new Button();
	@FXML
	private Button buttonTile12 = new Button();
	@FXML
	private Button buttonTile11 = new Button();
	@FXML
	private Button buttonTile10 = new Button();
	@FXML
	private Button buttonTile9 = new Button();
	@FXML
	private Button buttonTile8 = new Button();
	@FXML
	private Button buttonTile7 = new Button();
	@FXML
	private Button buttonTile6 = new Button();
	@FXML
	private Button buttonTile5 = new Button();
	@FXML
	private Button buttonTile4 = new Button();
	@FXML
	private Button buttonTile3 = new Button();
	@FXML
	private Button buttonTile2 = new Button();
	@FXML
	private Button buttonTile1 = new Button();
	@FXML
	private Button buttonTile0 = new Button();
	@FXML
	private Button buttonPowerUpCrate = new Button();
	@FXML
	private ImageView iconPlayer1; // = new ImageView(new Image("file:src/vendor/image/diamond-green.png"));
	@FXML
	private ImageView iconMafia; // = new ImageView(new Image("file:src/vendor/image/mafia-face.png"));
	@FXML
	private ImageView iconPlayer3; // = new ImageView(new Image("file:src/vendor/image/diamond-pink.png"));
	@FXML
	private ImageView iconPolice; // = new ImageView(new Image("file:src/vendor/image/police-logo.png"));
	@FXML
	private ImageView iconPlayer2; // = new ImageView(new Image("file:src/vendor/image/diamond-red.png"));
	@FXML
	private ImageView iconPlayer4; // = new ImageView(new Image("file:src/vendor/image/diamond-blue.png"));
	@FXML
	private Button buttonPlayer1;
	@FXML
	private Button buttonPlayer2;
	@FXML
	private Button buttonPlayer3;
	@FXML
	private Button buttonPlayer4;
	@FXML
	private ImageView turnIndicator1;
	@FXML
	private ImageView turnIndicator2;
	@FXML
	private ImageView turnIndicator3;
	@FXML
	private ImageView turnIndicator4;
	@FXML
	private VBox root;// = new VBox();
	@FXML
	private Button endTurnButton = new Button();
	@FXML
	private Button rollRice = new Button();
	@FXML
	private Label roundCounter = new Label();
	@FXML
	private Label diceLabel = new Label();
	@FXML
	private Text tileNameText0;

	@FXML
	private Text tilePriceText0;

	@FXML
	private Text tileNameText1;

	@FXML
	private Text tilePriceText1;

	@FXML
	private Text tileNameText2;

	@FXML
	private Text tilePriceText2;

	@FXML
	private Text tileNameText3;

	@FXML
	private Text tilePriceText3;

	@FXML
	private Text tileNameText4;

	@FXML
	private Text tilePriceText4;

	@FXML
	private Text tileNameText5;

	@FXML
	private Text tilePriceText5;

	@FXML
	private Text tileNameText6;

	@FXML
	private Text tilePriceText6;

	@FXML
	private Text tileNameText7;

	@FXML
	private Text tilePriceText7;

	@FXML
	private Text tileNameText8;

	@FXML
	private Text tilePriceText8;

	@FXML
	private Text tileNameText9;

	@FXML
	private Text tilePriceText9;

	@FXML
	private Text tileNameText10;

	@FXML
	private Text tilePriceText10;

	@FXML
	private Text tileNameText11;

	@FXML
	private Text tilePriceText11;

	@FXML
	private Text tileNameText12;

	@FXML
	private Text tilePriceText12;

	@FXML
	private Text tileNameText13;

	@FXML
	private Text tilePriceText13;

	@FXML
	private Text tileNameText14;

	@FXML
	private Text tilePriceText14;

	@FXML
	private Text tileNameText15;

	@FXML
	private Text tilePriceText15;

	@FXML
	private Text tileNameText16;

	@FXML
	private Text tilePriceText16;

	@FXML
	private Text tileNameText17;

	@FXML
	private Text tilePriceText17;

	@FXML
	private Text tileNameText18;

	@FXML
	private Text tilePriceText18;

	@FXML
	private Text tileNameText19;

	@FXML
	private Text tilePriceText19;

	@FXML
	private Text tileNameText20;

	@FXML
	private Text tilePriceText20;

	@FXML
	private Text tileNameText21;

	@FXML
	private Text tilePriceText21;

	@FXML
	private ImageView t1h1icon;

	@FXML
	private ImageView t1h2icon;

	@FXML
	private ImageView t1h3icon;

	@FXML
	private ImageView t1h4icon;

	@FXML
	private ImageView t2h1icon;

	@FXML
	private ImageView t2h2icon;

	@FXML
	private ImageView t2h3icon;

	@FXML
	private ImageView t2h4icon;

	@FXML
	private ImageView t3h1icon;

	@FXML
	private ImageView t3h2icon;

	@FXML
	private ImageView t3h3icon;

	@FXML
	private ImageView t3h4icon;

	@FXML
	private ImageView t4h1icon;

	@FXML
	private ImageView t4h2icon;

	@FXML
	private ImageView t4h3icon;

	@FXML
	private ImageView t4h4icon;

	@FXML
	private ImageView t5h1icon;

	@FXML
	private ImageView t5h2icon;

	@FXML
	private ImageView t5h3icon;

	@FXML
	private ImageView t5h4icon;

	@FXML
	private ImageView t6h1icon;

	@FXML
	private ImageView t6h2icon;

	@FXML
	private ImageView t6h3icon;

	@FXML
	private ImageView t6h4icon;

	@FXML
	private ImageView t7h1icon;

	@FXML
	private ImageView t7h2icon;

	@FXML
	private ImageView t7h3icon;

	@FXML
	private ImageView t7h4icon;

	@FXML
	private ImageView t8h1icon;

	@FXML
	private ImageView t8h2icon;

	@FXML
	private ImageView t8h3icon;

	@FXML
	private ImageView t8h4icon;

	@FXML
	private ImageView t9h1icon;

	@FXML
	private ImageView t9h2icon;

	@FXML
	private ImageView t9h3icon;

	@FXML
	private ImageView t9h4icon;

	@FXML
	private ImageView t10h1icon;

	@FXML
	private ImageView t10h2icon;

	@FXML
	private ImageView t10h3icon;

	@FXML
	private ImageView t10h4icon;

	@FXML
	private ImageView t11h1icon;

	@FXML
	private ImageView t11h2icon;

	@FXML
	private ImageView t11h3icon;

	@FXML
	private ImageView t11h4icon;

	@FXML
	private ImageView t12h1icon;

	@FXML
	private ImageView t12h2icon;

	@FXML
	private ImageView t12h3icon;

	@FXML
	private ImageView t12h4icon;

	@FXML
	private ImageView t13h1icon;

	@FXML
	private ImageView t13h2icon;

	@FXML
	private ImageView t13h3icon;

	@FXML
	private ImageView t13h4icon;

	@FXML
	private ImageView t14h1icon;

	@FXML
	private ImageView t14h2icon;

	@FXML
	private ImageView t14h3icon;

	@FXML
	private ImageView t14h4icon;

	@FXML
	private ImageView t15h1icon;

	@FXML
	private ImageView t15h2icon;

	@FXML
	private ImageView t15h3icon;

	@FXML
	private ImageView t15h4icon;

	@FXML
	private ImageView t16h1icon;

	@FXML
	private ImageView t16h2icon;

	@FXML
	private ImageView t16h3icon;

	@FXML
	private ImageView t16h4icon;

	@FXML
	private ImageView t17h1icon;

	@FXML
	private ImageView t17h2icon;

	@FXML
	private ImageView t17h3icon;

	@FXML
	private ImageView t17h4icon;

	@FXML
	private ImageView t18h1icon;

	@FXML
	private ImageView t18h2icon;

	@FXML
	private ImageView t18h3icon;

	@FXML
	private ImageView t18h4icon;

	@FXML
	private ImageView t19h1icon;

	@FXML
	private ImageView t19h2icon;

	@FXML
	private ImageView t19h3icon;

	@FXML
	private ImageView t19h4icon;

	@FXML
	private ImageView t20h1icon;

	@FXML
	private ImageView t20h2icon;

	@FXML
	private ImageView t20h3icon;

	@FXML
	private ImageView t20h4icon;

	@FXML
	private ImageView t21h1icon;

	@FXML
	private ImageView t21h2icon;

	@FXML
	private ImageView t21h3icon;

	@FXML
	private ImageView t21h4icon;

	@FXML
	private ImageView t22h1icon;

	@FXML
	private ImageView t22h2icon;

	@FXML
	private ImageView t22h3icon;

	@FXML
	private ImageView t22h4icon;

	@FXML private ImageView boardImage;


	int[] player;

	private Stage context;
	private ImageView[][] tileInfo;
	private Button[] buttons;
	private Text[] tileNameTexts, tilePriceTexts;
	private ImageView[] icons;
	private final int[][] offsets = new int[][]{
			{22, 17}, {32, 17},
			{22, 27}, {32, 27},
			{22, 37}, {32, 37},
	};
	int bankruptedPLayerCount;

	SoundManager sm = new SoundManager(false);

	@FXML
	public void initialize() {
		bankruptedPLayerCount = 0;
		checkIfFinished();
		updateAllIconPlayers();
		setupPlayersBar();
		setupAccountGUI();

		/*buttonTile0.setOnAction(e -> showTileActions(0));
		buttonTile1.setOnAction(e -> showTileActions(1));
		buttonTile2.setOnAction(e -> showTileActions(2));
		buttonTile3.setOnAction(e -> showTileActions(3));
		buttonTile4.setOnAction(e -> showTileActions(4));
		buttonTile5.setOnAction(e -> showTileActions(5));
		buttonTile6.setOnAction(e -> showTileActions(6));
		buttonTile7.setOnAction(e -> showTileActions(7));
		buttonTile8.setOnAction(e -> showTileActions(8));
		buttonTile9.setOnAction(e -> showTileActions(9));
		buttonTile10.setOnAction(e -> showTileActions(10));
		buttonTile11.setOnAction(e -> showTileActions(11));
		buttonTile12.setOnAction(e -> showTileActions(12));
		buttonTile13.setOnAction(e -> showTileActions(13));
		buttonTile14.setOnAction(e -> showTileActions(14));
		buttonTile15.setOnAction(e -> showTileActions(15));
		buttonTile16.setOnAction(e -> showTileActions(16));
		buttonTile17.setOnAction(e -> showTileActions(17));
		buttonTile18.setOnAction(e -> showTileActions(18));
		buttonTile19.setOnAction(e -> showTileActions(19));
		buttonTile20.setOnAction(e -> showTileActions(20));
		buttonTile21.setOnAction(e -> showTileActions(21));
		buttonTile22.setOnAction(e -> showTileActions(22));
		buttonTile23.setOnAction(e -> showTileActions(23));
		buttonTile24.setOnAction(e -> showTileActions(24));
		buttonTile25.setOnAction(e -> showTileActions(25));
		buttonTile26.setOnAction(e -> showTileActions(26));
		buttonTile27.setOnAction(e -> showTileActions(27));
		buttonTile28.setOnAction(e -> showTileActions(28));
		buttonTile29.setOnAction(e -> showTileActions(29));
		buttonTile30.setOnAction(e -> showTileActions(30));
		buttonTile31.setOnAction(e -> showTileActions(31));
		buttonTile32.setOnAction(e -> showTileActions(32));
		buttonTile33.setOnAction(e -> showTileActions(33));
		buttonTile34.setOnAction(e -> showTileActions(34));
		buttonTile35.setOnAction(e -> showTileActions(35));
		buttonTile36.setOnAction(e -> showTileActions(36));
		buttonTile37.setOnAction(e -> showTileActions(37));
		buttonTile38.setOnAction(e -> showTileActions(38));
		buttonTile39.setOnAction(e -> showTileActions(39)); */

		setupBoardGUI();
		update();
		endTurnButton.setDisable(true);
	}

	private void setupBoardGUI() {
		buttons = new Button[]{
				buttonTile0, buttonTile1, buttonTile2, buttonTile3, buttonTile4,
				buttonTile5, buttonTile6, buttonTile7, buttonTile8, buttonTile9,
				buttonTile10, buttonTile11, buttonTile12, buttonTile13, buttonTile14,
				buttonTile15, buttonTile16, buttonTile17, buttonTile18, buttonTile19,
				buttonTile20, buttonTile21, buttonTile22, buttonTile23, buttonTile24,
				buttonTile25, buttonTile26, buttonTile27, buttonTile28, buttonTile29,
				buttonTile30, buttonTile31, buttonTile32, buttonTile33, buttonTile34,
				buttonTile35, buttonTile36, buttonTile37, buttonTile38, buttonTile39
		};

		tileNameTexts = new Text[] {
				tileNameText0, tileNameText1, tileNameText2, tileNameText3, tileNameText4,
				tileNameText5, tileNameText6, tileNameText7, tileNameText8, tileNameText9,
				tileNameText10, tileNameText11, tileNameText12, tileNameText13, tileNameText14,
				tileNameText15, tileNameText16, tileNameText17, tileNameText18, tileNameText19,
				tileNameText20, tileNameText21
		};

		tilePriceTexts = new Text[] {
				tilePriceText0, tilePriceText1, tilePriceText2, tilePriceText3, tilePriceText4,
				tilePriceText5, tilePriceText6, tilePriceText7, tilePriceText8, tilePriceText9,
				tilePriceText10, tilePriceText11, tilePriceText12, tilePriceText13, tilePriceText14,
				tilePriceText15, tilePriceText16, tilePriceText17, tilePriceText18, tilePriceText19,
				tilePriceText20, tilePriceText21
		};

		boardImage.setImage(new Image(MainMenu.colorblindMode ? "file:src/vendor/image/colorblind_board.png" : "file:src/vendor/image/board.png"));
		initializeTileInfo();

		icons = new ImageView[]{
				iconPlayer1, iconPlayer2, iconPlayer3, iconPlayer4, iconMafia, iconPolice
		};
	}

	private void setupPlayersBar() {
		infoPlayer1Name.setText(GameManager.getInstance().getPlayerAt(0).getName());
		infoPlayer2Name.setText(GameManager.getInstance().getPlayerAt(1).getName());
		infoPlayer3Name.setText(GameManager.getInstance().getPlayerAt(2).getName());
		infoPlayer4Name.setText(GameManager.getInstance().getPlayerAt(3).getName());
		infoPlayer1Money.setText(df.format(GameManager.getInstance().getPlayerAt(0).getAccount().getTrl()) + "₺");
		infoPlayer2Money.setText(df.format(GameManager.getInstance().getPlayerAt(1).getAccount().getTrl()) + "₺");
		infoPlayer3Money.setText(df.format(GameManager.getInstance().getPlayerAt(2).getAccount().getTrl()) + "₺");
		infoPlayer4Money.setText(df.format(GameManager.getInstance().getPlayerAt(3).getAccount().getTrl()) + "₺");
		buttonPlayer1.setOnAction(this::showTradeActions);
		buttonPlayer2.setOnAction(this::showTradeActions);
		buttonPlayer3.setOnAction(this::showTradeActions);
		buttonPlayer4.setOnAction(this::showTradeActions);
		endTurnButton.setOnAction(this::endButton);
		rollRice.setOnAction(this::roll);
	}

	private void setupAccountGUI() {
		currentPlayerName.setText(GameManager.getInstance().getTurnOfPlayer().getName());
		exRateTextUpdate();

		buttonDollarBuy.setOnAction(buttonDollarBuy());
		buttonEuroBuy.setOnAction(buttonEuroBuy());
		buttonFrancBuy.setOnAction(buttonFrancBuy());

		buttonDollarSell.setOnAction(buttonDollarSell());
		buttonEuroSell.setOnAction(buttonEuroSell());
		buttonFrancSell.setOnAction(buttonFrancSell());
	}

	private void showTradeActions(ActionEvent e) {
		int playerNo = GameManager.getInstance().getTurnOfPlayerIndex();

		sm.music(5);
		if (e.getSource() == buttonPlayer1) {
			if (playerNo != 0)
				new TradePopup(0).display(context);
		} else if (e.getSource() == buttonPlayer2) {
			if (playerNo != 1)
				new TradePopup(1).display(context);
		} else if (e.getSource() == buttonPlayer3) {
			if (playerNo != 2)
				new TradePopup(2).display(context);
		} else if (e.getSource() == buttonPlayer4) {
			if (playerNo != 3)
				new TradePopup(3).display(context);
		}
		update();
	}

	private void showTileActions(int tileNo) {
		if (Map.getInstance().getTileAt(tileNo).getClass() == CityTile.class) {
			if (!((BuyableTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				new TilePopup().display("City Tile", (BuyableTile) Map.getInstance().getTileAt(tileNo));
			}
			if (((BuyableTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				if (((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner() != GameManager.getInstance().getTurnOfPlayer()) {
						Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
						Bank.getInstance().takeWithResign(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
					Bank.getInstance().giveMoney(((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
				}
			}
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == CardTile.class) {
			if (((CardTile) (Map.getInstance().getTileAt(tileNo))).getIsChance()) {
				Card card = GameManager.getInstance().getChangedeck().drawCard(GameManager.getInstance().getTurnOfPlayer());
				new CardPopup().display("Card Tile", card);
				if (card.getCardStrategy().getClass() == MovementByNumCardStrategy.class || card.getCardStrategy().getClass() == MovementToCardStrategy.class) {
					updateAllLocations();
					showTileActions(GameManager.getInstance().getTurnOfPlayer().getLocation());
				}
			} else {
				Card card = GameManager.getInstance().getChangedeck().drawCard(GameManager.getInstance().getTurnOfPlayer());
				new CardPopup().display("Card Tile", card);
				if (card.getCardStrategy().getClass() == MovementByNumCardStrategy.class || card.getCardStrategy().getClass() == MovementToCardStrategy.class) {
					updateAllLocations();
					showTileActions(GameManager.getInstance().getTurnOfPlayer().getLocation());
				}
			}
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == CompanyTile.class) {
			if (!((CompanyTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				new TilePopup().display("Company Tile", (BuyableTile) Map.getInstance().getTileAt(tileNo));
			}
			if (((CompanyTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				if (((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner() != GameManager.getInstance().getTurnOfPlayer()) {
						Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
						Bank.getInstance().takeWithResign(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
					Bank.getInstance().giveMoney(((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
				}
			}
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == DoNothingTile.class) {
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == StartTile.class) {
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == TaxTile.class) {
			new TaxPopup().display("Tax Tile", (TaxTile) Map.getInstance().getTileAt(tileNo), tileNo != Map.LUXURYNO);
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == JailTile.class) {
			GameManager.getInstance().gotoJail();
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == TransportationTile.class) {
			if (!((TransportationTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				new TilePopup().display("Transportation Tile", (BuyableTile) Map.getInstance().getTileAt(tileNo));
			}
			if (((TransportationTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				if (((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner() != GameManager.getInstance().getTurnOfPlayer()) {
//
					Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
//					if(Bank.getInstance().getAllMoneyAmount(GameManager.getInstance().getTurnOfPlayer()) < ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount()){
//						System.out.println("lütfen gir");
//						GameManager.getInstance().resign(GameManager.getInstance().getTurnOfPlayer());
//					} else{
					Bank.getInstance().takeWithResign(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
					Bank.getInstance().giveMoney(((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
				}
			}
		}
		update();

	}

	public void mafiaTileActions(int tileNo) {
		if (Map.getInstance().getTileAt(tileNo).getClass() == CityTile.class) {
			if(((CityTile)(Map.getInstance().getTileAt(tileNo))).getHotelCount() > 0){
				Map.getInstance().hotelRekt(GameManager.getInstance().getMafia().getLocation());
			}
		}
	}

	private void doTileActions(int tileNo) {
		if (Map.getInstance().getTileAt(tileNo).getClass() == CityTile.class) {
			if (!((BuyableTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				GameManager.getInstance().mapBuyTile(GameManager.getInstance().getTurnOfPlayer(),((BuyableTile) Map.getInstance().getTileAt(tileNo)).getId(), false);
				Map.getInstance().buildHouse(GameManager.getInstance().getTurnOfPlayer(),((BuyableTile) Map.getInstance().getTileAt(tileNo)).getId());
				Map.getInstance().buildHotel(GameManager.getInstance().getTurnOfPlayer(),((BuyableTile) Map.getInstance().getTileAt(tileNo)).getId());
			}
			if (((BuyableTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				if (((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner() != GameManager.getInstance().getTurnOfPlayer()) {
					//if(Bank.getInstance().getAllMoneyAmount(GameManager.getInstance().getTurnOfPlayer()) < ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount()){
					//GameManager.getInstance().resign(GameManager.getInstance().getTurnOfPlayer());
					//} else{
					Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
					//}
					Bank.getInstance().giveMoney(((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
				}
			}
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == CardTile.class) { // ileri geri hareketlerde sıkıntı oluyor
			System.out.print("CARD POP UP");
			if (((CardTile) (Map.getInstance().getTileAt(tileNo))).getIsChance() == true) {
				Card card = GameManager.getInstance().getChangedeck().drawCard(GameManager.getInstance().getTurnOfPlayer());
				if (card.getCardStrategy().getClass() == MovementByNumCardStrategy.class || card.getCardStrategy().getClass() == MovementToCardStrategy.class) {
					updateAllLocations();
					showTileActions(GameManager.getInstance().getTurnOfPlayer().getLocation());
				}
			} else {
				Card card = GameManager.getInstance().getChangedeck().drawCard(GameManager.getInstance().getTurnOfPlayer());
				if (card.getCardStrategy().getClass() == MovementByNumCardStrategy.class || card.getCardStrategy().getClass() == MovementToCardStrategy.class) {
					updateAllLocations();
					showTileActions(GameManager.getInstance().getTurnOfPlayer().getLocation());
				}
			}
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == CompanyTile.class) {
			if (!((CompanyTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				GameManager.getInstance().mapBuyTile(GameManager.getInstance().getTurnOfPlayer(),((BuyableTile) Map.getInstance().getTileAt(tileNo)).getId(), false);
			}
			if (((CompanyTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				if (((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner() != GameManager.getInstance().getTurnOfPlayer()) {
					if (Bank.getInstance().getAllMoneyAmount(GameManager.getInstance().getTurnOfPlayer()) < ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount()) {
						//GameManager.getInstance().resign(GameManager.getInstance().getTurnOfPlayer());
						//} else {
						Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());

						Bank.getInstance().giveMoney(((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
					}
				}
			}
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == DoNothingTile.class) {
			// do nothing OwO
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == StartTile.class) {
			// unused might be deleted, handled in another place
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == TaxTile.class) {
			Bank.getInstance().takeMoney(GameManager.getInstance().getTurnOfPlayer(), ((TaxTile)Map.getInstance().getTileAt(tileNo)).getAmount());
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == JailTile.class) {
			GameManager.getInstance().gotoJail();
		} else if (Map.getInstance().getTileAt(tileNo).getClass() == TransportationTile.class) {
			if (!((TransportationTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				GameManager.getInstance().mapBuyTile(GameManager.getInstance().getTurnOfPlayer(),((BuyableTile) Map.getInstance().getTileAt(tileNo)).getId(), false);
			}
			if (((TransportationTile) Map.getInstance().getTileAt(tileNo)).isOwned()) {
				if (((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner() != GameManager.getInstance().getTurnOfPlayer()) {
					if (Bank.getInstance().getAllMoneyAmount(GameManager.getInstance().getTurnOfPlayer()) < ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount()) {
						//GameManager.getInstance().resign(GameManager.getInstance().getTurnOfPlayer());
						//} else{
						Bank.getInstance().takeWithResign(GameManager.getInstance().getTurnOfPlayer(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
						//}
						Bank.getInstance().giveMoney(((BuyableTile) Map.getInstance().getTileAt(tileNo)).getOwner(), ((BuyableTile) Map.getInstance().getTileAt(tileNo)).getRentAmount());
					}
				}
			}
		}
		update();
	}


	private EventHandler<ActionEvent> buttonDollarBuy() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().buyForexDollar(
					Double.parseDouble(textFieldDollar.getText()) >= 0 ? Double.parseDouble(textFieldDollar.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonDollarSell() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().sellForexDollar(
					Double.parseDouble(textFieldDollar.getText()) >= 0 ? Double.parseDouble(textFieldDollar.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonEuroBuy() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().buyForexEuro(
					Double.parseDouble(textFieldEuro.getText()) >= 0 ? Double.parseDouble(textFieldEuro.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonEuroSell() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().sellForexEuro(
					Double.parseDouble(textFieldEuro.getText()) >= 0 ? Double.parseDouble(textFieldEuro.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonFrancBuy() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().buyForexFranc(
					Double.parseDouble(textFieldFranc.getText()) >= 0 ? Double.parseDouble(textFieldFranc.getText()) : 0);
			update();
		};
	}

	private EventHandler<ActionEvent> buttonFrancSell() {
		return e -> {
			sm.music(3);
			GameManager.getInstance().sellForexFranc(
					Double.parseDouble(textFieldFranc.getText()) >= 0 ? Double.parseDouble(textFieldFranc.getText()) : 0);
			update();
		};
	}

	private void endButton(ActionEvent e) {
		endButtonMethod();
		updateTileInfo();
		endTurnButton.setDisable(true);
		checkIfFinished();
	}
	private void endButtonMethod(){
//		updateAllLocations();
		ForexManager.getInstance().calcSupDemand();

		// forex update in the gui
		textForexDollar.setText(df.format(GameManager.getInstance().getForexDollar()));
		textForexEuro.setText(df.format(GameManager.getInstance().getForexEuro()));
		textForexFrank.setText(df.format(GameManager.getInstance().getForexFrank()));

		GameManager.getInstance().increaseTurn();

		int turnOf = GameManager.getInstance().getTurnOfPlayerIndex();

		if(turnOf == 4 && GameManager.getInstance().getPlayerAt(GameManager.getInstance().getTurnOrder()[0]).getIsBankrupt()){
			GameManager.getInstance().playTurn();
			GameManager.getInstance().playTurn();
			turnOf = GameManager.getInstance().getTurnOfPlayerIndex();
		}
		if(turnOf < 4){
			while(GameManager.getInstance().getTurnOfPlayer().getIsBankrupt()){
				GameManager.getInstance().increaseTurn();
				turnOf = GameManager.getInstance().getTurnOfPlayerIndex();
			}
		}

		while (turnOf > 3) {
			GameManager.getInstance().playTurn();
			turnOf = GameManager.getInstance().getTurnOfPlayerIndex();
		}


		if (!GameManager.getInstance().getTurnOfPlayer().getTrades().isEmpty()) {
			new ShowTradesPopup().display(context);
			update();
			endTurnButton.setDisable(true);
		}


		updateAllLocations();
		diamondUpdate(turnOf);
		rollRice.setDisable(false);

		updatePlayerLabels();
		getItems();
		roundCounter.setText("Round " + GameManager.getInstance().getRoundNo());
		try {
			FileManager.saveGame();
		} catch (Exception exception) {
			System.out.println(exception.toString());
		}
	}

	private void initializeTileInfo() {
		tileInfo = new ImageView[][] {
				{t1h1icon, t1h2icon, t1h3icon, t1h4icon},
				{t2h1icon, t2h2icon, t2h3icon, t2h4icon},
				{t3h1icon, t3h2icon, t3h3icon, t3h4icon},
				{t4h1icon, t4h2icon, t4h3icon, t4h4icon},
				{t5h1icon, t5h2icon, t5h3icon, t5h4icon},
				{t6h1icon, t6h2icon, t6h3icon, t6h4icon},
				{t7h1icon, t7h2icon, t7h3icon, t7h4icon},
				{t8h1icon, t8h2icon, t8h3icon, t8h4icon},
				{t9h1icon, t9h2icon, t9h3icon, t9h4icon},
				{t10h1icon, t10h2icon, t10h3icon, t10h4icon},
				{t11h1icon, t11h2icon, t11h3icon, t11h4icon},
				{t12h1icon, t12h2icon, t12h3icon, t12h4icon},
				{t13h1icon, t13h2icon, t13h3icon, t13h4icon},
				{t14h1icon, t14h2icon, t14h3icon, t14h4icon},
				{t15h1icon, t15h2icon, t15h3icon, t15h4icon},
				{t16h1icon, t16h2icon, t16h3icon, t16h4icon},
				{t17h1icon, t17h2icon, t17h3icon, t17h4icon},
				{t18h1icon, t18h2icon, t18h3icon, t18h4icon},
				{t19h1icon, t19h2icon, t19h3icon, t19h4icon},
				{t20h1icon, t20h2icon, t20h3icon, t20h4icon},
				{t21h1icon, t21h2icon, t21h3icon, t21h4icon},
				{t22h1icon, t22h2icon, t22h3icon, t22h4icon}
		};

		int indexCity = 0;
		for (int i = 0; i < Map.TILE_COUNT; i++) {
			if (Map.getInstance().getTileAt(i).getClass() == CityTile.class) {
				tileNameTexts[indexCity].setStyle(Style.text_four);
				tilePriceTexts[indexCity].setStyle(Style.text_four);
				tileNameTexts[indexCity].setText(Map.getInstance().getTileAt(i).getName());
				tilePriceTexts[indexCity].setText((((CityTile) Map.getInstance().getTileAt(i)).getPrice()) + "₺");
				indexCity++;
			}
		}
	}

	private void updateTileInfo() {
		int cityIndex = 0;
		for (int i = 0; i < Map.TILE_COUNT; i++) {
			if (Map.getInstance().getTileAt(i).getClass() == CityTile.class) {
				for (int j = 0; j < 4; j++) { // set transparent first
					tileInfo[cityIndex][j].setOpacity(0);
				}

				int totalBuilding = ((CityTile) Map.getInstance().getTileAt(i)).getHouseCount()
						+ ((CityTile) Map.getInstance().getTileAt(i)).getHotelCount();
				switch (totalBuilding) {
					case 4 :  tileInfo[cityIndex][3].setOpacity(1);
					case 3 :  tileInfo[cityIndex][2].setOpacity(1);
					case 2 :  tileInfo[cityIndex][1].setOpacity(1);
					case 1 :  tileInfo[cityIndex][0].setOpacity(1);
				}

				cityIndex++;
			}
		}
	}

	private void exRateTextUpdate() {
		textForexDollar.setText(Double.toString(GameManager.getInstance().getForexDollar()));
		textForexEuro.setText(Double.toString(GameManager.getInstance().getForexEuro()));
		textForexFrank.setText(Double.toString(GameManager.getInstance().getForexFrank()));
	}
	private void updatePlayerLabels() {
		showDollarAmount.setText("$" + df.format(GameManager.getInstance().getTurnOfPlayer().getAccount().getDollar()));
		showEuroAmount.setText(df.format(GameManager.getInstance().getTurnOfPlayer().getAccount().getEuro()) + "€");
		showFrancAmount.setText("CHF " + df.format(GameManager.getInstance().getTurnOfPlayer().getAccount().getSwissFrank()));
		currentPlayerName.setText(GameManager.getInstance().getTurnOfPlayer().getName());
	}

	public void update() {

		// player money's on the player bar
		infoPlayer1Money.setText(df.format(GameManager.getInstance().getPlayerAt(0).getAccount().getTrl()) + "₺");
		infoPlayer2Money.setText(df.format(GameManager.getInstance().getPlayerAt(1).getAccount().getTrl()) + "₺");
		infoPlayer3Money.setText(df.format(GameManager.getInstance().getPlayerAt(2).getAccount().getTrl()) + "₺");
		infoPlayer4Money.setText(df.format(GameManager.getInstance().getPlayerAt(3).getAccount().getTrl()) + "₺");

		// player money stats in the account bar
		updatePlayerLabels();

		int turnOf = GameManager.getInstance().getTurnOfPlayerIndex();

		while (turnOf > 4) {
			GameManager.getInstance().playTurn();
			turnOf = GameManager.getInstance().getTurnOfPlayerIndex();
		}

		checkIfFinished();
		diamondUpdate(turnOf);

		getItems();
		updateAllLocations();
		updateTileInfo();
	}

	private void diamondUpdate(int turnOf) {
		if(!GameManager.getInstance().getPlayerAt(turnOf).getIsBankrupt()){
			turnIndicator1.setOpacity(turnOf == 0 ? 1 : 0);
			turnIndicator2.setOpacity(turnOf == 1 ? 1 : 0);
			turnIndicator3.setOpacity(turnOf == 2 ? 1 : 0);
			turnIndicator4.setOpacity(turnOf == 3 ? 1 : 0);
		}
	}


	private void updateAllLocations() {
		for (int i = 0; i < 6; i++) {
			updateLocations(i);
		}
	}

	public void setStage(Stage context) {
		this.context = context;
	}

	public void roll(ActionEvent e) {
		rollTheDice();
		rollRice.setDisable(true);
	}

	public void rollTheDice() {
		SoundManager sm = new SoundManager(false);
		sm.music(2);
		Player p = GameManager.getInstance().getTurnOfPlayer();
		int[] dices = GameManager.getInstance().playTurn();
		diceLabel.setText("Dices: " + dices[0] + ", " + dices[1]);
		update();
		endTurnButton.setDisable(false);
		if(p.getIsBot()){
			doTileActions(p.getLocation());
		}else
			showTileActions(p.getLocation());
	}

	private void updateLocations(int index) {
		if (index == 4) {
			if (GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT <= 10) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutX() + 14);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutY() + 44);
			} else if (GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT <= 20) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutX() + 24);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutY() + 28);
			} else if (GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT <= 30) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutX() + 16);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutY() + 37);
			} else if (GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT > 30) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutX() + 39);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getMafia().getLocation() % Map.TILE_COUNT].getLayoutY() + 5);
			}
		} else if (index == 5) {
			if (GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT <= 10) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutX() + 31);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutY() + 43);
			} else if (GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT <= 20) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutX() + 26);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutY() + 7);
			}
			if (GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT <= 30) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutX() + 16);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutY() + 17);
			}
			if (GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT > 30) {
				icons[index].setLayoutX(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutX() + 41);
				icons[index].setLayoutY(buttons[GameManager.getInstance().getPolice().getLocation() % Map.TILE_COUNT].getLayoutY() + 29);
			}
		} else {
			if (index == 0) {
				if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 10) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 3);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 20);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 20) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() - 1);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 1);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() - 1);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 1);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 18);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 1);
				}

			} else if (index == 1) {
				if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 10) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 34);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 20);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 20) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 43);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 2);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 30);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 0);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 62);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 1);
				}

			} else if (index == 2) {
				if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 10) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 4);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 58);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 20) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 1);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 27);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 0);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 39);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 19);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 26);
				}

			} else if (index == 3) {
				if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT >= 0 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 10) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 33);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 60);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 10 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 20) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 44);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 25);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 20 && GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT <= 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 30);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + Map.TILE_COUNT);
				} else if (GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT > 30) {
					icons[index]
							.setLayoutX(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutX() + 62);
					icons[index]
							.setLayoutY(buttons[GameManager.getInstance().getPlayerAt(index).getLocation() % Map.TILE_COUNT].getLayoutY() + 27);
				}
			}
		}
	}

	public void getItems() {
		ListView list = new ListView();
		SoundManager sm = new SoundManager(false);
		Player currentPlayer = GameManager.getInstance().getTurnOfPlayer();
		ArrayList<PowerUp> powerUps;
		ArrayList<Tile> tiles;
		ArrayList<Card> cards;
		list.setStyle("-fx-font-family: Forte;");
		Label label = new Label("Your Power-ups:");
		Label label2 = new Label("Your special cards:");
		Label label3 = new Label("Your special cards:");
		label.setTextFill(Color.rgb(194, 58, 178));
		label2.setTextFill(Color.rgb(194, 58, 178));
		label3.setTextFill(Color.rgb(194, 58, 178));
		//Add PowerUps
		list.getItems().add(label);
		powerUps = currentPlayer.getPowerUps();
		if (powerUps.size() == 0)
			list.getItems().add("No Power-Ups available!");
		else
			for (int i = 0; i < powerUps.size(); i++) {
				Button btn = new Button(powerUps.get(i).getBehaviourName());
				btn.setStyle(Style.button_two);
				list.getItems().add(btn);
				int x = i;

				btn.setOnAction(event -> {
					sm.music(5);
					new PowerupInfoPopup(powerUps.get(x)).display(context);
					getItems();
				});
			}
		//Add Cards
		list.getItems().add(label2);
		cards = currentPlayer.getCards();
		if (cards.size() == 0)
			list.getItems().add("No cards available!");
		else
			for (int k = 0; k < cards.size(); k++) {
				Button button = new Button("Jailbreak Daddy Card");
				button.setStyle(Style.button_two);
				list.getItems().add(button);

				button.setOnAction(event -> {
					sm.music(5);
					if(currentPlayer.getIsArrested()){
						new UseCardPopup().display(context);
						getItems();
					}
				});
			}
		//Add Tiles
		list.getItems().add(label3);
		tiles = currentPlayer.getTileList();
		if (tiles.size() == 0)
			list.getItems().add("No tiles available!");
		else
			for (int m = 0; m < tiles.size(); m++) {
				Button bttn;
				if(MainMenu.colorblindMode && tiles.get(m).getClass() == CityTile.class)
					bttn = new Button(tiles.get(m).getName() + " (" + ((CityTile) tiles.get(m)).getColorGroup() + ")");
				else
					bttn = new Button(tiles.get(m).getName());

				if (tiles.get(m).getClass() != CityTile.class) {
					bttn.setStyle(Style.button_three + "-fx-text-fill: #647399");
					list.getItems().add(bttn);

					continue; // skip the city tile styling if the tile is not a city
				}

				if(MainMenu.colorblindMode)
					bttn.setStyle(Style.button_two);
				else
					switch (((CityTile) (tiles.get(m))).getColorGroup()) {
						case 1:
							bttn.setStyle(Style.button_three + "-fx-text-fill: #F29BC8;");
							break;
						case 2:
							bttn.setStyle(Style.button_three + "-fx-text-fill: #95F9EA;");
							break;
						case 3:
							bttn.setStyle(Style.button_three + "-fx-text-fill: #FDF071;");
							break;
						case 4:
							bttn.setStyle(Style.button_three + "-fx-text-fill: #EF6E57;");
							break;
						case 5:
							bttn.setStyle(Style.button_three + "-fx-text-fill: #ADE581;");
							break;
						case 6:
							bttn.setStyle(Style.button_three + "-fx-text-fill: #B893E3;");
							break;
						case 7:
							bttn.setStyle(Style.button_three + "-fx-text-fill: #EFBE6E;");
							break;
						case 8:
							bttn.setStyle(Style.button_three + "-fx-text-fill: #A6D3FF;");
							break;
						default:
							bttn.setStyle(Style.button_two);
					}

				list.getItems().add(bttn);
				int n = m;
				bttn.setOnAction(event -> {
					sm.music(5);
					new TileOperationPopup(tiles.get(n)).display(context);
				});
			}
		listItems.getChildren().add(list);
	}

	public void pauseGame() {
		sm.music(5);
		SoundManager.getInstance().pauseMusic();
		blurScreen();
		new PausePopup().display(context);
		removeBlur();
	}

	private void removeBlur() {
		root.setEffect(null);
		update();
		updateIconPlayer();
	}

	public void trade() {
		//new TradePopup(1).display(context);
		new ShowTradesPopup().display(context);
		update();
	}

	private void blurScreen() {
		ColorAdjust adj = new ColorAdjust(0, -0.9, -0.5, 0);
		GaussianBlur blur = new GaussianBlur(55);
		adj.setInput(blur);
		root.setEffect(adj);
	}

	public void mafiaButton () {
		if(!GameManager.getInstance().getMafia().getIsArrested()){
			sm.music(5);
			new MafiaPopup().display(context);
			update();
		}
	}

	public void powerupCrate(){
		sm.music(5);
		new PowerUpPopup().display(context);
		update();
	}

	public void updateIconPlayer(){
		if(GameManager.getInstance().getTurnOfPlayer().getIsBankrupt()){
			if(GameManager.getInstance().getTurnOfPlayer() == GameManager.getInstance().getPlayerAt(0)){
				iconPlayer1.setOpacity(0);
			}else if(GameManager.getInstance().getTurnOfPlayer() == GameManager.getInstance().getPlayerAt(1)){
				iconPlayer2.setOpacity(0);
			}else if(GameManager.getInstance().getTurnOfPlayer() == GameManager.getInstance().getPlayerAt(2)){
				iconPlayer3.setOpacity(0);
			}else if(GameManager.getInstance().getTurnOfPlayer() == GameManager.getInstance().getPlayerAt(3)){
				iconPlayer4.setOpacity(0);
			}
		}
	}

	public void updateAllIconPlayers(){
		for(int i = 0; i < 6; i++){
			updateIconPlayer();
			GameManager.getInstance().increaseTurn();
		}

	}

	public void checkIfFinished(){
		bankruptedPLayerCount= 0;
		for(int i = 0; i < 4; i++){
			if(GameManager.getInstance().getPlayerAt(i).getIsBankrupt())
				bankruptedPLayerCount ++;
		}
		if(bankruptedPLayerCount >= 3){
			Player winner = null;
			for(int k = 0; k < 4; k++)
				if(!GameManager.getInstance().getPlayerAt(k).getIsBankrupt())
					winner = GameManager.getInstance().getPlayerAt(k);
			new FinishPopup(winner.getName(), true).display(context);
		}else {
			for(int i = 0; i < 4; i++){
				if(Bank.getInstance().getAllMoneyAmount(GameManager.getInstance().getPlayerAt(i)) >= 1000000)
					new FinishPopup(GameManager.getInstance().getPlayerAt(i).getName(), true).display(context);
			}
		}
	}

	public void showFailedPopUp(){
		new FailedPopup().display(context);
	}
}