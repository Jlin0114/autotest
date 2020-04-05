package zhiyiting2.model;

import java.util.List;
import java.util.Map;

public class ResponseModel {
	private String fileId;
	private String code;
	private String uuid;
	private String message;
	private String session;
	private Integer carId;
	private List<Map> list;
	private List<Map> activities;
	private Integer id;
	
	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Map> getActivities() {
		return activities;
	}

	public void setActivities(List<Map> activities) {
		this.activities = activities;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public List<Map> getList() {
		return list;
	}

	public void setList(List<Map> list) {
		this.list = list;
	}



	

	

	

}
