package pl.zdunek.myapp.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the theaters database table.
 * 
 */
@Entity
@Table(name="theaters")
@NamedQuery(name="Theater.findAll", query="SELECT t FROM Theater t")
public class Theater implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="theater_name", unique=true, nullable=false, length=40)
	private String theaterName;

	@Column(name="theater_address", nullable=false, length=50)
	private String theaterAddress;

	@Column(name="theater_phone_number", nullable=false, length=11)
	private int theaterPhoneNumber;
	
	//bi-directional many-to-one association to Show
	@OneToMany(mappedBy="theater")
	private List<Show> shows;

	public Theater() {
	}

	public String getTheaterName() {
		return this.theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterAddress() {
		return theaterAddress;
	}

	public void setTheaterAddress(String theaterAddress) {
		this.theaterAddress = theaterAddress;
	}

	public int getTheaterPhoneNumber() {
		return theaterPhoneNumber;
	}

	public void setTheaterPhoneNumber(int theaterPhoneNumber) {
		this.theaterPhoneNumber = theaterPhoneNumber;
	}

	public List<Show> getShows() {
		return this.shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public Show addShow(Show show) {
		getShows().add(show);
		show.setTheater(this);

		return show;
	}

	public Show removeShow(Show show) {
		getShows().remove(show);
		show.setTheater(null);

		return show;
	}

}