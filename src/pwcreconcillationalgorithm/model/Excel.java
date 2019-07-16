/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwcreconcillationalgorithm.model;

import com.gizbel.excel.annotations.ExcelBean;
import com.gizbel.excel.annotations.ExcelColumnHeader;

/**
 *
 * @author aojinadu
 */
@ExcelBean
public class Excel {

	@ExcelColumnHeader(columnHeader = "SN", dataType = "int", defaultValue = "0")
	private int sn;

	@ExcelColumnHeader(columnHeader = "ID", dataType = "int", defaultValue = "0")
	private int id;

	@ExcelColumnHeader(columnHeader = "RRA", dataType = "String", defaultValue = "0")
	private String rrn;

	@ExcelColumnHeader(columnHeader = "STA", dataType = "String", defaultValue = "0")
	private String stan;

	@ExcelColumnHeader(columnHeader = "AMOUNT", dataType = "String", defaultValue = "0")
	private String amount;

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	
}
