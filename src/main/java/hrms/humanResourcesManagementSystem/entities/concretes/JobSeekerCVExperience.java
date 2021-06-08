package hrms.humanResourcesManagementSystem.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_cv_experiences")
@Entity
public class JobSeekerCVExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "job_seeker_CV_id")
//	private int jobSeekerCVId;
	
	@Column(name = "job_title_id")
	private int jobTitleId;
	
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "institution_name")
	private String institutionName;
	
	@Column(name = "starting_date")
	private LocalDate statingDate;
	
	@Column(name = "ending_date")
	private LocalDate endingDate;
	
//	@Setter()
//	private String status;
//	
//	void setStatus(status) {
//		TODO: Burda bir setter yazılacak
//	}
	
	@Column(name = "added_date_time")
	private LocalDateTime addedDateTime = LocalDateTime.now();
	
//	@JsonIgnore
	@JsonIgnoreProperties({"jobSeekerCVExperiences", "githubAddress", "linkedInAddress",
		"coverLetter", "createdDateTime", "lastUpdatedDateTime", "jobSeekerCVSkills",
		"jobSeekerCVLanguages", "jobSeekerCVEducations", "jobSeekerCVImage"})
	@ManyToOne()
	@JoinColumn(name = "job_seeker_cv_id")
	private JobSeekerCV jobSeekerCV;
	
//	@JsonIgnore
//	@ManyToOne()
//	@JoinColumn(name = "job_title_id")
//	private JobTitle jobTitle;
	
	public JobSeekerCVExperience(int jobSeekerCVId, int jobTitleId,  int cityId,
			String institutionName, LocalDate startingDate, LocalDate endingDate) {
		
		this.jobSeekerCV = new JobSeekerCV();
		this.jobSeekerCV.setId(jobSeekerCVId);
		
		this.jobTitleId = jobTitleId;
		
		this.cityId = cityId;
		
		this.institutionName = institutionName;
		
		this.statingDate = startingDate;
		
		this.endingDate = endingDate;
		
//		this.jobTitle = new JobTitle();
//		this.jobTitle.setId(jobTitleId);
		
	}
	
	
	
}

