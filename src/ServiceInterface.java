import java.util.ArrayList;


/** From: https://refactoring.guru/design-patterns/proxy
Step 1: If there’s no pre-existing service interface, create one to make proxy and service objects interchangeable.
Extracting the interface from the service class isn’t always possible, because you’d need to change all
of the service’s clients to use that interface.

Plan B is to make the proxy a subclass of the service class, and this way it’ll inherit the interface of the service.*/
public interface ServiceInterface
{
  ArrayList<ArrayList<String>> getCitizenshipData(Client client);
}
