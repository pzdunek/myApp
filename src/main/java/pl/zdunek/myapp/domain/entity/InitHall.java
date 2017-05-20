package pl.zdunek.myapp.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="init_hall")
public class InitHall implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private int id;
	
	
	@Column(name="theater_name")
	private String theaterName;
	
	@Column(name="row_char",  nullable=true)
	private String rowChar;
	
	@Column(name="col_number" , nullable=true)
	private int colNumber;

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getRowChar() {
		return rowChar;
	}

	public void setRowChar(String rowChar) {
		this.rowChar = rowChar;
	}

	public int getColNumber() {
		return colNumber;
	}

	public void setColNumber(int colNumber) {
		this.colNumber = colNumber;
	}

	
}
