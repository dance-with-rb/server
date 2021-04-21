package com.ddareung2.server.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@Entity(name="voc_question")
public class VocQuestion extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, insertable = true)
	private long id;
	
//	@Column(name = "category", nullable = false, updatable = true, insertable = true)
	@OneToOne(fetch = FetchType.LAZY, targetEntity = VocCategory.class)
	@JoinColumn(name="category", referencedColumnName = "name", nullable = false)
	private String category;
	
	@Column(name = "title", nullable = false, updatable = true, insertable = true)
	private String title;
	@Column(name = "content", nullable = false, updatable = true, insertable = true)
	private String content;
	@Column(name = "username", nullable = true, updatable = true, insertable = true)
	private String username;
	@Column(name = "email", nullable = true, updatable = true, insertable = true)
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = StationInformation.class)
	@JoinColumn(name="station_id", referencedColumnName = "station_id", nullable = false, updatable = true, insertable = true)
	private String stationId;
	
	
	@Column(name = "need_reply", nullable = false, updatable = true, insertable = true)
	private int needReply;
	
	public VocQuestion() {}

	@Builder
	public VocQuestion(String category, String title, String content, String username, String email, String stationId,
			int needReply, LocalDateTime createAt) {
		this.category = category;
		this.title = title;
		this.content = content;
		this.username = username;
		this.email = email;
		this.stationId = stationId;
		this.needReply = needReply;
	}
}
