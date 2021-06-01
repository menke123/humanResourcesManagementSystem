package hrms.humanResourcesManagementSystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hrms.humanResourcesManagementSystem.entities.concretes.JobAdvert;
import hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto"
            + "(e.companyName, jT.title, jA.numberOfOpenPositions,"
            + " jA.publishedDateTime, jA.deadLineForAppeal) from Employer e"
            + " inner join e.jobAdverts jA inner join jA.jobTitle jT where jA.active = true")
	List<JobAdvertDto> getJobAdvertDtosByActiveTrue();

	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto"
            + "(e.companyName, jT.title, jA.numberOfOpenPositions,"
            + " jA.publishedDateTime, jA.deadLineForAppeal) from Employer e"
            + " inner join e.jobAdverts jA inner join jA.jobTitle jT where jA.active = true order by  jA.publishedDateTime desc")
	List<JobAdvertDto> getJobAdvertDtosByPublishedDateTimeAndActiveTrue();

	@Query("select new hrms.humanResourcesManagementSystem.entities.dtos.JobAdvertDto"
            + "(e.companyName, jT.title, jA.numberOfOpenPositions,"
            + " jA.publishedDateTime, jA.deadLineForAppeal) from Employer e"
            + " inner join e.jobAdverts jA inner join jA.jobTitle jT where jA.active = true"
            + " and e.id=:employerId")
	List<JobAdvertDto> getJobAdvertDtosByEmployerIdAndActiveTrue(int employerId);

}
