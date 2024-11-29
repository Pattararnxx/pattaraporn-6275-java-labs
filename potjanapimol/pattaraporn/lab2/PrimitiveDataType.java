package potjanapimol.pattaraporn.lab2;
/*
 * Author: Pattaraporn Potjanapimol
 * ID : 673040627-5
 * The PrimitiveDataType Program
 * This Program output the values of all the variables in the format type
 * Type => String byte short integer long float double char boolean
 * Last-Update : 29/11/2567
 * The output should be
 * Student ID : <num_studentNumber>
 * First Name : <student_name>
 * Byte Value: <num_myByte>
 * Short Value: <num_myShort>
 * Int Value: <num_myInt>
 * Long Value: <num_mylong>
 * Float Value: <numf_myfloat>
 * Double Value: <numf_myDouble>
 * Char Value: <myChar_alphabet>
 * Boolean Value: <myboolean>
 */
public class PrimitiveDataType {
    public static void main(String[] args) {
        // Declaring variables and Assigning value
        String studentNumber = "673040627-5";
        String firstname = "Pattaraporn";
        byte myByte = 11;
        short myShort =231;
        int myInt = 406275;
        long myLong = 67304046275l;
        float myFloat = 0.11f;
        double myDouble = 0.6275;
        char myChar = 'P';
        boolean myBoolean = true;
        // Outputting Variable
        System.out.println("Student ID : "+studentNumber);
        System.out.println("First Name : "+firstname);
        System.out.println("Byte Value: "+myByte);
        System.out.println("Short Value: "+myShort);
        System.out.println("Int Value: "+myInt);
        System.out.println("Long Value: "+myLong);
        System.out.println("Float Value: "+myFloat);
        System.out.println("Double Value: "+myDouble);
        System.out.println("Char Value: "+myChar);
        System.out.println("Boolean Value: "+myBoolean);
        
    }
}
