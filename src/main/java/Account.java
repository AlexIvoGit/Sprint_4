import io.qameta.allure.Step;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    @Step("Проверка соответствия критериям: {account}")
    public static boolean checkNameToEmboss(Account account) {
        if (account.name != null && account.name.length() >= 3 && account.name.length() <= 19 && !account.name.isBlank()) {
            if(!account.name.startsWith(" ") && !account.name.endsWith(" ")){
                if(account.name.contains(" ")){
                    return account.name.split(" ").length == 2;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Аккаунт{" +
                "ФИ='" + name + '\'' +
                '}';
    }
}