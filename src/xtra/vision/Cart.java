/*
 * This class is used to save a cart instance with important properties.
 */
package xtra.vision;

import java.util.ArrayList;

public class Cart {
    /*
 * Member Variables of class
 */
    private ArrayList<String> movies;
    private ArrayList<Integer> tags;    
    private double totalPrice;
    private int qty;
    private final int Cartlimit;  
    private double promo;
    /*
 * Constructors of class
 */ 
    Cart(){
        this.movies = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.totalPrice = 0.0;
        this.qty = 0;
        this.promo = 0;
        this.Cartlimit = 4;
    }
  /*
 * This function adds the item to current cart.
 */
    public void addToCart(String movie, int tag){
        if(movie!=null ){
            movies.add(movie);
            tags.add(tag);
            qty++;
        }
        
    }
/*
 * This function removes the item to current cart.
 */    
    public void removeFromCart(String movie){
        movies.remove(movie);
        qty--;
    }    
 /*
 * This function returns the final current cart price.
 */   
    public double calculateAndReturnPrice(){
        totalPrice = (qty * 2.99) - promo;        
        return totalPrice;
    } 
 /*
 * This function checks the space in current cart.
 */   
    public boolean hasSpace(){
        return qty < Cartlimit;
    }
/*
 * This function returns the movies present in the cart as a String.
 */    
    public String getMovies(){
        String moviesList = "";
        for(int i=0; i < movies.size() ; i++){
            moviesList = moviesList + (String) movies.get(i) + ",";
        }
        return moviesList.substring(0, moviesList.length()-1);       
    }
 /*
 * This function returns the movies present in the cart as a ArrayList.
 */   
    public ArrayList getMoviesAsList(){       
        return this.movies;     
    }
    
    public ArrayList getMoviesTags(){       
        return this.tags;     
    }
    
    public int getQty(){
        return this.qty;
    }
 /*
 * This function checks that a movie is already in cart or not.
 */   
    public boolean hasAlreadySelected(String name){
        boolean matched = false;
         for(int i=0; i < movies.size() ; i++){
            if(movies.get(i).equals(name)){
                matched = true;
            }
        }
         return matched;
    }
    
    public void setPromo(double amount){
        this.promo = amount;
    }
    
    public double getPromo(){
        return this.promo;
    }
    
    public String getCartItem(int index){
        return (String) this.movies.get(index);
    }
}
