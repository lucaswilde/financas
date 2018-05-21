package com.financas.model;

import java.util.Date;

public class LancamentoQueryRequest {
	private Integer year;
	private Integer month;
	private Date date;
	
	public LancamentoQueryRequest() {
		super();
	}
	
	public LancamentoQueryRequest(Integer year, Integer month, Date date) {
		super();
		this.year = year;
		this.month = month;
		this.date = date;
	}
	
	public LancamentoQueryRequest(LancamentoQueryRequestBuilder builder) {
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
	
	public static class LancamentoQueryRequestBuilder {
		protected Integer year;
		protected Integer month;
		protected Date date;
		
		public LancamentoQueryRequestBuilder setYear(Integer year) {
			this.year = year;
			return this;
		}
		
		public LancamentoQueryRequestBuilder setMonth(Integer month) {
			this.month = month;
			return this;
		}
		
		public LancamentoQueryRequestBuilder setDate(Date date) {
			this.date = date;
			return this;
		}
		
		public LancamentoQueryRequest build() {
			return new LancamentoQueryRequest(this);
		}
	}
}
