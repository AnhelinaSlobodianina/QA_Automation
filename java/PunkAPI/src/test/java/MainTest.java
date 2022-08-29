
import controller.PunkAPIController;
import org.testng.annotations.Test;
import static java.util.Collections.emptyMap;
import static org.apache.http.HttpStatus.*;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import pojos.PunkPojo;
import static org.testng.AssertJUnit.assertEquals;

public class MainTest {
    private final PunkAPIController punkAPI = new PunkAPIController();

    @Test
    @Story("1")
    @Description("Scenario: Validating the Punk API\n" +
            "Given I call the punk api with beer id 192\n" +
            "Then I expect a 200 status response\n" +
            "And The malt is “Extra Pale”\n" +
            "And The malt value is 5.3 and the unit is “kilograms”")
    public void test_1(){
        PunkPojo[] actuallyCreated =
                punkAPI.get(emptyMap(), "192")
                        .assertThat().statusCode(SC_OK)
                        .extract().body().as(PunkPojo[].class);


        assertEquals("Extra Pale", actuallyCreated[0].ingredients.malt.get(0).name);
        assertEquals(5.3, actuallyCreated[0].ingredients.malt.get(0).amount.value);
        assertEquals("kilograms", actuallyCreated[0].ingredients.malt.get(0).amount.unit);
    }
}
