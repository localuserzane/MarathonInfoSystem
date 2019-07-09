package com.example.demo.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity//to use relation with other tables
@Table(name="marathonTable")// to create table automatically
public class Marathon {

	@Id//value will be unique
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id_mar")//id column will be in table
	private long id_mar;
	
	@NotEmpty
	@NotNull
	@Size(min=3,max=25)
	@Column(name="Name")
	private String name;
	
	@NotNull
	@Min(20)
	@Max(65)
	@Column(name="Distance")
	private int distance;
	
	@NotEmpty
	@NotNull
	@Size(min=3,max=30)
	@Column(name="Place")
	private String place;
	
	@NotEmpty
	@NotNull
	@Column(name="Date")
	private LocalDate date;
	
	@NotEmpty
	@NotNull
	@Column(name="Time")
	private LocalDate time;
	
	/*@NotEmpty
	@NotNull
	@Column(name="Id_org")
	private Organizer id_org;
	*/
	
	@ManyToOne
	@JoinColumn(name="ID_org")
	private Organizer organizer;
	
	public Marathon() {
		
	}
	
	public Marathon(String name,int distance, String place, LocalDate date, LocalDate time) {
		setName(name);
		setDistance(distance);
		setPlace(place);
		setDate(date);
		setTime(time);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public Long getId_mar() {
		return id_mar;
	}
	
	
	
}
