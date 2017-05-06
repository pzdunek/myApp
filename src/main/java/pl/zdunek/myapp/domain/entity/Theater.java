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
	@Column(name="theater_name", unique=true, nullable=false, length=11)
	private String theaterName;

	@Column(name="number_of_seats", nullable=false, length=20)
	private String numberOfSeats;

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

	public String getNumberOfSeats() {
		return this.numberOfSeats;
	}

	public void setNumberOfSeats(String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
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