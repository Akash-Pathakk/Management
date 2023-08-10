package POJO;

public class Student2  implements java.io.Serializable {
     private Integer id;
     private String firstName;
     private String lastName;
     private int age;
     private String phone;
     private String gender;
     private String email;
     private String city;
     private String hobbies;
     private String highereducation;

 
   public Student2() {
    }

	
    public Student2(String firstName) {
        this.firstName = firstName;
    }
    public Student2(String firstName, String lastName, int age, String phone, String gender, String email, String city, String hobbies, String highereducation) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.age = age;
       this.phone = phone;
       this.gender = gender;
       this.email = email;
       this.city = city;
       this.hobbies = hobbies;
       this.highereducation = highereducation;
     
     
    }

   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
       
    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
    
    public String getHighereducation() {
        return highereducation;
    }

    public void setHighereducation(String highereducation) {
        this.highereducation = highereducation;
    }
    
}


