import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    /*
    Purpose of this class is to create a singleton pattern for the RestaurantBlog Panel.
    That way, ArrayList restaurants and ListModel Titles are completely static without affecting
    the non-static fields of RestaurantBlog.

    Call getInstance() to change any values inside RestaurantBlog from here, such as setting the Model for RestaurantList.
    Since getInstance() only returns one instance of RestaurantBlog that is static, we can use our static fields here to
    change any values inside RestaurantBlog.

    This is necessary since GUI components cannot be static and fields like restaurants and Titles need to be global for
    the restaurantEditor to add new restaurants to the JList.
     */
    private static ArrayList<restaurant> restaurants;
    private static DefaultListModel<String> Titles;
    private static RestaurantBlog instance;

    public static ArrayList<restaurant> getRestaurants() {
        return restaurants;
    }

    public static void addRestaurant(restaurant e) {
        restaurants.add(e);
        Titles.addElement(e.toString());
        getInstance().getRestaurantList().setModel(Titles);
        getInstance().setDataLoaded(false);
    }


    public static void removeRestaurant(String removeRes) {
//            String removeRes = null;
        for (restaurant r : restaurants) {
            if (r.getName().equals(removeRes)) {
                System.out.println(r);
                int ind = restaurants.indexOf(r);
                restaurants.remove(r);
                Titles.remove(ind);
                getInstance().getRestaurantList().setModel(Titles);
                getInstance().setDataLoaded(false);
                break;
            }
        }
    }

//    public Main() {
//
//    }
    //singleton pattern here
    public static RestaurantBlog getInstance() {
        if (instance == null) {
            instance = new RestaurantBlog();
        }

        return instance;
    }
    //for searching...
    public static ArrayList<restaurant> searchCuisineTags(String searchFromUser){
        //List with restaurants that contain user search pero wala paniii na add sa form kanang search engine basta kana
        ArrayList<restaurant> searchList = new ArrayList<>();
        for (restaurant r : restaurants)
            for (String cuisineTagsList : r.getCuisineTags())
                if (Objects.equals(searchFromUser, cuisineTagsList))
                    searchList.add(r);
        return searchList;
    }
    public static ArrayList<restaurant> searchMinimumRatings(int rating){
        ArrayList<restaurant> searchlist = new ArrayList<>();
        for(restaurant r: restaurants)
            if(r.getRating() >= rating)
                searchlist.add(r);
        return searchlist;
    }
    public static ArrayList<restaurant> searchExactRatings(int rating){
        ArrayList<restaurant> searchlist = new ArrayList<>();
        for(restaurant r : restaurants)
            if(r.getRating() == rating)
                searchlist.add(r);
        return searchlist;
    }
    public static void loadDataToFile() throws IOException{
        ArrayList<String> database = new ArrayList<>();
        /*
        To do list:
        -Implement get data into file button then display it into gui: done
        -Implement save into file button to save the lists of restaurants and use that list again in the future : goods
        Take note to take advantage of the code implemented in main
        --If naay error, posts errors in github to get resolved
         */

        //get file from JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter( "*.txt", "txt"));
        fileChooser.setCurrentDirectory(new File("src\\Database"));
        int res = fileChooser.showOpenDialog(null); //selects location where to write file

        File file = null;
        if (res == JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        }

        //check if file exists
        if (file != null) {
            //Tig get data from file
            try {
                String line;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while ((line = bufferedReader.readLine()) != null) {
                    database.add(line);
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                System.err.println("Restaurant List file not found");
                return;
            } catch (IOException e) {
                System.err.println("Error occurred when reading the file");
            }
            if (!database.isEmpty()) {

                for (String s : database) {
                    ArrayList<String> labelsLabel = new ArrayList<>();
                    String[] infos = s.split("\\|");
                    String[] labels = infos[3].split(" ");
                    for (int a = 0; a < labels.length; a++)
                        labels[a] = labels[a].replaceAll("-", " ");
                    Collections.addAll(labelsLabel, labels);
                    restaurants.add(new restaurant(infos[0], infos[1], labelsLabel, Integer.parseInt(infos[2])));
                }
            }

            //update listModel for JList to show the restaurants in file
            if (restaurants != null) {
                for (restaurant r : restaurants) {
                    Titles.addElement(r.toString());
                    getInstance().getRestaurantList().setModel(Titles);
                }
            }
        } else {
            throw new FileNotFoundException("File does not exist.");
        }
    }

    public static void saveDataToFile() throws IOException {
        //choose where to save file to
        JFileChooser fileChooser = new JFileChooser() {
            @Override //Overriding approveSelection to avoid overwriting to file accidentally
            public void approveSelection() {
                File f = getSelectedFile();
                if (f.exists() && getDialogType() == SAVE_DIALOG) {
                    switch (JOptionPane.showConfirmDialog(this, "File already exists. Would you like to overwrite it?", "Overwrite Existing File", JOptionPane.YES_NO_CANCEL_OPTION)) {
                        case JOptionPane.YES_OPTION:
                            super.approveSelection();
                            return;
                        case JOptionPane.NO_OPTION, JOptionPane.CLOSED_OPTION:
                            return;
                        case JOptionPane.CANCEL_OPTION:
                            cancelSelection();
                            return;
                    }
                }
                super.approveSelection();
            }
        };

        fileChooser.setFileFilter(new FileNameExtensionFilter( "*.txt", "txt"));
        fileChooser.setCurrentDirectory(new File("src\\Database"));
        int res = fileChooser.showSaveDialog(null); //selects location where to write file

        File file = null;
        if (res == JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            if (!file.toString().endsWith(".txt")) {
                file = new File(file.toString() + ".txt");
            }
        }

        //checking if file exists or not. Will not continue if it doesn't exist
        if (file != null) {
            //Tig write into file
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                for (restaurant r : restaurants) {
                    StringBuilder store = new StringBuilder();
                    store.append(r.getName()).append("|").append(r.getLocation()).append("|").append(r.getRating())
                            .append("|");
                    for (String labels : r.getCuisineTags()) {
                        String splitter = labels.replaceAll(" ", "-");
                        store.append(splitter).append(" ");
                    }
                    bufferedWriter.write(store + "\n");
                }
            } catch (IOException e) {
                System.err.println("Error occurred when saving to file");
                e.printStackTrace();
            } finally {
                assert bufferedWriter != null : "Buffered Writer is Null";
                bufferedWriter.close();
            }
        } else {
            throw new FileNotFoundException("File does not exist.");
        }
    }

    public static void main(String[] args) {

        RestaurantBlog rb = getInstance();
        restaurants = new ArrayList<>();
        Titles = new DefaultListModel<>();

        rb.setContentPane(rb.mainPanel);
        rb.setSize(1500,980);
        rb.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rb.setVisible(true);
        rb.setTitle("Restaurant Blog");


    }
}
