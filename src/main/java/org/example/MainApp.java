package org.example;    // Nov 2024

/**
 This program demonstrates the use of a Measurable Interface.
 BankAccount and Country classes implement the Measurable interface.
 A method average() offers the service of averaging an array of elements -
 but only if the elements are of type Measurable.
 So, arrays that use this service must ensure that the objects in the array
 are of type measurable.
 This is the *contract* between the service and its users.
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

      // We can pass the array of Measurable objects to the average() method,
      // but, in this case it doesn't really a lot of sense in this case as
      // the measures of BankAccount and Country are two unrelated things.
      //
      System.out.println("Average area of measurables: "
              + average(arrayOfMeasurable));
   }//end main.


   //TODO
   // As an exercise, write a method:
   // increaseBy( Measurable[] objects, int percent )
   // that will accept an array of Measurable objects, and will increase
   // the measure of all objects by the percentage argument.  (e.g. 10 for 10%)
   // The method will only work for objects that are of type Measurable.
   // Call the method twice, once passing countries[] and then passing accounts[]
   // and check to see if the method has made the intended increases.


   /** average()
      Computes the average of the measures of the given objects.
      @param objects an array of Measurable objects (requirement of the contract)
      @return the average of the measures
      This method provides the service of getting the average of the measures
      of an array of objects - but only if the objects are Measurable.
      To be "measurable", the objects in the array must have implemented
      the measurable interface and have implemented the getMeasure()
      method.
      The interface is a contract that lists the methods that must be implemented.
      The contract states that a measurable object must provide a measure() method
      that can be called to provide a measure of that object.

    Notice here that the method code depends only on the Interface, and uses
      references of the interface type (i.e. Measurable)
    - All references are of type Measurable
    - All functions called are declared in the interface (i.e. getMeasure() )

    This method can deal only with objects of type Measurable.
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
