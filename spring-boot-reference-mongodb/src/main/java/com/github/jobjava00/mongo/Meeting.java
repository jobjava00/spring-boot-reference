package com.github.jobjava00.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jobjava00
 */
@Document(collection = "meetings")
public class Meeting {
	@Id
	private String id;
	private String title;
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override public String toString() {
		return "Meeting{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Meeting meeting = (Meeting) o;

		if (id != null ? !id.equals(meeting.id) : meeting.id != null)
			return false;
		if (title != null ? !title.equals(meeting.title) : meeting.title != null)
			return false;
		return address != null ? address.equals(meeting.address) : meeting.address == null;
	}

	@Override public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		return result;
	}
}
