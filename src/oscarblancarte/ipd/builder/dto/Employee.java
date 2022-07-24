package oscarblancarte.ipd.builder.dto;

import java.util.ArrayList;
import java.util.List;
import oscarblancarte.ipd.builder.IBuilder;

/**
 * @author oblancarte
 */
public class Employee {

    private String name;
    private int age;
    private String gender;
    private Address adress;
    private List<Phone> phones;
    private List<Contact> contacs;
    private Departamento departamento;

    private Employee(String name, int age, String gender, Address adress, 
            List<Phone> phones, List<Contact> contacs, Departamento departamento) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.adress = adress;
        this.phones = phones;
        this.contacs = contacs;
        this.departamento = departamento;
    }

    public Employee(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Contact> getContacs() {
        return contacs;
    }

    public void setContacs(List<Contact> contacs) {
        this.contacs = contacs;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", age=" + age + ", gender=" 
                + gender + ", \nadress=" + adress + ", \nphones=" + phones 
                + ", \ncontacs=" + contacs + ", \ndepartamento=" + departamento + '}';
    }
    
    public static class EmployeeBuilder implements IBuilder<Employee>{

        private String name;
        private int age;
        private String gender;
        private Address adress;
        private final List<Phone> phones = new ArrayList<>();
        private final List<Contact> contacs = new ArrayList<>();
        private Departamento departamento;

        public EmployeeBuilder() {
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public EmployeeBuilder setAdress(String address, String city, 
                String country, String cp) {
            adress = new Address(address, city, country, cp);
            return this;
        }

        public EmployeeBuilder addPhones(String phoneNumber, String ext, 
                String phoneType) {
            phones.add(new Phone(phoneNumber, ext, phoneType));
            return this;
        }

        public EmployeeBuilder addContacs(String name, String phoneNumber, 
                String ext, String phoneType,String address, String city, 
                String country, String cp) {
            contacs.add(new Contact(name, new Phone(phoneNumber, ext, phoneType)
                    ,new Address(address, city, country, cp)));
            return this;
        }
        
        public EmployeeBuilder addContacs(String name, String phoneNumber, 
                String ext, String phoneType) {
            contacs.add(new Contact(name, new Phone(phoneNumber, ext, phoneType)));
            return this;
        }
        
        public EmployeeBuilder setDepartamento(String nombreDepartamento) {
            departamento = new Departamento(nombreDepartamento);
            return this;
        }

        @Override
        public Employee build() {
            return new Employee(name, age, gender, adress, phones, contacs, departamento);
        }
    }
}