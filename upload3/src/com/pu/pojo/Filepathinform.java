package com.pu.pojo;

/**
 * Filepathinform entity. @author MyEclipse Persistence Tools
 */

public class Filepathinform implements java.io.Serializable {

	// Fields

	private Integer id;
	private String filename;
	private String filepathzip;
	private String filepathurl;
	private String preimgurl;
	private Integer downtimes;

	// Constructors

	/** default constructor */
	public Filepathinform() {
	}

	/** full constructor */
	public Filepathinform(String filename, String filepathzip,
			String filepathurl, String preimgurl, Integer downtimes) {
		this.filename = filename;
		this.filepathzip = filepathzip;
		this.filepathurl = filepathurl;
		this.preimgurl = preimgurl;
		this.downtimes = downtimes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepathzip() {
		return this.filepathzip;
	}

	public void setFilepathzip(String filepathzip) {
		this.filepathzip = filepathzip;
	}

	public String getFilepathurl() {
		return this.filepathurl;
	}

	public void setFilepathurl(String filepathurl) {
		this.filepathurl = filepathurl;
	}

	public String getPreimgurl() {
		return this.preimgurl;
	}

	public void setPreimgurl(String preimgurl) {
		this.preimgurl = preimgurl;
	}

	public Integer getDowntimes() {
		return this.downtimes;
	}

	public void setDowntimes(Integer downtimes) {
		this.downtimes = downtimes;
	}

}