package pl.zdunek.myapp.domain.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reservations database table.
 * 
 */
@Entity
@Table(name="reservations")
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reservation_number", unique=true, nullable=false)
	private int reservationNumber;

	@Column(nullable=false)
	private int seats;

	//bi-directional many-to-one association to Show
	@ManyToOne
	@JoinColumn(name="show_id", nullable=false)
	private Show show;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_name", nullable=false)
	private CinemaUser user;

	public Reservation() {
	}

	public int getReservationNumber() {
		return this.reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public int getSeats() {
		return this.seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Show getShow() {
		return this.show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public CinemaUser getUser() {
		return this.user;
	}

	public void setUser(CinemaUser user) {
		this.user = user;
	}

}