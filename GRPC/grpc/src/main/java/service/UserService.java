package service;

import generated.APIResponse;
import generated.Empty;
import generated.LoginRequest;
import io.grpc.stub.StreamObserver;
import generated.userGrpc;

public class UserService extends userGrpc.userImplBase{

    @Override
    public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        APIResponse.Builder response = APIResponse.newBuilder();
        if (username.equals(password)){
            response.setResponseMessage("Sucesso").setResponseCode(200);
        } else {
            response.setResponseMessage("Falha ao efetuar o login").setResponseCode(403);
        }
        
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
    	APIResponse.Builder responseLogout = APIResponse.newBuilder();
    	responseLogout.setResponseMessage("Deslogado").setResponseCode(204);
    	responseObserver.onNext(responseLogout.build());
    	responseObserver.onCompleted();
    }
}
