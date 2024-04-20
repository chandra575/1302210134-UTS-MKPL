package lib;

public class children {
    public class Child {
        private String name;
        private String idNumber;
    
        public Child(String name, String idNumber) {
            this.name = name;
            this.idNumber = idNumber;
        }
    
        // Getter dan setter untuk name dan idNumber
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getIdNumber() {
            return idNumber;
        }
    
        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }
    }    
}
