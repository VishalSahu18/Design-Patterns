**Single Responsibility Principle (SRP)**

**Definition:**

A class should have only one reason to change, meaning it should have only one responsibility.

**Explanation:**

Each class should focus on a single functionality. If a class has multiple responsibilities, changes in one part may affect others, leading to maintenance difficulties.

**Example (Violating SRS):**

```java

class Marker {

    String name;
    String color;
    int year;
    int price;

    public Marker(String name,String color,int  year,int price){
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}


class Invoice {

    private Marker marker;
    private int quantity;

    public Invoice(Marker marker,int quantity){
        this.marker  = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        int price = ((marker.price)*this.quantity);
        return price;
    }

    public void printInvoice(){
        //print the Invoice
    }

    public void saveToDB(){
        //save the data into DB
    }

}

```
**What's wrong?**

The Invoice class has three responsibilities:

Calculating total.  
Printing the invoice.  
Saving the invoice to the database.  

This makes the class difficult to maintain.

**Correct Approach**  
Make a separate class for each responsibility such it has only have single reason to change.

```java

class Invoice {
    
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker , int quantity){
        this.marker = marker;
        this.quantity = quantity;
    }
    
    public int calculateTotal(){
        int price = ((marker.price)*this.quantity);
        return price;
    }
}


class InvoiceDao {
    
    Invoice invoice;
    public InvoiceDao(Invoice invoice){
        this.invoice = invoice;
    }
    
    public void saveToDB(){
        // Save into the DB
    }

}

class InvoicePrinter {
    
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice){
        this.invoice = invoice;
    }
    
    public void print(){
        // print the invoice
    }
}
```

**Why is this better?**

Each class has a single responsibility.  
The design is more maintainable.  


**What happens if we don’t follow SRP?**  
🔴 High Complexity → The class has too many responsibilities, making it hard to understand.  
🔴 Difficult Maintenance → A change in one responsibility may break another.  
🔴 Poor Code Reusability → You can't reuse a part of the logic easily.  

**Benefits of SRP**  
✅ Easier to maintain → Each class has only one reason to change.  
✅ Better reusability → Each class does one thing well.  
✅ Improved readability → Code is easier to understand.  

