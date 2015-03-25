package com.videothegathering.vo;

import java.util.Date;

public class PlayitemVO {

	// ���̺��� �÷���� ������ ������� �����

	private int id;

	private String URL;

	private String Title;

	private String realMP4;
	
	private Date date;

	// ����Ʈ ������

	public PlayitemVO() {
	}

	// 4���� �Ķ���͸� �޾Ƽ� ��������� �����ϴ� ������

	public PlayitemVO(int id, String URL, String Title, String realMP4, Date date) {

		// 4���� �Ķ���͸� �޾Ƽ� ��������� �����ϴ� ������

		this.id = id;

		this.URL = URL;

		this.Title = Title;

		this.realMP4 = realMP4;

		this.date = date;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getRealMP4() {
		return realMP4;
	}

	public void setRealMP4(String realMP4) {
		this.realMP4 = realMP4;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
