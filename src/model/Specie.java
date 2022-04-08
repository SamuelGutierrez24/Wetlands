package model;

	/**
	* Descripción: This class that put together the info for create a object Specie for be asociate to a wetland an in the dagma system.
	*/
public class Specie {
	/**Variable: floraOrFauna String
	this is the variable that says the type of the specie*/
	private SpecieType floraOrFauna;
	/**Variable: name String
	this is the variable that take the name of the specie*/
	private String name;
	/**Variable: scientificName String
	this is the variable that take the scientific name of the specie*/
	private String scientificName;
	/**Variable: isMygratory boolean
	this is the variable that says if the specie is native of the wetland or if is mygratory*/
	private boolean isMigratory;
	/**Variable: type String
	this is the variable that says the specific tipe of the specie(like: flying terrestrial)*/
	private String type;
	/**Variable: habitat array
	this is the array that asociates a specie to different wetlands*/
	private Wetland[] habitat;
	
		/**
	* Descripción: This is the constructor method that create objets Specie for regist in every wetland and in the system of dagma.
	* <b> pre:</b> the global variables need to be initialized with a value give in main
	* <b> pos:</b> they conserve the value give with a name, type, scientific name,etc for the object Specie is creating, but will change when we asig another value for a new object specie, becouse they are absolut different
	* @param The parameters in this method are the the characteristics need for regist a new Specie.(String floraOrFauna, String n, String scientificName, boolean mygratory, String type)
	* @return Return a new object Specie
	*/
	public Specie(SpecieType floraOrFauna, String n, String scientificName, boolean mygratory, String type){
		
		this.floraOrFauna = floraOrFauna;
		name = n;
		this.scientificName = scientificName;
		isMigratory = mygratory;
		this.type = type;
		habitat = new Wetland [200];
		
	}
	
	public SpecieType getFloraOrFauna(){
		return this.floraOrFauna;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n){
		name = n;
	}

	public String getScientificName() {
		return this.scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public boolean getIsMigratory() {
		return isMigratory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}