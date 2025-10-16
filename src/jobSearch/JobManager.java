package jobSearch;
import java.util.ArrayList;
import java.util.Scanner;


public class JobManager {
	
	/*
	 * ArrayList containing the list of JobApplications
	 */
	private ArrayList<JobApplication> jobs;
	
	/*
	 * Scanner object for reading user input
	 */
	private Scanner scanner;
	
	public JobManager() {
		this.jobs = new ArrayList<>();
		this.scanner = new Scanner(System.in);
	}
	
	/*
	 * Add a JobApplication to jobs
	 */
	public void addJob(JobApplication job) {
		this.jobs.add(job);
	}
	
	/*
	 * Prompts user to enter job application details and creates a JobApplication object
	 * @return new JobApplication object
	 */
	public JobApplication inputJob() {
		System.out.println("Enter name of company:");
		String companyName = scanner.nextLine();
		System.out.println("Enter job title:");
		String jobTitle = scanner.nextLine();
		System.out.println("Enter date posted:");
		String datePosted = scanner.nextLine();
		System.out.println("Enter pay information:");
		String payInformation = scanner.nextLine();
		return new JobApplication(companyName, jobTitle, datePosted, payInformation);
	}
	
	/*
	 * Prints all the stored jobs to terminal
	 */
	public void DisplayJobs() {
		for(JobApplication job: this.jobs) {
			System.out.println("Company: " + job.getCompanyName() + ", Job Title: " + job.getJobTitle() + 
					", Date Posted: " + job.getDatePosted() + ", Pay Information: " + job.getPayInformation());
		}
	}

	public static void main(String[] args) {
		JobManager manager = new JobManager();
		String response = "";
		while (!response.equals("quit")) {
			System.out.println("What would you like to do?" + '\n' +
					"1: Input Job" + "\n" +
					"2: Display Jobs" + '\n' +
					"quit: Exit program");
			response = manager.scanner.nextLine();
			switch (response) {
			case "1":
				manager.addJob(manager.inputJob());
				break;
			case "2":
				manager.DisplayJobs();
				break;
			case "quit":
				System.out.println("Exiting program");
				break;
			default:
				System.out.println("Invalid input");
			}
		}

	}

}
