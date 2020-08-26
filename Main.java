public class Main {

	public static void main (String[] args) throws Exception {

		Course course = new Course();

		String path = "students.txt";

		// the following line passes the path of the data
		//to be read by readData in Course

		course.readData(path);

		System.out.println("\nThe grades and average of "+
				     "each student are:\n\n" + course);

		/* The below line prints the name and grades of the student
	 	who obtained the highest grade, the mean, and the standard
	 	deviation for each exam at the time
		*/

		for(int i = 0; i<3; i++) {

			System.out.printf("\n\n\n- For exam " + (i+1)+
				"\n\n\tThe student who attained the highest" +
				" grade is:\n\t	%s" +
				"\n\n\tThe mean of the class is: %.3f" +
		 	"\n\n\tThe standard deviation of the class is: %.3f\n",
			course.getByIndex(course.indexOfHighest(i+1)),
			course.findAverageGrade(i+1),course.findStandardDev(i+1));

		} // end for-loop

	} // end main

} // end class studentMain
