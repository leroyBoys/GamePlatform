package com.lgame.model;

import com.module.db.UserInfo;
import com.mysql.impl.DbFactory;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User extends DbFactory implements Serializable {
    public static User instance;
    private int id;
	private String name;
	private String password;
	private String mail;
	private short group;
	private int card;
	private byte userStatus;
	private Date createTime;


	private Set<String> urls = new HashSet<>();
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public short getGroup() {
		return group;
	}

	public void setGroup(short group) {
		this.group = group;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean hasUrl(String url) {
		return group == 0||urls.contains(url);
	}

	public void setUrls(Set<String> urls) {
		this.urls = urls;
	}

	@Override
	public User create(ResultSet rs) throws Exception {
		User user = createNew();
		user.setId(rs.getInt("id"));
		user.setGroup(rs.getShort("group"));
		user.setCreateTime(rs.getDate("create_time"));
		user.setUserStatus(rs.getByte("user_status"));
		return user;
	}

	public byte getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(byte userStatus) {
		this.userStatus = userStatus;
	}

	public Set<String> getUrls() {
		return urls;
	}

	@Override
	protected User createNew() {
		return new User();
	}
}
