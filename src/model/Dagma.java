package model;
import java.util.Scanner;

	
	/**
	* Descripción: This class is the main system of the dagma company, so in this one we ejecute  all the actions
	* <b> pre:</b> the global variables are the other class that need to be already create and in function
	*/
	public class Dagma {
		  
		  Scanner sc = new Scanner (System.in);
		  
		  /**Variable: wetlands array
	this is the array that saves every wetland create*/
		  private Wetland [] wetlands;
		  /**Variable: Specie array
	this is the array that saves every Specie in all wetlands*/
			private Specie [] allSpecies;
			 /**Variable: MAX_WETLANDS int
	is the constat of the max wetlands can be registered*/
			public static final int MAX_WETLANDS = 80;
			 /**Variable: MAX_SPECIES int
	this is the constant of maximum species can be registered*/
			public static final int MAX_SPECIES = 200;
 		/**Variable: registedSpecies int
	this is the global variable that count the registered species*/
			public int registedSpecies = 0;
		/**Variable: registedWetlands int
	this is the global variable that count the registered Wetlands*/
			public int registedWetlands = 0;
		
		public Dagma (){
			
			wetlands = new Wetland[MAX_WETLANDS];
			allSpecies = new Specie[MAX_SPECIES];
			
		}
		
		/**This method verified if in the array of wetlands is space to registered more 
	 	*@retunr a boolean that confirm if is space.
		  */
		public boolean hasSpace(){
			boolean emptyPosition = false;
			
			for(int i = 0; i<MAX_WETLANDS && !emptyPosition;i++){
			
				if(wetlands[i] == null){
					emptyPosition = true;
				}
			}
			return emptyPosition;
		}
		/**This method search a wetlands array space in with we will save a new wetland
	 * @return return a int that is the position we need. 
	  */
		public int wetlandSpace(){
			int position = -1;
			if (hasSpace() != false){
				
				for(int i = 0 ; i<MAX_WETLANDS && position==-1;i++){
					if(wetlands[i]==null){
						position = i;
					}
				}
				
			}
			
			return position;
		}
		/**This method ask if is a wetland already create with that name.
	 *@return a boolean to confirm is a wetland with that name
	 *@param name is the name of the wetland is going to  be registered.
	  */
		public boolean sameWetland(String name){
			
			boolean repeated = false;

			for(int i = 0; i<MAX_WETLANDS;i++){
				
				if(wetlands[i] != null){
					if(wetlands[i].getName().equals(name)){
					repeated = true;
					}
				}			
			}
			return repeated;
		}
		/**This method creates an object wetland and save him to the array of wetlands
	 * @return a string for confirm is added.
	 * @param name,zone,type,length,url,status,ambientalplan those params are the information need to create a new wetland.
	  */
		public String addWetland(String name,int zone, int type, int length,String url, Boolean status, double ambientalPlan ){
			
			Location local = null;
		
			switch(zone){
			case 1 :
			local = Location.URBAN;
			break;
			case 2 :
			local = Location.RURAL;
			break;
			}

			Type tipo = null;

			switch(type){
			case 1 :
			tipo = Type.PRIVATE;
			break;
			case 2 :
			tipo= Type.PUBLIC;
			break;
			}
			String out = "";
			
			int position = wetlandSpace();
			if (position == -1) {
			
			out = "We already regist all wetlands in our system";
			
		}else{
			
			wetlands[position] = new Wetland (name, local, tipo, length, url, status, ambientalPlan);
			
			out = "The wetland has been registed ";
			registedWetlands += 1;
		}
		
			return out;
				
		}

		/**This method verify that the user put a valid option of location.
		 * @return a boolean for confirm is valid.
	  */
		public boolean verifyLocation(int num){

			boolean out = false;
			if(num == 1 || num ==2){
				out = true;
			}
			 return out;
		}
		/**This method verify that the user put a valid option of type.
	 * @return a boolean for confirm is valid.
	  */
		public boolean verifyType(int num){

			boolean out = false;
			if(num == 1 || num ==2){
				out = true;
			}
			 return out;
		}
		//-----------------------------------------------------------------

		/**This method ask if is a specie already create with that name.
	 *@return a boolean to confirm is a specie with that name
	 *@param name is the name of the specie is going to  be registered.
	  */
		public boolean sameSpecie(String name){
			
			boolean repeated = false;
		for(int i = 0; i<MAX_SPECIES ;i++){
			
			if(allSpecies[i].getName().equals(name)){
				repeated = true;
			}
			
		}
		return repeated;
		
		}
		
		/**This method search in specie array a space in with we will save a new specie
	 * @return return a int that is the position we need. 
	  */
		public int specieSpace(){
			
			int position = -1;
				
				for(int i = 0 ; i<MAX_SPECIES && position==-1;i++){
					if(allSpecies[i]==null){
						position = i;
					}
				}
				
			
			
			return position;
		}

		/**This method creates an object specie and save him to the array of species
	 * @return a string for confirm is added.
	 * @param type,name,scientificname,mygratory,characterType are what we need to create a specie.
	  */
		public String addSpecie (int type, String name, String scientificName, boolean mygratory, int characterType){

			SpecieType realType = null;
			switch(type){
				case 1 :
				realType = SpecieType.FLORA;
				break;
				case 2 :
				realType = SpecieType.FAUNA;
				break;
				}
			
			SpecieSpecificType SpecificType = null;

			switch(characterType){
				case 1 :
				SpecificType = SpecieSpecificType.AQUATIC_FLORA;
				break;
				case 2 :
				SpecificType = SpecieSpecificType.LAND_FLORA;
				break;
				case 3 :
				SpecificType = SpecieSpecificType.BIRD;
				break;
				case 4 :
				SpecificType = SpecieSpecificType.MAMMAL;
				break;
				case 5 :
				SpecificType = SpecieSpecificType.AQUATIC;
				break;
				}
			
			String out = "";

			int position = specieSpace();
			if (position == -1) {
			
			out = "We already regist the maximum species in our system";
			
		}else{
			
			allSpecies[position] = new Specie (realType,name,scientificName,mygratory,SpecificType);
			registedSpecies +=1;
			out = "The specie has been registed ";
		}
		
			return out;

		}

		/**This show a list of the regitered species
	 * @return a string of the lis.
	  */
		public String showRegistedSpecies(){
			
			String out = "";

			for(int i = 0;i<MAX_SPECIES;i++){

				if(allSpecies[i] != null){
					out += "(" + (i+1) + ")" + " " + allSpecies[i].getName() + "\n";
				}
			}
			
			return out;
		}

		public boolean specieExist(int num){
			boolean out = false;

			if(num<=registedSpecies && num>0){
				out = true;
			}
			return out;
		}
		/**This method add a specie to a wetland.
	 * @return a string to confirm was added correctly.
	 * @param wetlandName,specie are the specie to add and the wetland will m¿be added.
	  */
		public String registeSpecie2Wetland(int wetlandName, int specie){

			String out = "";
			
			if(!wetlands[wetlandName - 1].alreadyRegistedSpecie(allSpecies[specie-1])){
			
			wetlands[wetlandName - 1].addSpecie2Wetland(allSpecies[specie-1]);
			allSpecies[specie-1].addWetland2Specie(wetlands[wetlandName-1]);
			out = "The specie was assigned to the wetland";
			
			
			}else{
				out = "The specie is already regist in this wetland.";
			}
			return out;
		}
			//-----------------------------------------------------------------

		/**This method creates an object event to save in a wetland.
	 * @return a string for confirm is added.
	 * @param type,boss,d,m,y,cost,description,wetland are what we need to create a event and add to a wetland.
	  */
		public String createEvent(int type, String boss, int d, int m, int y, double cost, String description,int wetland){
			
			
			String out = "";

			EventType eventType = null;

			switch(type){
			case 1 :
			eventType = EventType.MAINTANCE;
			break;
			case 2 :
			eventType = EventType.SCHOOL_VISIT;
			break;
			case 3 :
			eventType = EventType.ACTIVITY;
			break;
			case 4 :
			eventType = EventType.CELEBRATION;
			break;
			}

			Date newDate = new Date(d,m,y);

			Event theEvent = new Event(eventType,boss,newDate,cost,description);

			wetlands[wetland-1].addEvent2Wetland(theEvent);
			
			out = "The event was registed";

			return out;

		}

		public boolean wetlandExist(int num){
			boolean out = false;

			if(num<=registedWetlands && num>0){
				out = true;
			}
			return out;
		}
		/**This show a list of the regitered wetlands
	 * @return a string of the list.
	  */
		public String showRegistedWetlands(){
			
			String out = "";

			for(int i = 0;i<MAX_WETLANDS;i++){

				if(wetlands[i] != null){
					out += "(" + (i+1) + ")" + " " + wetlands[i].getName() + "\n";
				}
			}
			
			return out;
		}

		public boolean verifyEventType(int num){

			boolean hello =false;
			if (num == 1 || num ==2 || num==3 ||num==4){
				hello= true;
			}
			return hello;

		}
		//---------------------------------------------
		/**This method show the cuantity of events in all wetlands maintance in a year determinate.
	 * @return a string of all wetlands an the cuantity of events maintance
	 * @param year the year for calculate the cuantity of events.
	  */
		public String wetlandsMaintance(int year){

			String out = "";

			

				for(int i = 0;i<MAX_WETLANDS;i++){

					if(wetlands[i]!= null){
						
						out += wetlands[i].getName() + ": " + wetlands[i].maintanceInTheYear(year) + "\n"; 

					}

				}

			return out;

		}

		//-----------------------------------------------------------------
		/**This method show the wetland with less species flora.
	 * @return a string of the wetland name
	  */
		public String lessFloraWetland(){

			int position = wetlands[0].countFlora();
			String out = "";

			for(int i = 1;i<MAX_WETLANDS;i++){

				if(wetlands[i] != null){

					if(position>wetlands[i].countFlora()){
						position = i;
					}
					

				}

			}
			out = wetlands[position].getName();

			return out;

		}
		//-----------------------------------------------------
		/**This method show the habitat(wetlands) a specie have.
	 * @return a string of the list
	 * @param specie is the selct specie for show the habitats.
	  */
		public String wetlandsOfASpecie(int specie){

			String out = "";

			out = allSpecies[specie-1].toStringWetlands();

			return out;

		}
		/**This method show the information of all the registered wetlands.
	 * @return a string with the name and the information of all wetlands.
	  */
		public String infoWetlands(){

			String out = "";
			
			for(int i = 0;i<MAX_WETLANDS;i++){

				if(wetlands[i]!=null){

					out += wetlands[i].toString() + "\n"; 

				}

			}

			return out;
		}
		/**This method show the name of the wetland with most fauna species
	 * @return a string of the name of the wetland. */
		public String wetlandMostFauna(){

			String out = "";

			
			int position = wetlands[0].countFauna();
			for(int i = 1;i<MAX_WETLANDS;i++){

				if(wetlands[i] != null){

					if(position<wetlands[i].countFauna()){
						position = i;
					}
					

				}

			}
			out = wetlands[position].getName();


			return out;

		}
	}
		
			
			
			
			
		
	
	