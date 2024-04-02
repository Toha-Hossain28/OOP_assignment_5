import java.util.Random;

class Semester{
    public Student[] students;
    public Course[] courses;
    private int studentCount;
    private int courseCount;

    public Semester(){
        this.students = new Student[20];
        this.courses = new Course[5];
        this.studentCount = 0;
        this.courseCount = 0;
    }

    public void addStudent(Student student){
        students[studentCount++] = student;
    }
    public void addCourse(Course course){
        courses[courseCount++] = course;
    }

    public int getCourseCount(){
        return courseCount;
    }

    public int getStudentCount(){
        return studentCount;
    }

    // Function to rank student according to GPA
    public void rankStudentsBasedOnGPA(){
        for(int i=0;i<studentCount-1;i++){
            for(int j=0;j<studentCount-i-1;j++){
                if(students[j].getGPA()<students[j + 1].getGPA()){
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        for(int i = 0;i<studentCount;i++){
            System.out.println("------------------------------------------------------------");
            System.out.println("name: " + students[i].getStudentName());
            System.out.println("roll: " + students[i].getRoll());
            System.out.println("email: " + students[i].getEmail());
            System.out.println("GPA: " + String.format("%.2f", students[i].getGPA()));
            // System.out.println("***************");
            // System.out.println("Major Courses");
            // for (int j = 0; j < students[i].getStudentCourseCount(); j++) {
            //     System.out.println("Course Name: " + students[i].majorCourses[j].getCourseName());
            //     System.out.println("Credit: " + students[i].majorCourses[j].getCredit());
            //     System.out.println("Mid Term Marks: " + students[i].majorCourses[j].getMidTermMarks());
            //     System.out.println("Regular Assessment Marks: " + students[i].majorCourses[j].getRegularAssessment());
            //     System.out.println("Final Marks: " + students[i].majorCourses[j].getFinalMarks());
            //     System.out.println("Grade: " + students[i].majorCourses[j].getGrade());
            //     System.out.println("***************");
            // }
            // System.out.println("Minor Course");
            // System.out.println("Course Name: " + students[i].getMinorCourse().getCourseName());
            // System.out.println("Credit: " +students[i].getMinorCourse().getCredit());
            // System.out.println("Mid Term Marks: " +students[i].getMinorCourse().getMidTermMarks());
            // System.out.println("Regular Assessment Marks: " +students[i].getMinorCourse().getRegularAssessment());
            // System.out.println("Final Marks: " +students[i].getMinorCourse().getFinalMarks());
            // System.out.println("Grade: " +students[i].getMinorCourse().getGrade());
            System.out.println("------------------------------------------------------------");
        }
    }

    //Function to list all the student
    public void listStudents(){
        for(int i=0;i<studentCount;i++){
            for(int j=0;j<studentCount-i-1;j++){
                if(students[j].getRoll()>students[j + 1].getRoll()){
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        for(int i = 0;i<studentCount;i++){
            System.out.println("------------------------------------------------------------");
            System.out.println("name: " + students[i].getStudentName());
            System.out.println("roll: " + students[i].getRoll());
            System.out.println("email: " + students[i].getEmail());
            System.out.println("GPA: " + String.format("%.2f", students[i].getGPA()));
            System.out.println("************************************************");
            System.out.println("Major Courses");
            for (int j = 0; j < students[i].getStudentCourseCount(); j++) {
                System.out.println("Course Name: " + students[i].majorCourses[j].getCourseName());
                System.out.println("Credit: " + students[i].majorCourses[j].getCredit());
                System.out.println("Mid Term Marks: " + students[i].majorCourses[j].getMidTermMarks());
                System.out.println("Regular Assessment Marks: " + students[i].majorCourses[j].getRegularAssessment());
                System.out.println("Final Marks: " + students[i].majorCourses[j].getFinalMarks());
                System.out.println("Grade: " + students[i].majorCourses[j].getGrade());
                System.out.println("************************************************");
            }
            System.out.println("Minor Course");
            System.out.println("Course Name: " + students[i].getMinorCourse().getCourseName());
            System.out.println("Credit: " +students[i].getMinorCourse().getCredit());
            System.out.println("Mid Term Marks: " +students[i].getMinorCourse().getMidTermMarks());
            System.out.println("Regular Assessment Marks: " +students[i].getMinorCourse().getRegularAssessment());
            System.out.println("Final Marks: " +students[i].getMinorCourse().getFinalMarks());
            System.out.println("Grade: " +students[i].getMinorCourse().getGrade());
            System.out.println("------------------------------------------------------------");
        }
    }

    public void rankStudentAccordingToCourse(String name) {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                double grade1 = students[j].getCourseGrade(name);
                double grade2 = students[j + 1].getCourseGrade(name);

                if (grade1 == -1 || grade2 == -1) {
                    if (grade1 == -1 && grade2 != -1) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                } else {
                    if (grade1 < grade2) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }
        }
        for(int i = 0;i<studentCount;i++){
            System.out.println("------------------------------------------------------------");
            System.out.println("name: " + students[i].getStudentName());
            System.out.println("roll: " + students[i].getRoll());
            System.out.println("email: " + students[i].getEmail());
            System.out.println("GPA: " + String.format("%.2f", students[i].getGPA()));
            System.out.println("***************");
            System.out.println("Major Courses");
            for (int j = 0; j < students[i].getStudentCourseCount(); j++) {
                System.out.println("Course Name: " + students[i].majorCourses[j].getCourseName());
                System.out.println("Credit: " + students[i].majorCourses[j].getCredit());
                System.out.println("Mid Term Marks: " + students[i].majorCourses[j].getMidTermMarks());
                System.out.println("Regular Assessment Marks: " + students[i].majorCourses[j].getRegularAssessment());
                System.out.println("Final Marks: " + students[i].majorCourses[j].getFinalMarks());
                System.out.println("Grade: " + students[i].majorCourses[j].getGrade());
                System.out.println("***************");
            }
            System.out.println("Minor Course");
            System.out.println("Course Name: " + students[i].getMinorCourse().getCourseName());
            System.out.println("Credit: " +students[i].getMinorCourse().getCredit());
            System.out.println("Mid Term Marks: " +students[i].getMinorCourse().getMidTermMarks());
            System.out.println("Regular Assessment Marks: " +students[i].getMinorCourse().getRegularAssessment());
            System.out.println("Final Marks: " +students[i].getMinorCourse().getFinalMarks());
            System.out.println("Grade: " +students[i].getMinorCourse().getGrade());
            System.out.println("------------------------------------------------------------");
        }        
    }
}

class Course{
    private String courseName;
    private Student[] courseStudents;
    private int courseStudentCount;
    public Course (String name){
        this.courseName = name;
        courseStudentCount = 0;
        courseStudents = new Student[30];
    }

    public String getCourseName() {
        return courseName;
    }

    public Student[] getCourseStudents() {
        return courseStudents;
    }

    public int getCourseStudentCount() {
        return courseStudentCount+1;
    }

    public void addStudentToCourse(Student student){
        courseStudents[this.courseStudentCount++] = student;
    }

    //Function to list all the student in this course
    public void listStudentsInCourse(){
        for(int i=0; i<=this.courseStudentCount;i++){
            System.out.println(this.courseStudents[i].getStudentName());
        }
    }


    //Function to rank all the Course student
    public void rankStudent(){
        for (int i = 0; i < courseStudentCount - 1; i++) {
            for (int j = 0; j < courseStudentCount - i - 1; j++) {
                double grade1 = courseStudents[j].getCourseGrade(courseName);
                double grade2 = courseStudents[j + 1].getCourseGrade(courseName);
                if(grade1 == -1 || grade2 == -1){
                    if(grade1 == -1 && grade2 != -1){
                        Student temp = courseStudents[j];
                        courseStudents[j] = courseStudents[j + 1];
                        courseStudents[j + 1] = temp;
                    }
                }
                else{
                    if (grade1 < grade2) {
                        Student temp = courseStudents[j];
                        courseStudents[j] = courseStudents[j + 1];
                        courseStudents[j + 1] = temp;
                    }
                }

            }
        }
        for (int i = 0; i < courseStudentCount; i++) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Student Name: " + courseStudents[i].getStudentName());
            System.out.println("Roll: " + courseStudents[i].getRoll());
            System.out.println("Grade: " + courseStudents[i].getCourseGrade(courseName));
            System.out.println("------------------------------------------------------------");
        }
    }
    
    



    //Function to list all student details
    public void listStudents(){
        for(int i = 0;i<courseStudentCount;i++){
            System.out.println("name: " + courseStudents[i].getStudentName() + " roll: " + courseStudents[i].getRoll());
        }
    }
}
class EnrolledCourse{
    private Student student;
    private String courseName;
    private double grade;
    private double credit;
    private double midTermMarks;
    private double regularAssessmentMarks;
    private double finalMarks;

    public EnrolledCourse(Student student, String courseName, double credit, double midTermMarks, double regularAssessment, double finalMarks){
        this.student = student;
        this.courseName = courseName;
        this.credit = credit;
        this.midTermMarks = midTermMarks;
        this.regularAssessmentMarks = regularAssessment;
        this.finalMarks = finalMarks;
        this.grade = 0;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getMidTermMarks() {
        return midTermMarks;
    }

    public void setMidTermMarks(double midTermMarks) {
        this.midTermMarks = midTermMarks;
    }

    public double getRegularAssessment() {
        return regularAssessmentMarks;
    }

    public void setRegularAssessment(double regularAssessment) {
        this.regularAssessmentMarks = regularAssessment;
    }

    public double getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(double finalMarks) {
        this.finalMarks = finalMarks;
    }

    public void calculateGrade() {
        int totalMarks = (int) (midTermMarks + regularAssessmentMarks + finalMarks);
        if (totalMarks >= 80) {
            grade = 4.0;
        }
        else if (totalMarks >= 75) {
            grade = 3.75;
        }
        else if (totalMarks >= 70) {
            grade = 3.5;
        }
        else if (totalMarks >= 65) {
            grade = 3.25;
        }
        else if (totalMarks >= 60) {
            grade = 3;
        }
        else if (totalMarks >= 55) {
            grade = 2.75;
        }
        else if (totalMarks >= 50) {
            grade = 2.5;
        }
        else if (totalMarks >= 45) {
            grade = 2.25;
        }
        else if (totalMarks >= 40) {
            grade = 2;
        }
        else {
            grade = 0;
        }
    }
}

class Student{
    private String studentName;
    private int roll;
    private String email;
    public EnrolledCourse[] majorCourses;
    public EnrolledCourse minorCourse;
    private int StudentCourseCount;
    private Double GPA;

    public Student(String name, int roll, String email){
        this.studentName = name;
        this.roll = roll;
        this.email = email;
        this.StudentCourseCount = 0;
        this.majorCourses = new EnrolledCourse[3];
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnrolledCourse getMinorCourse() {
        return minorCourse;
    }

    public void setMinorCourse(EnrolledCourse minorCourse) {
        this.minorCourse = minorCourse;
    }

    public Double getGPA() {
        return GPA;
    }

    public void addMajorCourse(EnrolledCourse course) {
        majorCourses[StudentCourseCount++] = course;
    }

    public int getStudentCourseCount() {
        return StudentCourseCount;
    } 

    public void calculateGPA() {
        double totalCredit = 0;
        double totalGrade = 0;
        for (int i = 0; i < StudentCourseCount; i++) {
            totalCredit += majorCourses[i].getCredit();
            totalGrade += majorCourses[i].getGrade() * majorCourses[i].getCredit();
        }
        if (minorCourse != null) {
            totalCredit += minorCourse.getCredit();
            totalGrade += minorCourse.getGrade() * minorCourse.getCredit();
        }
        if (totalCredit == 0) {
            GPA = 0.0;
        } else {
            GPA = totalGrade / totalCredit;
        }
    }

    public double getCourseGrade(String name) {
        for (int i = 0; i < StudentCourseCount; i++) {
            if (majorCourses[i].getCourseName().equals(name)) {
                return majorCourses[i].getGrade();
            }
        }
        if (minorCourse != null) {
            if (minorCourse.getCourseName().equals(name)) {
                return minorCourse.getGrade();
            }
        }
        return -1;
    }

}

public class Main {
    public static void main(String[] args) {
        Semester semester1 = new Semester();
        Course ArtificialIntelligence = new Course("ArtificialIntelligence");
        Course Security = new Course("Security");
        Course OperationResearch = new Course("OperationResearch");
        Course Networking = new Course("Networking");
        Course EmbeddedSystems = new Course("EmbeddedSystems");
        semester1.addCourse(ArtificialIntelligence);
        semester1.addCourse(Security);
        semester1.addCourse(OperationResearch);
        semester1.addCourse(Networking);
        semester1.addCourse(EmbeddedSystems);
        int n = 20;
        Random rnd = new Random();
        final String[] firstNames = {
                "Anik", "Tahmid", "Jannatul", "Shamima", "Rahim", "Farhana", "Rana", "Munni",
                "Saif", "Nila", "Tania", "Riaz", "Kabir", "Shirin", "Faisal", "Afroza",
                "Jubair", "Humaira", "Faruk", "Lucky", "Salma", "Mamun", "Popy", "Rony"
        };
        final String[] lastNames = {
                "Khan", "Ahmed", "Islam", "Chowdhury", "Begum", "Roy", "Das", "Miah",
                "Hossain", "Jakia", "Rahman", "Karim", "Kalam", "Akter", "Sarker", "Ali",
                "Khatun", "Mia", "Mollah", "Hawlader", "Talukder"
        };
        final String[] courseList = {
                "ArtificialIntelligence", "Security", "OperationResearch", "Networking", "EmbeddedSystems"
        };
        for(int i=0;i<n;i++){
            int []mapArr = new int[5];
            for(int j=0;j<5;j++){
                mapArr[j]=0;
            }
            String FN = firstNames[rnd.nextInt(firstNames.length)];
            String LN = lastNames[rnd.nextInt(lastNames.length)];
            Student s = new Student(FN+" "+LN,i+1,FN+"@gmail.com");
            for(int l=0;l<3;l++){
                int courseIndex = rnd.nextInt(5);
                if(mapArr[courseIndex]==0){
                    String cName = courseList[courseIndex];
                    mapArr[courseIndex]++;
                    int midmarks = rnd.nextInt(30)+1;
                    int regAssess = rnd.nextInt(10)+1;
                    int finalMark = rnd.nextInt(60)+1;
                    EnrolledCourse c = new EnrolledCourse(s,cName,3,midmarks,regAssess,finalMark);
                    c.calculateGrade();
                    s.addMajorCourse(c);
                    for(int p=0;p<semester1.getCourseCount();p++){
                        if(semester1.courses[p].getCourseName().equals(cName)){
                            semester1.courses[p].addStudentToCourse(s);
                        }
                    }
                }
                else{
                    l--;
                }
            }
            while(true){
                int courseIndex = rnd.nextInt(5);
                if(mapArr[courseIndex]==0){
                    String cName = courseList[courseIndex];
                    mapArr[courseIndex]++;
                    int midmarks = rnd.nextInt(30)+1;
                    int regAssess = rnd.nextInt(10)+1;
                    int finalMark = rnd.nextInt(60)+1;
                    EnrolledCourse c = new EnrolledCourse(s,cName,1.5,midmarks,regAssess,finalMark);
                    c.calculateGrade();
                    s.setMinorCourse(c);
                    for(int p=0;p<semester1.getCourseCount();p++){
                        if(semester1.courses[p].getCourseName().equals(cName)){
                            semester1.courses[p].addStudentToCourse(s);
                        }
                    }
                    break;
                }
            }
            s.calculateGPA();
            semester1.addStudent(s);
        }
        semester1.listStudents();
        semester1.rankStudentsBasedOnGPA();
    }
}
