package jobSearch;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;


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
		System.out.println("Enter job description:");
		String jobDesc = scanner.nextLine();
		System.out.println("Enter date posted:");
		String datePosted = scanner.nextLine();
		System.out.println("Enter pay information:");
		String payInformation = scanner.nextLine();
		return new JobApplication(companyName, jobTitle, jobDesc, datePosted, payInformation);
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
	
	/*
	 * Writes jobs out to json file
	 * @param filename the file to save the jobs ArrayList to
	 */
	public void SaveJobs(String filename) {
		Gson gson = new Gson();
		
		// Append ".json" to filename
		if (!filename.endsWith(".json")) {
			filename += ".json";
		}
		
		// Write to filename
		try (Writer writer = new FileWriter(filename)) {
			gson.toJson(this.jobs, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JobManager manager = new JobManager();
		String response = "";
		while (!response.equals("quit")) {
			System.out.println("What would you like to do?" + '\n' +
					"1: Input Job" + "\n" +
					"2: Display Jobs" + '\n' +
					"3: Save Jobs" + '\n' +
					"quit: Exit program");
			response = manager.scanner.nextLine();
			switch (response) {
			case "1":
				manager.addJob(manager.inputJob());
				break;
			case "2":
				manager.DisplayJobs();
				break;
			case "3":
				System.out.println("Specify filename:");
				String filename = manager.scanner.nextLine();
				manager.SaveJobs(filename);
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
