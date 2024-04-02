public class Proxy implements ServiceInterface
{
  private static ServiceInterface serviceInterface;
  private static Proxy instance;

  public Proxy()
  {

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

}
