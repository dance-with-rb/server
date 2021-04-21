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
@Entity(name="voc_answer")
public class VocAnswer extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, insertable = false)
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = VocQuestion.class)
	@JoinColumn(name="question_id", referencedColumnName = "id", nullable = false, updatable = true, insertable = true)
	private int questionId;
	
	@Column(name = "content", nullable = false, updatable = true, insertable = true)
	private String content;
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = AdminItem.class)
	@JoinColumn(name="admin_id", referencedColumnName = "id", nullable = false, updatable = true, insertable = true)
	private String adminId;
	
	public VocAnswer() {}

	@Builder
	public VocAnswer(int questionId, String content, String adminId, LocalDateTime createAt) {
		this.questionId = questionId;
		this.content = content;
		this.adminId = adminId;
	}
}
