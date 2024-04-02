import java.util.ArrayList;

public class Client
{
  private ServiceInterface service;
  private int clientId;
  private String originCountry;

  public Client(int clientId, ServiceInterface service, String originCountry)
  {
    this.service = service;
    this.clientId = clientId;
    this.originCountry = originCountry;
  }

  public int getClientId()
  {
    return clientId;
  }

  public String getOriginCountry()
  {
    return originCountry;
  }

  public void displayCitizenshipData()
  {
    ArrayList<ArrayList<String>> citizenShipData = service.getCitizenshipData(this);

    if(citizenShipData != null)
    {
      System.out.println(": RETRIEVED THIS CITIZENSHIP DATA:");

      //Format and display the data:
      for (int i = 0; i < citizenShipData.size(); i++)
      {
        StringBuilder stringToDisplay = new StringBuilder();
        stringToDisplay.append("#");
        stringToDisplay.append(i);
        stringToDisplay.append(": [");

        for (int j = 0; j < citizenShipData.get(i).size(); j++)
        {
          stringToDisplay.append(citizenShipData.get(i).get(j));
          if(j != citizenShipData.get(i).size()-1)
          {
            stringToDisplay.append(";");
          }
        }
        stringToDisplay.append("]");
        System.out.println(stringToDisplay);
      }
    }
    else
    {
      System.out.println(": Unable to retrieve citizenship data for client [" + this.getClientId() + ", " + this.getOriginCountry() + "]");
    }
  }
}