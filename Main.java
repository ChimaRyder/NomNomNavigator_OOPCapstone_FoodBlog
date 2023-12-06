import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    private static ArrayList<restaurant> restaurants;
    private static DefaultListModel<String> Titles;
    private static RestaurantBlog instance;


    public static void addRestaurant(restaurant e) {
        restaurants.add(e);
        Titles.addElement(e.toString());
        getInstance().getRestaurantList().setModel(Titles);
    }
    public static RestaurantBlog getInstance() {
        if (instance == null) {
            instance = new RestaurantBlog();
        }
        return instance;
    }

    public static ArrayList<restaurant> getSearchList(String searchFromUser){
        //List with restaurants that contain user search pero wala paniii na add sa form kanang search engine basta kana
        ArrayList<restaurant> searchList = new ArrayList<>();
        for (restaurant r : restaurants) {
            for (String cuisineTagsList : r.getCuisineTags()) {
                if (Objects.equals(searchFromUser, cuisineTagsList)) {
                    searchList.add(r);
                }
            }
        }
        return searchList;
    }

    public static void main(String[] args) {
        ArrayList<String> database = new ArrayList<>();
        /*
        To do list:
        -Implement get data into file button then display it into gui
        -Implement save into file button to save the lists of restaurants and use that list again in the future
        Take note to take advantage of the code implemented in main
        --If naay error, posts errors in github to get resolved
         */


        //Tig get data from file
        /*try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Database/Restaurant List.txt"));
            while((line = bufferedReader.readLine()) != null){
                database.add(line);
            }
            bufferedReader.close();
        }catch (FileNotFoundException e){
            System.err.println("Restaurant List file not found");
            return;
        } catch (IOException e) {
            System.err.println("Error occurred when reading the file");
        }
        if(!database.isEmpty()){
            ArrayList<String> labelsLabel = new ArrayList<>();
            for(String s: database){
                String[] infos = s.split("\\|");
                String[] labels = infos[3].split(" ");
                Collections.addAll(labelsLabel, labels);
                restaurants.add(new restaurant(infos[0], infos[1], labelsLabel, Integer.parseInt(infos[2])));
            }
        }*/
        RestaurantBlog rb = getInstance();
        restaurants = new ArrayList<>();
        Titles = new DefaultListModel<>();
        rb.setContentPane(rb.mainPanel);
        rb.setSize(500,500);
        rb.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rb.setVisible(true);
        rb.setTitle("Restaurant Blog");
        //Tig write into file
        /*try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Database/Restaurant List.txt"));
            for(restaurant r: restaurants){
                StringBuilder store = new StringBuilder();
                store.append(r.getName()).append("|").append(r.getLocation()).append("|").append(r.getRating())
                        .append("|");
                for(String labels: r.getCuisineTags()){
                    store.append(labels).append(" ");
                }
                bufferedWriter.write(store + "\n");
            }
        }catch (IOException e){
            System.err.println("Error occurred when writing to file");
        }*/
    }
}