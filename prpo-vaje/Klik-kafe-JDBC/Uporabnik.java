
public class Uporabnik extends Entiteta {
	private String uname;
	private String name;
	private String surname;
	private float lat;
	private float long;
	private String email;
	
	//GETTER methods
	/**
	 * Returns the username of Uporabnik
	 * @return String
	 */
	public String getUsername() {
		return this.uname;
	}
	
	/**
	 * Returns the name of Uporabnik
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the surname of Uporabnik
	 * @return String
	 */
	public String getSurname(){
		return this.surname;
	}
	
	/**
	 * Returns the latitude of Uporabnik
	 * @return float
	 */
	public float getLat() {
		return this.lat;
	}
	
	/**
	 * Returns the longtitude of Uporabnik
	 * @return float
	 */
	public float getLong() {
		return this.long;
	}
	
	/**
	 * Returns the email of Uporabnik
	 * @return String
	 */
	public String getEmail() {
		return this.email;
	}
	
	
	//SETTER methods
	/**
	 * Set the username of uporabnik
	 * @param new_uname the new name for Uporanik
	 */
	public void setUsername(String new_uname) {
		this.uname = new_uname;
	}
	
	/**
	 * Set the name of Uporabnik
	 * @param new_name the new name for Uporabnik
	 */
	public void setName(String new_name) {
		this.name = new_name;
	}
	
	/**
	 * Set the surname of Uporabnik
	 * @param new_surname	new surname for Uporabnik
	 */
	public void setSurname(String new_surname) {
		this.surname = new_surname;
	}
	
	/**
	 * Set the latitude of Uporabnik
	 * @param new_lat	the new latitude for Uporabnik
	 */
	public void setLatitude(float new_lat) {
		this.lat = new_lat;
	}
	
	/**
	 * Set the longtitude of Uporabnik
	 * @param new_long	the new longtitude for Uporabnik
	 */
	public void setLongtitude(float new_long) {
		this.long = new_long;
	}
	
	/**
	 * Set the email of Uporabnik
	 * @param new_email	the new email for Uporabnik
	 */
	public void setEmail(String new_email) {
		this.email = new_email;
	}
}
