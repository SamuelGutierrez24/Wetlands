package model;

	/**
	* Descripción: This class that put together the info for create a object wetland to save in dagma system
	*/
public class Wetland {
/**Variable: name String
	this is the variable that save the name of the wetland*/
	private String name;
	/**Variable: Specie array
	this is the array that will save  the species in the wetland created*/
	private Specie [] species;
	/**Variable: zone String
	this is the variable that infor about the city or department of the wetland*/
	private Location zone;
	/**Variable: type String
	this is the variable that says if is public o private the wetland*/
	private Type type;
	/**Variable: length int
	this is the variable that says the length area of the wetland*/
	private int length;
	/**Variable: urlPhoto String
	this is the variable that save the url of the photo of the wetland*/
	private String urlPhoto;
	/**Variable: protectedStatus boolean
	this is the variable that says if the wetland if under protection*/
	private boolean protectedStatus;
	/**Variable: ambientalPlan manageAmbientalPlan
	this is the variable that save the info of the ambiental plan of the wetland*/
	private double ambientalPlan;
	/**Variable: wetlandEvents array
	this is the array that saves all events in the wetland*/
	private Event [] wetlandEvents;


	

	/**
	* Descripción: This is the constructor method that create objets Wetlands that have all the info of every wetland that will be save in the dagma system
	* <b> pre:</b> Most of the global variables in this method are already object, so thhey need to be create. Second the  other variables need to be initialized with a value give in main.
	* <b> pos:</b> This variables will change they value for every new wetland will be create.
	* @param (name)(String) the wetland need to have a identification name
		(zone)(String) need to be a real city or department.
		(type)(String) the wetland can be public or private.
		(length)(int)
		(urlPhoto)(String) need to be already take the photo of the wetland
		(protectedStatus)(boolean).
		(ambientalPlan)(manageAmbientalPlan)need to be create already the ambiental plan
	* @return Return a new object Wetland that will be safe in the dagma system.
	*/
	public Wetland (String name, Location zone, Type type, int length, String urlPhoto, boolean protectedStatus, double ambientalPlan){
		
		species = new Specie [200];
		wetlandEvents = new Event [100];
		this.name = name;
		this.zone = zone;
		this.type = type;
		this.length = length;
		this.urlPhoto = urlPhoto;
		this.protectedStatus = protectedStatus;
		this.ambientalPlan = ambientalPlan;
	}
	
	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public Location getZone() {
		return zone;
	}

	public Type getType() {
		return type;
	}

	public int getLength(){
		return length;
	}


	public void setLength(int l) {
		length = l;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public boolean getProtectedStatus() {
		return protectedStatus;
	}


	public void setProtectedStatus(boolean protectedStatus) {
		this.protectedStatus = protectedStatus;
	}
	
	public double getAmbientalPlan(){
		return ambientalPlan;
	}
	
	public void setAmbientalPlan (double ambiental){
		
		ambientalPlan = ambiental;
		
	}

	public int speciesSpace(){

		int position = -1;
			
				
			for(int i = 0 ; i<200 && position==-1;i++){
				if(species[i]==null){
					position = i;
				}
			}
		return position;		
	}
	public void addSpecie2Wetland(Specie specie){
		
		int i = speciesSpace();
		species[i] = specie;
	


	}
	
	public boolean alreadyRegistedSpecie(Specie specie){
		
		boolean registed = false;
		
		for(int i = 0;i<species.length;i++){
			
			if (species[i] != null){
				if(species[i].equals(specie)){
				registed = true;
				}
			}
		}
		return registed;
	}
	

	public int eventSpace(){

		int position = -1;
			
				
			for(int i = 0 ; i<100 && position==-1;i++){
				if(wetlandEvents[i]==null){
					position = i;
				}
			}
		return position;		
	}

	public void addEvent2Wetland(Event event){
		
		int i = eventSpace();
		wetlandEvents[i] = event;
	


	}

	public int maintanceInTheYear(int year){

		int index = 0;

		for(int i = 0;i<wetlandEvents.length;i++){

			if(wetlandEvents[i] != null){
				index += wetlandEvents[i].countMaintance(year);
			}

		}

		return index;
	}
	
	public int countFlora(){

		int count = 0;
		for(int i = 0;i<species.length;i++){

			if(species[i] !=null){

				if(species[i].isFlora() == true)
					count +=1;
			}

		}
		return count;
	}

	public String toString(){

		return "name : " + getName() + "\n" +
		"Location : " + getZone() + "\n" +
		"Type : " + getType() + "\n" +
		"Length : " + getLength() + "Klm2 \n" +
		"Photo Url : " + getUrlPhoto() + "\n" +
		"Is a protected zone? : " + getProtectedStatus() + "\n" +
		"porcentage of Ambiental plan :" + getAmbientalPlan() + "% \n" +
		" Species : \n" + stringSpecies();

	}

	public String stringSpecies(){

		int af,lf,b,mam,aq;
		af = 0;
		lf = 0;
		b = 0;
		mam = 0;
		aq = 0;
		for(int i = 0;i<species.length;i++){
			if(species[i] != null){


				if(species[i].getType().equals(SpecieSpecificType.AQUATIC_FLORA)){
					af += 1;
				}

				if(species[i].getType().equals(SpecieSpecificType.LAND_FLORA)){
					lf +=1;
				}

				if(species[i].getType().equals(SpecieSpecificType.BIRD)){
					b += 1;
				}

				if(species[i].getType().equals(SpecieSpecificType.MAMMAL)){
					mam += 1;
				}

				if(species[i].getType().equals(SpecieSpecificType.AQUATIC)){
					aq += 1;
				}
			}


			
		}

		return "Aquatic flora :" + af + "\n" +
		"Land flora :" + lf + "\n" +
		"Birds :" + b + "\n" +
		"Mammals :" + mam + "\n" +
		"Aquatic :" + aq + "\n" ;
		
	}

	public int countFauna(){

		int count = 0;
		for(int i = 0;i<species.length;i++){

			if(species[i] !=null){

				if(species[i].isFauna() == true)
					count +=1;
			}

		}
		return count;
	}
}
