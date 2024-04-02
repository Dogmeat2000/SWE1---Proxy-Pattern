import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServiceObject implements ServiceInterface
{
  private static ServiceObject instance;
  private static final Lock lock = new ReentrantLock();

  private ServiceObject()
  {
    //Empty
  }

  public static ServiceObject getInstance()
  {
    //Here we use the "Double-checked lock" principle to ensure proper synchronization.
    //5. Consider implementing lazy initialization for the service object (Only create the object when actually needed).
    if(instance == null)
    {
      synchronized (lock)
      {
        if(instance == null)
        {
          instance = new ServiceObject();
        }
      }
    }
    return instance;
  }
}
