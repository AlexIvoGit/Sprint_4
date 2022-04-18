import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
@DisplayName("Проверка соответствия данных владельца для печати на банковской карте")
public class AccountTest {
    private final Account account;
    private final boolean expectedResult;
    private final String nameCheck;

    public AccountTest(Account account, boolean expectedResult, String nameCheck) {
        this.account = account;
        this.expectedResult = expectedResult;
        this.nameCheck = nameCheck;
    }

    @Parameterized.Parameters(name = "Передаем: {2}, Ожидаемый результат: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {new Account(""), false, "Пустая строка"},
                {new Account("      "), false, "Только пробелы"},
                {new Account("А Т"), true, "Передаем 3 символа"},
                {new Account("А "), false, "Передаем 2 символа"},
                {new Account("Ан Т"), true, "Передаем 4 символа"},
                {new Account("Антонов Антониргде"), true, "Передаем 18 символов"},
                {new Account("Антонов Антониргдет"), true, "Передаем 19 символов"},
                {new Account("Антонов Антониргдетт"), false, "Передаем 20 символов"},
                {new Account("Антонов Антониргдеттт"), false, "Передаем 21 символов"},
                {new Account(" Антонов Антон"), false, "Пробел в начале"},
                {new Account("Антонов Антон "), false, "Пробел в конце"},
                {new Account("Антонов Антон"), true, "Пробел в середине"},
                {new Account("Антонов Ан тон"), false, "Несколько пробелов"}
        };
    }

    @Test
    @DisplayName("Проверка соответствия имени аккаунта критериям проверки")
    public void checkAccount() {
        boolean actualResult = Account.checkNameToEmboss(account);
        Assert.assertEquals("Результат проверки Фамилии, Имени не соответствует критериям проверки"
                , expectedResult, actualResult);
    }
}
