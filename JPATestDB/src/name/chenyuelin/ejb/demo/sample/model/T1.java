package name.chenyuelin.ejb.demo.sample.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the t1 database table.
 * 
 */
@Entity
@NamedQuery(name="T1.findAll", query="SELECT t FROM T1 t")
public class T1 implements Serializable {
	private static final long serialVersionUID = 1214161527308496228L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dt;

	@Temporal(TemporalType.DATE)
	private Date fild1;

	@Column(name="parent_id")
	private Integer parentId;

	private Time timee;

	public T1() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDt() {
		return this.dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public Date getFild1() {
		return this.fild1;
	}

	public void setFild1(Date fild1) {
		this.fild1 = fild1;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Time getTimee() {
		return this.timee;
	}

	public void setTimee(Time timee) {
		this.timee = timee;
	}

}