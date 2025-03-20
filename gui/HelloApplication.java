package game.gui;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;


import game.engine.Battle;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.*;
import game.engine.weapons.WeaponRegistry;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {

    private Label label;

    private ToggleGroup switchMode;
    private RadioButton easy;
    private RadioButton hard;
    private static Battle battle;
    private WeaponRegistry weaponRegistry;
    private Button piercingCannon = new Button("Piercing Cannon");
    private Button walltrap = new Button("WallTrap");
    private Button volleySpreadCannon = new Button("volleySpreadCannon");
    private Button snipercannon = new Button("SniperCannon");


    Button passTurnEasy;


    private Stage stage;

    private Label Turn = new Label("Turn:");
    private Label Score = new Label("Score:");
    private Label Phase = new Label("Phase:");
    private Label Res = new Label("Resources:");

    private PureTitan pureTitan;
    private static ArrayList<Lane> lanes = new ArrayList<>();
    private static int WeaponCode = 1;
    private static Button[] ButtonLane = new Button[5];
    private static VBox vboxButtonLane = new VBox();
    private static GridPane gridPane1;
    private static GridPane gridPane2;
    private static GridPane gridPane3;
    private static GridPane gridPane4;
    private static GridPane gridPane5;



    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = new AnchorPane();
        root = Hardmode();
        root = new AnchorPane();
        root.setPrefSize(1000, 800);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #1e3c72, #2a5298);");

        Button btnInstructions = new Button("Instructions");
        btnInstructions.setLayoutX(418);
        btnInstructions.setLayoutY(480);
        btnInstructions.setPrefSize(151, 61);
        btnInstructions.setFont(new Font("Ink Free", 24));
        btnInstructions.setStyle("-fx-background-color: #f0ad4e; -fx-text-fill: white; -fx-background-radius: 10;");
        btnInstructions.setOnAction(this::Instructions);

        Button btnStart = new Button("Start");
        btnStart.setLayoutX(418);
        btnStart.setLayoutY(365);
        btnStart.setPrefSize(151, 71);
        btnStart.setFont(new Font("Ink Free", 34));
        btnStart.setStyle("-fx-background-color: #5cb85c; -fx-text-fill: white; -fx-background-radius: 10;");
        btnStart.setOnAction(this);

        switchMode = new ToggleGroup();

        easy = new RadioButton("Easy Mode");
        easy.setLayoutX(242);
        easy.setLayoutY(286);
        easy.setFont(new Font("Ink Free", 25));
        easy.setToggleGroup(switchMode);
        easy.setStyle("-fx-text-fill: white;");
        easy.setOnAction(event -> easy());

        hard = new RadioButton("Hard Mode");
        hard.setLayoutX(609);
        hard.setLayoutY(286);
        hard.setFont(new Font("Ink Free", 25));
        hard.setToggleGroup(switchMode);
        hard.setStyle("-fx-text-fill: white;");
        hard.setOnAction(event -> hard());

        label = new Label("Select Mode");
        label.setLayoutX(384);
        label.setLayoutY(79);
        label.setPrefSize(322, 51);
        label.setFont(new Font("Ink Free", 40));
        label.setStyle("-fx-text-fill: white;");

        root.getChildren().addAll(btnInstructions, btnStart, easy, hard, label);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }
    private void Instructions(ActionEvent event) {
    AnchorPane root =new AnchorPane();
    root.setPrefSize(1000,800);
    Scene scene = new Scene(root);


    }

    private void Start() {
        System.out.println("Start button clicked");
    }

    private void easy() {
        System.out.println("Easy mode selected");
    }

    private void hard() {
        System.out.println("Hard mode selected");
    }

    private AnchorPane Easymode() {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000, 800);

        HBox hBox = new HBox();
        hBox.setLayoutX(200);
        hBox.setLayoutY(14);
        hBox.setPrefSize(600, 85);
        try {
            battle = new Battle(1, 0, 80, 3, 250);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        lanes = new ArrayList<>();
        lanes.addAll(battle.getLanes());
        piercingCannon = new Button("PiercingCannon"+"\n" +"price" +"25"+ "\n"+"Damage"+"10");
        piercingCannon.setPrefSize(162, 85);
        piercingCannon.setFont(new Font("Ink Free", 18));
        piercingCannon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //   if(!battle.isGameOver())
                displayAlert(1);

            }

        });

