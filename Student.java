/**
 * @Date: February-26-2020
 * @Author: Alpha Kaba
 * @Description:
 *
 * 		The following program is divided into three classes. The first class
 * is the "Student" one, which receives five parameters through its constructor
 * and initializes the class' variables so that the data for a particular student
 * can be processed.
 * The second class called "Course" purpose is to fill data for all students into
 * the array 'students' and performs calculations such as the average of the class,
 * the standard deviation and more.
 * Finally, the "Main" class contains the main which operates using the "Course"
 * class. The main purpose of the main is to print the list of all students from
 * the data read by course. Lastly, it prints the student who attained the highest
 * grade, the mean, and the standard deviation for a given exam number.
 *
 */


import java.text.DecimalFormat;

public class Student {

	// DecimalFormat will helps me print to three places the average of each
	// student

	private static DecimalFormat df = new DecimalFormat("#.###");

	private String first;

	private String last;

	private int[] examGrades;


	// the below constructor permits us to fill the first, last, and examGrades
	// of each student.

	public Student(String first, String last, int exam1, int exam2, int exam3) {

		examGrades = new int [3];

		examGrades[0] = exam1;
		examGrades[1] = exam2;
		examGrades[2] = exam3;

		this.first = first;
		this.last = last;

	} // end constructor Student


	public String getFirst() {

		return first;

	} // end getFirst

	public String getLast() {

		return last;

	} // end getLast

	//Throughout the code, the user doesn't know that examNo 1 is at
	//the slot 0 of the examGrades, hence I must subtract 1 every time
	//examNo is passed as a parameter

	public int getExam(int examNo) throws Exception {

		return examGrades[examNo-1];

	} // end getExam

	//examNo is which exam needs a grade adjusted, change is the number of
	//points

	public void addPoints(int examNo, int change) throws Exception {

		this.examGrades[examNo-1] += change;

	} // end addPoints

	// finding the average of grades for a given student below

	public double calculateAverage() throws Exception {

		double sum = examGrades[0] + examGrades[1] + examGrades[2];

		return sum / 3;
	}

	//Creates a String representation for a Student below

	public String toString() {

		double average = 0.0;

		try {
			average = calculateAverage();

		} catch (Exception error) {
			System.exit(1);
		}

		return first + "\t" + last + "\tgrades are: " +
			examGrades[0] + " " + examGrades[1] + " " + examGrades[2]
			+ " and the average of these grades is : " +
			 df.format(average);

		// df.format() is a method defined from DecimalFormat

	} // end toString

	//The below method determines whether or not “obj” has equivalent data
	//to “this”

	public boolean equals(Object obj) {

		boolean result = obj instanceof Student;

		if(!result)
			return false;

		Student another  = (Student) obj;

		return  this.first.equals(another.first)
			&& this.last.equals(another.last)
			&& this.examGrades[0] == another.examGrades[0]
			&& this.examGrades[1] == another.examGrades[1]
			&& this.examGrades[2] == another.examGrades[2];

	} // end boolean equals

} // end class Student