package jobSearch;

public class Job {
	/*
	 * Company name
	 */
	private String companyName;
	
	/*
	 * Job title
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
	 * Constructs a Job
	 */
	public Job(String companyName, String jobTitle, String jobDesc, String datePosted, String payInformation) {
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.jobDesc = jobDesc;
		this.datePosted = datePosted;
		this.payInformation = payInformation;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getJobTitle() {
		return this.jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getJobDesc() {
		return this.jobDesc;
	}
	
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getDatePosted() {
		return this.datePosted;
	}
	
	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}
	
	public String getPayInformation() {
		return this.payInformation;
	}
	
	public void setPayInformation(String payInformation) {
		this.payInformation = payInformation;
	}
}
