package com.lgame.model;

import com.mysql.impl.DbFactory;

import java.io.Serializable;
import java.sql.ResultSet;

public class UserLimit extends DbFactory implements Serializable {
    public static UserLimit instance;
    private int id;
    private int uid;
	private int urlId;
	private ExtraType extraType;

	@Override
	public UserLimit create(ResultSet rs) throws Exception {
		UserLimit user = createNew();
		user.setUid(rs.getInt("uid"));
		user.setUrlId(rs.getInt("url_id"));
		user.setId(rs.getInt("id"));
		user.setExtraType(ExtraType.valueOf(rs.getString("extra_type")));
		return user;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUrlId() {
		return urlId;
	}

	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}

	public ExtraType getExtraType() {
		return extraType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setExtraType(ExtraType extraType) {
		this.extraType = extraType;
	}

	@Override
	protected UserLimit createNew() {
		return new UserLimit();
	}

	public enum ExtraType{
		yes,no
	}
}
