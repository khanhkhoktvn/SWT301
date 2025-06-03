import khanhtv.example.AccountService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class AccountServiceTest {

    private final AccountService accountService = new AccountService();

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean result = accountService.registerAccount(username, password, email);
        assertEquals(expected, result, () -> String.format(
                "* username=\"%s\", password=\"%s\", email=\"%s\" => Expected %s but eal result is %s",
                username, password, email, expected, result
        ));
    }
}
