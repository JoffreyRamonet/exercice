package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Diagram;
import model.Point;

public class Prompt {

	Scanner scanner = new Scanner(System.in);
	Diagram diagram = new Diagram(new ArrayList<Point>());

	public void launch() throws Exception {
		
		System.out.println("Voulez vous afficher le diagram actuel? O/N");
		String response = scanner.nextLine();

		switch (response.toUpperCase()) {
		case "O":
			diagram.generateDiagram();
			Reader.read();
			pointRegister();
		case "N":
			pointRegister();
		default:
			System.out.println("Veuillez répondre par O pour oui ou N pour non.");
			launch();
		}
	}

	private void pointRegister() throws Exception {
		System.out.println("Voulez vous enregistrer un nouveau point? O/N");
		String response = scanner.nextLine();

		switch (response.toUpperCase()) {
		case "O":
			getPoint();
			pointRegister();
		case "N":
			System.out.println("Si vous ne voulez ni enregistrer de points ni afficher le diagramme, que voulez vous?");
			launch();
		default:
			System.out.println("Veuillez répondre par O pour oui ou N pour non.");
			pointRegister();
		}
	}

	private void getPoint() throws Exception {
		System.out.println("Entrez l'abscisse et l'ordonné, séparé d'une virgule: ");
		String response = scanner.nextLine();
		
		String regexp = "^-?[0-9],-?[0-9]$";
		
		if(!response.matches(regexp)) {
			System.out.println("Je n'ai pas compris..");
			getPoint();
		} else {
			diagram.addPoint(response);
			launch();
		}
	}
}
