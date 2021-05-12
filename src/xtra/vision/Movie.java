/*
 * This class is used to save a movie instance with important properties.
 */
package xtra.vision;

import java.util.Date;

/**

 */
public class Movie {
    /*
 * Member Variables of class
 */   
    private final String name;
    private final String cast;
    private final Date releaseDate;
    private final String description;
    private final String length;
    private final String category;
    private final int electronicTagNo;
     /*
 * Constructors of class
 */  
    Movie(String Name,String Cast,Date ReleaseDate,String Description,String Length,String Category,int tagNo ){
       this.name = Name;
       this.cast = Cast;
       this.releaseDate = ReleaseDate;
       this.description = Description;
       this.length = Length;
       this.category = Category;
       this.electronicTagNo = tagNo;
    }
    /*
 * Setters and Getters of class
 */   
    public String getName(){
        return this.name;
    }       
   
     public int getElectTagNo(){
        return this.electronicTagNo;
    } 
     
    public String getCast(){
        return this.cast;
    }
    
    public Date getReleaseDate(){
        return this.releaseDate;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getLength(){
        return this.length;
    }
    
    public String getCategory(){
        return this.category;
    }
    
}
