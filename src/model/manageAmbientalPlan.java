package model;

	/**
	* Descripción: This class that put together the info for create a object manageAmbientalPlan and asig to every wetland.
	*/
public class manageAmbientalPlan {

	/**Variable: percentageCompleted double
	this is the variable that gives a value of how much the  ambiental plan is completed */
	private double percentageCompleted;

	/**
	* Descripción: This is the constructor method that create objets ambienlPlan for every Wetland.
	* <b> pre:</b> the global variables need to be initialized with a value give in main
	* <b> pos:</b> The variable conserve the value in percentage of how much the plan is completed.
	* @param (percentageCompleted) (double)The parameters in this method is the percentage of how much the plan is completed that will variat as time goes by.
	* @return Return a new object manageAmbientalPlan
	*/
	public manageAmbientalPlan(double percentage){
		
		percentageCompleted = percentage;
		
	}
	public double getPercentageCompleted() {
		return percentageCompleted;
	}

	public void setPercentageCompleted(double percentajeCompleted) {
		this.percentageCompleted = percentajeCompleted;
	}

}