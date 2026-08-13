import java.util.Scanner;
public class Gradecalci
{
    public static void main (String ar[]){
    Scanner s = new Scanner(System.in);
    int i , totalmarks = 0 ;
    double avrgpercentage ;
    char grade;

    System.out.println("how many sunjects you have ");
    int subjects = s.nextInt();
    int[] marks = new int[subjects];
    


    for( i=0 ; i< subjects ; i++)
    {
        System.out.println("enter marks for subject :" + (i+1));
        System.out.println("enter makrs between 0 to 100");
        marks[i]= s.nextInt();
        totalmarks  += marks[i];
    }
     avrgpercentage = totalmarks / subjects ;
    
    System.out.println("your grade ");
    if(avrgpercentage >= 90){
          grade = 'A';
    }
    else if ( avrgpercentage >= 80 ){
        grade = 'B';
    }
    else if ( avrgpercentage >= 70 ){
        grade = 'C';
    }
     else if ( avrgpercentage >= 60 ){
        grade = 'D';
     }
     else {
        grade = 'E';
     }

System.out.println("whole Result ");
System.out.println("your total marks are :" + totalmarks);
System.out.println("Your average percentage is  : %.2f%%\n" + avrgpercentage);
System.out.println("your grade is :" + grade);

}
}
