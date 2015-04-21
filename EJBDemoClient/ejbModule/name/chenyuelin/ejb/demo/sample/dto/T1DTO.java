package name.chenyuelin.ejb.demo.sample.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class T1DTO implements Serializable{
	private static final long serialVersionUID = 4948496571276572102L;

	private byte id;

	private String content;

	private Date dt;

	private Date fild1;

	private byte parentId;

	private Time timee;
	
	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public Date getFild1() {
		return fild1;
	}

	public void setFild1(Date fild1) {
		this.fild1 = fild1;
	}

	public byte getParentId() {
		return parentId;
	}

	public void setParentId(byte parentId) {
		this.parentId = parentId;
	}

	public Time getTimee() {
		return timee;
	}

	public void setTimee(Time timee) {
		this.timee = timee;
	}
	
	@Override
	public String toString() {
		return "T1DTO [id=" + id + ", content=" + content + ", dt=" + dt + ", fild1=" + fild1 + ", parentId=" + parentId + ", timee=" + timee + "]";
	}
}
