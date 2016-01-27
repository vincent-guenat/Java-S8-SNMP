package snmppack;

import java.util.Scanner;

public class Interface {
	
	private Scanner scan;

	public Interface(){
		
	}
	
	public int choixInit(){
		scan = new Scanner(System.in);
		int choix;
		do{
			System.out.println("------- Bienvenu sur SNMP ---------");
			System.out.println("\n\n Veuillez faire votre selection au clavier (1-2)");
			System.out.println("\n1. Ouverture de l'agent ");
			System.out.println("\n2. Ouverture du manager");
			System.out.println("\n\n0. Quitter le programme");
			choix = scan.nextInt();
		}while(choix != 1 && choix !=2 && choix!= 0);
		
		return choix;
	}
	
	
	
}
