package esercizio2;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Studenti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, name="name")
	private String name;
	
	@Column(nullable = false, name="last_name")
	private String lastname;
	
	@Column(nullable = false, name="gender")
	private String gender;
	
	@Column(nullable = false, name="birthdate")
	private LocalDate birthdate;
	
	@Column(nullable = false, name="avg")
	private int avg;
	
	@Column(nullable = false, name="min_voto")
	private int min_voto;
	
	@Column(nullable = false, name="max_voto")
	private int max_voto;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the avg
	 */
	public int getAvg() {
		return avg;
	}

	/**
	 * @param avg the avg to set
	 */
	public void setAvg(int avg) {
		this.avg = avg;
	}

	/**
	 * @return the min_voto
	 */
	public int getMin_voto() {
		return min_voto;
	}

	/**
	 * @param min_voto the min_voto to set
	 */
	public void setMin_voto(int min_voto) {
		this.min_voto = min_voto;
	}

	/**
	 * @return the max_voto
	 */
	public int getMax_voto() {
		return max_voto;
	}

	/**
	 * @param max_voto the max_voto to set
	 */
	public void setMax_voto(int max_voto) {
		this.max_voto = max_voto;
	}

	@Override
	public String toString() {
		return "studenti [id=" + id + ", name=" + name + ", lastname=" + lastname + ", gender=" + gender
				+ ", birthdate=" + birthdate + ", avg=" + avg + ", min_voto=" + min_voto + ", max_voto=" + max_voto
				+ "]";
	}
	
	
	
}
