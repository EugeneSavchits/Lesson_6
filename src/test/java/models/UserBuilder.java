package models;

public class UserBuilder {
    private String email;
    private String password;

    public static class Builder {
        private UserBuilder newUser;

        public Builder(){
            newUser = new UserBuilder();
        }
        public Builder withEmail (String email){
            newUser.email = email;
            return this;
        }

        public Builder withPassword (String password) {
            newUser.password = password;
            return this;
        }

        public UserBuilder build() {
            return newUser;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
