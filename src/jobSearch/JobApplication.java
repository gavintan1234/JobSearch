package jobSearch;

public class JobApplication {
	/*
	 * Name of the company who posted the application
	 */
	private String companyName;
	
	/*
	 * Job title for the job application
	 */
	private String jobTitle;
	
	/*
	 * Job description
	 */
	private String jobDesc;
	
	/*
	 * Date the job was posted
	 */
	private String datePosted;
	
	/*
	 * Salary range for the job
	 */
	private String payInformation;
	
	/*
	 * Constructs a JobApplication
	 */
	public JobApplication(String companyName, String jobTitle, String jobDesc, String datePosted, String payInformation) {
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.jobDesc = jobDesc;
		this.datePosted = datePosted;
		this.payInformation = payInformation;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public String getJobTitle() {
		return this.jobTitle;
	}
	
	public String getDatePosted() {
		return this.datePosted;
	}
	
	public String getPayInformation() {
		return this.payInformation;
	}
}
