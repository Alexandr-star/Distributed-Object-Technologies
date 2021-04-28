package ru.krista.uniyar;

import io.grpc.stub.StreamObserver;
import io.quarkus.calc.CalculatorProto;
import io.quarkus.calc.CalculatorServiceGrpc;

import javax.inject.Singleton;

@Singleton
public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void calculate(CalculatorProto.CalculatorRequest request, StreamObserver<CalculatorProto.CalculatorResponse> responseObserver) {
        CalculatorProto.CalculatorRequest.OperationType operationType = request.getOperation();

        double number1 = request.getNumber1();
        double number2 = request.getNumber2();

        double resultNumber;
        String unrecognizedOperation = "Unrecognized operation";
        String divideForZeroError = "DO NOT divide for 0";

        switch (operationType){
            case ADD:
                resultNumber = number1 + number2;

                responseObserver.onNext(CalculatorProto.CalculatorResponse.newBuilder().setResult(resultNumber).build());
                break;
            case MULTIPLY:
                resultNumber = number1 * number2;

                responseObserver.onNext(CalculatorProto.CalculatorResponse.newBuilder().setResult(resultNumber).build());
                break;
            case SUBTRACT:
                resultNumber = number1 - number2;

                responseObserver.onNext(CalculatorProto.CalculatorResponse.newBuilder().setResult(resultNumber).build());
                break;
            case DIVIDE:
                if (number2 == 0.0) {
                    responseObserver.onError(new Throwable(divideForZeroError));
                    break;
                }

                resultNumber = number1 / number2;

                responseObserver.onNext(CalculatorProto.CalculatorResponse.newBuilder().setResult(resultNumber).build());
                break;
            case UNRECOGNIZED:
                responseObserver.onError(new Throwable(unrecognizedOperation));
                break;
            default:
                responseObserver.onError(new Throwable(unrecognizedOperation));
                break;
        }

        responseObserver.onCompleted();
    }
}
