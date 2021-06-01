package hrms.humanResourcesManagementSystem.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {

	private String companyName;
	private String title;
	private int numberOfOpenPositions;
	private LocalDateTime publishedDateTime;
	private LocalDateTime deadLineForAppeal;

}
