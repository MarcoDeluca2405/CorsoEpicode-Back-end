package Esercizio1;

public class Customer {
private long id;
private String name;
private int tier;


public Customer(long id, String name, int tier) {
	super();
	this.id = id;
	this.name = name;
	this.tier = tier;
}


/**
 * @return the id
 */
public long getId() {
	return id;
}


/**
 * @param id the id to set
 */
public void setId(long id) {
	this.id = id;
}


/**
 * @return the name
 */
public String getName() {
	return name;
}


/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}


/**
 * @return the tier
 */
public int getTier() {
	return tier;
}


/**
 * @param tier the tier to set
 */
public void setTier(int tier) {
	this.tier = tier;
}


}
