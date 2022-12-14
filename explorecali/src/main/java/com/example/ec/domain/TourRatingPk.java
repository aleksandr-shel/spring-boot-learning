package com.example.ec.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TourRatingPk implements Serializable {
	@ManyToOne
	private Tour tour;
	@Column(insertable = false, updatable = false, nullable = false)
	private Integer customerId;
	
	public TourRatingPk() {
		
	}

	public TourRatingPk(Tour tour, Integer customerId) {
		super();
		this.tour = tour;
		this.customerId = customerId;
	}

	public Tour getTour() {
		return tour;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, tour);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TourRatingPk other = (TourRatingPk) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(tour, other.tour);
	}

	@Override
	public String toString() {
		return "TourRatingPk [tour=" + tour + ", customerId=" + customerId + "]";
	}
	
	
}
