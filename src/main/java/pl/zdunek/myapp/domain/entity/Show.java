package pl.zdunek.myapp.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the shows database table.
 * 
 */
@Entity
@Table(name="shows")
@NamedQuery(name="Show.findAll", query="SELECT s FROM Show s")
public class Show implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date movieDate;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="show")
	private List<Reservation> reservations;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="movie_name", nullable=false)
	private Movie movy;

	//bi-directional many-to-one association to Theater
	@ManyToOne
	@JoinColumn(name="theater_name", nullable=false)
	private Theater theater;

	public Show() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getMovieDate() {
		return this.movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setShow(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setShow(null);

		return reservation;
	}

	public Movie getMovy() {
		return this.movy;
	}

	public void setMovy(Movie movy) {
		this.movy = movy;
	}

	public Theater getTheater() {
		return this.theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

}