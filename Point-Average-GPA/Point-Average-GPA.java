
package pointaveragegpa;


import java.util.Scanner;

/**
 *
 * @author Kerry Mannette
 */
public class PointAverageGPA {

    /**
     * @param args the command line arguments
     * January 7, 2022
     * Final Project
     * Name: Student GPA Calculator
     */
    public static void main(String[] args) {
       Scanner input = new Scanner (System.in);
       
//     Declare all variables the use of (Data type: String, int)
//     All program methods (Methods: calQualityPoints, calGPA)
//     All array assigned (Arrays: gradeEARN_IN_COURSE_LETTER, gradeVALUE_POINTS)


//     User welcome greeting and program version
       String outputWELCOME_GREETING = "Welcome to student GPA calculator (Version: 1.0)";
      
//     Find student first and last names
       String studentFName, studentLName; 
       
//     Find student academic year
       String academicYear;
       
//     Find semester number with roman numerals
       String semesterNo_ROMAN_NUMERALS;

//     Find student ID
       int studentID;
      
       
//     Output user greeting and program version
       System.out.println(outputWELCOME_GREETING+ "\n");
   
     
       
//     Find for  (Student: first and last name, student ID, academic year) 
    

//     Find student first and last name
       System.out.print("Please enter student (First and Last Name): ");
       studentFName = input.next();
       studentLName = input.next();
       
       
//     Find student ID number
       System.out.print("Please enter student ID (e.g. 00022333): ");
       studentID = input.nextInt();

       
//     Find academic year
       System.out.print("Please enter academic year (e.g. 2020/2021): ");
       academicYear = input.next();

       
//     Find semester number using roman numerals
       System .out.print("Please enter semester number (e.g. II): ");
       semesterNo_ROMAN_NUMERALS = input.next();
//     Send student first and last name, academic year, semester number to (Method: calQualityPoints)
       calQualityPoints(studentFName,studentLName,academicYear,semesterNo_ROMAN_NUMERALS);
   
    }
    
    
//     Find student quality points and GPA using (Method: calQualityPoints, calGPA)
    
    
//  Find for student quality points    
    public static void calQualityPoints (String studentFName, String studentLName, String academicYear, String semesterNo_ROMAN_NUMERALS){
       Scanner input = new Scanner (System.in);
       
//     Declare all variables the use of (Data type: String, int, double)

       
//     Find the course name
       String courseNAME;  
       
//     Find  course code number, courses completed for this semester
       int courseCODE_NUMBER, courses_COMPLETED_FOR_THIS_SEMESTER;
       
//     Find student points, total grade points
       double find_POINTS, total_GRADE_POINTS = 0;
       
//     Find for student total quality points, send quality points to method, course credit, total credit
       double Total_Quality_Point_Is_Equal_TO = 0, METHOD_TOTAL_QUALITY_POINTS, courseCREDIT,  Find_TotalCredit = 0;
       
              
//     Find for  (Student: course code, course credit, grade earn) 
 

//     Find the amount of courses the student completed for this semester
       System.out.print("\nPlease enter the amount of courses you completed for this semester (e.g. 5): ");
       courses_COMPLETED_FOR_THIS_SEMESTER  = input.nextInt();
//     Find if student did all their courses this semester or not
       if (courses_COMPLETED_FOR_THIS_SEMESTER  == 0x0){
//     This statement is outputed if the student has not completed any courses this semester
       System.out.print("Sorry! you didn't pursued any courses this semester.\n ");
       return;
       }else if (courses_COMPLETED_FOR_THIS_SEMESTER  == 5){
//     This statement is outputed if the student has completed all their courses for this semester
       System.out.print("Congratulation! you have done all your courses this semester.\n ");
       }else if (courses_COMPLETED_FOR_THIS_SEMESTER > 5){
//     This statement is outputed if the student has entered more that five courses
       System.out.print("Error! you can not select more than 5 courses.\n ");
       return;
       }
       
          
     
//     Find for student grade earn and grade value points with (Array: gradeEARN_IN_COURSE_LETTER, gradeVALUE_POINTS) 


//     Assign a grades array
       String gradeEARN_IN_THE_COURSE [] = new String [courses_COMPLETED_FOR_THIS_SEMESTER];
       
       
//     Find for all courses for this semester using a for loop statement with the grade array length
       for (int y = 0; y < gradeEARN_IN_THE_COURSE.length; y++){
   
                       
//     Find the course code
       System.out.print("\nPlease enter the course code (e.g. ITECH 133): ");
       courseNAME = input.next();
       courseCODE_NUMBER = input.nextInt();
       
       
//     Find the course credit
       System.out.print("Please enter the course credit (e.g. 3): ");
       courseCREDIT = input.nextDouble();
      
       
//     Find the grade earn in that course
       System.out.print("Please enter the grade earn (e.g. A): ");
       gradeEARN_IN_THE_COURSE[y] = input.next().toUpperCase();
       

//     Assign a grade value points array
       double gradeVALUE_POINTS [] = {4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
           
    
//     Find student grade and grade point for each course using switch statement  
       switch(gradeEARN_IN_THE_COURSE[y]){
            case "A":
//              Grade point awarded for A students
                total_GRADE_POINTS = gradeVALUE_POINTS [0];
                break;
            case "B+":
//              Grade point awarded for B+ students
                total_GRADE_POINTS = gradeVALUE_POINTS [1];
                break;
            case "B":
//              Grade point awarded for B students
                total_GRADE_POINTS = gradeVALUE_POINTS [2];
                break;
            case "C+":
//              Grade point awarded for C+ students
                total_GRADE_POINTS = gradeVALUE_POINTS [3];
                break;
            case "C":
//              Grade point awarded for C students
                total_GRADE_POINTS = gradeVALUE_POINTS [4];
                break;
            case "D+":
//              Grade point awarded for D+ students
                total_GRADE_POINTS = gradeVALUE_POINTS [5];
                break;
            case "D":
//              Grade point awarded for D students
                total_GRADE_POINTS = gradeVALUE_POINTS [6];
                break;
            case "F":
//              Grade point awarded for F students
                total_GRADE_POINTS = gradeVALUE_POINTS [7];
//              This statement is outputed if the student has not obtain any grade value points
                System.out.println("Sorry! you did not optain any grade value points for this course. ");
                break;
//              This statement is outputed if the grade is invalid
       default: System.out.println("Invalid Grade");       
       }
            
//     Find for student quality points by multiplying total_GRADE_POINTS and courseCREDIT 
       find_POINTS = total_GRADE_POINTS * courseCREDIT;
//     Find for student total quality point
       Total_Quality_Point_Is_Equal_TO += find_POINTS;
//     Find for student total credit
       Find_TotalCredit += courseCREDIT;
                              
       }
                 
//     Send student course total quality points and credits to (method: calGPA ) 
       METHOD_TOTAL_QUALITY_POINTS = calGPA (Total_Quality_Point_Is_Equal_TO,Find_TotalCredit);
    
//     Final output of student name, academic year, semester number, and GPA
       System.out.print(studentFName+ " " +studentLName+ " your GPA for year " +academicYear+ " semester " +semesterNo_ROMAN_NUMERALS+ " is (" +METHOD_TOTAL_QUALITY_POINTS+ ")\n");
                    
    }  
        
      
//  Find for student GPA
    public static double calGPA (double findTOTAL_QUALITY_POINTS, double findCOURSE_CREDIT){
//     Declare all variables the use of (Data type: double)

       double findTOTAL_GPA;
      
//     Find for student GPA by dividing findTOTAL_QUALITY_POINTS and findCOURSE_CREDIT
       findTOTAL_GPA = findTOTAL_QUALITY_POINTS / findCOURSE_CREDIT;
//     Return student GPA to final output
       return findTOTAL_GPA;
     
    }
    
  
}
