package org.standrews.schedulingsurgeries.rest;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.standrews.schedulingsurgeries.domain.Patient;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PatientResourceTest {

    @Test
    public void testGetPatients(){
               given()
               .when().get("/patients")
               .then()
               .statusCode(200)
               .body("[0].patientId", is(1112),
                "[0].firstName", is("NA"),
                        "[0].lastName", is("NA"));
    }

    /**
     * Review this part
     */
    @Test
    public void testPatient(){
        JsonObject jsonObject = Json.createObjectBuilder()
                                .add("patientId", 999)
                                .add("firstName", "NA")
                                 .add("lastName", "NA")
                                 .build();

                 given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .post("/patients/999/NA/NA/1")
                .then()
                .statusCode(Response.Status.ACCEPTED.getStatusCode());

                 given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .post("/patients/999/NA/NA/1")
                .then()
                .statusCode(Response.Status.NOT_ACCEPTABLE.getStatusCode());

                 given()
                 .when().get("/patients/999")
                 .then()
                 .statusCode(Response.Status.FOUND.getStatusCode());

                 given()
                .when().get("/patients/876")
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());

    }

}
