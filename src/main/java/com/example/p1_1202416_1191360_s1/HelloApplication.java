package com.example.p1_1202416_1191360_s1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        MissionariesAndCannibals missionariesAndCannibals = new MissionariesAndCannibals();

        //Main Scene
        Image backgroundImage = new Image("file:///Users/hindsuleiman/Desktop/scene1.png");
        // Create background for the main scene
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );

        Button bfsSceneButton = new Button("Take to BFS Algorithm");
        bfsSceneButton.setStyle("-fx-border-radius: 90;");
        bfsSceneButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        bfsSceneButton.setStyle("-fx-border-color: #00008B; " + "-fx-border-radius: 30px;" +
                "-fx-background-radius: 30px;" + "-fx-border-width: 4px");
        bfsSceneButton.setTextFill(Color.CORNFLOWERBLUE);

        Button dfsSceneButton = new Button("Take to DFS Algorithm");
        dfsSceneButton.setStyle("-fx-border-radius: 90;");
        dfsSceneButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        dfsSceneButton.setStyle("-fx-border-color: #00008B; " + "-fx-border-radius: 30px;" +
                "-fx-background-radius: 30px;" + "-fx-border-width: 4px");
        dfsSceneButton.setTextFill(Color.CORNFLOWERBLUE);

        Label mainLabel = new Label("Choose the Algorithm for the Missionaries and Cannibals Problem");
        mainLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        mainLabel.setTextFill(Color.DARKBLUE);

        VBox sceneBox = new VBox(15);
        sceneBox.getChildren().addAll(mainLabel, bfsSceneButton, dfsSceneButton);
        sceneBox.setAlignment(Pos.CENTER);
        sceneBox.setBackground(new Background(background));
        Scene scene = new Scene(sceneBox, 800, 250);


        // BFS Scene
        missionariesAndCannibals.bfs();
        Label BFSLabel = new Label();
        String bfs = "Solution using Breadth-First Search in: " + missionariesAndCannibals.getSolutionBFS().size() + " Steps";
        BFSLabel.setText(bfs);
        BFSLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        BFSLabel.setTextFill(Color.DARKBLUE);

        Label bfsTimeLabel = new Label();
        bfsTimeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        bfsTimeLabel.setTextFill(Color.DARKBLUE);
        bfsTimeLabel.setText(missionariesAndCannibals.printBFSExecutionTime());

        TextArea bfsAlgorithm = new TextArea();
        bfsAlgorithm.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        bfsAlgorithm.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
        bfsAlgorithm.setMaxWidth(1000);
        bfsAlgorithm.setPrefHeight(600);
        bfsAlgorithm.setTranslateX(10);
        bfsAlgorithm.setTranslateY(10);
        bfsAlgorithm.setEditable(false);
        bfsAlgorithm.setStyle("-fx-text-fill: black;");

        bfsAlgorithm.setText(missionariesAndCannibals.printBFSSolution());

        Button backFromBFS = new Button("Back");
        backFromBFS.setStyle("-fx-border-radius: 90;");
        backFromBFS.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        backFromBFS.setStyle("-fx-border-color: #00008B; " + "-fx-border-radius: 30px;" +
                "-fx-background-radius: 30px;" + "-fx-border-width: 4px");
        backFromBFS.setTextFill(Color.CORNFLOWERBLUE);
        backFromBFS.setOnAction(e->stage.setScene(scene));

        VBox bfsBox = new VBox(15);
        bfsBox.getChildren().addAll(BFSLabel, bfsAlgorithm, bfsTimeLabel, backFromBFS);
        bfsBox.setAlignment(Pos.CENTER);

        BackgroundFill backgroundFill = new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        Background backgroundBFS = new Background(backgroundFill);
        bfsBox.setBackground(backgroundBFS);

        Scene bfsScene = new Scene(bfsBox, 1200, 1200);
        bfsSceneButton.setOnAction(e->stage.setScene(bfsScene));

        // DFS Scene
        missionariesAndCannibals.dfs();
        Label DFSLabel = new Label();
        String dfs = "Solution using Depth-First Search in: " + missionariesAndCannibals.getSolutionDFS().size() + " Steps";
        DFSLabel.setText(dfs);
        DFSLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        DFSLabel.setTextFill(Color.DARKBLUE);

        Label dfsTimeLabel = new Label();
        dfsTimeLabel.setTextFill(Color.DARKBLUE);
        dfsTimeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        dfsTimeLabel.setText(missionariesAndCannibals.printDFSExecutionTime());

        TextArea dfsAlgorithm = new TextArea();
        dfsAlgorithm.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        dfsAlgorithm.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
        dfsAlgorithm.setMaxWidth(1000);
        dfsAlgorithm.setPrefHeight(600);
        dfsAlgorithm.setTranslateX(10);
        dfsAlgorithm.setTranslateY(10);
        dfsAlgorithm.setStyle("-fx-text-fill: black;");
        dfsAlgorithm.setEditable(false);
        dfsAlgorithm.setText(missionariesAndCannibals.printDFSSolution());

        Button backFromDFS = new Button("Back");
        backFromDFS.setStyle("-fx-border-radius: 90;");
        backFromDFS.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        backFromDFS.setStyle("-fx-border-color: #00008B; " + "-fx-border-radius: 30px;" +
                "-fx-background-radius: 30px;" + "-fx-border-width: 4px");
        backFromDFS.setTextFill(Color.CORNFLOWERBLUE);
        backFromDFS.setOnAction(e->stage.setScene(scene));

        VBox dfsBox = new VBox(15);
        dfsBox.getChildren().addAll(DFSLabel, dfsAlgorithm, dfsTimeLabel, backFromDFS);
        dfsBox.setAlignment(Pos.CENTER);

        BackgroundFill backgroundFill2 = new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        Background backgroundDFS = new Background(backgroundFill2);
        dfsBox.setBackground(backgroundDFS);


        Scene dfsScene = new Scene(dfsBox, 1200, 1200);
        dfsSceneButton.setOnAction(e->stage.setScene(dfsScene));


        stage.setTitle("First Artificial Intelligence Project!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}