class Admin {
    long admin_id;
    String admin_name;
    String email;
    String admin_password;

    public Admin(long admin_id, String admin_name, String email, String admin_password) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.email = email;
        this.admin_password = admin_password;
    }

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", email='" + email + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }
}