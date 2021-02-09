package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.UnaryOperator;

public class Main extends Application {
    int i = 0;
    int steps = 0;


    int[][] state = new int[3][3];
    Node currentState = new Node();

    Button btn1 = new Button("1");
    Button btn2 = new Button("2");
    Button btn3 = new Button("5");
    Button btn4 = new Button("3");
    Button btn5 = new Button("4");
    Button btn6 = new Button("0");
    Button btn7 = new Button("6");
    Button btn8 = new Button("7");
    Button btn9 = new Button("8");
    //btn1.setText("1");
    //btn2.setText("2");
    //btn3.setText("3");
    //btn4.setText("4");
    //btn5.setText("5");
    //btn6.setText("6");
    //btn7.setText("7");
    //btn8.setText("8");
    //btn9.setText("0");
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("8-Puzzle");


        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setAlignment(Pos.CENTER);


        HBox hBox3 = new HBox();
        hBox3.setAlignment(Pos.CENTER);

        Label stepLable = new Label("Step "+ i);
        stepLable.setVisible(false);
        hBox3.getChildren().add(stepLable);
        vBox.getChildren().add(hBox3);

        GridPane gridPane3 = new GridPane();
        gridPane3.setPadding(new Insets(10,10,10,10));
        gridPane3.setVgap(5);
        gridPane3.setHgap(5);

        GridPane.setConstraints(btn1,0,0);
        GridPane.setConstraints(btn2,1,0);
        GridPane.setConstraints(btn3,2,0);
        GridPane.setConstraints(btn4,0,1);
        GridPane.setConstraints(btn5,1,1);
        GridPane.setConstraints(btn6,2,1);
        GridPane.setConstraints(btn7,0,2);
        GridPane.setConstraints(btn8,1,2);
        GridPane.setConstraints(btn9,2,2);
        btn6.setDisable(true);

        gridPane3.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9);
        HBox hBox4 = new HBox();





        hBox4.setAlignment(Pos.CENTER);

        hBox4.getChildren().add(gridPane3);
        vBox.getChildren().add(hBox4);


        GridPane gridPane4 = new GridPane();
        gridPane4.setVgap(5);
        gridPane4.setHgap(5);
        gridPane4.setPadding(new Insets(10,10,10,10));
        gridPane4.setAlignment(Pos.CENTER);
        gridPane4.setPadding(new Insets(0,20,20,20));
        //Button next = new Button();
        //next.setText(">");
        //next.setDisable(true);
        //GridPane.setConstraints(next,1,0);
