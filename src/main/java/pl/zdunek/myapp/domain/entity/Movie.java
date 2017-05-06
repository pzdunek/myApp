package pl.zdunek.myapp.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the movies database table.
 * 
 */
@Entity
@Table(name="movies")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_name", unique=true, nullable=false, length=30)
	private String movieName;

	//bi-directional many-to-one association to Show
	@OneToMany(mappedBy="movy")
	private List<Show> shows;

	public Movie() {
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List<Show> getShows() {
		return this.shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public Show addShow(Show show) {
		getShows().add(show);
		show.setMovy(this);

		return show;
	}

	public Show removeShow(Show show) {
		getShows().remove(show);
		show.setMovy(null);

		return show;
	}

}