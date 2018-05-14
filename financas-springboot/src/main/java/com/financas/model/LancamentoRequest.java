package com.financas.model;

import java.util.Date;

public class LancamentoRequest {
	private Integer year;
	private Integer month;
	private Date date;
	
	public LancamentoRequest() {
		super();
	}
	
	public LancamentoRequest(Integer year, Integer month, Date date) {
		super();
		this.year = year;
		this.month = month;
		this.date = date;
	}
	
	public LancamentoRequest(LancamentoRequestBuilder builder) {
		super();
		this.year = builder.year;
		this.month = builder.month;
		this.date = builder.date;
	}

	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static class LancamentoRequestBuilder {
		protected Integer year;
		protected Integer month;
		protected Date date;
		
		public LancamentoRequestBuilder setYear(Integer year) {
			this.year = year;
			return this;
		}
		
		public LancamentoRequestBuilder setMonth(Integer month) {
			this.month = month;
			return this;
		}
		
		public LancamentoRequestBuilder setDate(Date date) {
			this.date = date;
			return this;
		}
		
		public LancamentoRequest build() {
			return new LancamentoRequest(this);
		}
	}
}