//        private void displayAlert(String title, String message) {
//            Stage alertStage = new Stage();
//            alertStage.setTitle(title);
//
//            Label label = new Label(message);
//            Button closeButton = new Button("Continue Shopping");
//            //closing is predefined
//            closeButton.setOnAction(event -> alertStage.close());
//
//            BorderPane pane = new BorderPane();
//            pane.setTop(label);
//            pane.setCenter(closeButton);
//
//            Scene scene = new Scene(pane, 500, 100);
//            alertStage.setScene(scene);
//            alertStage.show();
//        }
        walltrap = new Button("walltrap\nprice 100\nDmage 5");
        walltrap.setPrefSize(162, 85);
        walltrap.setFont(new Font("Ink Free", 18));
        walltrap.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //  if(!battle.isGameOver())
                displayAlert(4);

            }
        });
        volleySpreadCannon = new Button("VolleySpreadCannon\nprice 100\nDmege 5");
        volleySpreadCannon.setPrefSize(162, 85);
        volleySpreadCannon.setFont(new Font("Ink Free", 15));
        volleySpreadCannon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // if(!battle.isGameOver())
                displayAlert(3);

            }
        });

        snipercannon = new Button("SniperCannon\n price 25 \n damage 35");
        snipercannon.setPrefSize(168, 85);
        snipercannon.setFont(new Font("Ink Free", 18));
        snipercannon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //   if(!battle.isGameOver())
                displayAlert(2);

            }
        });

        hBox.getChildren().addAll(piercingCannon, walltrap, volleySpreadCannon, snipercannon);

        Turn = new Label("Turn:");
        Turn.setLayoutX(14);
        Turn.setLayoutY(14);
        Turn.setPrefSize(189, 51);
        Turn.setFont(new Font("Javanese Text", 18));

        Phase = new Label("Phase:");
        Phase.setLayoutX(14);
        Phase.setLayoutY(57);
        Phase.setPrefSize(189, 39);
        Phase.setFont(new Font("Javanese Text", 18));

        Score = new Label("Score:");
        Score.setLayoutX(831);
        Score.setLayoutY(14);
        Score.setPrefSize(189, 51);
        Score.setFont(new Font("Javanese Text", 18));

        Res = new Label("Resources:");
        Res.setLayoutX(831);
        Res.setLayoutY(57);
        Res.setPrefSize(189, 51);
        Res.setFont(new Font("Javanese Text", 18));

        Line line1 = new Line(-101, 0, 963.5, 0);
        line1.setLayoutX(101);
        line1.setLayoutY(172);

        Line line2 = new Line(-107, 37, 958.5, 37);
        line2.setLayoutX(106);
        line2.setLayoutY(335);

        Line line3 = new Line(-107, 0, 959.5, 0);
        line3.setLayoutX(107);
        line3.setLayoutY(572);

        Line line4 = new Line(-100, 0, 965.5, 0);
        line4.setLayoutX(101);
        line4.setLayoutY(772);

        Rectangle wall1 = new Rectangle(2, 222, 155, 150);
        wall1.setArcHeight(5);
        wall1.setArcWidth(5);
        wall1.setFill(javafx.scene.paint.Color.DODGERBLUE);
        wall1.setStroke(javafx.scene.paint.Color.BLACK);

        Rectangle wall2 = new Rectangle(2, 422, 155, 150);
        wall2.setArcHeight(5);
        wall2.setArcWidth(5);
        wall2.setFill(javafx.scene.paint.Color.DODGERBLUE);
        wall2.setStroke(javafx.scene.paint.Color.BLACK);

        Rectangle wall3 = new Rectangle(2, 622, 155, 150);
        wall3.setArcHeight(5);
        wall3.setArcWidth(5);
        wall3.setFill(javafx.scene.paint.Color.DODGERBLUE);
        wall3.setStroke(javafx.scene.paint.Color.BLACK);

        Label   l5 = new Label("Health" );
        l5.setLayoutX(10);
        l5.setLayoutY(164);
        l5.setPrefSize(139, 17);
        l5.setFont(new Font("Javanese Text", 14));

        Label  l6 = new Label("Damage"  );
        l6.setLayoutX(10);
        l6.setLayoutY(184);
        l6.setPrefSize(139, 17);
        l6.setFont(new Font("Javanese Text", 14));

        Label   l7 = new Label("Health");
        l7.setLayoutX(10);
        l7.setLayoutY(370);
        l7.setPrefSize(139, 17);
        l7.setFont(new Font("Javanese Text", 14));

        Label    l8 = new Label("Damage" );
        l8.setLayoutX(10);
        l8.setLayoutY(390);
        l8.setPrefSize(139, 17);
        l8.setFont(new Font("Javanese Text", 14));

        Label    l9 = new Label("Health" );
        l9.setLayoutX(10);
        l9.setLayoutY(572);
        l9.setPrefSize(139, 17);
        l9.setFont(new Font("Javanese Text", 14));

        Label l10 = new Label("Damage" );
        l10.setLayoutX(10);
        l10.setLayoutY(592);
        l10.setPrefSize(139, 17);
        l10.setFont(new Font("Javanese Text", 14));

        passTurnEasy = new Button("PassTurn");
        passTurnEasy.setLayoutX(410);
        passTurnEasy.setLayoutY(126);
        passTurnEasy.setPrefSize(243, 25);
        passTurnEasy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

               battle.passTurn();
               PassturnEasy(event);
                moveTitan();
            }
        });

        gridPane1 = createGridPane();
        gridPane1.setLayoutX(156);
        gridPane1.setLayoutY(171);

        gridPane2 = createGridPane();
        gridPane2.setLayoutX(156);
        gridPane2.setLayoutY(373);

        gridPane3 = createGridPane();
        gridPane3.setLayoutX(156);
        gridPane3.setLayoutY(573);

        root.getChildren().addAll(hBox, Turn, Phase, Score, Res, line1, line2, line3, line4, wall1, wall2, wall3, l5, l6, l7, l8, l9, l10, passTurnEasy, gridPane1, gridPane2, gridPane3);

        return root;
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(841, 200);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col1.setPrefWidth(100);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col2.setPrefWidth(100);
        gridPane.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        row1.setPrefHeight(30);
        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        row2.setPrefHeight(30);
        RowConstraints row3 = new RowConstraints();
        row3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        row3.setPrefHeight(30);
        gridPane.getRowConstraints().addAll(row1, row2, row3);

        return gridPane;
    }

    private AnchorPane Hardmode() throws IOException {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(1000, 800);

        HBox hBox = new HBox();
        hBox.setLayoutX(200);
        hBox.setLayoutY(14);
        hBox.setPrefSize(600, 85);
        try {
            battle = new Battle(1, 0, 70, 5, 125);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        lanes = new ArrayList<>();
        lanes.addAll(battle.getLanes());
        piercingCannon = new Button("PiercingCannon" + "\n" );
        piercingCannon.setPrefSize(162, 85);
        piercingCannon.setFont(new Font("Ink Free", 18));
        piercingCannon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayAlert(1);

            }
        });

        walltrap = new Button("WallTrap");
        walltrap.setPrefSize(162, 85);
        walltrap.setFont(new Font("Ink Free", 18));
        walltrap.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayAlert(4);

            }
        });

        volleySpreadCannon = new Button("VolleySpreadCannon");
        volleySpreadCannon.setPrefSize(162, 85);
        volleySpreadCannon.setFont(new Font("Ink Free", 15));
        volleySpreadCannon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayAlert(3);

            }
        });

        snipercannon = new Button("SniperCannon\n price 25 \n damage 35");
        snipercannon.setPrefSize(168, 85);
        snipercannon.setFont(new Font("Ink Free", 18));
        snipercannon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayAlert(2);
            }
        });

        hBox.getChildren().addAll(piercingCannon, walltrap, volleySpreadCannon, snipercannon);

        Turn = new Label("Turn:");
        Turn.setLayoutX(14);
        Turn.setLayoutY(14);
        Turn.setPrefSize(189, 51);
        Turn.setFont(new Font("Javanese Text", 18));

        Phase = new Label("Phase:");
        Phase.setLayoutX(14);
        Phase.setLayoutY(57);
        Phase.setPrefSize(189, 39);
        Phase.setFont(new Font("Javanese Text", 18));

        Score = new Label("Score:");
        Score.setLayoutX(831);
        Score.setLayoutY(14);
        Score.setPrefSize(189, 51);
        Score.setFont(new Font("Javanese Text", 18));

        Res = new Label("Resources:");
        Res.setLayoutX(831);
        Res.setLayoutY(57);
        Res.setPrefSize(189, 51);
        Res.setFont(new Font("Javanese Text", 18));

        Line line1 = new Line(-101, 0, 980, 0);
        line1.setLayoutX(101);
        line1.setLayoutY(172);

        Line line2 = new Line(-124.5, 37, 958.5, 37);
        line2.setLayoutX(122);
        line2.setLayoutY(260);

        Line line3 = new Line(-107, 0, 976.5, 0);
        line3.setLayoutX(105);
        line3.setLayoutY(418);

        Line line4 = new Line(-100, 0, 984.5, 0);
        line4.setLayoutX(98);
        line4.setLayoutY(545);

        Rectangle wall1 = new Rectangle(100, 80);
        wall1.setLayoutX(-1);
        wall1.setLayoutY(217);
        wall1.setArcHeight(5);
        wall1.setArcWidth(5);
        wall1.setFill(javafx.scene.paint.Color.DODGERBLUE);
        wall1.setStroke(javafx.scene.paint.Color.BLACK);

        Rectangle wall2 = new Rectangle(100, 80);
        wall2.setLayoutY(338);
        wall2.setArcHeight(5);
        wall2.setArcWidth(5);
        wall2.setFill(javafx.scene.paint.Color.DODGERBLUE);
        wall2.setStroke(javafx.scene.paint.Color.BLACK);

        Rectangle wall3 = new Rectangle(100, 80);
        wall3.setLayoutY(465);
        wall3.setArcHeight(5);
        wall3.setArcWidth(5);
        wall3.setFill(javafx.scene.paint.Color.DODGERBLUE);
        wall3.setStroke(javafx.scene.paint.Color.BLACK);

        Label  l5 = new Label("Health:" );
        l5.setLayoutX(2);
        l5.setLayoutY(167);
        l5.setPrefSize(139, 17);
        l5.setFont(new Font("Javanese Text", 12));

        Label     l6 = new Label("Damage" );
        l6.setLayoutX(2);
        l6.setLayoutY(187);
        l6.setPrefSize(139, 17);
        l6.setFont(new Font("Javanese Text", 12));

        Label   l7 = new Label("Health:" );
        l7.setLayoutX(5);
        l7.setLayoutY(293);
        l7.setPrefSize(139, 17);
        l7.setFont(new Font("Javanese Text", 12));

        Label l8 = new Label("Damage" );
        l8.setLayoutX(4);
        l8.setLayoutY(312);
        l8.setPrefSize(139, 17);
        l8.setFont(new Font("Javanese Text", 12));

       Label  l9 = new Label("Health:"  );
        l9.setLayoutX(4);
        l9.setLayoutY(418);
        l9.setPrefSize(139, 17);
        l9.setFont(new Font("Javanese Text", 12));

        Label l10 = new Label("Damage" );
        l10.setLayoutX(4);
        l10.setLayoutY(438);
        l10.setPrefSize(139, 17);
        l10.setFont(new Font("Javanese Text", 12));

        Button passTurnHard = new Button("PassTurn");
        passTurnHard.setLayoutX(410);
        passTurnHard.setLayoutY(126);
        passTurnHard.setPrefSize(243, 25);
        passTurnHard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                battle.passTurn();
                PassturnHard(event);
                moveTitan();
            }
        });

        Rectangle wall4 = new Rectangle(100, 80);
        wall4.setLayoutY(589);
        wall4.setArcHeight(5);
        wall4.setArcWidth(5);
        wall4.setFill(javafx.scene.paint.Color.DODGERBLUE);
        wall4.setStroke(javafx.scene.paint.Color.BLACK);

        Rectangle wall5 = new Rectangle(100, 80);
        wall5.setLayoutY(709);
        wall5.setArcHeight(5);
        wall5.setArcWidth(5);
        wall5.setFill(javafx.scene.paint.Color.DODGERBLUE);
        wall5.setStroke(javafx.scene.paint.Color.BLACK);

        Label l11 = new Label("Health:");
        l11.setLayoutX(3);
        l11.setLayoutY(540);
        l11.setPrefSize(139, 17);
        l11.setFont(new Font("Javanese Text", 12));

        Label l12 = new Label("Damage" );
        l12.setLayoutX(3);
        l12.setLayoutY(560);
        l12.setPrefSize(139, 17);
        l12.setFont(new Font("Javanese Text", 12));

        Line line41 = new Line(-100, 0, 979.5, 0);
        line41.setLayoutX(104);
        line41.setLayoutY(669);

         Label l13 = new Label("Health:" );
        l13.setLayoutX(2);
        l13.setLayoutY(664);
        l13.setPrefSize(139, 17);
        l13.setFont(new Font("Javanese Text", 12));

        Label l14 = new Label("Damage" );
        l14.setLayoutX(2);
        l14.setLayoutY(684);
        l14.setPrefSize(139, 17);
        l14.setFont(new Font("Javanese Text", 12));

        Line line411 = new Line(-107, 0, 977.5, 0);
        line411.setLayoutX(107);
        line411.setLayoutY(789);

        gridPane1 = createGridPane2();
        gridPane1.setLayoutX(99);
        gridPane1.setLayoutY(172);

        gridPane2 = createGridPane2();
        gridPane2.setLayoutX(109);
        gridPane2.setLayoutY(299);

        gridPane3 = createGridPane2();
        gridPane3.setLayoutX(99);
        gridPane3.setLayoutY(418);

        gridPane4 = createGridPane2();
        gridPane4.setLayoutX(109);
        gridPane4.setLayoutY(545);

        gridPane5 = createGridPane2();
        gridPane5.setLayoutX(99);
        gridPane5.setLayoutY(669);

        root.getChildren().addAll(
                hBox, Turn, Phase, Score, Res,
                line1, line2, line3, line4, line41, line411,
                wall1, wall2, wall3, wall4, wall5,
                l5, l6, l7, l8, l9, l10, l11, l12, l13, l14,
                passTurnHard, gridPane1, gridPane2, gridPane3, gridPane4, gridPane5
        );

        return root;
    }

    public GridPane createGridPane2() {
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(989, 124);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col1.setMinWidth(10);
        col1.setPrefWidth(100);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        col2.setMinWidth(10);
        col2.setPrefWidth(100);

        gridPane.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        row1.setMinHeight(10);
        row1.setPrefHeight(30);

        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        row2.setMinHeight(10);
        row2.setPrefHeight(30);

        RowConstraints row3 = new RowConstraints();
        row3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        row3.setMinHeight(10);
        row3.setPrefHeight(30);

        gridPane.getRowConstraints().addAll(row1, row2, row3);

        return gridPane;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof Button) {
            Button clickedButton = (Button) actionEvent.getSource();
            if (clickedButton.getText().equals("Start")) {
                if (easy.isSelected()) {
                    Stage primaryStage = (Stage) easy.getScene().getWindow();
                    primaryStage.setScene(new Scene(Easymode()));

                } else if (hard.isSelected()) {
                    Stage primaryStage = (Stage) hard.getScene().getWindow();
                    try {
                        primaryStage.setScene(new Scene(Hardmode()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            } else if (clickedButton.getText().equals("Instructions")) {
                Instructions(actionEvent);
            }

        }
    }

    private void displayAlert(int code) {
        Stage alertStage = new Stage();
        alertStage.setTitle("Weapon Shop");
        VBox vbox = new VBox(10);
        vbox.setPrefSize(200, 500);


        vboxButtonLane.getChildren().clear();

        for (int i = 0; i < lanes.size(); i++) {
            Lane lane = lanes.get(i);
            Button laneButton = new Button("Lane " + (i + 1));
            laneButton.setPrefSize(100, 100);


            laneButton.setOnAction(event -> {
                if(battle.isGameOver()){
                    showError("abl3");
                }else {
                    try {
                        battle.purchaseWeapon(code, lane);
                    } catch (InsufficientResourcesException | InvalidLaneException e) {
                        showError(e.getMessage());
                    }
                    alertStage.close();
                }
            });


            vbox.getChildren().add(laneButton);
        }

        Button closeButton = new Button("Continue Shopping");
        closeButton.setOnAction(event -> alertStage.close());

        BorderPane pane = new BorderPane();
        pane.setCenter(vbox);
        pane.setBottom(closeButton);
        BorderPane.setAlignment(closeButton, Pos.CENTER);

        Scene scene = new Scene(pane, 700, 700);
        alertStage.setScene(scene);
        alertStage.show();
    }

    public static void showError(String message) {
        // Create a new Stage for the error dialog
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setTitle("Error");

        // Create a Label to show the error message
        Label errorMessageLabel = new Label(message);
        errorMessageLabel.setTextFill(Color.RED);

        // Create a Button to close the dialog
        Button closeButton = new Button("Close");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialogStage.close();
            }
        });

        // Create a layout for the dialog
        VBox dialogVBox = new VBox(20);
        dialogVBox.getChildren().addAll(errorMessageLabel, closeButton);
        dialogVBox.setAlignment(Pos.CENTER);

        // Set the Scene and show the Stage
        Scene dialogScene = new Scene(dialogVBox, 300, 150);
        dialogStage.setScene(dialogScene);
        dialogStage.showAndWait();
    }
