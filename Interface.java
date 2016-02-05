package snmppack;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Scanner;

public class Interface {
	
	private Scanner scan;

	public Interface(){
		
	}
	
   /**
	 * Initialisation du Manager et de l'Agent
   * @return La valeur du choix de l'utilisateur
	 */
        
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
        
        
	 /**
	 * Affichage du menu principal
   * @return La valeur du choix de l'utilisateur
	 */
	public int menuPrinc(){
		scan = new Scanner(System.in);
		int valChoix;
		do{
			System.out.println("------- Menu principal ---------");
			System.out.println("\n\n Veuillez faire votre selection au clavier");
			System.out.println("\n1. Ajouter un agent ");
			System.out.println("\n2. Supprimer un agent");
                        System.out.println("\n3. Requete Get");
                        System.out.println("\n4. Requete Set");
			System.out.println("\n\n0. Quitter le programme");
			valChoix = scan.nextInt();
		}while(valChoix != 1 && valChoix !=2 && valChoix !=3 && valChoix !=4 && valChoix!= 0);
		
		return valChoix;
	}
        
   /**
	 * Affichage de la reponse à la requete
	 * @param rep reponse envoyee
   * @return La reponse a la requete
	 */
	public void affRep(String rep) {
            System.out.println(rep);
        }
        
        
   /**
	 * Affichage du menu permettant de supprimer un agent 
   * @return l'ID de l'agent à supprimer
	 */
	public String menuSuppr() {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("------- Supprimer un agent ---------");
            System.out.println("\n\n Entrez l'ID de l'agent à supprimer");
            
            String idA = sc.nextLine();
            
            return idA;
        }
        
        
   /**
	 * Affichage du menu permettant d'ajouter un agent
   * @return l'adresse IP de l'agent + le port de l'agent
   * @throws java.net.UnknownHostException
	 */
	public Hashtable menuAjout() throws UnknownHostException {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("------- Ajouter un agent ---------");
            System.out.println("\n\n Entrez l'adresse IP de l'agent");
            
            String ipStr = sc.nextLine();
            InetAddress ipA = InetAddress.getByName(ipStr);
            
            System.out.println("\n Entrez le numéro de port de l'agent");
            
            sc.nextLine();
            int portA = sc.nextInt();
            
            Hashtable propA = new Hashtable();
            propA.put(1, ipA);
            propA.put(2, portA);
            
            return propA;
        }
        
        
   /**
	 * Choix de la requete
   * @return l'ID de l'agent + la requete
	 */
        public Hashtable choixReq() {
            Scanner sc = new Scanner(System.in);
            int choix; 
            do{
                System.out.println("------- Choix de la requete ---------");
                System.out.println("\n\n Veuillez faire votre selection au clavier");
                System.out.println("\n 1. Requete Get");
                System.out.println("\n 2. Requete Set");
                System.out.println("\n\n 0. Quitter le programme");

                choix = sc.nextInt();
            }while(choix != 1 && choix !=2 && choix!= 0);
            
            int req = choix;
            
            System.out.println("\n\n Entrez l'ID de l'agent");
            sc.nextLine();
            int idA = sc.nextInt();
            
            Hashtable reqIdA = new Hashtable();
            reqIdA.put(1, req);
            reqIdA.put(2, idA);
            
            return reqIdA;
            
        }
        
        
}
