package jobSearch;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class JobManager {
	
	/*
	 * ArrayList containing the list of JobApplications
	 */
	private ArrayList<Job> jobs;
	
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
	public void addJob(Job job) {
		this.jobs.add(job);
	}
	
	/*
	 * Prompts user to enter job application details and creates a JobApplication object
	 * @return new JobApplication object
	 */
	public Job inputJob() {
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
		return new Job(companyName, jobTitle, jobDesc, datePosted, payInformation);
	}
	
	/*
	 * Prints all the stored jobs to terminal
	 */
	public void DisplayJobs() {
		for(Job job: this.jobs) {
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
		
		// Write to file
		try (Writer writer = new FileWriter(filename)) {
			gson.toJson(this.jobs, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Loads jobs from json file
	 * @param filename the file to load jobs from
	 */
	public void LoadJobs(String filename) {
		Gson gson = new Gson();
		
		// Append ".json" to filename
		if (!filename.endsWith(".json")) {
			filename += ".json";
		}
		
		// Read from file
		try (Reader reader = new FileReader(filename)) {
			Type listType = new TypeToken<ArrayList<Job>>(){}.getType();
			this.jobs = gson.fromJson(reader, listType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JobManager manager = new JobManager();
		String response = "";
		String filename;
		while (!response.equals("quit")) {
			System.out.println("What would you like to do?" + '\n' +
					"1: Input Job" + "\n" +
					"2: Display Jobs" + '\n' +
					"3: Save Jobs" + '\n' +
					"4: Load Jobs" + '\n' +
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
				filename = manager.scanner.nextLine();
				manager.SaveJobs(filename);
				break;
			case "4":
				System.out.println("Specify filename:");
				filename = manager.scanner.nextLine();
				manager.LoadJobs(filename);
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
