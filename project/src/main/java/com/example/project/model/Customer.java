package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
@Id
@GeneratedValue
private int custId;
private String CustName;
private String custAdd;
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getCustName() {
	return CustName;
}
public void setCustName(String custName) {
	CustName = custName;
}
public String getCustAdd() {
	return custAdd;
}
public void setCustAdd(String custAdd) {
	this.custAdd = custAdd;
}
}
