package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Yareth Pinzon
 */
@Entity
@Table(name="roulette")
public class roulette {
	@Id
    @GeneratedValue
    @Column(name="id")
	private int id;
    @Column(name="result")
	private int result;
    @Column(name="lastresults")
	private int lastresults;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getLastresults() {
		return lastresults;
	}
	public void setLastresults(int lastresults) {
		this.lastresults = lastresults;
	}
	public roulette(int id, int result, int lastresults) {
		super();
		this.id = id;
		this.result = result;
		this.lastresults = lastresults;
	}
    public roulette() {
    	
    }
	
}
