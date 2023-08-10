package Bean;

import javax.faces.bean.ManagedBean;
import POJO.Student2;
import Util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
//import javax.annotation.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.type.TypeFactory.serializable;
import static org.primefaces.component.graphicimage.GraphicImage.PropertyKeys.name;

@ManagedBean(name = "bean")
@javax.faces.bean.SessionScoped
public class Bean implements java.io.Serializable {

    private int id;
    private String firstname, lastname, gender;
    private int age;
    private String phone;
    // private String gender;
    private String email;
    private String city;
    private List<String> hobbies = new ArrayList();

    List<Student2> stuList = new ArrayList<>();
    private boolean showDialog = true;

    public boolean isShowDialog() {
        return showDialog;
    }
    private String highereducation;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

    public String getHighereducation() {
        return highereducation;
    }

    public void setHighereducation(String highereducation) {
        this.highereducation = highereducation;
    }

    public List<Student2> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student2> stuList) {
        this.stuList = stuList;
    }

    public void save() {            // create session
        Session session = NewHibernateUtil.getSessionFactory().openSession();
//Open transaction
        Transaction tran = session.beginTransaction();
// Create object of pojo class
        Student2 student2 = new Student2();
        
//set the all variable to method of pojo   

        student2.setFirstName(firstname);
        student2.setLastName(lastname);
        student2.setAge(age);
        student2.setPhone(phone);
        student2.setGender(gender);
        student2.setEmail(email);
        student2.setCity(city);
        String temphobbies = null;
        String tempHobbies = null;
        for (String str : hobbies) {
            if (tempHobbies == null) {
                tempHobbies = str;
            } else {
                tempHobbies = tempHobbies + "," + str;
            }
        }
        student2.setHighereducation(highereducation);
        student2.setHobbies(tempHobbies);
        session.save(student2);// commit transaction
        tran.commit();
        session.close();
        reset();
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Save", "Saved Successfully"));


// close session
    }

    public void lookUp() {
        showDialog = true;
        System.out.println("CLLLLING lookUp");
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String query = "from Student2";
        Query q = session.createQuery(query);
        stuList = q.list();
        System.out.println("stuList:::" + stuList.size()); //to check total no of record in console
    }

    public void fill(Student2 fList) {
        System.out.println("calling fill");
        NewHibernateUtil.getSessionFactory().openSession();
        id = fList.getId();

        firstname = fList.getFirstName();
        lastname = fList.getLastName();
        age = fList.getAge();
        gender = fList.getGender();
        highereducation = fList.getHighereducation();
        String[] str = fList.getHobbies().split(",");
        for (String s : str) {
            hobbies.add(s);
        }
        System.out.println("hobbies:::" + hobbies);
    }

    public void update() {

        NewHibernateUtil.getSessionFactory().openSession();
        Session session = NewHibernateUtil.getSessionFactory().openSession();

        Transaction txn = session.beginTransaction();
        Student2 student2 = (Student2) session.load(Student2.class, id);

        student2.setId(id);
        student2.setFirstName(firstname);
        student2.setLastName(lastname);
        student2.setAge(age);
        student2.setPhone(phone);
        student2.setGender(gender);
        student2.setEmail(email);
        student2.setCity(city);
        String tempHobbies = null;
        for (String str : hobbies) {
            if (tempHobbies == null) {
                tempHobbies = str;
            } else {
                tempHobbies = tempHobbies + "," + str;
            }
        }
        student2.setHobbies(tempHobbies);
        student2.setHighereducation(highereducation);
        session.update(student2);
        txn.commit();
        session.close();
        reset();

    }

    public void delete() {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tran = session.beginTransaction();
        // Object student2 = session.load(Student2.class, id);     
        Student2 student2 = (Student2) session.load(Student2.class, id);/* pojo name                                                                                             & unique id for database*/

        session.delete(student2);                   // delete record
        tran.commit();
         reset();
        //commit transaction
    }

    public void reset() {
        firstname = "";
        lastname = "";
        age = 0;
        phone = "";
        gender = "";
        email = "";
        city = "";
        hobbies.clear();
        highereducation = "";

    }

}
