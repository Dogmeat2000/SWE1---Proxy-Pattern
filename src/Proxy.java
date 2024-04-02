import java.util.ArrayList;

public class Proxy implements ServiceInterface
{
  private final ServiceObject service;
  private static Proxy instance;

  private Proxy()
  {
    this.service = (ServiceObject) getTrueService();
  }


  //4. Consider introducing a creation method that decides whether the client gets a proxy or a real service. This can be a simple static method in the proxy class or a full-blown factory method.
  public static ServiceInterface getProxy()
  {
    if(instance == null)
    {
      instance = new Proxy();
    }
    return instance;
  }

  public static ServiceInterface getTrueService()
  {
    return ServiceObject.getInstance();
  }



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
