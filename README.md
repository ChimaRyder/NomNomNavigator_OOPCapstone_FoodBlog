# OOP_Capstone_FoodBlog
A program that showcases reviewed Restaurants and uses a randomizer to randomly select a restaurant based on preferences.
## How It Works
You can view or delete your reviewed restaurants via the *JList* and utilize the buttons to either create, add, or view your lists or restaurants.

### 📝 **Create List** 
- Create a new List of restaurants to add onto.

### 🍴 **+** 
- Add a restaurant to the List based on its Name, Location, Rating, and Tags.

### 🎲 **Randomizer** 
- Randomly pick a restaurant via By Tag, By Location, or completely random.
  #### By Tag
  - Randomly selects a restaurant that fits the tag selected.
  #### By Location
  - Randomly selects a restaurant that fits the location selected.
  #### Surprise Me
  - Randomly selects a restaurant of any type.

### 📃 **View Lists** 
- Views your current lists available and select which list to open onto the viewer.


## Implementation
Applied a *singleton pattern* on the Main class to create a single instance of Restaurant Blog to utilize its non-static components with the global lists and ListModel.
