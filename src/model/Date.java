package model;

	/**
	* Descripción: This class is the encharge to put together all info for create a Date.
	*/
	public class Date {
		/**Variable: day int
	this is the variable that take the value of the day for create a object Date*/
		private int day;
		/**Variable: mounth int
	tthis is the variable that take the value of the mounth for create a object Date*/
		private int mounth;
		/**Variable: year int
	this is the variable that take the value of the year for create a object Date*/
		private int year;

		
		/**
	* Descripción: This is the constructor method that create objets Date for the class Event
	* <b> pre:</b> the global variables need to be initialized with a value give in main
	* <b> pos:</b> they conserve the value give, but will change when we asig another value for a new object Date
	* @param The parameters in this method are the 3 values for a Date, d-(day), m-(mounth) and y-(year)
	* @return Return a objec Date
	*/
		public Date(int d, int m, int y){
			
			day = d;
			mounth = m;
			year = y;
			
		}
		
		
		public int getDay() {
		return day;
		}

	
		public void setDay(int day) {
			this.day = day;
		}

		public int getMounth() {
			return mounth;
		}

	
	public void setMounth(int mounth) {
		this.mounth = mounth;
	}

	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString(){
			
		return day + "/" +  mounth + "/" +  year;
	}

}