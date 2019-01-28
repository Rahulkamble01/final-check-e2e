# # Design and Analysis
## Screen Layout
The screen consist of a form with following fields : 
*  Name (input type="text")
*  Email (input type="text")
*  Password (input type="password")
*  Button (input type="button")

![SignUp](/uploads/05c830dcc2c39a747a8ebb5d2202c52a/SignUp.PNG)

## Database 
* **Database Name :** skynews

## ER DIAGRAM

![ER_Diagram](/uploads/043320ba4780e56184a868c05c61edbc/ER_Diagram.PNG)

## Package and Classes

### **Package :** com.cts.signup
#### **1. Class :** SignUpStatus.java
* **Attributes :**
   * private boolean signedUp
   * private boolean emailExist

#### **2. Class :** AuthenticationStatus.java
* **Attributes :**
   * private boolean authenticated
   * private boolean accountStatus
   

### **Package :** com.cts.signup.bean
#### **1. Class :** User.java
* **Attributes :**
   * private int id
   * private String name
   * private String email
   * private String password
   * private String status
   * private Role role
   * private Language language

#### **1. Class :** Role.java
* **Attributes :**
   * private int id
   * private String description

#### **1. Class :** Language.java
* **Attributes :**
   * private int id
   * private String description

#### **1. Class :** Article.java
* **Attributes :**
   * private int id
   * private String author;
   * private String title;
   * private String description;
   * private String url;
   * private String urlToImage;
   * private String publishedAt;


#### **1. Class :** FavouriteArticle.java
* **Attributes :**
   * private int id;
   * private User user;
   * private Article article;


  

### **Package :** com.cts.signup.rest
#### **1. Class:** UserController.java
* **Links:**
  * @RequestMapping("/user")

* **Methods :**
   1. **Add a User**
       * @PostMapping("/signup")
       * public SignUpStatus addUser(@RequestBody User user) {}
    
   2.**Login**
       * @PostMapping("/login")
       * public AuthenticationStatus addUser(@RequestBody User user) {}
   2.**Modify Account Status**
       * @PostMapping("/login")
       * public void modifyAccoountStatus(@RequestBody User user) {}


### **Package :** com.cts.signup.service
#### **1. Class:** UserService.java
* **Methods :**
   * public SignUpStatus addUser(User user) {};
   * public AuthenticationStatus loginUser(User user){};
   * public void mofifyAccountSatus(User user) {};
   
### **Package :** com.cts.signup.dao
#### **1. Class:** UserDao.java
* **Methods :**
   * public void addUser(User user)
   

   

## Angular
### Components
* **signup**
  * **sign-up.component.css** - This will contain all the custom styling for the signup component.
  * **sign-up.component.html** - This will contain html code for our signup page for the screen layout defined above.
  * **sign-up.component.spec.ts** - This will contain test cases for karma testing.
  * **sign-up.component.ts** - This will contain the service call definition and method definitions.
     * **Variables :**
           * user:new FormGroup() - It is a Reactive Form Group.
     * **Method :**
           * Onsubmit() : This method will make the below mention service call to the backend.
           * signUpService.addUser(this.user.value) : This method will make the below mention service call to the backend.





### Services
* **sign-up.service.ts**
   * Methods :
      * addUser(userData)






