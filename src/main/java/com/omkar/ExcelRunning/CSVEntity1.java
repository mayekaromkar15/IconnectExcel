package com.omkar.ExcelRunning;

import java.time.LocalDate;

public class CSVEntity1 {

	private String SYMBOL;
	private String SERIES;
	private double OPEN;
	private double HIGH;
	private double LOW;
	private double CLOSE;
	private double LAST;
	private double PREVCLOSE;
	private int TOTTRDQTY;
	private double TOTTRDVAL;
	private LocalDate TIMESTAMP;
	private int TOTALTRADES;
	private String ISIN;
	private double RANGE;
	private double runningTotal;

	public CSVEntity1() {
		// TODO Auto-generated constructor stub
	}

	public CSVEntity1(String sYMBOL, String sERIES, double oPEN, double hIGH, double lOW, double cLOSE, double lAST,
			double pREVCLOSE, int tOTTRDQTY, double tOTTRDVAL, LocalDate tIMESTAMP, int tOTALTRADES, String iSIN) {
		SYMBOL = sYMBOL;
		SERIES = sERIES;
		OPEN = oPEN;
		HIGH = hIGH;
		LOW = lOW;
		CLOSE = cLOSE;
		LAST = lAST;
		PREVCLOSE = pREVCLOSE;
		TOTTRDQTY = tOTTRDQTY;
		TOTTRDVAL = tOTTRDVAL;
		TIMESTAMP = tIMESTAMP;
		TOTALTRADES = tOTALTRADES;
		ISIN = iSIN;
	}

	public String getSYMBOL() {
		return SYMBOL;
	}

	public void setSYMBOL(String sYMBOL) {
		SYMBOL = sYMBOL;
	}

	public String getSERIES() {
		return SERIES;
	}

	public void setSERIES(String sERIES) {
		SERIES = sERIES;
	}

	public double getOPEN() {
		return OPEN;
	}

	public void setOPEN(double oPEN) {
		OPEN = oPEN;
	}

	public double getHIGH() {
		return HIGH;
	}

	public void setHIGH(double hIGH) {
		HIGH = hIGH;
	}

	public double getLOW() {
		return LOW;
	}

	public void setLOW(double lOW) {
		LOW = lOW;
	}

	public double getCLOSE() {
		return CLOSE;
	}

	public void setCLOSE(double cLOSE) {
		CLOSE = cLOSE;
	}

	public double getLAST() {
		return LAST;
	}

	public void setLAST(double lAST) {
		LAST = lAST;
	}

	public double getPREVCLOSE() {
		return PREVCLOSE;
	}

	public void setPREVCLOSE(double pREVCLOSE) {
		PREVCLOSE = pREVCLOSE;
	}

	public int getTOTTRDQTY() {
		return TOTTRDQTY;
	}

	public void setTOTTRDQTY(int tOTTRDQTY) {
		TOTTRDQTY = tOTTRDQTY;
	}

	public double getTOTTRDVAL() {
		return TOTTRDVAL;
	}

	public void setTOTTRDVAL(double tOTTRDVAL) {
		TOTTRDVAL = tOTTRDVAL;
	}

	public LocalDate getTIMESTAMP() {
		return TIMESTAMP;
	}

	public void setTIMESTAMP(LocalDate tIMESTAMP) {
		TIMESTAMP = tIMESTAMP;
	}

	public int getTOTALTRADES() {
		return TOTALTRADES;
	}

	public void setTOTALTRADES(int tOTALTRADES) {
		TOTALTRADES = tOTALTRADES;
	}

	public String getISIN() {
		return ISIN;
	}

	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}

	public double getRANGE() {
		return RANGE;
	}

	public void setRANGE(double rANGE) {
		RANGE = rANGE;
	}

	
	
	public double getRunningTotal() {
		return runningTotal;
	}

	public void setRunningTotal(double runningTotal) {
		this.runningTotal = runningTotal;
	}

	@Override
	public String toString() {
		return "SYMBOL=" + SYMBOL + ", SERIES=" + SERIES + ", OPEN=" + OPEN + ", HIGH=" + HIGH + ", LOW="
				+ LOW + ", CLOSE=" + CLOSE + ", LAST=" + LAST + ", PREVCLOSE=" + PREVCLOSE + ", TOTTRDQTY=" + TOTTRDQTY
				+ ", TOTTRDVAL=" + TOTTRDVAL + ", TIMESTAMP=" + TIMESTAMP + ", TOTALTRADES=" + TOTALTRADES + ", ISIN="
				+ ISIN + ", RANGE=" + RANGE + ", runningTotal=" + runningTotal;
	}

	

}
