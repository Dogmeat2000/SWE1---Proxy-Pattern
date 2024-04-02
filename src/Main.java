import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)
  {
    System.out.println("\nPROXY PATTERN CODE EXAMPLE:");

    try
    {
      //Showcase Proxy functionality:

      //Create 5 different clients:
      System.out.println("Creating Dummy clients:");

      //Tick
      Thread.sleep(1000);
      Client client1 = new Client(1, "Denmark", "User");
      System.out.println("\nClient #" + client1.getClientId() + " from " + client1.getOriginCountry() + " is active.");

      //Tick
      Thread.sleep(1000);
      Client client2 = new Client(3, "Germany", "User");
      System.out.println("Client #" + client2.getClientId() + " from " + client2.getOriginCountry() + " is active.");

      //Tick
      Thread.sleep(1000);
      Client client3 = new Client(7, "DNK", "User");
      System.out.println("Client #" + client3.getClientId() + " from " + client3.getOriginCountry() + " is active.");

      //Tick
      Thread.sleep(1000);
      Client client4 = new Client(11, "Australia", "User");
      System.out.println("Client #" + client4.getClientId() + " from " + client4.getOriginCountry() + " is active.");

      //Tick
      Thread.sleep(1000);
      Client client5 = new Client(12, "DNK", "User");
      System.out.println("Client #" + client5.getClientId() + " from " + client5.getOriginCountry() + " is active.\n\n");

      //For each client attempt to query citizenship data.
      ArrayList<Client> clients = new ArrayList<>();
      clients.add(client1);
      clients.add(client2);
      clients.add(client3);
      clients.add(client4);
      clients.add(client5);

      for (Client client : clients)
      {
        //Tick
        Thread.sleep(2000);
        System.out.println("Client #" + client.getClientId() + " from " + client.getOriginCountry() + " is attempting to query citizenship information.");

        client.displayCitizenshipData();

        //Wait a bit before the next cycle in order to allow the presenter to explain what is happening.
        for (int i = 0; i < 3; i++)
        {
          //Tick
          Thread.sleep(1000);

        }
        System.out.println("\n");
      }
    }
    catch (InterruptedException e)
    {
      //Do nothing... This is just to enable the presenter to explain what is happening.
    }
  }
}
