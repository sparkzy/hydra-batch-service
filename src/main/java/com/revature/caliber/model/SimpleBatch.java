package com.revature.caliber.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * The type Simple Batch.
 */
@Entity
@Table(name = "CALIBER_BATCH")
@Cacheable
public class SimpleBatch implements Serializable {
	private static final long serialVersionUID = -7000300062384597615L;

	@Id
	@Column(name = "BATCH_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BATCH_ID_SEQUENCE")
	@SequenceGenerator(name = "BATCH_ID_SEQUENCE", sequenceName = "BATCH_ID_SEQUENCE")
	private Integer batchId;

	@Column(name = "RESOURCE_ID")
	private String resourceId;

	@NotNull
	@Column(name = "TRAINING_NAME")
	private String trainingName;

	@NotNull
	// @JsonProperty
	@Column(name = "TRAINER_ID", nullable = false)
	private Integer trainerId;

	@Column(name = "CO_TRAINER_ID")
	private Integer coTrainerId;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "SKILL_TYPE")
	private SkillType skillType;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "TRAINING_TYPE")
	private TrainingType trainingType;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE", nullable = false)
	private Date endDate;

	@NotEmpty
	@Column(name = "LOCATION", nullable = false)
	private String location;

	@Column(name = "ADDRESS_ID")
	private Integer addressId;

	/**
	 * Anything above this grade is GREEN
	 */
	@Min(value = 1)
	@Column(name = "GOOD_GRADE_THRESHOLD")
	private Short goodGradeThreshold;

	/**
	 * Anything above this grade but below goodGradeThreshold is YELLOW Anything
	 * below this grade is RED
	 */
	@Min(value = 1)
	@Column(name = "BORDERLINE_GRADE_THRESHOLD")
	private Short borderlineGradeThreshold;

	@Column(name = "NUMBER_OF_WEEKS", nullable = false)
	private Integer weeks;

	@Column(name = "GRADED_WEEKS")
	private Integer gradedWeeks;

	public SimpleBatch() {
		super();
		this.weeks = 1;
		this.gradedWeeks = 7;
		this.goodGradeThreshold = 80;
		this.borderlineGradeThreshold = 70;
		this.trainingType = TrainingType.Revature;
	}

	/**
	 * Constructor mostly used for testing. Defaults TrainingType - Revature,
	 * SkillType - J2EE, Good grade - 80, and Borderline grade - 70
	 *
	 * @param trainingName
	 * @param trainer
	 * @param startDate
	 * @param endDate
	 * @param location
	 */
	public SimpleBatch(String trainingName, Integer trainerId, Date startDate, Date endDate, String location) {
		super();
		this.trainingName = trainingName;
		this.trainerId = trainerId;
		this.skillType = SkillType.J2EE;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
	}

	public SimpleBatch(Batch batch) {
		super();
		this.batchId = batch.getBatchId();
		this.resourceId = batch.getResourceId();
		this.trainingName = batch.getTrainingName();
		this.trainerId = batch.getTrainer() != null ? batch.getTrainer().getTrainerId() : null;
		this.coTrainerId = batch.getCoTrainer() != null ? batch.getCoTrainer().getTrainerId() : null;
		this.skillType = batch.getSkillType();
		this.trainingType = batch.getTrainingType();
		this.startDate = batch.getStartDate();
		this.endDate = batch.getEndDate();
		this.location = batch.getLocation();
		this.addressId = batch.getAddress() != null ? batch.getAddress().getAddressId() : null;
		this.goodGradeThreshold = batch.getGoodGradeThreshold();
		this.borderlineGradeThreshold = batch.getBorderlineGradeThreshold();
		this.trainingType = batch.getTrainingType();
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public Integer getCoTrainerId() {
		return coTrainerId;
	}

	public void setCoTrainerId(Integer coTrainerId) {
		this.coTrainerId = coTrainerId;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public TrainingType getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Short getGoodGradeThreshold() {
		return goodGradeThreshold;
	}

	public void setGoodGradeThreshold(Short goodGradeThreshold) {
		this.goodGradeThreshold = goodGradeThreshold;
	}

	public Short getBorderlineGradeThreshold() {
		return borderlineGradeThreshold;
	}

	public void setBorderlineGradeThreshold(Short borderlineGradeThreshold) {
		this.borderlineGradeThreshold = borderlineGradeThreshold;
	}

	public Integer getWeeks() {
		return weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}

	public Integer getGradedWeeks() {
		return gradedWeeks;
	}

	public void setGradedWeeks(Integer gradedWeeks) {
		this.gradedWeeks = gradedWeeks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + batchId;
		result = prime * result + borderlineGradeThreshold;
		result = prime * result + ((coTrainerId == null) ? 0 : coTrainerId.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + goodGradeThreshold;
		result = prime * result + gradedWeeks;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result + ((skillType == null) ? 0 : skillType.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
		result = prime * result + ((trainingName == null) ? 0 : trainingName.hashCode());
		result = prime * result + ((trainingType == null) ? 0 : trainingType.hashCode());
		result = prime * result + weeks;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleBatch other = (SimpleBatch) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (batchId != other.batchId)
			return false;
		if (borderlineGradeThreshold != other.borderlineGradeThreshold)
			return false;
		if (coTrainerId == null) {
			if (other.coTrainerId != null)
				return false;
		} else if (!coTrainerId.equals(other.coTrainerId))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (goodGradeThreshold != other.goodGradeThreshold)
			return false;
		if (gradedWeeks != other.gradedWeeks)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		if (skillType != other.skillType)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		if (trainingName == null) {
			if (other.trainingName != null)
				return false;
		} else if (!trainingName.equals(other.trainingName))
			return false;
		if (trainingType != other.trainingType)
			return false;
		if (weeks != other.weeks)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimpleBatch [batchId=" + batchId + ", resourceId=" + resourceId + ", trainingName=" + trainingName
				+ ", trainerId=" + trainerId + ", coTrainerId=" + coTrainerId + ", skillType=" + skillType
				+ ", trainingType=" + trainingType + ", startDate=" + startDate + ", endDate=" + endDate + ", location="
				+ location + ", addressId=" + addressId + ", goodGradeThreshold=" + goodGradeThreshold
				+ ", borderlineGradeThreshold=" + borderlineGradeThreshold + ", weeks=" + weeks + ", gradedWeeks="
				+ gradedWeeks + "]";
	}
}