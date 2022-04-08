package model;

/**
	* Descripción: This class that put together the info for create a object event to regist in wetland
	*/
public class Event {
	
	/**Variable: typeEvent String
	this is the variable that infor about the type of event(Scholar, celebrations, maintance,etc...)*/
	private String typeEvent;
	/**Variable: eventDate Date
	this is the variable that take the value of the object Date for have a date for the event*/
	private Date eventDate;
	/**Variable: cost double
	this is the variable that take the value of how much cost the event in the wetland*/
	private double cost;
	/**Variable: description String
	this is the variable that inform a little description of the event and what id going on it*/
	private String description;

		/**
	* Descripción: This is the constructor method that create objets Event for some Wetlands
	* <b> pre:</b> for global variable need tobe initialized with a value in main and a object Date need to be already crate
	* <b> pos:</b> they conserve the given value, but will change when we asig another value for a new object Event, (exept Date becouse is already a object, so need to be create another object Date)
	* @param The parameters in this method are the global variables that need to be already initialized with a value.(type) String, (eventDate)Date, (cost)double, (description)String 
	* @return Return a objec Event
	*/
	public Event(String type, Date eventDate, double c, String description){
		
		typeEvent = type;
		this.eventDate = eventDate;
		cost = c;
		this.description = description;
		
	}
	
	public String getTypeEvent(){
		return typeEvent;
	}
	
	public void setTypeEvent(String type){
		this.typeEvent = type;
	}
	
	
	public Date getDate() {
		return eventDate;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public double getCost() {
		return cost;
	}

	/**
	 * 
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

}