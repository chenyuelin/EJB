package name.chenyuelin.ejb.demo.sample.model2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t2 database table.
 * 
 */
@Entity
@NamedQuery(name="T2.findAll", query="SELECT t FROM T2 t")
public class T2 implements Serializable {

	private static final long serialVersionUID = 438579663084291160L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private byte id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String name;

	public T2() {
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}