import java.util.Scanner;
import java.io.File;

public class Course {

	private Student[] students;

	private int numStudents;

	public Course() {

		students = new Student[100];

		numStudents = 0;

	} // end constructor Course

	//The below method opens up the file from “path” and loads
	//"students" with the data.

	public void readData(String path) throws Exception {

		Scanner sc = new Scanner(new File(path));

		while (sc.hasNext()) {

			String first = sc.next();
			String last = sc.next();
			int exam1 = sc.nextInt();
			int exam2 = sc.nextInt();
			int exam3 = sc.nextInt();

			students[numStudents] = new Student (first, last,
							exam1, exam2, exam3);

			numStudents++;

		} // end while-loop

	} // end readData

	/*The below method returns the index within the array of students that
	holds the student with the highest grade on exam “examNo.” If more than
	one student tied for the highest grade, just return one of them.
	*/

	public int indexOfHighest(int examNo) throws Exception {

		int high = 0;

		try {
			for(int i = 1; i<numStudents; i++) {
				if((students[i].getExam(examNo) <
					students[i+1].getExam(examNo)) &&
					(students[i+1].getExam(examNo) >
					students[high].getExam(examNo)))

					high = i+1;

			} // end for-loop

		} catch (Exception error) {

			;
		}

		return high;

	} // end indexOfHighest

	//returns a reference to the Student at index “index”

 	public Student getByIndex(int index) throws Exception {

		return students[index];

	} // end getByIndex

	// findAverage returns the mean of a given exam number for  the
	// entire class

	public double findAverageGrade(int examNo) throws Exception {

		double sum = 0.0;

		for(int i = 0; i<numStudents; i++)
			sum += students[i].getExam(examNo);

		return sum / numStudents;

	} // end findAverageGrade

	public double findStandardDev(int examNo) throws Exception {

		double sum = 0.0;

		double X = findAverageGrade(examNo);

		for(int i = 0; i<numStudents; i++)
			sum += Math.pow((students[i].getExam(examNo)-X),2);

		// Math.pow(a,b) is a method from java's Math class that
		// determines 'a' to the exponent 'b'

		return Math.sqrt(sum / (numStudents - 1));

	} // end findStandardDev

	/* The following method returns "true" if two objects of the class
	 Course have the same students (e.g. All the students have the  exact
	 first and last names, and grades). Otherwise, it returns "false"
	*/

	public boolean equals (Object obj) {

		boolean result = obj instanceof Course;

		if(!result)
			return false;

		Course another = (Course) obj;

			for(int i = 0; i< numStudents; i++) {
				if(students[i].equals(another.students[i]))
					;
				else
					return false;
			} // end for-loop

		return result;

	} // end boolean equals

	//Creates a String representation for a Course

	public String toString() {

		String result = "";

		for(int i = 0; i<numStudents; i++)
			result += students[i] + "\n";

		return result;

	} // end toString

} // end class Course
