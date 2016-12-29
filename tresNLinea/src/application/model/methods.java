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
				cpu();
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
				cpu();
			} else {
				torn.setText("X");
				cpu2();
			}
		}

	}

	public void fin() {
		if ((boton1.getText() == "X" && boton2.getText() == "X" && boton3.getText() == "X")
				|| (boton1.getText() == "O" && boton2.getText() == "O" && boton3.getText() == "O")) {
			torn.setText("FINALIZADO");
			// CAMBIAR EL COLOR DEL TEXTO
			disableButtons();
		} else if ((boton4.getText() == "X" && boton5.getText() == "X" && boton6.getText() == "X")
				|| (boton4.getText() == "O" && boton5.getText() == "O" && boton6.getText() == "O")) {
			torn.setText("FINALIZADO");

			disableButtons();
		} else if ((boton7.getText() == "X" && boton8.getText() == "X" && boton8.getText() == "X")
				|| (boton7.getText() == "O" && boton8.getText() == "O" && boton9.getText() == "O")) {
			torn.setText("FINALIZADO");

			disableButtons();
		} else if ((boton1.getText() == "X" && boton5.getText() == "X" && boton9.getText() == "X")
				|| (boton1.getText() == "O" && boton5.getText() == "O" && boton9.getText() == "O")) {
			torn.setText("FINALIZADO");

			disableButtons();
		} else if ((boton3.getText() == "X" && boton5.getText() == "X" && boton7.getText() == "X")
				|| (boton3.getText() == "O" && boton5.getText() == "O" && boton7.getText() == "O")) {
			torn.setText("FINALIZADO");

			disableButtons();
		} else if ((boton1.getText() == "X" && boton4.getText() == "X" && boton7.getText() == "X")
				|| (boton1.getText() == "O" && boton4.getText() == "O" && boton7.getText() == "O")) {
			torn.setText("FINALIZADO");
			disableButtons();
		} else if ((boton2.getText() == "X" && boton5.getText() == "X" && boton8.getText() == "X")
				|| (boton2.getText() == "O" && boton5.getText() == "O" && boton8.getText() == "O")) {
			torn.setText("FINALIZADO");
			disableButtons();
		} else if ((boton3.getText() == "X" && boton6.getText() == "X" && boton9.getText() == "X")
				|| (boton3.getText() == "O" && boton6.getText() == "O" && boton9.getText() == "O")) {
			torn.setText("FINALIZADO");
			disableButtons();
		} else if ((boton1.getText() != "") && (boton2.getText() != "") && (boton3.getText() != "")
				&& (boton4.getText() != "") && (boton5.getText() != "") && (boton6.getText() != "")
				&& (boton7.getText() != "") && (boton8.getText() != "") && (boton9.getText() != "")) {
			torn.setText("EMPATE");
			disableButtons();
		}
	}

	public void cpu() {
		int botonRandom = (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);

		switch (botonRandom) {
		case 1:
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton1.getText() == "") {
						System.out.println("boton1");
						boton1.setText("O");
						canviTorn();
						fin();
					} else {
						fin();
						cpu();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 2:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton2.getText() == "") {
						System.out.println("boton2");
						boton2.setText("O");
						canviTorn();
						fin();
					} else {
						fin();
						cpu();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 3:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton3.getText() == "") {
						System.out.println("boton3");
						boton3.setText("O");
						canviTorn();
						fin();
					} else {
						fin();
						cpu();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 4:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton4.getText() == "") {
						System.out.println("boton4");
						boton4.setText("O");
						canviTorn();
						fin();
					} else {
						fin();
						cpu();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 5:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton5.getText() == "") {
						System.out.println("boton5");
						boton5.setText("O");
						canviTorn();
						fin();
					} else {
						cpu();
						fin();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 6:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton6.getText() == "") {
						System.out.println("boton6");
						boton6.setText("O");
						canviTorn();
						fin();
					} else {
						fin();
						cpu();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 7:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton7.getText() == "") {
						System.out.println("boton7");
						boton7.setText("O");
						canviTorn();
						fin();
					} else {
						fin();
						cpu();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 8:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton8.getText() == "") {
						System.out.println("boton8");
						boton8.setText("O");
						canviTorn();
						fin();
					} else {
						fin();
						cpu();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 9:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton9.getText() == "") {
						System.out.println("boton9");
						boton9.setText("O");
						canviTorn();
						fin();
					} else {
						fin();
						cpu();
					}
				}
			} catch (Exception e) {
			}
			break;
		default:
			break;
		}

	}

	public void cpu2() {
		int botonRandom = (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);
		System.out.println(botonRandom);

		switch (botonRandom) {
		case 1:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton1.getText() == "") {
						System.out.println("boton1");
						boton1.setText("X");
						canviTorn();
						fin();
					} else {
						fin();
						cpu2();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 2:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton2.getText() == "") {
						System.out.println("boton2");
						boton2.setText("X");
						canviTorn();
						fin();
					} else {
						fin();
						cpu2();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 3:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton3.getText() == "") {
						System.out.println("boton3");
						boton3.setText("X");
						canviTorn();
						fin();
					} else {
						fin();
						cpu2();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 4:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton4.getText() == "") {
						System.out.println("boton4");
						boton4.setText("X");
						canviTorn();
						fin();
					} else {
						fin();
						cpu2();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 5:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton5.getText() == "") {
						System.out.println("boton5");
						boton5.setText("X");
						canviTorn();
						fin();
					} else {
						fin();
						cpu2();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 6:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton6.getText() == "") {
						System.out.println("boton6");
						boton6.setText("X");
						canviTorn();
						fin();
					} else {
						fin();
						cpu2();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 7:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton7.getText() == "") {
						System.out.println("boton7");
						boton7.setText("X");
						canviTorn();
						fin();
					} else {
						fin();
						cpu2();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 8:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton8.getText() == "") {
						System.out.println("boton8");
						boton8.setText("X");
						canviTorn();
						fin();
					} else {
						fin();
						cpu2();
					}
				}

			} catch (Exception e) {
			}
			break;
		case 9:
			System.out.println("Fuera del if");
			try {
				if ((torn.getText() != "EMPATE") || (torn.getText() != "FINALIZADO")) {
					if (boton9.getText() == "") {
						System.out.println("boton9");
						boton9.setText("X");
						canviTorn();
						fin();
					} else {
						fin();
						cpu2();
					}
				}

			} catch (Exception e) {
			}
			break;
		default:
			break;
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

	}
	
	public void cases(Button boton){
		//tengo que meter los cases y generalizarlo mas, mirate la foto que paso manel
	}

}
