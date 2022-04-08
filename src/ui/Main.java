package ui;

import model.Dagma;
import java.util.Scanner;

public class Main{
	
	private Dagma dagma;
	private Scanner sc;
	
	public Main(){
		
		dagma= new Dagma();
		sc= new Scanner(System.in);
		
		
	}
	
	public static void main(String [] args) {
		
	Main ppal = new Main();
	
	int option = 0;
	
	do{
		option = ppal.Menu();
		ppal.Operation(option);
		
	}while(option!=0);

		
	}
	
	public int Menu(){
		int option = 0;
		
		System.out.println(
			"Selec an option: \n" +
				"(1) Create a wetland \n" +
				"(2) create a new Specie\n"+
				"(3) Regist a specie to wetland \n"+
				"(4) information about the maintance of a wetland\n" + 
				"(5) wetland with minous quantity of flora species\n" +
				"(6) show the wetlands in which live a specificc specie\n" +
				"(7) Wetlands information\n" +
				"(8) Wetland with most fauna species\n" +
				"(0) Para salir"
		);
		option= sc.nextInt();
		sc.nextLine();
		return option;
		
	}
	
	public void Operation(int op){
		
			switch(op) {
		case 0:
			System.out.println("see you next time!");
			break;
		case 1:
			createWetland() ;
			break;
		case 2:
			createNewSpecie();
			break;
	
		case 3:
			addSpecietoWetland();
			break;

		case 4:
			System.out.println("No hay nada");
			break;
		
		default:
			System.out.println("invalid option");
		
		}
	}	
		
		public void createWetland(){
			
			boolean realLocation = true;
			boolean realType = true;
			String name;
			System.out.println("Welcome!" + "\n fot the regist of a new wetland please insert the wetland name: ");
			name = sc.nextLine();
			sc.nextLine();

			int zone;
			System.out.println("location of the wetland : \n " +
			"(1) urban. \n" +
			"(2) rural");
			zone = sc.nextInt();
			sc.nextLine();
			
			realLocation = dagma.verifyLocation(zone);
			if(realLocation==true){
			
			int type;
			System.out.println("Is the wetland private or public? : \n" +
			"(1) Private\n" +
			"(2) Public");
			type = sc.nextInt();
			sc.nextLine();
			
			realType = dagma.verifyType(type);
			if(realType == true){

			int length;
			System.out.println(" length of the wetland in square kilometers:  ");
			length = sc.nextInt();
			sc.nextLine();
			
			String url;
			System.out.println(" Please insert the URL wetland Photo: ");
			url = sc.nextLine();
			sc.nextLine();
			
			boolean status;
			System.out.println("Is the wetland declarete as a protected zone? (true or false):");
			status = sc.nextBoolean();
			sc.nextLine();
			
			dagma.addWetland(name,zone,type,length,url,status);
			
			}else{
				System.out.println("ERROR, you don't select a correct type");
			}

			}else{
				System.out.println("ERROR, you don't select a correct location");
			}
		}
		
		public void addSpecietoWetland(){
		
			
			
			
		}

		public void createNewSpecie(){

		boolean SpecieType = true;
		boolean sameSpecie = false;

		System.out.println("For create a new specie please do the next regist");

		int sType;
		System.out.println("Select the Specie type: \n" +
		"(1) flora \n" +
		"(2) fauna");
		sType = sc.nextInt();
		sc.nextLine();

		SpecieType = dagma.verifyType(sType);

		if(SpecieType == true){
		
		String name;
		System.out.println("Input the name of the specie:");
		name = sc.nextLine();
		sc.nextLine();
		
		sameSpecie = dagma.sameSpecie(name);
		if(sameSpecie == false){
		
		String scientific;
		System.out.println("Input the scientific name of the specie:");
		scientific = sc.nextLine();
		sc.nextLine();

		boolean mygratory;
		System.out.println("Is the specie mygratory? (true or false)");
		mygratory = sc.nextBoolean();
		sc.nextLine();

		String type;
		System.out.println("Input the atribute types of the specie: (Example: terrester, acuatic.)");
		type = sc.nextLine();
		sc.nextLine();

		dagma.addSpecie(sType, name, scientific, mygratory,type);

		}else{
			System.out.println("This specie is already registed.");
		}
		}else{
			System.out.println("ERORR, the selection of the specie type was incorrect, please try again.");
		}

		}
		
		
		
	
}