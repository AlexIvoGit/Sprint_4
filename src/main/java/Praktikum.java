public class Praktikum {

    public static void main(String[] args) {
        String firstNameAndLastName = "Антонов Антон";

        Account account = new Account(firstNameAndLastName);
        boolean checkNameToEmboss = Account.checkNameToEmboss(account);

        System.out.println(checkNameToEmboss);
    }

}