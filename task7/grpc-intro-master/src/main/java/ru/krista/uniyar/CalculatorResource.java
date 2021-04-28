package ru.krista.uniyar;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.calc.CalculatorProto;
import io.quarkus.calc.CalculatorServiceGrpc;
import io.quarkus.grpc.runtime.annotations.GrpcService;


@Path("/calc")
public class CalculatorResource {

    @Inject
    @GrpcService("calculator")
    CalculatorServiceGrpc.CalculatorServiceBlockingStub client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "hello";
    }

    @GET
    @Path("/{number1}-{number2}-{operation}")
    public String calculator(@PathParam("number1") String stringNumber1, @PathParam("number2") String stringNumber2, @PathParam("operation") int operation) {

        double number1 = Double.valueOf(stringNumber1);
        double number2 = Double.valueOf(stringNumber2);

        CalculatorProto.CalculatorRequest.OperationType operationType = CalculatorProto.CalculatorRequest.OperationType.forNumber(operation);

        CalculatorProto.CalculatorRequest request = CalculatorProto.CalculatorRequest.newBuilder().setNumber1(number1).setNumber2(number2).setOperation(operationType).build();

        CalculatorProto.CalculatorResponse response = client.calculate(request);

        return String.valueOf(response.getResult());
    }
}
