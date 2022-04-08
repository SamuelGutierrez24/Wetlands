package model;
import java.util.Scanner;

	
	/**
	* Descripción: This class is the main system of the dagma company, so in thisone we ejecute  all the actions
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
			
			public static final int MAX_WETLANDS = 80;
			
			public static final int MAX_SPECIES = 200;
		
		public Dagma (){
			
			wetlands = new Wetland[MAX_WETLANDS];
			allSpecies = new Specie[MAX_SPECIES];
			
		}
		
		public boolean hasSpace(){
			boolean emptyPosition = false;
			
			for(int i = 0; i<MAX_WETLANDS && !emptyPosition;i++){
			
				if(wetlands[i] == null){
					emptyPosition = true;
				}
			}
			return emptyPosition;
		}
		
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

		public boolean sameWetland(){
			return true;
		}
		
		public String addWetland(String name,int zone, int type, int length,String url, Boolean status ){
			
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
			
			wetlands[position] = new Wetland (name, local, tipo, length, url, status);
			
			out = "The wetland has been registed ";
		}
		
			return out;
				
		}

		public boolean verifyLocation(int num){

			boolean out = false;
			if(num == 1 || num ==2){
				out = true;
			}
			 return out;
		}
		
		public boolean verifyType(int num){

			boolean out = false;
			if(num == 1 || num ==2){
				out = true;
			}
			 return out;
		}

		public boolean sameSpecie(String name){
			
			boolean repeated = false;
		for(int i = 0; i<MAX_SPECIES && repeated != false;i++){
			
			if(allSpecies[i].getName().equals(name)){
				repeated = true;
			}
			
		}
		return repeated;
		
		}
		
		public int specieSpace(){
			
			int position = -1;
				
				for(int i = 0 ; i<MAX_SPECIES && position==-1;i++){
					if(allSpecies[i]==null){
						position = i;
					}
				}
				
			
			
			return position;
		}

		public String addSpecie (int type, String name, String scientificName, boolean mygratory, String characterType){

			SpecieType realType = null;
			switch(type){
				case 1 :
				realType = SpecieType.FLORA;
				break;
				case 2 :
				realType = SpecieType.FAUNA;
				break;
				}
			
			String out = "";

			int position = specieSpace();
			if (position == -1) {
			
			out = "We already regist the maximum species in our system";
			
		}else{
			
			allSpecies[position] = new Specie (realType,name,scientificName,mygratory,characterType);
			
			out = "The specie has been registed ";
		}
		
			return out;

		}


		public String showRegistedSpecies(){
			return "hola";
		}
			
	}
		
			
			
			
			
		
	
	