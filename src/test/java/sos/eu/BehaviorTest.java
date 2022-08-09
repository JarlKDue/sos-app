package sos.eu;

import org.junit.jupiter.api.Test;

import generated.Patient;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import javax.ws.rs.core.Response;

@QuarkusTest
public class BehaviorTest {
    
    @Test
    public void whenAskingForPatientByIdReturnPatientIfPresent(){
       Patient patientResponse = given()
            .when()
            .get("/patients/1")
            .then()
            .statusCode(200)
            .assertThat()
            .extract().response().as(Patient.class);

        System.out.println(patientResponse.toString());
    }

}
