package application;

import application.schema.GetUserRequest;
import application.schema.GetUserResponse;
import application.schema.ObjectFactory;
import application.schema.User;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://localhost/users";

    private final ObjectFactory objectFactory;

    public UserEndpoint(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = objectFactory.createGetUserResponse();
        User user = objectFactory.createUser();
        user.setId(request.getId());
        user.setName("Ім'я користувача");
        response.setUser(user);
        return response;
    }
}
