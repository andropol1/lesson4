package market;

import java.util.Objects;

public class Customer {
        private String name;
        private int age;
        private String phone;
        enum Gender {MALE, FEMALE};
        private Gender sex;

        public Customer(String name, int age, String phone, String sex) {
            this.name = name;
            this.age = age;
            this.phone = phone;
            this.sex = Gender.valueOf(sex);
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
        public Gender getSex() {
            return sex;
        }

         public void setSex(Gender sex) {
            this.sex = sex;
        }

    @Override
        public String toString() {
            return "market.Customer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", phone='" + phone + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return age == customer.age && Objects.equals(name, customer.name) && Objects.equals(phone, customer.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, phone);
        }
    }