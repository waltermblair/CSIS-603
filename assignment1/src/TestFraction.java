import walter.Fraction;
import java.util.*;
import java.io.*;

/**
 * Modifications here are all taken from my own work in CSCI 230 assignments.
 */

public class TestFraction
{
  public static void main(String[] args)
  {
    long numerator, denominator;
    boolean fromFile = true;
    Fraction f1, f2;
    Scanner in;
    File file = new File(args[0]);
    try {
      in = new Scanner(file);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      in = new Scanner(System.in);
    }

    do {

      System.out.println("Enter four integers representing two fractions (\"0 1 0 1\" to terminate):  ");

      numerator = in.nextLong();
      denominator = in.nextLong();
      System.out.println("First numerator & denominator entered: " + numerator + " / " + denominator);
      f1 = new Fraction(numerator, denominator);

      numerator = in.nextInt();
      denominator = in.nextInt();
      System.out.println("Second numerator & denominator entered: " + numerator + " / " + denominator);
      f2 = new Fraction(numerator, denominator);

      if (!f1.equals(Fraction.ZERO) || !f2.equals(Fraction.ZERO)) {
        System.out.println("f1 = " + f1 + "    f2 = " + f2);
        System.out.println();

        System.out.println("f1.toDouble() = " + f1.toDouble()
                + "    f2.toDouble() = " + f2.toDouble());
        System.out.println();

        System.out.println("f1 == f2 is " + (f1 == f2));
        System.out.println("f1.equals(f2) is " + f1.equals(f2));
        System.out.println("f1.compareTo(f2) is " + f1.compareTo(f2));
        System.out.println();

        System.out.println("-f1 = " + f1.negate());
        System.out.println();

        System.out.println("f1 + f2 = " + f1.add(f2));
        System.out.println("f1 - f2 = " + f1.subtract(f2));
        System.out.println("f1 * f2 = " + f1.multiply(f2));
        System.out.println("f1 / f2 = " + f1.divide(f2));

        System.out.println("***********************************************************");

      }
    }
    while (!f1.equals(Fraction.ZERO) || !f2.equals(Fraction.ZERO));

//     Fraction f = new Fraction(6.2);      // should not be permitted
    in.close();
  }
}