//    public void PiercingCannon(ActionEvent event) {
//        displayAlert(1);
//    }
//
//    public void WallTrap(ActionEvent event) {
//        displayAlert(4);
//    }
//
//    public void VolleySpreadCannon(ActionEvent event) {
//        displayAlert(3);
//    }
//
//    public void SniperCannon(ActionEvent event) {
//        displayAlert(2);
//    }

    public void WeaponShop(ActionEvent event) {
    }

    public void setResLabel(Label resLabel) {
    }

    public void setScoreLabel(Label scoreLabel) {
    }

    public void setPhaseLabel(Label phaseLabel) {
    }

    public void setTurnLabel(Label turnLabel) {
    }


    public void PassturnEasy(ActionEvent event) {
        updateBattleStatus(3, 250);

    }

    public void PassturnHard(ActionEvent event) {


        updateBattleStatus(5, 125);

    }


    private void updateBattleStatus(int lanesCount, int resources) {
        Turn.setText("Turn: " + battle.getNumberOfTurns());
        Score.setText("Score: " + battle.getScore());
        Phase.setText("Phase: " + battle.getBattlePhase());
        Res.setText("Resources: " + battle.getResourcesGathered());

    }





    public static void moveTitan() {
        int count = 0;
        gridPane1.getChildren().clear();
        gridPane2.getChildren().clear();
        gridPane3.getChildren().clear();
        gridPane4.getChildren().clear();
        gridPane5.getChildren().clear();

        for (Lane l : lanes) {
            Label laneHealthLabel = new Label("Danger Level: " + l.getDangerLevel());
            laneHealthLabel.setTranslateX(10);
            laneHealthLabel.setTranslateY(10);

            for (Titan t : l.getTitans()) {
                Rectangle rectangle = new Rectangle();
                Label damageLabel = new Label("Damage: " + t.getDamage());
                damageLabel.setFont(new Font("Arial", 16));
                damageLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

                Label healthLabel = new Label("Health: " + t.getCurrentHealth());
                healthLabel.setFont(new Font("Arial", 16));
                healthLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

                if (t instanceof PureTitan) {
                    rectangle.setFill(Color.RED);
                    rectangle.setWidth(30);
                    rectangle.setHeight(30);
                } else if (t instanceof AbnormalTitan) {
                    rectangle.setFill(Color.YELLOW);
                    rectangle.setTranslateY(21);
                    rectangle.setWidth(50);
                    rectangle.setHeight(50);
                } else if (t instanceof ArmoredTitan) {
                    rectangle.setFill(Color.BLUE);
                    rectangle.setTranslateY(42);
                    rectangle.setWidth(70);
                    rectangle.setHeight(70);
                } else if (t instanceof ColossalTitan) {
                    rectangle.setFill(Color.BLACK);
                    rectangle.setTranslateY(20);
                    rectangle.setWidth(90);
                    rectangle.setHeight(90);
                }

                // Set initial position off-screen to the right
                double initialX = 1000;
                rectangle.setTranslateX(initialX);

                double targetX = t.getDistance() * 10;
                TranslateTransition transition = new TranslateTransition(Duration.seconds(1), rectangle);
                transition.setFromX(initialX);
                transition.setToX(targetX);
                transition.play();

                damageLabel.setTranslateX(targetX + 10);
                damageLabel.setTranslateY(rectangle.getTranslateY() + 20);
                healthLabel.setTranslateX(targetX + 10);
                healthLabel.setTranslateY(rectangle.getTranslateY() + 40);

                if (count == 0) {
                    gridPane1.getChildren().addAll(rectangle, damageLabel, healthLabel);
                } else if (count == 1) {
                    gridPane2.getChildren().addAll(rectangle, damageLabel, healthLabel);
                } else if (count == 2) {
                    gridPane3.getChildren().addAll(rectangle, damageLabel, healthLabel);
                } else if (count == 3) {
                    gridPane4.getChildren().addAll(rectangle, damageLabel, healthLabel);
                } else if (count == 4) {
                    gridPane5.getChildren().addAll(rectangle, damageLabel, healthLabel);
                }
            }

            if (count == 0) {
                gridPane1.getChildren().add(laneHealthLabel);
            } else if (count == 1) {
                gridPane2.getChildren().add(laneHealthLabel);
            } else if (count == 2) {
                gridPane3.getChildren().add(laneHealthLabel);
            } else if (count == 3) {
                gridPane4.getChildren().add(laneHealthLabel);
            } else if (count == 4) {
                gridPane5.getChildren().add(laneHealthLabel);
            }

            count++;
        }
    }
        public static void main (String[]args){
            launch(args);
        }


}