//
        //Button prev = new Button();
        //prev.setText("<");
        //prev.setDisable(true);
        //GridPane.setConstraints(prev,0,0);
        //gridPane4.getChildren().addAll(prev,next);
        //vBox.getChildren().add(gridPane4);


        HBox hBox6 = new HBox();
        hBox6.setPadding(new Insets(10,10,10,10));
        hBox6.setAlignment(Pos.CENTER);
        ChoiceBox methods = new ChoiceBox();
        methods.setValue("BFS");
        methods.getItems().add("BFS");
        methods.getItems().add("DFS");
        //methods.getItems().add("A*");
        methods.setMaxWidth(110);
        methods.setMinWidth(110);
        hBox6.getChildren().add(methods);
        vBox.getChildren().add(hBox6);

        HBox hBox7 = new HBox();
        hBox7.setPadding(new Insets(0,10,10,10));
        hBox7.setAlignment(Pos.CENTER);
        Button solve = new Button();
        solve.setText("Solve");
        //Button shuffle = new Button();
        //shuffle.setText("Shuffle");
        hBox7.getChildren().addAll(solve);
        hBox7.setSpacing(10);
        vBox.getChildren().add(hBox7);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!solve.isDisabled()){
                    String s = btn1.getText();
                    if(btn2.getText().equals("0")){
                        btn1.setText("0");
                        btn2.setText(s);
                        btn1.setDisable(true);
                        btn2.setDisable(false);
                        steps++;
                    }
                    else if (btn4.getText().equals("0")){
                        btn1.setText("0");
                        btn4.setText(s);
                        btn1.setDisable(true);
                        btn4.setDisable(false);
                        steps++;
                    }
                    updateState();

                }
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!solve.isDisabled()){
                    String s = btn2.getText();
                    if(btn1.getText().equals("0")){
                        btn2.setText("0");
                        btn1.setText(s);
                        btn2.setDisable(true);
                        btn1.setDisable(false);
                        steps++;
                    }
                    else if (btn5.getText().equals("0")){
                        btn2.setText("0");
                        btn5.setText(s);
                        btn2.setDisable(true);
                        btn5.setDisable(false);
                        steps++;
                    }
                    else if (btn3.getText().equals("0")){
                        btn2.setText("0");
                        btn3.setText(s);
                        btn2.setDisable(true);
                        btn3.setDisable(false);
                        steps++;
                    }
                    updateState();

                }
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!solve.isDisabled()){
                    String s = btn3.getText();
                    if(btn2.getText().equals("0")){
                        btn3.setText("0");
                        btn2.setText(s);
                        btn3.setDisable(true);
                        btn2.setDisable(false);
                        steps++;
                    }
                    else if (btn6.getText().equals("0")){
                        btn3.setText("0");
                        btn6.setText(s);
                        btn3.setDisable(true);
                        btn6.setDisable(false);
                        steps++;
                    }
                    updateState();

                }
            }
        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!solve.isDisabled()){
                    String s = btn4.getText();
                    if(btn1.getText().equals("0")){
                        btn4.setText("0");
                        btn1.setText(s);
                        btn4.setDisable(true);
                        btn1.setDisable(false);
                        steps++;
                    }
                    else if (btn5.getText().equals("0")){
                        btn4.setText("0");
                        btn5.setText(s);
                        btn4.setDisable(true);
                        btn5.setDisable(false);
                        steps++;
                    }
                    else if (btn7.getText().equals("0")){
                        btn4.setText("0");
                        btn7.setText(s);
                        btn4.setDisable(true);
                        btn7.setDisable(false);
                        steps++;
                    }
                    updateState();

                }
            }
        });
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!solve.isDisabled()){
                    String s = btn5.getText();
                    if(btn2.getText().equals("0")){
                        btn5.setText("0");
                        btn2.setText(s);
                        btn5.setDisable(true);
                        btn2.setDisable(false);
                        steps++;
                    }
                    else if (btn4.getText().equals("0")){
                        btn5.setText("0");
                        btn4.setText(s);
                        btn5.setDisable(true);
                        btn4.setDisable(false);
                        steps++;
                    }
                    else if (btn6.getText().equals("0")){
                        btn5.setText("0");
                        btn6.setText(s);
                        btn5.setDisable(true);
                        btn6.setDisable(false);
                        steps++;
                    }
                    else if (btn8.getText().equals("0")){
                        btn5.setText("0");
                        btn8.setText(s);
                        btn5.setDisable(true);
                        btn8.setDisable(false);
                        steps++;
                    }
                    updateState();

                }
            }
        });
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!solve.isDisabled()){
                    String s = btn6.getText();
                    if(btn3.getText().equals("0")){
                        btn6.setText("0");
                        btn3.setText(s);
                        btn6.setDisable(true);
                        btn3.setDisable(false);
                        steps++;
                    }
                    else if (btn5.getText().equals("0")){
                        btn6.setText("0");
                        btn5.setText(s);
                        btn6.setDisable(true);
                        btn5.setDisable(false);
                        steps++;
                    }
                    else if (btn9.getText().equals("0")){
                        btn6.setText("0");
                        btn9.setText(s);
                        btn6.setDisable(true);
                        btn9.setDisable(false);
                        steps++;
                    }
                    updateState();

                }
            }
        });
        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!solve.isDisabled()){
                    String s = btn7.getText();
                    if(btn8.getText().equals("0")){
                        btn7.setText("0");
                        btn8.setText(s);
                        btn7.setDisable(true);
                        btn8.setDisable(false);
                        steps++;
                    }
                    else if (btn4.getText().equals("0")){
                        btn7.setText("0");
                        btn4.setText(s);
                        btn7.setDisable(true);
                        btn4.setDisable(false);
                        steps++;
                    }
                    updateState();

                }
            }
        });
        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!solve.isDisabled()){

                    String s = btn8.getText();
                    if(btn9.getText().equals("0")){
                        btn8.setText("0");
                        btn9.setText(s);
                        btn8.setDisable(true);
                        btn9.setDisable(false);
                        steps++;
                    }
                    else if (btn5.getText().equals("0")){
                        btn8.setText("0");
                        btn5.setText(s);
                        btn8.setDisable(true);
                        btn5.setDisable(false);
                        steps++;
                    }
                    else if (btn7.getText().equals("0")){
                        btn8.setText("0");
                        btn7.setText(s);
                        btn8.setDisable(true);
                        btn7.setDisable(false);
                        steps++;
                    }
                    updateState();

                }
            }
        });
        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!solve.isDisabled()){
                    String s = btn9.getText();
                    if(btn8.getText().equals("0")){
                        btn9.setText("0");
                        btn8.setText(s);
                        btn9.setDisable(true);
                        btn8.setDisable(false);
                        steps++;
                    }
                    else if (btn6.getText().equals("0")){
                        btn9.setText("0");
                        btn6.setText(s);
                        btn9.setDisable(true);
                        btn6.setDisable(false);
                        steps++;
                    }
                    updateState();
                }
            }
        });

        solve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int[][] start = new int[3][3];
                start[0][0] = Integer.parseInt(btn1.getText());
                start[0][1] = Integer.parseInt(btn2.getText());
                start[0][2] = Integer.parseInt(btn3.getText());
                start[1][0] = Integer.parseInt(btn4.getText());
                start[1][1] = Integer.parseInt(btn5.getText());
                start[1][2] = Integer.parseInt(btn6.getText());
                start[2][0] = Integer.parseInt(btn7.getText());
                start[2][1] = Integer.parseInt(btn8.getText());
                start[2][2] = Integer.parseInt(btn9.getText());

                currentState.puzzle = start;

                //Node startState = new Node(start,null);

                //next.setDisable(false);
                solve.setDisable(true);
                methods.setDisable(true);
                PuzzleSolver solver = new PuzzleSolver(currentState.puzzle);

                if (methods.getValue().equals("DFS")){
                    System.out.println("Solve with DFS");
                    solver.dfsSolve();
                }
                else if (methods.getValue().equals("BFS")){
                    System.out.println("Solve with BFS");
                    solver.bfsSolve();
                }
                else if (methods.getValue().equals("A*")){
                    System.out.println("Solve with A*");
                    //solver.Euclidean();
                }
                stepLable.setVisible(true);
                stepLable.setText("it took "+Integer.toString(solver.steps)+" steps with "+methods.getValue());
                btn1.setText("0");
                btn1.setDisable(true);
                btn2.setText("1");
                btn2.setDisable(false);
                btn3.setText("2");
                btn3.setDisable(false);
                btn4.setText("3");
                btn4.setDisable(false);
                btn5.setText("4");
                btn5.setDisable(false);
                btn6.setText("5");
                btn6.setDisable(false);
                btn7.setText("6");
                btn7.setDisable(false);
                btn8.setText("7");
                btn8.setDisable(false);
                btn9.setText("8");
                btn9.setDisable(false);

            }
        });

        //next.setOnAction(new EventHandler<ActionEvent>() {
        //    @Override
        //    public void handle(ActionEvent actionEvent) {
        //        i++;
        //        stepLable.setText("Step: "+ i);
        //        prev.setDisable(false);
        //    }
        //});
        //prev.setOnAction(new EventHandler<ActionEvent>() {
        //    @Override
        //    public void handle(ActionEvent actionEvent) {
        //        if (i>0){
        //            i--;
        //            stepLable.setText("Step: "+ i);
        //        }
        //        if (i==0)
        //            prev.setDisable(true);
        //    }
        //});
        //shuffle.setOnAction(new EventHandler<ActionEvent>() {
        //    @Override
        //    public void handle(ActionEvent actionEvent) {
        //        Shuffle();
        //    }
        //});

        Scene scene = new Scene(vBox,250,250);



        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void updateState(){
        int[][] start = new int[3][3];
        start[0][0] = Integer.parseInt(btn1.getText());
        start[0][1] = Integer.parseInt(btn2.getText());
        start[0][2] = Integer.parseInt(btn3.getText());
        start[1][0] = Integer.parseInt(btn4.getText());
        start[1][1] = Integer.parseInt(btn5.getText());
        start[1][2] = Integer.parseInt(btn6.getText());
        start[2][0] = Integer.parseInt(btn7.getText());
        start[2][1] = Integer.parseInt(btn8.getText());
        start[2][2] = Integer.parseInt(btn9.getText());
        currentState.puzzle = start;


        //currentState.printState();

    }

    public void Shuffle(){
        steps=0;
        Integer[] state = {1,2,3,4,5,6,7,8,0};
        List<Integer> list = Arrays.asList(state);
        Collections.shuffle(list);
        list.toArray(state);
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        btn8.setDisable(false);
        btn9.setDisable(false);
        btn1.setText(Integer.toString(state[0]));
        if (state[0]==0)
            btn1.setDisable(true);
        btn2.setText(Integer.toString(state[1]));
        if (state[1]==0)
            btn2.setDisable(true);
        btn3.setText(Integer.toString(state[2]));
        if (state[2]==0)
            btn3.setDisable(true);
        btn4.setText(Integer.toString(state[3]));
        if (state[3]==0)
            btn4.setDisable(true);
        btn5.setText(Integer.toString(state[4]));
        if (state[4]==0)
            btn5.setDisable(true);
        btn6.setText(Integer.toString(state[5]));
        if (state[5]==0)
            btn6.setDisable(true);
        btn7.setText(Integer.toString(state[6]));
        if (state[6]==0)
            btn7.setDisable(true);
        btn8.setText(Integer.toString(state[7]));
        if (state[7]==0)
            btn8.setDisable(true);
        btn9.setText(Integer.toString(state[8]));
        if (state[8]==0)
            btn9.setDisable(true);
    }
}
