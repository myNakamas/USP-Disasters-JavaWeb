package models;

public final class Verification {

    public static void checkUsername(String username) throws Exception {
        if(username.length()<5 || username.length()>100){
            throw new Exception("Username should be between 5 and 100 symbols");
        }
    }

    public static void checkPass(String password) throws Exception {
        if(password.length()<8){
            throw new Exception("Password should be at least 8 symbols");
        }
    }

    public static void checkPhone(String phone) throws Exception {
        if(phone.length()!=10 && phone.length()!=13){
            throw new Exception("Phone number should be either 10 or 13 symbols long");
        }
        if(!phone.startsWith("08")&&!phone.startsWith("+"))
        {
            throw new Exception("Phone number should start with 08 or +");
        }
    }
}
