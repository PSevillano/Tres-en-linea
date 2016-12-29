package application.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class methods {

	@FXML
	private Button boton1;
	@FXML
	private Button boton2;
	@FXML
	private Button boton3;
	@FXML
	private Button boton4;
	@FXML
	private Button boton5;
	@FXML
	private Button boton6;
	@FXML
	private Button boton7;
	@FXML
	private Button boton8;
	@FXML
	private Button boton9;

	@FXML
	private RadioButton cvc;
	@FXML
	private RadioButton hvh;
	@FXML
	private RadioButton hvc;

	@FXML
	private Label torn;
	
	private boolean fin=false;

	@FXML
	protected void start(ActionEvent event) {

		boolean turno = turno();
		init();

		if (hvh.isSelected()) {
			if (turno) {
				torn.setText("X");
				turno = true;
			} else {
				torn.setText("O");
				turno = false;
			}
		} else if (hvc.isSelected()) {
			if (turno) {
				torn.setText("X");
				turno = true;
			} else {
				torn.setText("O");
				cpu();
				turno = false;
			}
		} else if (cvc.isSelected()) {
			if (turno) {
				torn.setText("X");
				cpu2();
				turno = true;
			} else {
				torn.setText("O");
				cpu2();
				turno = false;
			}

		}

	}

	@FXML
	protected void b1(ActionEvent event) {
		boton(boton1);
	}

	@FXML
	protected void b2(ActionEvent event) {
		boton(boton2);
	}

	@FXML
	protected void b3(ActionEvent event) {
		boton(boton3);
	}

	@FXML
	protected void b4(ActionEvent event) {
		boton(boton4);
	}

	@FXML
	protected void b5(ActionEvent event) {
		boton(boton5);
	}

	@FXML
	protected void b6(ActionEvent event) {
		boton(boton6);
	}

	@FXML
	protected void b7(ActionEvent event) {
		boton(boton7);
	}

	@FXML
	protected void b8(ActionEvent event) {
		boton(boton8);
	}

	@FXML
	protected void b9(ActionEvent event) {
		boton(boton9);
	}

	public boolean turno() {

		int numeroAleatorio = (int) (Math.random() * (1 - 0 + 1)) + 0;
		if (numeroAleatorio == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void boton(Button boton) {
		if (torn.getText() == "X") {
			boton.setText("X");
			canviTorn();
			fin();
		} else {
			boton.setText("O");
			canviTorn();
			fin();
		}
	}

	public void canviTorn() {
		if (hvh.isSelected()) {
			if (torn.getText() == "X") {
				torn.setText("O");
			} else {
				torn.setText("X");
			}
		} else if (hvc.isSelected()) {
			if (torn.getText() == "X") {
				torn.setText("O");
				cpu();
			} else {
				torn.setText("X");
			}
		} else if (cvc.isSelected()) {
			if (torn.getText() == "X") {
				torn.setText("O");
				cpu2();
			} else {
				torn.setText("X");
				cpu2();
			}
		}

	}

	public void fin() {
		if ((boton1.getText() == "X" && boton2.getText() == "X" && boton3.getText() == "X")
				|| (boton1.getText() == "O" && boton2.getText() == "O" && boton3.getText() == "O")) {
			condicion(boton1,boton2,boton3);
		} else if ((boton4.getText() == "X" && boton5.getText() == "X" && boton6.getText() == "X")
				|| (boton4.getText() == "O" && boton5.getText() == "O" && boton6.getText() == "O")) {
			condicion(boton4,boton5,boton6);
		} else if ((boton7.getText() == "X" && boton8.getText() == "X" && boton8.getText() == "X")
				|| (boton7.getText() == "O" && boton8.getText() == "O" && boton9.getText() == "O")) {
			condicion(boton7,boton8,boton9);
		} else if ((boton1.getText() == "X" && boton5.getText() == "X" && boton9.getText() == "X")
				|| (boton1.getText() == "O" && boton5.getText() == "O" && boton9.getText() == "O")) {
			condicion(boton1,boton5,boton9);
		} else if ((boton3.getText() == "X" && boton5.getText() == "X" && boton7.getText() == "X")
				|| (boton3.getText() == "O" && boton5.getText() == "O" && boton7.getText() == "O")) {
			condicion(boton3,boton5,boton9);
		} else if ((boton1.getText() == "X" && boton4.getText() == "X" && boton7.getText() == "X")
				|| (boton1.getText() == "O" && boton4.getText() == "O" && boton7.getText() == "O")) {
			condicion(boton1,boton4,boton7);
		} else if ((boton2.getText() == "X" && boton5.getText() == "X" && boton8.getText() == "X")
				|| (boton2.getText() == "O" && boton5.getText() == "O" && boton8.getText() == "O")) {
			condicion(boton2,boton5,boton8);
		} else if ((boton3.getText() == "X" && boton6.getText() == "X" && boton9.getText() == "X")
				|| (boton3.getText() == "O" && boton6.getText() == "O" && boton9.getText() == "O")) {
			condicion(boton3,boton6,boton9);
		} else if ((boton1.getText() != "") && (boton2.getText() != "") && (boton3.getText() != "")
				&& (boton4.getText() != "") && (boton5.getText() != "") && (boton6.getText() != "")
				&& (boton7.getText() != "") && (boton8.getText() != "") && (boton9.getText() != "")) {
			torn.setText("EMPATE");
			fin=true;
			disableButtons();
		}
	}

	public void cpu() {
		int botonRandom = (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);

		switch (botonRandom) {
		case 1:
			casesO(boton1);
			break;
		case 2:
			casesO(boton2);
			break;
		case 3:
			casesO(boton3);
			break;
		case 4:
			casesO(boton4);
			break;
		case 5:
			casesO(boton5);
			break;
		case 6:
			casesO(boton6);
			break;
		case 7:
			casesO(boton7);
			break;
		case 8:
			casesO(boton8);
			break;
		case 9:
			casesO(boton9);
			
			break;
		default:
			break;
		}

	}

	public void cpu2() {
	 
	 while(fin!=true){
	 
	  int botonRandom = (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);

		switch (botonRandom) {
		case 1:
			casesX(boton1);
			break;
		case 2:
			casesX(boton2);
			break;
		case 3:
			casesX(boton3);
			break;
		case 4:
			casesX(boton4);
			break;
		case 5:
			casesX(boton5);
			break;
		case 6:
			casesX(boton6);
			break;
		case 7:
			casesX(boton7);
			break;
		case 8:
			casesX(boton8);
			break;
		case 9:
			casesX(boton9);
			
			break;
		default:
			break;
		}
	  }
		

	}

	public void disableButtons() {
		boton1.setDisable(true);
		boton2.setDisable(true);
		boton3.setDisable(true);
		boton4.setDisable(true);
		boton5.setDisable(true);
		boton6.setDisable(true);
		boton7.setDisable(true);
		boton8.setDisable(true);
		boton9.setDisable(true);

	}

	public void init() {
		boton1.setDisable(false);
		boton2.setDisable(false);
		boton3.setDisable(false);
		boton4.setDisable(false);
		boton5.setDisable(false);
		boton6.setDisable(false);
		boton7.setDisable(false);
		boton8.setDisable(false);
		boton9.setDisable(false);
		boton1.setText("");
		boton2.setText("");
		boton3.setText("");
		boton4.setText("");
		boton5.setText("");
		boton6.setText("");
		boton7.setText("");
		boton8.setText("");
		boton9.setText("");
		fin=false;

	}
	
	public void casesX(Button boton){
		//tengo que meter los cases y generalizarlo mas, mirate la foto que paso manel
		try {
				if (boton.getText() == "") {
					boton.setText(torn.getText());
					canviTorn();
					fin();
				} else {
					fin();
					cpu2();
				}
			

		} catch (Exception e) {
		}
	}
	
	public void casesO(Button boton){
		//tengo que meter los cases y generalizarlo mas, mirate la foto que paso manel
		try {
			if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO") || (fin==true)) {
				if (boton.getText() == "") {
					fin();
					boton.setText("O");
					canviTorn();
				} else {
					fin();
					cpu();
				}
			}

		} catch (Exception e) {
		}
	}
	
	public void condicion(Button b1,Button b2, Button b3){
		System.out.println(b1.getText());
		if(b1.getText() == "X" && b2.getText() == "X" && b3.getText() == "X"){
			fin=true;
			disableButtons();
			torn.setText("HAN GANADO LAS X");
			
		}else{
			fin=true;
			disableButtons();
			torn.setText("HAN GANADO LAS O");
			
		}
	}

}
