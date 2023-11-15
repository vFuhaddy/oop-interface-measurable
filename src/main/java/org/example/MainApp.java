package org.example;

/**
   This program demonstrates the measurable BankAccount and Country classes.
*/
public class MainApp
{
   public static void main(String[] args)
   {
      BankAccount b1 = new BankAccount(2000);
      System.out.println( b1.getBalance()   );  // reference of type BankAccount can invoke any BankAccount method

      Measurable m1 = new BankAccount(2000);
      System.out.println( m1.getMeasure() ); // reference of type Measurable can invoke only methods defined in the interface Measurable

      Measurable m2 = new Country("Uruguay", 176220);
      System.out.println( m2.getMeasure() );

      // Create an array of BankAccount objects and pass them into the average() method.
      // This is possible because BankAccount objects are Measurable objects (they have implemented Measurable)
      // and the average() method deals only with Measurable objects.
      BankAccount[] accounts = new BankAccount[3];
      accounts[0] = new BankAccount(0);
      accounts[1] = new BankAccount(10000);
      accounts[2] = new BankAccount(2000);
      System.out.println("Average balance: " + average(accounts));

      Country[] countries = new Country[3];
      countries[0] = new Country("Uruguay", 176220);
      countries[1] = new Country("Thailand", 514000);
      countries[2] = new Country("Belgium", 30510);
      System.out.println("Average area: " + average(countries));

      // We can also create an array of Measurable objects
      // Only Measurable objects can be added to this array,
      // so both BankAccount and Country objects can be added.
      //
      Measurable[] arrayOfMeasurable = new Measurable[4];
      arrayOfMeasurable[0] = new BankAccount(0);
      arrayOfMeasurable[1] = new BankAccount(10000);
      arrayOfMeasurable[2] = new Country("Uruguay", 176220);
      arrayOfMeasurable[3] = new Country("Thailand", 514000);

      System.out.println("Average area of measurables: "
              + average(arrayOfMeasurable));

      //TODO
      // As an exercise, assume that we want to create a method drawAll() that
      // will accept an array of Drawable objects.  By Drawable, we mean that
      // the objects must have implemented the drawable interface, and that they
      // must have implemented the draw() method from the interface.
      // Write and call the drawAll() method, passing an array of Countries.
      // To implement a draw() method, simply print out a string "printing a Country",
      // for the Country class.
      //
   }

   /**
      Computes the average of the measures of the given objects.
      @param objects an array of Measurable objects
      @return the average of the measures
      This method provides the service of getting the average of the measures
      of an array of objects - but only if the objects are Measurable.
      To be "measurable", the objects in the array must have implemented
      the measurable interface and have implemented the getMeasure()
      method.
      The interface is a contract that lists the methods that must be implemented.

    Notice here that the function depends only on the Interface.
    - All references are of type Measurable
    - All functions called are declared in the interface
   */
   public static double average(Measurable[] objects)
   {
      if (objects.length == 0) { return 0; }
      double sum = 0;
      for (Measurable obj : objects)
      {
               sum = sum + obj.getMeasure();
      }
      return sum / objects.length;
   }

}
