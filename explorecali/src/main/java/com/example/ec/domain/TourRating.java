package com.example.ec.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class TourRating {

	@EmbeddedId
	private TourRatingPk pk;
	@Column(nullable = false)
	private Integer score;
	@Column
	private String comment;
	public TourRatingPk getPk() {
		return pk;
	}
	public void setPk(TourRatingPk pk) {
		this.pk = pk;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public TourRating(TourRatingPk pk, Integer score, String comment) {
        this.pk = pk;
        this.score = score;
        this.comment = comment;
    }
	
	protected TourRating() {
    }
	@Override
	public int hashCode() {
		return Objects.hash(comment, pk, score);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TourRating other = (TourRating) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(pk, other.pk)
				&& Objects.equals(score, other.score);
	}
	@Override
	public String toString() {
		return "TourRating [pk=" + pk + ", score=" + score + ", comment=" + comment + "]";
	}
	
	
	
}
