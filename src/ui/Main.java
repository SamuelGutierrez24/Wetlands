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
				"(4) add event to a wetland\n" + 
				"(5) Wetlands maintance in a year\n" +
				"(6) wetland with minous quantity of flora species\n" +
				"(7) Wetlands of a Specie\n" +
				"(8) Wetlands information\n" +
				"(9) Wetland with most fauna species\n" +
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
			createEvent();;
			break;
		case 5 :
			maintanceInAyear();
			break;
		case 6 :
			wetlandLessflora();
			break;
		case 7 :
			wetlandsOfSpecie();
			break;
		case 8 :
			wetlandsInfo();
			break;
		case 9 :
			mostFauna();
			break;
		default:
			System.out.println("invalid option");
		
		}
	}	

		/**This method is the regist for get the info to create a wetland
	  */
		public void createWetland(){
			
			boolean realLocation = true;
			boolean realType = true;
			boolean repeatedWet = false;
		
			String name;
			System.out.println("Welcome!" + "\n fot the regist of a new wetland please insert the wetland name: ");
			name = sc.nextLine();
			sc.nextLine();
			repeatedWet = dagma.sameWetland(name);
			
			if(repeatedWet == false){

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

						double ambientalPlan;
						System.out.println("Input the percentage of the ambiental plan of the wetland (If the wetland hasn't a ambiental plan please insert 0):");
						ambientalPlan = sc.nextDouble();
						sc.nextLine();
						System.out.println(dagma.addWetland(name,zone,type,length,url,status,ambientalPlan));
			
					}else{
					System.out.println("ERROR, you don't select a correct type");
					}

				}else{
				System.out.println("ERROR, you don't select a correct location");
				}
			}else{
				System.out.println("This wetland is already regist");
			}
		}
		/**This method recives the information necesarry for add a specie to a wetland.
	  */
		public void addSpecietoWetland(){
			
			int specie;
			System.out.println("For regist a specie in Wetland. \n Select the number of a regist Specie or 0 if the Specie is not registed" );
			System.out.println(dagma.showRegistedSpecies());
			specie = sc.nextInt();
			sc.nextLine();
			if(specie != 0){
			
				if (dagma.specieExist(specie)){
					
					int wetName;
					System.out.println("Input the number of the wetland");
					System.out.println(dagma.showRegistedWetlands());
					wetName = sc.nextInt();
					sc.nextLine();
					if(dagma.wetlandExist(wetName) == true){
						System.out.println(dagma.registeSpecie2Wetland(wetName,specie));
						System.out.println("The specie was added :)");
					}
				}else{
					System.out.println("ERROR, the specie you select doesn't exist, please restar");
				}
			}else{
				createNewSpecie();
			}
		}
		/**This method is the regist for get the info to create a new specie
	  */
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

			int type;
			System.out.println("Input the atribute types of the specie: \n" +
			"(1) Aquatic flora \n" +
			"(2) Land flora \n" + 
			"(3) Bird \n" +
			"(4) Mammal \n" +
			"(5) Aquatic");
			type = sc.nextInt();
			sc.nextLine();

			System.out.println(dagma.addSpecie(sType, name, scientific, mygratory,type));
			addSpecietoWetland();

			}else{
			System.out.println("This specie is already registed.");
				}
			}else{
				System.out.println("ERORR, the selection of the specie type was incorrect, please try again.");
			}

		}
		
		/**This method is the regist for get the info to create a event and add it to aa wetland
	  */
	public void createEvent(){

		System.out.println("Before regist de event we need to create it,");
		
		int typeEvent;
		System.out.println("Input the type of the event :");
		System.out.println("(1) Maintance \n "+
		"(2) School visit \n " +
		"(3) Activity \n" +
		"(4) Celebration");
		typeEvent = sc.nextInt();
		sc.nextLine();

		String boss;
		System.out.println("Name of the boss of the event");
		boss = sc.nextLine();

		int d, m, y;
		System.out.println("Date of the event, \n" +
		"first the day :");
		d = sc.nextInt();
		sc.nextLine();
		System.out.println("Second the mounth:");
		m = sc.nextInt();
		sc.nextLine();
		System.out.println("Third the year:");
		y = sc.nextInt();
		sc.nextLine();

		double cost;
		System.out.println("How much will be the cost of it? :");
		cost = sc.nextDouble();
		sc.nextLine();

		String desc;
		System.out.println("Finally, give a small description of the event:");
		desc = sc.nextLine();
		sc.nextLine();

		int wetland;
		System.out.println("For finish, please select the name of the wetland in wich the event will take place");
		System.out.println(dagma.showRegistedWetlands());
		wetland = sc.nextInt();
		sc.nextLine();

		if(dagma.wetlandExist(wetland)){

		System.out.println(dagma.createEvent(typeEvent, boss, d, m, y, cost, desc,wetland));
		}else{
			System.out.println("ERROR, the wetland you select doesn't exist");
		}
	}
	/**This method recives the year for calculate in all wetlands the events maintance in that year and show in screen.
	  */
	public void maintanceInAyear(){

		int year;
		System.out.println("Give a specific year for search maintance.");
		year = sc.nextInt();
		sc.nextLine();

		System.out.println(dagma.wetlandsMaintance(year));
	}
	
	/**This method show the wetland with less flora in all wetlands.
	  */
	public void wetlandLessflora(){

		System.out.println(dagma.lessFloraWetland());

	}
	/**This method show all the habitats(wetlands) of a specific specie is give of the user.
	  */
	public void wetlandsOfSpecie(){

		int specieNum;
		System.out.println("Digit the Number of the specie: \n" +
		dagma.showRegistedSpecies());
		specieNum = sc.nextInt();
		sc.nextLine();
		if(dagma.specieExist(specieNum)){
			System.out.println(dagma.wetlandsOfASpecie(specieNum));
		}
	}
	/**This method show all the information registered in all wetlands.
	  */
	public void wetlandsInfo(){

		System.out.println(dagma.infoWetlands());

	}
	/**This method show the name of the wetland with most fauna Species.
	  */
	public void mostFauna(){

		System.out.println(dagma.wetlandMostFauna());

	}
	
}