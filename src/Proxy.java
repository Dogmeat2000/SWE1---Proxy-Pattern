import java.util.ArrayList;


/** From: https://refactoring.guru/design-patterns/proxy
 Step 2: Create the proxy class. It should have a field for storing a reference to the service.
 Usually, proxies create and manage the whole life cycle of their services.
 On rare occasions, a service is passed to the proxy via a constructor by the client.*/
public class Proxy implements ServiceInterface
{
  private final ServiceObject service;

  private Proxy()
  {
    this.service = new ServiceObject();
  }


  /** From: https://refactoring.guru/design-patterns/proxy
   Step 4: Consider introducing a creation method that decides whether the client gets a proxy or a real service.
   This can be a simple static method in the proxy class or a full-blown factory method.*/
  public static ServiceInterface getProxy(Client client)
  {
    if(client.getClientType().equalsIgnoreCase("admin"))
    {
      return new ServiceObject(); //Bypasses the proxy and returns the true object, if the user is an admin.
    }
    else
    {
      return new Proxy(); //Returns a new proxy object - imaging the true object with added functionality and access control.
    }
  }


  /** From: https://refactoring.guru/design-patterns/proxy
   Step 3: Implement the proxy methods according to their purposes.
   In most cases, after doing some work, the proxy should delegate the work to the service object.*/
  @Override public ArrayList<ArrayList<String>> getCitizenshipData(Client client)
  {
    //First authorize the client:
    if(this.authorizeClient(client))
    {
      System.out.println(": Please wait! It will take some time to get the requested data!");
      //client authorized. Fetch data:
      return service.getCitizenshipData(client);
    }
    else
    {
      return null;
    }
  }



  //Performs the logic relating to authorising the client and fetching relevant authorization information from the true object, while updating the UI throughout the process.
  private boolean authorizeClient(Client client)
  {
    System.out.println(": Attempting to authorize client");

    //Check if client Id is an authorized ID:
    if(service.getAuthorizedIds().contains(client.getClientId()))
    {
      //Check if client is from an authorized country:
      if(service.getAuthorizedCountries().contains(client.getOriginCountry()))
      {
        System.out.println(": Client successfully authorized");
        return true;
      }
      else
      {
        System.out.println(": Authorization FAILED: Clients country/location is not valid.");
        return false;
      }
    }
    else
    {
      System.out.println(": Authorization failed: ClientId is not valid.");
      return false;
    }
  }
}
