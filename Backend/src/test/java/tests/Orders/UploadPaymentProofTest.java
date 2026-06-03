package tests.Orders;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UploadPaymentProofTest extends BaseOrderTest {


    private final String sampleProofFile = "src/test/resources/files/test-avatar.jpg.jpg";
    @Test
    void testUploadPaymentProofSuccessfully() {
        Response response = api.uploadPaymentProof(orderId, sampleProofFile, token);

        assertEquals(response.statusCode(), 200);
        assertTrue(response.jsonPath().getBoolean("success"));
    }
}
